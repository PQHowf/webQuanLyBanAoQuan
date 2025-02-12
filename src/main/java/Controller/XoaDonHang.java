package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoaDonModel.HoaDonDAO;

/**
 * Servlet implementation class XoaDonHang
 */
@WebServlet("/XoaDonHang")
public class XoaDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HoaDonDAO hddao = new HoaDonDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("delete");
			String mahoadonxoa = request.getParameter("mahoadonxoa");
			if("delete".equalsIgnoreCase(action)) {
				if(mahoadonxoa!=null && !mahoadonxoa.trim().isEmpty()) {
					long mahdLong = Long.parseLong(mahoadonxoa);
					int result = hddao.XoaDonHang(mahdLong);
					if(result > 0) {
						response.sendRedirect("QuanLyDonHang");
					}
				}
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
