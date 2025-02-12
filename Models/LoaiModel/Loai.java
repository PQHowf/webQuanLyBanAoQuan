package LoaiModel;

public class Loai {
	private long MaLoai;
	private String TenLoai;
	public Loai(long maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	public Loai(String tenLoai) {
		super();
		TenLoai = tenLoai;
	}
	public Loai() {
		super();
	}
	public long getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(long maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	
}
