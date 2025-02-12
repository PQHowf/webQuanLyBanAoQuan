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
 * Servlet implementation class SuaMau_HienThiForm
 */
@WebServlet("/SuaMau_HienThiForm")
public class SuaMau_HienThiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MauDAO mdao = new MauDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaMau_HienThiForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mamau = request.getParameter("mamausua");
			Mau m = mdao.getMauByMaMau(Long.parseLong(mamau));
			if(m!=null) {
				request.setAttribute("mauSua", m);
				request.getRequestDispatcher("ADMIN_SuaMau.jsp").forward(request, response);
			} else {
				response.sendRedirect("QuanLyLoai");
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
