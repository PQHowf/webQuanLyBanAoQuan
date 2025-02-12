package GioHangModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

import SanPhamModel.SanPham;

public class GioHangDAO {
	public ArrayList<GioHang> dsGioHang = new ArrayList<GioHang>();

	public ArrayList<GioHang> getDsGioHang() {
		return dsGioHang;
	}

	public void setDsGioHang(ArrayList<GioHang> dsGioHang) {
		this.dsGioHang = dsGioHang;
	}
	
	public void ThemVaoGioHang(Long masp, String tensp, Long giasp, Long soluongsp, String anhsp) {
		for(GioHang h : dsGioHang) {
			if(h.getMaSanPham() == masp) {
				h.setSoLuong(h.getSoLuong() + soluongsp);
				return;
			}
		}
		dsGioHang.add(new GioHang(masp, tensp, giasp, soluongsp, anhsp));
	}
	
	public void CapNhatSoLuong(Long maSanPham, int quantityChange) {
	    for (GioHang h : dsGioHang) {
	        if (h.getMaSanPham().equals(maSanPham)) {
	            long newQuantity = h.getSoLuong() + quantityChange;
	            if (newQuantity < 1) {
	            	dsGioHang.remove(h);
	            }
	            h.setSoLuong(newQuantity);
	            h.setThanhTien(h.getGia() * newQuantity);
	            break;
	        }
	    }
	}
	
	public String TongThanhTien() {
		long t = 0L;
		for(GioHang h : dsGioHang) {
			t += h.getThanhTien();
		}
		DecimalFormat df = new DecimalFormat("#,###");
	    String formattedTotal = df.format(t);
	    
	    return formattedTotal;
	}
	
	public void Xoa(Long masp) {
		for(GioHang h : dsGioHang) {
			if(h.getMaSanPham() == masp) {
				dsGioHang.remove(h);
				break;
			}
		}
	}
	
	public void XoaTatCaSanPham() {
		dsGioHang.clear();
	}
	
	public long TongSoLuongSanPham() {
	    long tongSoLuong = 0;
	    for (GioHang h : dsGioHang) {
	        tongSoLuong += h.getSoLuong();
	    }
	    return tongSoLuong;
	}
}
