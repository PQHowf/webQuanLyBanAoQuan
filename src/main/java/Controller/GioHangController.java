package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GioHangModel.GioHangDAO;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String masp = request.getParameter("masp");
			String tensp = request.getParameter("tensp");
			String giasp = request.getParameter("giasp");
			String anhsp = request.getParameter("anhsp");
			if(masp!=null && tensp!=null && giasp!=null) {
				GioHangDAO gioHang = null;
				HttpSession session = request.getSession();
				if(session.getAttribute("gioHang") == null) {
					gioHang = new GioHangDAO(); 
					session.setAttribute("gioHang", gioHang);
				}
				gioHang = (GioHangDAO) session.getAttribute("gioHang");
				gioHang.ThemVaoGioHang(Long.parseLong(masp), tensp, Long.parseLong(giasp), (long)1, anhsp);
				session.setAttribute("gioHang", gioHang);
		
				response.sendRedirect("GioHangDayDuController");
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