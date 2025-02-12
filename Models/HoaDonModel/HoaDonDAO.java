package HoaDonModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import KetNoiModel.KetNoi;
import TaiKhoanModel.TaiKhoan;

public class HoaDonDAO {
	ArrayList<HoaDon> dsHoaDon;
	
	public long LuuHoaDon(long IDTaiKhoan, String PhuongThucThanhToan, String TongTien, String TenNguoiNhan, String SoDienThoaiNguoiNhan, String EmailNguoiNhan, String ThanhPhoNguoiNhan, String DiaChiNhaNguoiNhan, String GhiChu) throws Exception {
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    
	    String sql = "INSERT INTO HoaDon(IDTaiKhoan, PhuongThucThanhToan, TongTien, NgayLap, XacNhanThanhToan, TenNguoiNhan, SoDienThoaiNguoiNhan, ThanhPhoNguoiNhan, DiaChiNhaNguoiNhan, EmailNguoiNhan, GhiChu ) OUTPUT INSERTED.MaHoaDon VALUES (?, ?, ?, GETDATE(), 0, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    ps.setLong(1, IDTaiKhoan);
	    ps.setString(2, PhuongThucThanhToan);
	    ps.setString(3, TongTien);
	    ps.setString(4, TenNguoiNhan);
	    ps.setString(5, SoDienThoaiNguoiNhan);
	    ps.setString(6, ThanhPhoNguoiNhan);
	    ps.setString(7, DiaChiNhaNguoiNhan);
	    ps.setString(8, EmailNguoiNhan);
	    ps.setString(9, GhiChu);

	    ResultSet rs = ps.executeQuery();
	    long maHoaDon = 0;
	    if (rs.next()) {
	        maHoaDon = rs.getLong("MaHoaDon");
	    }

	    rs.close();
	    ps.close();
	    kn.cn.close();
	    
	    return maHoaDon;
	}
	
