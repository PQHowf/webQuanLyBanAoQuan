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
 * Servlet implementation class SuaKichThuoc_HienThiForm
 */
@WebServlet("/SuaKichThuoc_HienThiForm")
public class SuaKichThuoc_HienThiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KichThuocDAO ktdao = new KichThuocDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaKichThuoc_HienThiForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String makichthuoc = request.getParameter("makichthuocsua");
			KichThuoc kt = ktdao.getKichThuocByMaKichThuoc(Long.parseLong(makichthuoc));
			if(kt!=null) {
				request.setAttribute("kichthuocSua", kt);
				request.getRequestDispatcher("ADMIN_SuaKichThuoc.jsp").forward(request, response);
			} else {
				response.sendRedirect("QuanLySize");
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
