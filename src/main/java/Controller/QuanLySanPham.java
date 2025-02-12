package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SanPhamModel.SanPham;
import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class QuanLySanPham
 */
@WebServlet("/QuanLySanPham")
public class QuanLySanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long IDTaiKhoan = (Long) session.getAttribute("IDTaiKhoan");
		if(IDTaiKhoan == null) {
			response.sendRedirect("DangNhapController");
			return;
		} else {
			int page = 1;
			int limit = 5;
			try {
				if (request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}
				SanPhamDAO spdao = new SanPhamDAO();
				List<SanPham> dsSanPham = spdao.laySanPhamPhanTrang(page, limit);
				int tongSoSanPham = spdao.demTongSanPham();
				int SoTrang = (int) Math.ceil((double) tongSoSanPham / limit);
				String key = request.getParameter("txtTimKiem");
				if(key!=null) {
					dsSanPham = spdao.Tim(key);
				}
				request.setAttribute("dsSanPham", dsSanPham);
				request.setAttribute("currentPage", page);
				request.setAttribute("SoTrang", SoTrang);
				RequestDispatcher rd = request.getRequestDispatcher("ADMIN_QuanLySanPham.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
