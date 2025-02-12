package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModel.Loai;
import LoaiModel.LoaiDAO;

/**
 * Servlet implementation class ThemLoai
 */
@WebServlet("/ThemLoai")
public class ThemLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemLoai.jsp");
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

            String tenloai = request.getParameter("tenloai");
            Loai l = new Loai(tenloai);
            LoaiDAO ldao = new LoaiDAO();
            int result = ldao.ThemLoai(l);
            if(result > 0) {
            	response.sendRedirect("QuanLyLoai");
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemLoai.jsp");
                rd.forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
