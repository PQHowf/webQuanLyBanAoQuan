package LoaiModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModel.KetNoi;
import SanPhamModel.SanPham;

public class LoaiDAO {
	ArrayList<Loai> dsLoai;
	
	public ArrayList<Loai> getLoai() throws Exception {
		ArrayList<Loai> dsLoai = new ArrayList<Loai>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM Loai";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			Long maLoai = rs.getLong("MaLoai");
			String tenLoai = rs.getString("TenLoai");
			dsLoai.add(new Loai(maLoai, tenLoai));
		}
		rs.close();
		kn.cn.close();
		return dsLoai;
	}
	
	public ArrayList<Loai> Tim(String key) throws Exception {
		if(dsLoai==null || dsLoai.isEmpty()) {
			dsLoai = getLoai();
		}
		ArrayList<Loai> dsTim = new ArrayList<Loai>();
		for(Loai l : dsLoai) {
			if(l.getTenLoai().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				dsTim.add(l);
			}
		}
		return dsTim;
	}
	
	public int ThemLoai(Loai l) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO Loai(TenLoai) VALUES (?)";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, l.getTenLoai());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int XoaLoai(long maloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM Loai WHERE MaLoai = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, maloai);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Loai getLoaiByMaLoai(Long maloai) {
		Loai l = null;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "SELECT * FROM Loai WHERE MaLoai = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, maloai);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				l = new Loai(rs.getLong("MaLoai"), rs.getString("TenLoai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public int CapNhatLoai(Loai l) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE Loai SET TenLoai = ? WHERE MaLoai = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, l.getTenLoai());
			ps.setLong(2, l.getMaLoai());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
