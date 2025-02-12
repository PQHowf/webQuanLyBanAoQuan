package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaiKhoanModel.TaiKhoan;
import TaiKhoanModel.TaiKhoanDAO;

/**
 * Servlet implementation class SuaTaiKhoan_HienThiForm
 */
@WebServlet("/SuaTaiKhoan_HienThiForm")
public class SuaTaiKhoan_HienThiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO tkdao = new TaiKhoanDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTaiKhoan_HienThiForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String matk = request.getParameter("mataikhoansua");
			TaiKhoan tk = tkdao.getTaiKhoanByMaTaiKhoan(Long.parseLong(matk));
			if(tk!=null) {
				request.setAttribute("tkSua", tk);
				request.getRequestDispatcher("ADMIN_SuaTaiKhoan.jsp").forward(request, response);
			} else {
				response.sendRedirect("QuanLyTaiKhoan");
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
