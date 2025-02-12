package KichThuocModel;

public class KichThuoc {
	private Long MaKichThuoc;
	private String TenKichThuoc;
	public KichThuoc(Long maKichThuoc, String tenKichThuoc) {
		super();
		MaKichThuoc = maKichThuoc;
		TenKichThuoc = tenKichThuoc;
	}
	public KichThuoc(String tenKichThuoc) {
		super();
		TenKichThuoc = tenKichThuoc;
	}
	public KichThuoc() {
		super();
	}
	public Long getMaKichThuoc() {
		return MaKichThuoc;
	}
	public void setMaKichThuoc(Long maKichThuoc) {
		MaKichThuoc = maKichThuoc;
	}
	public String getTenKichThuoc() {
		return TenKichThuoc;
	}
	public void setTenKichThuoc(String tenKichThuoc) {
		TenKichThuoc = tenKichThuoc;
	}
	
}
