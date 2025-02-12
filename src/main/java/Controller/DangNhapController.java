package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DangNhapModel.DangNhap;
import DangNhapModel.DangNhapDAO;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DangNhapController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String tenTaiKhoan = request.getParameter("txtTenTaiKhoan");
			String matKhau = request.getParameter("txtMatKhau");
			if(tenTaiKhoan != null && matKhau != null) {
				DangNhapDAO dnDAO = new DangNhapDAO();
				DangNhap dn = dnDAO.kiemtradangnhap(tenTaiKhoan, matKhau);
				if(dn != null) {
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if(answer==null)
						request.setAttribute("errorMessage", "Vui lòng nhập captcha.");
					else if (captcha.isCorrect(answer)) {
						session = request.getSession();
						session.setAttribute("dn", dn);
						session.setAttribute("IDTaiKhoan", dn.getIDTaiKhoan());
						if ("Admin".equals(dn.getChucVu())) {
				            response.sendRedirect("QuanLySanPham");
				        } else if("NguoiDung".equals(dn.getChucVu())) {
				            response.sendRedirect("SanPhamController");
				        }

					} else {
						 response.getWriter().print("CaptCha sai");
					}
					return;
				}
			}
			request.setAttribute("errorMessage", "Tên tài khoản hoặc mật khẩu không đúng.");
			RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
			rd.forward(request, response);
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
