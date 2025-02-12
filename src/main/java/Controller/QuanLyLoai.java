package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoaiModel.Loai;
import LoaiModel.LoaiDAO;

/**
 * Servlet implementation class QuanLyLoai
 */
@WebServlet("/QuanLyLoai")
public class QuanLyLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Long IDTaiKhoan = (Long) session.getAttribute("IDTaiKhoan");
			if(IDTaiKhoan == null) {
				response.sendRedirect("DangNhapController");
				return;
			} else {
				LoaiDAO ldao = new LoaiDAO();
				List<Loai> dsLoai = ldao.getLoai();
				String key = request.getParameter("txtTimKiem");
				if(key!=null) {
					dsLoai = ldao.Tim(key);
				}
				request.setAttribute("dsLoai", dsLoai);
				RequestDispatcher rd = request.getRequestDispatcher("ADMIN_QuanLyLoai.jsp");
				rd.forward(request, response);
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
