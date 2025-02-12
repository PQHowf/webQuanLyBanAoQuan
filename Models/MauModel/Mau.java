package MauModel;

public class Mau {
	private Long MaMau;
	private String TenMau;
	public Mau() {
		super();
	}
	public Mau(Long maMau, String tenMau) {
		super();
		MaMau = maMau;
		TenMau = tenMau;
	}
	public Mau(String tenMau) {
		super();
		TenMau = tenMau;
	}
	public Long getMaMau() {
		return MaMau;
	}
	public void setMaMau(Long maMau) {
		MaMau = maMau;
	}
	public String getTenMau() {
		return TenMau;
	}
	public void setTenMau(String tenMau) {
		TenMau = tenMau;
	}
	
}
