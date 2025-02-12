package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModel.Loai;
import LoaiModel.LoaiDAO;

/**
 * Servlet implementation class SuaLoai_HienThiForm
 */
@WebServlet("/SuaLoai_HienThiForm")
public class SuaLoai_HienThiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiDAO ldao = new LoaiDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaLoai_HienThiForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String maloai = request.getParameter("maloaisua");
			Loai l = ldao.getLoaiByMaLoai(Long.parseLong(maloai));
			if(l!=null) {
				request.setAttribute("loaiSua", l);
				request.getRequestDispatcher("ADMIN_SuaLoai.jsp").forward(request, response);
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
