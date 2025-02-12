package HoaDonModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KetNoiModel.KetNoi;

public class ChiTietHoaDonDAO {
	public int LuuChiTietHoaDon(long MaHoaDon, long MaSanPham, String TenSanPham, long IDTaiKhoan, int SoLuongSanPham, long MaMau, long MaKichThuoc, long TongTien) throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon, MaSanPham, TenSanPham, IDTaiKhoan, SoLuongSanPham, MaMau, MaKichThuoc, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, MaHoaDon);
		ps.setLong(2, MaSanPham);
		ps.setString(3, TenSanPham);
		ps.setLong(4, IDTaiKhoan);
		ps.setInt(5, SoLuongSanPham);
		ps.setLong(6, MaMau);
		ps.setLong(7, MaKichThuoc);
		ps.setLong(8, TongTien);
		int n = ps.executeUpdate();
		kn.cn.close();
		ps.close();
		return n;
	}
	
	public List<ChiTietHoaDon> LayThongTinHoaDon(long maHoaDon) throws Exception{
		List<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT ChiTietHoaDon.*, HoVaTen, TenMau, TenKichThuoc, Anh FROM ChiTietHoaDon\r\n"
				+ "JOIN TaiKhoan ON ChiTietHoaDon.IDTaiKhoan = TaiKhoan.IDTaiKhoan\r\n"
				+ "JOIN Mau ON ChiTietHoaDon.MaMau = Mau.MaMau\r\n"
				+ "JOIN KichThuoc ON ChiTietHoaDon.MaKichThuoc = KichThuoc.MaKichThuoc\r\n"
				+ "JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham\r\n"
				+ "WHERE MaHoaDon = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maHoaDon);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ChiTietHoaDon cthd = new ChiTietHoaDon();
			cthd.setMaChiTietHoaDon(rs.getLong("MaChiTietHoaDon"));
			cthd.setMaHoaDon(rs.getLong("MaHoaDon"));
			cthd.setMaSanPham(rs.getLong("MaSanPham"));
			cthd.setTenSanPham(rs.getString("TenSanPham"));
			cthd.setIdTaiKhoan(rs.getLong("IDTaiKhoan"));
			cthd.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
			cthd.setMaMau(rs.getLong("MaMau"));
			cthd.setMaKichThuoc(rs.getLong("MaKichThuoc"));
			cthd.setTongTien(rs.getDouble("TongTien"));
			cthd.setHoVaTen(rs.getString("HoVaTen"));
			cthd.setTenMau(rs.getString("TenMau"));
			cthd.setTenKichThuoc(rs.getString("TenKichThuoc"));
			cthd.setAnh(rs.getString("Anh"));
			dsChiTietHoaDon.add(cthd);
		}
		return dsChiTietHoaDon;
	}
}
