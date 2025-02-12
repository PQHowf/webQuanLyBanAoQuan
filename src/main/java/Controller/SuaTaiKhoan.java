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
 * Servlet implementation class SuaTaiKhoan
 */
@WebServlet("/SuaTaiKhoan")
public class SuaTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO tkdao = new TaiKhoanDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTaiKhoan() {
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
    		
    		Long mataikhoan = Long.parseLong(request.getParameter("mataikhoan"));
    		String tentaikhoan = request.getParameter("tentaikhoan");
    		String matkhau = request.getParameter("matkhau");
    		String hovaten = request.getParameter("hovaten");
    		String sodienthoai = request.getParameter("sodienthoai");
    		String email = request.getParameter("email");
    		String diachinha = request.getParameter("diachinha");
    		String thanhpho = request.getParameter("thanhpho");
    		String chucvu = request.getParameter("chucvu");
    		
    		TaiKhoan tk = new TaiKhoan(mataikhoan, tentaikhoan, matkhau, hovaten, sodienthoai, email, diachinha, thanhpho, chucvu);
    		int result = tkdao.CapNhatTaiKhoan(tk);
    		
    		if(result > 0) {
    			response.sendRedirect("QuanLyTaiKhoan");
    		} else {
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
