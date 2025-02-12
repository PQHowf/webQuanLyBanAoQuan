package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KichThuocModel.KichThuocDAO;

/**
 * Servlet implementation class XoaKichThuoc
 */
@WebServlet("/XoaKichThuoc")
public class XoaKichThuoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KichThuocDAO ktdao = new KichThuocDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaKichThuoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("delete");
			String makichthuoc = request.getParameter("makichthuocxoa");
			if("delete".equalsIgnoreCase(action)) {
				if(makichthuoc!=null && !makichthuoc.trim().isEmpty()) {
					long makichthuocLong = Long.parseLong(makichthuoc);
					int result = ktdao.XoaSize(makichthuocLong);
					if(result > 0) {
						response.sendRedirect("QuanLySize");
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
