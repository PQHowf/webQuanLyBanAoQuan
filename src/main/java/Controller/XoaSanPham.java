package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class XoaSanPham
 */
@WebServlet("/XoaSanPham")
public class XoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO spdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        spdao = new SanPhamDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("delete");
			String masp = request.getParameter("mspxoa");
			if("delete".equalsIgnoreCase(action)) {
				if(masp!=null && !masp.trim().isEmpty()) {
					long maspLong = Long.parseLong(masp);
					boolean result = spdao.XoaSanPham(maspLong);
					if(result) {
						response.sendRedirect("QuanLySanPham");
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
