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
import HoaDonModel.HoaDonDAO;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/XacNhanThanhToanController")
public class XacNhanThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanThanhToanController() {
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
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			HttpSession session = request.getSession();
			Long IDTaiKhoan = (Long) session.getAttribute("IDTaiKhoan");
			
			String ten = request.getParameter("ten");
	        String sodienthoai = request.getParameter("sodienthoai");
	        String email = request.getParameter("email");
	        String thanhpho = request.getParameter("thanhpho");
	        String diachinha = request.getParameter("diachinha");
	        String ghichu = request.getParameter("ghichu");
	        
			String paymentMethod = request.getParameter("paymentMethod");
			
			GioHangDAO ghdao = (GioHangDAO) session.getAttribute("gioHang");
			
			long TongTien = 0;
			for(int i=0; i<ghdao.getDsGioHang().size(); i++) {
				GioHang item = ghdao.getDsGioHang().get(i);
				TongTien += (item.getGia()*item.getSoLuong());
			}
			String TongTienStr = TongTien + "";
			HoaDonDAO hddao = new HoaDonDAO();
			
			if("TienMat".equals(paymentMethod)) {
				long maHoaDon = hddao.LuuHoaDon(IDTaiKhoan, paymentMethod, TongTienStr, ten, sodienthoai, email, thanhpho, diachinha, ghichu);
				request.setAttribute("maHoaDon", maHoaDon);
				for(int i=0; i<ghdao.getDsGioHang().size(); i++) {
					GioHang item = ghdao.getDsGioHang().get(i);
					hddao.LuuChiTietHoaDon(maHoaDon, item.getMaSanPham(), item.getTenSanPham(), IDTaiKhoan, item.getSoLuong(), item.getMaMau(), item.getMaKichThuoc(), TongTien);
				}
	            request.getRequestDispatcher("DatHangThanhCongController").forward(request, response);
			} else if("TheATM".equals(paymentMethod)) {
				long maHoaDon = hddao.LuuHoaDon(IDTaiKhoan, paymentMethod, TongTienStr, ten, sodienthoai, email, thanhpho, diachinha, ghichu);
				request.setAttribute("maHoaDon", maHoaDon);
				for(int i=0; i<ghdao.getDsGioHang().size(); i++) {
					GioHang item = ghdao.getDsGioHang().get(i);
					hddao.LuuChiTietHoaDon(maHoaDon, item.getMaSanPham(), item.getTenSanPham(), IDTaiKhoan, item.getSoLuong(), item.getMaMau(), item.getMaKichThuoc(), TongTien);
				}
				
	            request.getRequestDispatcher("MaQRController").forward(request, response);
			} else {
				//Báo lỗi
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
