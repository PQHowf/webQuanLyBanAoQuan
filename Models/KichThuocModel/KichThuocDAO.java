package KichThuocModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModel.KetNoi;
import LoaiModel.Loai;

public class KichThuocDAO {
	ArrayList<KichThuoc> dsSize;
	
	public ArrayList<KichThuoc> getKichThuoc() throws Exception {
		ArrayList<KichThuoc> dsKichThuoc = new ArrayList<KichThuoc>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM KichThuoc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maKichThuoc = rs.getString("MaKichThuoc");
			String tenKichThuoc = rs.getString("TenKichThuoc");
			dsKichThuoc.add(new KichThuoc(Long.parseLong(maKichThuoc), tenKichThuoc));
		}
		rs.close();
		kn.cn.close();
		return dsKichThuoc;
	}
	
	public ArrayList<KichThuoc> Tim(String key) throws Exception {
		if(dsSize==null || dsSize.isEmpty()) {
			dsSize = getKichThuoc();
		}
		ArrayList<KichThuoc> dsTim = new ArrayList<KichThuoc>();
		for(KichThuoc kt : dsSize) {
			if(kt.getTenKichThuoc().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				dsTim.add(kt);
			}
		}
		return dsTim;
	}
	
	public int ThemSize(KichThuoc kt) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO KichThuoc(TenKichThuoc) VALUES (?)";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, kt.getTenKichThuoc());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int XoaSize(long masize) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM KichThuoc WHERE MaKichThuoc = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, masize);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public KichThuoc getKichThuocByMaKichThuoc(Long makichthuoc) {
		KichThuoc kt = null;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "SELECT * FROM KichThuoc WHERE MaKichThuoc = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, makichthuoc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				kt = new KichThuoc(rs.getLong("MaKichThuoc"), rs.getString("TenKichThuoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kt;
	}
	
	public int CapNhatKichThuoc(KichThuoc kt) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE KichThuoc SET TenKichThuoc = ? WHERE MaKichThuoc = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, kt.getTenKichThuoc());
			ps.setLong(2, kt.getMaKichThuoc());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
