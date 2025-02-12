package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModel.Loai;
import LoaiModel.LoaiDAO;
import SanPhamModel.SanPham;
import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class SuaSanPham
 */
@WebServlet("/SuaSanPham_HienThiForm")
public class SuaSanPham_HienThiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO spdao = new SanPhamDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPham_HienThiForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String masp = request.getParameter("maspsua");
			SanPham sp = spdao.getSanPhamByMaSanPham(Long.parseLong(masp));
			if(sp!=null) {
				LoaiDAO ldao = new LoaiDAO();
				List<Loai> dsLoai = ldao.getLoai();
				request.setAttribute("dsLoai", dsLoai);
				request.setAttribute("spSua", sp);
				request.getRequestDispatcher("ADMIN_SuaSanPham.jsp").forward(request, response);
			} else {
				response.sendRedirect("QuanLySanPham");
			}
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
