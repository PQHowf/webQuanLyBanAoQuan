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
 * Servlet implementation class XacNhanDonHangController
 */
@WebServlet("/XacNhanDonHangController")
public class XacNhanDonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDonHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        GioHangDAO gioHang = (GioHangDAO) session.getAttribute("gioHang");

        if (gioHang == null || gioHang.getDsGioHang().isEmpty()) {
            response.sendRedirect("GioHangDayDuController");
            return;
        }

        request.setAttribute("gioHang", gioHang);
        request.getRequestDispatcher("XacNhanDonHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
