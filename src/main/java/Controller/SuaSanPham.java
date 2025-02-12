package Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import SanPhamModel.SanPham;
import SanPhamModel.SanPhamDAO;

/**
 * Servlet implementation class SuaSanPham
 */
@WebServlet("/SuaSanPham")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2,
	    maxFileSize = 1024 * 1024 * 10,
	    maxRequestSize = 1024 * 1024 * 50
	)
public class SuaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPham() {
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
    		Long masp = Long.parseLong(request.getParameter("masp"));
    		String tensp = request.getParameter("tensp");
    		Long giasp = Long.parseLong(request.getParameter("giasp"));
    		String motasp = request.getParameter("motasp");
    		Long maloai = Long.parseLong(request.getParameter("maloai"));
    		String anhspCu = request.getParameter("anhspcu");

    		String uploadPath = request.getServletContext().getRealPath("") + "image";
    		File uploadDir = new File(uploadPath);
    		if (!uploadDir.exists()) {
    	        uploadDir.mkdirs();
    	    }
    		String anhMoi = null;
    		Part filePart = request.getPart("anhsp");
    		if(filePart != null && filePart.getSize() > 0) {
    			String fileMoi = extractFileName(filePart);
    			filePart.write(uploadPath + File.separator + fileMoi);
    			anhMoi = "image/" + fileMoi;
    		} else {
    			anhMoi = anhspCu;
    		}
    		
    		SanPham sp = new SanPham(masp, tensp, giasp, motasp, anhMoi, maloai);
    		int result = spdao.CapNhatSanPham(sp);
    		if(result > 0) {
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
		for(String content : contentDisp.split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		return null;
	}

}
