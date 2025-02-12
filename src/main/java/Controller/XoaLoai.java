package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModel.LoaiDAO;

/**
 * Servlet implementation class XoaLoai
 */
@WebServlet("/XoaLoai")
public class XoaLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiDAO ldao = new LoaiDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("delete");
			String maloai = request.getParameter("maloaixoa");
			if("delete".equalsIgnoreCase(action)) {
				if(maloai!=null && !maloai.trim().isEmpty()) {
					long maloaiLong = Long.parseLong(maloai);
					int result = ldao.XoaLoai(maloaiLong);
					if(result > 0) {
						response.sendRedirect("QuanLyLoai");
					}
				}
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
