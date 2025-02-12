package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TaiKhoanModel.TaiKhoan;
import TaiKhoanModel.TaiKhoanDAO;

/**
 * Servlet implementation class ThemTaiKhoan
 */
@WebServlet("/ThemTaiKhoan")
public class ThemTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemTaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemTaiKhoan.jsp");
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
    	    
    	    String tenTaiKhoan = request.getParameter("tentaikhoan");
    	    String matKhau = request.getParameter("matkhau");
    	    String hoVaTen = request.getParameter("hovaten");
    	    String soDienThoai = request.getParameter("sodienthoai");
    	    String email = request.getParameter("email");
    	    String diaChiNha = request.getParameter("diachinha");
    	    String thanhPho = request.getParameter("thanhpho");
    	    String chucVu = request.getParameter("chucvu");
    	    
    	    TaiKhoan tk = new TaiKhoan(tenTaiKhoan, matKhau, hoVaTen, soDienThoai, email, diaChiNha, thanhPho, chucVu);
    	    TaiKhoanDAO tkdao = new TaiKhoanDAO();
    	    int result = tkdao.ThemTaiKhoan(tk);
    	    
    	    if(result > 0) {
    	    	response.sendRedirect("QuanLyTaiKhoan");
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemTaiKhoan.jsp");
                rd.forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
