package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KichThuocModel.KichThuoc;
import KichThuocModel.KichThuocDAO;

/**
 * Servlet implementation class SuaKichThuoc
 */
@WebServlet("/SuaKichThuoc")
public class SuaKichThuoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KichThuocDAO ktdao = new KichThuocDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaKichThuoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("text/html; charset=utf-8");
    		Long makichthuoc = Long.parseLong(request.getParameter("makichthuocsua"));
    		String tenkichthuoc = request.getParameter("tenkichthuocsua");
    		KichThuoc kt = new KichThuoc(makichthuoc, tenkichthuoc);
    		int result = ktdao.CapNhatKichThuoc(kt);
    		if(result > 0) {
    			response.sendRedirect("QuanLySize");
    		} else {
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
