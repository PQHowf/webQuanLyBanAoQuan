package HoaDonModel;

public class ChiTietHoaDon {
	private Long maChiTietHoaDon;
    private Long maHoaDon;
    private Long maSanPham;
    private String tenSanPham;
    private Long idTaiKhoan;
    private int soLuongSanPham;
    private Long maMau;
    private Long maKichThuoc;
    private Double tongTien;
    private String hoVaTen;
    private String tenMau;
    private String tenKichThuoc;
    private String anh; 
	public ChiTietHoaDon(Long maChiTietHoaDon, Long maHoaDon, Long maSanPham, String tenSanPham, Long idTaiKhoan,
			int soLuongSanPham, Long maMau, Long maKichThuoc, Double tongTien, String hoVaTen, String tenMau, String tenKichThuoc, String anh) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.idTaiKhoan = idTaiKhoan;
		this.soLuongSanPham = soLuongSanPham;
		this.maMau = maMau;
		this.maKichThuoc = maKichThuoc;
		this.tongTien = tongTien;
		this.hoVaTen = hoVaTen;
		this.tenMau = tenMau;
		this.tenKichThuoc = tenKichThuoc;
		this.anh = anh;
	}
	public ChiTietHoaDon() {
		super();
	}
	
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	public String getTenKichThuoc() {
		return tenKichThuoc;
	}
	public void setTenKichThuoc(String tenKichThuoc) {
		this.tenKichThuoc = tenKichThuoc;
	}
	public Long getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(Long maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}
	public Long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Long getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(Long maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public Long getIdTaiKhoan() {
		return idTaiKhoan;
	}
	public void setIdTaiKhoan(Long idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public Long getMaMau() {
		return maMau;
	}
	public void setMaMau(Long maMau) {
		this.maMau = maMau;
	}
	public Long getMaKichThuoc() {
		return maKichThuoc;
	}
	public void setMaKichThuoc(Long maKichThuoc) {
		this.maKichThuoc = maKichThuoc;
	}
	public Double getTongTien() {
		return tongTien;
	}
	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
    
}
