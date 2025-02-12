package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MauModel.Mau;
import MauModel.MauDAO;

/**
 * Servlet implementation class SuaMau
 */
@WebServlet("/SuaMau")
public class SuaMau extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MauDAO mdao = new MauDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaMau() {
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
    		Long mamau = Long.parseLong(request.getParameter("mamausua"));
    		String tenmau = request.getParameter("tenmausua");
    		Mau m = new Mau(mamau, tenmau);
    		int result = mdao.CapNhatMau(m);
    		if(result > 0) {
    			response.sendRedirect("QuanLyMau");
    		} else {
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
