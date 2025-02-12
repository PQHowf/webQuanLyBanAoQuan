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
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("DangKy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			String tenTaiKhoan = request.getParameter("tentaikhoan");
			String matKhau = request.getParameter("matkhau");
			String hoVaTen = request.getParameter("hovaten");
			String soDienThoai = request.getParameter("sodienthoai");
			String email = request.getParameter("email");
			String thanhPho = request.getParameter("thanhpho");
			String diaChiNha = request.getParameter("diachinha");
			
			TaiKhoanDAO tkdao = new TaiKhoanDAO();
			if(tkdao.KiemTraTaiKhoanTonTai(tenTaiKhoan)) {
				request.setAttribute("error", "Tài khoản đã tồn tại. Vui lòng nhập tài khoản khác!");
	            request.getRequestDispatcher("DangKy.jsp").forward(request, response);
			} else {
				TaiKhoan tk = new TaiKhoan();
				tk.setTenTaiKhoan(tenTaiKhoan);
				tk.setMatKhau(matKhau);
				tk.setHoVaTen(hoVaTen);
				tk.setSoDienThoai(soDienThoai);
				tk.setEmail(email);
				tk.setThanhPho(thanhPho);
				tk.setDiaChiNha(diaChiNha);
				long check = tkdao.DangKyTaiKhoan(tk);
				if(check > 0) {
					request.setAttribute("message", "Đăng ký tài khoản thành công!");
					request.getRequestDispatcher("DangNhapController").forward(request, response);
				} else {
					request.setAttribute("message", "Đăng ký tài khoản thất bại!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Đã xảy ra lỗi trong quá trình đăng ký. Vui lòng thử lại!");
            request.getRequestDispatcher("DangKy.jsp").forward(request, response);
		}
	}

}