	public long LuuChiTietHoaDon(long maHoaDon, long maSanPham, String tenSanPham, long iDTaiKhoan, long soLuongSanPham, long maMau, long maKichThuoc, long tongTien) throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon, MaSanPham, TenSanPham, IDTaiKhoan, SoLuongSanPham, MaMau, MaKichThuoc, TongTien) OUTPUT INSERTED.MaChiTietHoaDon VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maHoaDon);
		ps.setLong(2, maSanPham);
		ps.setString(3, tenSanPham);
		ps.setLong(4, iDTaiKhoan);
		ps.setLong(5, soLuongSanPham);
		ps.setLong(6, maMau);
		ps.setLong(7, maKichThuoc);
		ps.setLong(8, tongTien);
		ResultSet rs = ps.executeQuery();
		long maChiTietHoaDon = 0;
		if(rs.next()) {
			maChiTietHoaDon = rs.getLong("MaChiTietHoaDon");
		}
		rs.close();
		ps.close();
		kn.cn.close();
		return maChiTietHoaDon;
	}
	
	public List<HoaDon> LayThongTinChiTietHoaDon(long IDTaiKhoan) throws Exception {
		List<HoaDon> danhSach = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT cthd.MaChiTietHoaDon, cthd.MaHoaDon, cthd.MaSanPham, cthd.TenSanPham, cthd.SoLuongSanPham, "
		           + "cthd.MaMau, cthd.MaKichThuoc, cthd.TongTien, hd.NgayLap "
		           + "FROM ChiTietHoaDon cthd "
		           + "JOIN HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon "
		           + "WHERE cthd.IDTaiKhoan = ? "
		           + "ORDER BY cthd.MaHoaDon DESC";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, IDTaiKhoan);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	        long maChiTietHoaDon = rs.getLong("MaChiTietHoaDon");
	        long maHoaDon = rs.getLong("MaHoaDon");
	        long maSanPham = rs.getLong("MaSanPham");
	        String tenSanPham = rs.getString("TenSanPham");
	        int soLuongSanPham = rs.getInt("SoLuongSanPham");
	        long maMau = rs.getLong("MaMau");
	        long maKichThuoc = rs.getLong("MaKichThuoc");
	        long tongTien = rs.getLong("TongTien");
	        Date ngayLap = rs.getDate("NgayLap");
	        
	        HoaDon hd = new HoaDon();
	        hd.setMaChiTietHoaDon(maChiTietHoaDon);
	        hd.setMaHoaDon(maHoaDon);
	        hd.setMaSanPham(maSanPham);
	        hd.setTenSanPham(tenSanPham);
	        hd.setSoLuong(soLuongSanPham);
	        hd.setMaMau(soLuongSanPham);
	        hd.setMaMau(maMau);
	        hd.setMaSize(maKichThuoc);
	        hd.setTongTien(tongTien);
	        hd.setNgayLap(ngayLap);
	        
	        HoaDonDAO hddao = new HoaDonDAO();
	        hd.setTenMau(hddao.LayThongTinMau(maMau));
	        hd.setTenSize(hddao.LayThongTinSize(maKichThuoc));
	        hd.setAnh(hddao.LayThongTinSanPham_Anh(maSanPham));
	        hd.setGia(hddao.LayThongTinSanPham_Gia(maSanPham));
	        
	        danhSach.add(hd);
	    }
		rs.close();
	    ps.close();
	    kn.cn.close();
	    return danhSach;
	}
	
	public long LayThongTinSanPham_Gia(long maSanPham) throws Exception {
		long gia = 0;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Gia FROM SanPham WHERE MaSanPham = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maSanPham);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			gia = rs.getLong("Gia");
		}
		rs.close();
	    ps.close();
	    kn.cn.close();
	    return gia;
	}
	
	public String LayThongTinSanPham_Anh(long maSanPham) throws Exception {
		String anh = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Anh FROM SanPham WHERE MaSanPham = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maSanPham);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			anh = rs.getString("Anh");
		}
		rs.close();
	    ps.close();
	    kn.cn.close();
	    return anh;
	}
	
	public String LayThongTinMau(long maMau) throws Exception {
		String tenMau = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT TenMau FROM Mau WHERE MaMau = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maMau);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			tenMau = rs.getString("TenMau");
		}
		rs.close();
	    ps.close();
	    kn.cn.close();
	    return tenMau;
	}
	
	public String LayThongTinSize(long maSize) throws Exception {
		String tenSize = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT TenKichThuoc FROM KichThuoc WHERE MaKichThuoc = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			tenSize = rs.getString("TenKichThuoc");
			
			HoaDon hd = new HoaDon();
			hd.setTenSize(tenSize);
		}
		rs.close();
	    ps.close();
	    kn.cn.close();
	    return tenSize;
	}
	
	public ArrayList<HoaDon> getHoaDon() throws Exception {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM HoaDon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			Long maHoaDon = rs.getLong("MaHoaDon");
			Long iDTaiKhoan = rs.getLong("IDTaiKhoan");
			String phuongThucThanhToan = rs.getString("PhuongThucThanhToan");
			Long tongTien = rs.getLong("TongTien");
			Date ngayLap = rs.getDate("NgayLap");
			String tenNguoiNhan = rs.getString("TenNguoiNhan");
			String soDienThoaiNguoiNhan = rs.getString("SoDienThoaiNguoiNhan");
			String thanhPhoNguoiNhan = rs.getString("ThanhPhoNguoiNhan");
			String diaChiNhaNguoiNhan = rs.getString("DiaChiNhaNguoiNhan");
			String emailNguoiNhan = rs.getString("EmailNguoiNhan");
			String ghiChu = rs.getString("GhiChu");
			int xacNhanThanhToan = rs.getInt("XacNhanThanhToan");
			
			dsHoaDon.add(new HoaDon(maHoaDon, iDTaiKhoan, phuongThucThanhToan, tongTien, ngayLap, xacNhanThanhToan, tenNguoiNhan, soDienThoaiNguoiNhan, thanhPhoNguoiNhan, diaChiNhaNguoiNhan, emailNguoiNhan, ghiChu));
			
		}
		rs.close();
		kn.cn.close();
		return dsHoaDon;
	}
	
	public ArrayList<HoaDon> Tim(Long key) throws Exception {
		if(dsHoaDon==null || dsHoaDon.isEmpty()) {
			dsHoaDon = getHoaDon();
		}
		ArrayList<HoaDon> dsTim = new ArrayList<HoaDon>();
		for(HoaDon hd : dsHoaDon) {
			if(hd.getMaHoaDon() == key) {
				dsTim.add(hd);
			}
		}
		return dsTim;
	}
	
	public int XoaDonHang(long madonhang) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, madonhang);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void capNhatTrangThaiThanhToan(long maHoaDon) {
	    try {
	    	KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE HoaDon SET XacNhanThanhToan = 1 WHERE MaHoaDon = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
		    ps.setLong(1, maHoaDon);
		    ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
