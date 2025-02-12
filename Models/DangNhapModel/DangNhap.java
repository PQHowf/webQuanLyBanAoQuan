package DangNhapModel;

public class DangNhap {
	private long IDTaiKhoan;
	private String TenDangNhap;
	private String MatKhau;
	private String HoVaTen;
	private String SoDienThoai;
	private String Email;
	private String DiaChiNha;
	private String ThanhPho;
	private String ChucVu;
	
	public DangNhap() {
		super();
	}

	public DangNhap(long idTaiKhoan, String tenDangNhap, String matKhau, String hoVaTen, String soDienThoai,
			String email, String diaChiNha, String thanhPho, String chucVu) {
		super();
		IDTaiKhoan = idTaiKhoan;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		HoVaTen = hoVaTen;
		SoDienThoai = soDienThoai;
		Email = email;
		DiaChiNha = diaChiNha;
		ThanhPho = thanhPho;
		ChucVu = chucVu;
	}
	

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
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

	public long getIDTaiKhoan() {
		return IDTaiKhoan;
	}

	public void setIDTaiKhoan(long idTaiKhoan) {
		IDTaiKhoan = idTaiKhoan;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
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
	
	
}
