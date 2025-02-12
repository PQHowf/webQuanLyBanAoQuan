package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModel.LoaiDAO;
import SanPhamModel.SanPham;
import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class SanPhamController
 */
@WebServlet("/SanPhamController")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int limit = 10;
        String maLoai = request.getParameter("maLoai"); 

        try {
            if (request.getParameter("page") != null && maLoai == null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            SanPhamDAO spdao = new SanPhamDAO();
            List<SanPham> dsSanPham;

            if (maLoai != null) {
                dsSanPham = spdao.TimMa(maLoai);
                request.setAttribute("maLoai", maLoai);
            } else {
                dsSanPham = spdao.laySanPhamPhanTrang(page, limit);
                int tongSoSanPham = spdao.demTongSanPham();
                int SoTrang = (int) Math.ceil((double) tongSoSanPham / limit);
                request.setAttribute("SoTrang", SoTrang);
                request.setAttribute("currentPage", page);
            }

            LoaiDAO ldao = new LoaiDAO();
            request.setAttribute("dsLoai", ldao.getLoai());

            String key = request.getParameter("txtTimKiem");
            if (key != null) {
                dsSanPham = spdao.Tim(key); 
            }

            request.setAttribute("dsSanPham", dsSanPham); 
            RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
