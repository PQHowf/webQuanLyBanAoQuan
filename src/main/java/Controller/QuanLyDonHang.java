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

import HoaDonModel.HoaDon;
import HoaDonModel.HoaDonDAO;

/**
 * Servlet implementation class QuanLyDonHang
 */
@WebServlet("/QuanLyDonHang")
public class QuanLyDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Long IDTaiKhoan = (Long) session.getAttribute("IDTaiKhoan");
			if(IDTaiKhoan == null) {
				response.sendRedirect("DangNhapController");
				return;
			} else {
				HoaDonDAO hddao = new HoaDonDAO();
				List<HoaDon> dsHoaDon = hddao.getHoaDon();
				String key = request.getParameter("txtTimKiem");
				if(key!=null && key!="") {
					dsHoaDon = hddao.Tim(Long.parseLong(key));
				}
				request.setAttribute("dsHoaDon", dsHoaDon);
				RequestDispatcher rd = request.getRequestDispatcher("ADMIN_QuanLyDonHang.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maHoaDon = request.getParameter("maHoaDon");
		try {
			HoaDonDAO hddao = new HoaDonDAO();
			hddao.capNhatTrangThaiThanhToan(Long.parseLong(maHoaDon));
			response.sendRedirect("QuanLyDonHang");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
