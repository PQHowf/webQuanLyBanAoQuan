package SanPhamModel;

import java.text.NumberFormat;
import java.util.Locale;

public class SanPham {
	private long MaSanPham;
	private String TenSanPham;
	private long Gia;
	private String MoTa;
	private String Anh;
	private long MaLoai;
	public SanPham() {
		super();
	}
	public SanPham(String tenSanPham, long gia, String moTa, String anh, long maLoai) {
		super();
		TenSanPham = tenSanPham;
		Gia = gia;
		MoTa = moTa;
		Anh = anh;
		MaLoai = maLoai;
	}
	public SanPham(long maSanPham, String tenSanPham, long gia, String moTa, String anh, long maLoai) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		Gia = gia;
		MoTa = moTa;
		Anh = anh;
		MaLoai = maLoai;
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
	public long getGia() {
		return Gia;
	}
	public String getGiaDinhDang() {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(Gia);
    }
	public void setGia(long gia) {
		Gia = gia;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public long getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(long maLoai) {
		MaLoai = maLoai;
	}
	
	
}
