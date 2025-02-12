package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KichThuocModel.KichThuoc;
import KichThuocModel.KichThuocDAO;

/**
 * Servlet implementation class ThemKichThuoc
 */
@WebServlet("/ThemKichThuoc")
public class ThemKichThuoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemKichThuoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemSize.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
    	    response.setCharacterEncoding("UTF-8");
    	    response.setContentType("text/html; charset=UTF-8");

            String tenkichthuoc = request.getParameter("tenkichthuoc");
            KichThuoc kt = new KichThuoc(tenkichthuoc);
            KichThuocDAO ktdao = new KichThuocDAO();
            int result = ktdao.ThemSize(kt);
            if(result > 0) {
            	response.sendRedirect("QuanLySize");
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemSize.jsp");
                rd.forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
