package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MauModel.Mau;
import MauModel.MauDAO;

/**
 * Servlet implementation class ThemMau
 */
@WebServlet("/ThemMau")
public class ThemMau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemMau.jsp");
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
    	    
    	    String tenmau = request.getParameter("tenmau");
    	    Mau m = new Mau(tenmau);
    	    MauDAO mdao = new MauDAO();
    	    int result = mdao.ThemMau(m);
    	    if(result > 0) {
    	    	response.sendRedirect("QuanLyMau");
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemMau.jsp");
                rd.forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
