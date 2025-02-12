package TaiKhoanModel;

public class TaiKhoan {
	private long IDTaiKhoan;
	private String TenTaiKhoan;
	private String MatKhau;
	private String HoVaTen;
	private String SoDienThoai;
	private String Email;
	private String DiaChiNha;
	private String ThanhPho;
	private String ChucVu;
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(long iDTaiKhoan, String tenTaiKhoan, String matKhau, String hoVaTen, String soDienThoai,
			String email, String diaChiNha, String thanhPho, String chucVu) {
		super();
		IDTaiKhoan = iDTaiKhoan;
		TenTaiKhoan = tenTaiKhoan;
		MatKhau = matKhau;
		HoVaTen = hoVaTen;
		SoDienThoai = soDienThoai;
		Email = email;
		DiaChiNha = diaChiNha;
		ThanhPho = thanhPho;
		ChucVu = chucVu;
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau, String hoVaTen, String soDienThoai,
			String email, String diaChiNha, String thanhPho, String chucVu) {
		super();
		TenTaiKhoan = tenTaiKhoan;
		MatKhau = matKhau;
		HoVaTen = hoVaTen;
		SoDienThoai = soDienThoai;
		Email = email;
		DiaChiNha = diaChiNha;
		ThanhPho = thanhPho;
		ChucVu = chucVu;
	}
	public long getIDTaiKhoan() {
		return IDTaiKhoan;
	}
	public void setIDTaiKhoan(long iDTaiKhoan) {
		IDTaiKhoan = iDTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getHoVaTen() {
		return HoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		HoVaTen = hoVaTen;
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
	public String getDiaChiNha() {
		return DiaChiNha;
	}
	public void setDiaChiNha(String diaChiNha) {
		DiaChiNha = diaChiNha;
	}
	public String getThanhPho() {
		return ThanhPho;
	}
	public void setThanhPho(String thanhPho) {
		ThanhPho = thanhPho;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	
}
