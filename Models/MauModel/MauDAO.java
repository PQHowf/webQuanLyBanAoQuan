package MauModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModel.KetNoi;
import LoaiModel.Loai;

public class MauDAO {
	ArrayList<Mau> dsMau;
	
	public ArrayList<Mau> getMau() throws Exception {
		ArrayList<Mau> dsMau = new ArrayList<Mau>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM Mau";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maMau = rs.getString("MaMau");
			String tenMau = rs.getString("TenMau");
			dsMau.add(new Mau(Long.parseLong(maMau), tenMau));
		}
		rs.close();
		kn.cn.close();
		return dsMau;
	}
	public ArrayList<Mau> Tim(String key) throws Exception {
		if(dsMau==null || dsMau.isEmpty()) {
			dsMau = getMau();
		}
		ArrayList<Mau> dsTim = new ArrayList<Mau>();
		for(Mau m : dsMau) {
			if(m.getTenMau().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				dsTim.add(m);
			}
		}
		return dsMau;
	}
	
	public int ThemMau(Mau m) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO Mau(TenMau) VALUES (?)";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, m.getTenMau());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int XoaMau(long mamau) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM Mau WHERE MaMau = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, mamau);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Mau getMauByMaMau(Long mamau) {
		Mau m = null;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "SELECT * FROM Mau WHERE MaMau = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, mamau);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m = new Mau(rs.getLong("MaMau"), rs.getString("TenMau"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public int CapNhatMau(Mau m) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE Mau SET TenMau = ? WHERE MaMau = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, m.getTenMau());
			ps.setLong(2, m.getMaMau());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
