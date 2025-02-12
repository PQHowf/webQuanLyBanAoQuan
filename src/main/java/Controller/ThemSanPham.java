package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import LoaiModel.Loai;
import LoaiModel.LoaiDAO;
import SanPhamModel.SanPham;
import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class ThemSanPham
 */
@WebServlet("/ThemSanPham")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2,
	    maxFileSize = 1024 * 1024 * 10,
	    maxRequestSize = 1024 * 1024 * 50
	)
public class ThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO spdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPham() {
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
			LoaiDAO ldao = new LoaiDAO();
			List<Loai> dsLoai = ldao.getLoai();
			request.setAttribute("dsLoai", dsLoai);
			RequestDispatcher rd = request.getRequestDispatcher("ADMIN_ThemSanPham.jsp");
            rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	request.setCharacterEncoding("UTF-8");
    	    response.setCharacterEncoding("UTF-8");
    	    response.setContentType("text/html; charset=UTF-8");

            String tensp = request.getParameter("tensp");
            String giasp = request.getParameter("giasp");
            String motasp = request.getParameter("motasp");
            String maloai = request.getParameter("maloai");

            Part filePart = request.getPart("anhsp");
            String fileName = extractFileName(filePart);
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + "image";
            
            System.out.println("Đường dẫn tải lên: " + uploadPath);
            
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String filePath = uploadPath + File.separator + fileName;
            System.out.println("Đường dẫn lưu file: " + filePath);
            
            filePart.write(filePath);
      

            SanPham sp = new SanPham(tensp, Long.parseLong(giasp), motasp, "image/" + fileName, Long.parseLong(maloai));
            SanPhamDAO spdao = new SanPhamDAO();
            int result = spdao.ThemSanPham(sp);

            if (result > 0) {
                response.sendRedirect("QuanLySanPham");
            } else {
                response.getWriter().println("Thêm sản phẩm thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
