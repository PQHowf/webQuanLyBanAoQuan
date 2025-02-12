package SanPhamModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KetNoiModel.KetNoi;

public class SanPhamDAO {
	ArrayList<SanPham> ds;
	
	public ArrayList<SanPham> getSanPham() throws Exception {
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM SanPham";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			Long MaSanPham = rs.getLong("MaSanPham");
			String TenSanPham = rs.getString("TenSanPham");
			Long Gia = rs.getLong("Gia");
			String MoTa = rs.getString("MoTa");
			String Anh = rs.getString("Anh");
			Long MaLoai = rs.getLong("MaLoai");
			dsSanPham.add(new SanPham(MaSanPham, TenSanPham, Gia, MoTa, Anh, MaLoai));
		}
		rs.close();
		kn.cn.close();
		return dsSanPham;
	}
	
	public ArrayList<SanPham> TimMa(String maLoai) throws Exception {
		if(ds==null || ds.isEmpty()) {
			ds = getSanPham();
		}
		ArrayList<SanPham> dsTheoMaLoai = new ArrayList<SanPham>();
		for(SanPham sp : ds) {
			if(sp.getMaLoai() == Long.parseLong(maLoai.trim())) {
				dsTheoMaLoai.add(sp);
			}
		}
		return dsTheoMaLoai;
	}
	
	public ArrayList<SanPham> Tim(String key) throws Exception {
		if(ds==null || ds.isEmpty()) {
			ds = getSanPham();
		}
		ArrayList<SanPham> dsTim = new ArrayList<SanPham>();
		for(SanPham sp : ds) {
			if(sp.getTenSanPham().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				dsTim.add(sp);
			}
		}
		return dsTim;
	}
	
	public List<SanPham> laySanPhamPhanTrang(int page, int limit) {
	    List<SanPham> dsSanPham = new ArrayList<>();
	    String sql = "SELECT * FROM SanPham ORDER BY MaSanPham OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	    try {
	    	KetNoi kn = new KetNoi();
			kn.ketnoi();
			PreparedStatement ps = kn.cn.prepareStatement(sql);
	        ps.setInt(1, (page - 1) * limit);
	        ps.setInt(2, limit);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            SanPham sp = new SanPham();
	            sp.setMaSanPham(rs.getInt("MaSanPham"));
	            sp.setTenSanPham(rs.getString("TenSanPham"));
	            sp.setGia(rs.getLong("Gia"));
	            sp.setMoTa(rs.getString("MoTa"));
	            sp.setAnh(rs.getString("Anh"));
	            sp.setMaLoai(rs.getInt("MaLoai"));
	            dsSanPham.add(sp);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return dsSanPham;
	}

	public int demTongSanPham() {
	    String sql = "SELECT COUNT(*) FROM SanPham";
	    try {
	    	KetNoi kn = new KetNoi();
	    	kn.ketnoi();
	    	PreparedStatement ps = kn.cn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	public boolean XoaSanPham(long masp) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM SanPham WHERE MaSanPham = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, masp);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int ThemSanPham(SanPham sp) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO SanPham(TenSanPham, Gia, MoTa, Anh, MaLoai) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, sp.getTenSanPham());
			ps.setLong(2, sp.getGia());
			ps.setString(3, sp.getMoTa());
			ps.setString(4, sp.getAnh());
			ps.setLong(5, sp.getMaLoai());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public SanPham getSanPhamByMaSanPham(Long masp) {
		SanPham sp = null;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "SELECT * FROM SanPham WHERE MaSanPham = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, masp);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sp = new SanPham(
						rs.getLong("MaSanPham"),
						rs.getString("TenSanPham"),
						rs.getLong("Gia"),
						rs.getString("MoTa"),
						rs.getString("Anh"),
						rs.getLong("MaLoai")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	public int CapNhatSanPham(SanPham sp) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE SanPham SET TenSanPham = ?, Gia = ?, MoTa = ?, Anh = ?, MaLoai = ? WHERE MaSanPham = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, sp.getTenSanPham());
			ps.setLong(2, sp.getGia());
			ps.setString(3, sp.getMoTa());
			ps.setString(4, sp.getAnh());
			ps.setLong(5, sp.getMaLoai());
			ps.setLong(6, sp.getMaSanPham());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
