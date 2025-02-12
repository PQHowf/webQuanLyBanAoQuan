package HoaDonModel;

import java.util.Date;

public class HoaDon {
	private long MaHoaDon;
	private long IDKhachHang;
	private String TenKhachHang;
	private String SoDienThoai;
	private String Email;
	private String ThanhPho;
	private String DiaChiNha;
	private String GhiChu;
	private long MaSanPham;
	private String TenSanPham;
	private long SoLuong;
	private long MaMau;
	private String TenMau;
	private String TenSize;
	private long MaSize;
	private String PhuongThucThanhToan;
	private long TongTien;
	private Date NgayLap;
	private long MaChiTietHoaDon;
	private long Gia;
	private String Anh;
	private int XacNhanThanhToan;
	public HoaDon(String tenMau, String tenSize, long gia, String anh, long maChiTietHoaDon, long maHoaDon, long iDKhachHang, String tenKhachHang, String soDienThoai, String email,
			String thanhPho, String diaChiNha, String ghiChu, long maSanPham, String tenSanPham, long soLuong,
			long maMau, long maSize, String phuongThucThanhToan, long tongTien, Date ngayLap) {
		super();
		MaHoaDon = maHoaDon;
		IDKhachHang = iDKhachHang;
		TenKhachHang = tenKhachHang;
		SoDienThoai = soDienThoai;
		Email = email;
		ThanhPho = thanhPho;
		DiaChiNha = diaChiNha;
		GhiChu = ghiChu;
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		SoLuong = soLuong;
		MaMau = maMau;
		MaSize = maSize;
		PhuongThucThanhToan = phuongThucThanhToan;
		TongTien = tongTien;
		NgayLap = ngayLap;
		MaChiTietHoaDon = maChiTietHoaDon;
		Gia = gia;
		Anh = anh;
		TenMau = tenMau;
		TenSize = tenSize;
	}
	public HoaDon(long maHoaDon, Long iDKhachHang, String phuongThucThanhToan, long tongTien, Date ngayLap, int xacNhanThanhToan,
			String tenKhachHang, String soDienThoai, String thanhPho, String diaChiNha, String email, String ghiChu) {
		super();
		MaHoaDon = maHoaDon;
		IDKhachHang = iDKhachHang;
		TenKhachHang = tenKhachHang;
		SoDienThoai = soDienThoai;
		Email = email;
		ThanhPho = thanhPho;
		DiaChiNha = diaChiNha;
		GhiChu = ghiChu;
		PhuongThucThanhToan = phuongThucThanhToan;
		TongTien = tongTien;
		NgayLap = ngayLap;
		XacNhanThanhToan = xacNhanThanhToan;
	}
	public HoaDon() {
		super();
	}
	
	public int getXacNhanThanhToan() {
		return XacNhanThanhToan;
	}
	public void setXacNhanThanhToan(int xacNhanThanhToan) {
		XacNhanThanhToan = xacNhanThanhToan;
	}
	public String getTenMau() {
		return TenMau;
	}
	public void setTenMau(String tenMau) {
		TenMau = tenMau;
	}
	public String getTenSize() {
		return TenSize;
	}
	public void setTenSize(String tenSize) {
		TenSize = tenSize;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public long getMaChiTietHoaDon() {
		return MaChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		MaChiTietHoaDon = maChiTietHoaDon;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public long getIDKhachHang() {
		return IDKhachHang;
	}
	public void setIDKhachHang(long iDKhachHang) {
		IDKhachHang = iDKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getThanhPho() {
		return ThanhPho;
	}
	public void setThanhPho(String thanhPho) {
		ThanhPho = thanhPho;
	}
	public String getDiaChiNha() {
		return DiaChiNha;
	}
	public void setDiaChiNha(String diaChiNha) {
		DiaChiNha = diaChiNha;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public long getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(long maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getMaMau() {
		return MaMau;
	}
	public void setMaMau(long maMau) {
		MaMau = maMau;
	}
	public long getMaSize() {
		return MaSize;
	}
	public void setMaSize(long maSize) {
		MaSize = maSize;
	}
	public String getPhuongThucThanhToan() {
		return PhuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		PhuongThucThanhToan = phuongThucThanhToan;
	}
	public long getTongTien() {
		return TongTien;
	}
	public void setTongTien(long tongTien) {
		TongTien = tongTien;
	}
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
	
}