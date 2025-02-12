package GioHangModel;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHang {
	private Long MaSanPham;
	private String TenSanPham;
	private Long Gia;
	private Long SoLuong;
	private String Anh;
	private Long ThanhTien;
	private Long MaMau;
	private Long MaKichThuoc;
	public GioHang() {
		super();
	}
	public GioHang(Long maSanPham, String tenSanPham, Long gia, Long soLuong, String anh) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		Gia = gia;
		SoLuong = soLuong;
		Anh = anh;
		ThanhTien = soLuong * gia;
	}
	
	
	public GioHang(Long maSanPham, String tenSanPham, Long gia, Long soLuong, String anh, Long thanhTien, Long maMau,
			Long maKichThuoc) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		Gia = gia;
		SoLuong = soLuong;
		Anh = anh;
		ThanhTien = thanhTien;
		MaMau = maMau;
		MaKichThuoc = maKichThuoc;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Long getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(Long maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public Long getGia() {
		return Gia;
	}
	public String getGiaDinhDang() {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(Gia);
    }
	public String getThanhTienDinhDang() {
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(Gia*SoLuong);
	}
	public void setGia(Long gia) {
		Gia = gia;
	}
	public Long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
	public Long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Long getMaMau() {
		return MaMau;
	}
	public void setMaMau(Long maMau) {
		MaMau = maMau;
	}
	public Long getMaKichThuoc() {
		return MaKichThuoc;
	}
	public void setMaKichThuoc(Long maKichThuoc) {
		MaKichThuoc = maKichThuoc;
	}
	
	
	
}
