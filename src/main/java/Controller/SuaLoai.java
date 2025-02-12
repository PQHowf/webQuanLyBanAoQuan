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
 * Servlet implementation class SuaLoai
 */
@WebServlet("/SuaLoai")
public class SuaLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiDAO ldao = new LoaiDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaLoai() {
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
    		Long maloai = Long.parseLong(request.getParameter("maloaisua"));
    		String tenloai = request.getParameter("tenloaisua");
    		Loai l = new Loai(maloai, tenloai);
    		int result = ldao.CapNhatLoai(l);
    		if(result > 0) {
    			response.sendRedirect("QuanLyLoai");
    		} else {
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
