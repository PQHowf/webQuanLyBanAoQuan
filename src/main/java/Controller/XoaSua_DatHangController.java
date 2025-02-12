package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GioHangModel.GioHang;
import GioHangModel.GioHangDAO;

/**
 * Servlet implementation class XoaSuaController
 */
@WebServlet("/XoaSua_DatHangController")
public class XoaSua_DatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSua_DatHangController() {
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
	    String action = request.getParameter("action");
	    HttpSession session = request.getSession();
	    GioHangDAO gioHang = (GioHangDAO) session.getAttribute("gioHang");
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    if (gioHang != null) {
	        if ("increase".equals(action) || "decrease".equals(action)) {
	            Long maSanPham = Long.parseLong(request.getParameter("masp"));
	            int quantityChange = 0;

	            if ("increase".equals(action)) {
	                quantityChange = 1;
	            } else if ("decrease".equals(action)) {
	                quantityChange = -1;
	            }

	            gioHang.CapNhatSoLuong(maSanPham, quantityChange);
	        } else if ("deleteSelected".equals(action)) {
	            String[] dsSpDaChon = request.getParameterValues("spDaChon");
	            if (dsSpDaChon != null) {
	                for (String maSpStr : dsSpDaChon) {
	                    Long masp = Long.parseLong(maSpStr);
	                    gioHang.Xoa(masp);
	                }
	            }
	        } else if ("deleteAll".equals(action)) {
	            gioHang.XoaTatCaSanPham();
	        } else {
	            for (GioHang item : gioHang.getDsGioHang()) {
	                Long maSanPham = item.getMaSanPham();

	                String maMau = request.getParameter("mau_" + maSanPham);
	                String kichCo = request.getParameter("kichCo_" + maSanPham);

	                if (maMau == null || maMau.isEmpty() || kichCo == null || kichCo.isEmpty()) {
	                    request.setAttribute("errorMessage", "Vui lòng chọn đầy đủ màu sắc và kích cỡ.");
	                    request.getRequestDispatcher("GioHangDayDuController").forward(request, response);
	                    return;
	                }

	                item.setMaMau(Long.parseLong(maMau));
	                item.setMaKichThuoc(Long.parseLong(kichCo));
	            }
	        }

	        session.setAttribute("gioHang", gioHang);

	        if ("placeOrder".equals(action)) {
	        	Object dn = session.getAttribute("dn");
		        if (dn == null) {
		            response.sendRedirect("DangNhapController");
		            return;
		        }
	            request.setAttribute("gioHang", gioHang);
	            //request.getRequestDispatcher("XacNhanDonHang.jsp").forward(request, response);
	            response.sendRedirect("XacNhanDonHangController");
	        } else {
	            response.sendRedirect("GioHangDayDuController");
	        }
	    } else {
	        response.sendRedirect("GioHangDayDuController");
	    }
	}


}
