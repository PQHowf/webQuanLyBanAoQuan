package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KichThuocModel.KichThuoc;
import KichThuocModel.KichThuocDAO;
import MauModel.Mau;
import MauModel.MauDAO;

/**
 * Servlet implementation class KichThuoc_MauController
 */
@WebServlet("/GioHangDayDuController")
public class GioHangDayDuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangDayDuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8");
			MauDAO mauDAO = new MauDAO();
			ArrayList<Mau> dsMau = mauDAO.getMau();
			request.setAttribute("dsMau", dsMau);
			
			KichThuocDAO kichthuocDAO = new KichThuocDAO();
			ArrayList<KichThuoc> dsKichThuoc = kichthuocDAO.getKichThuoc();
			request.setAttribute("dsKichThuoc", dsKichThuoc);
			
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
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
