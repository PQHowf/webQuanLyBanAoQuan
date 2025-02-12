package TaiKhoanModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModel.KetNoi;

public class TaiKhoanDAO {
	ArrayList<TaiKhoan> dsTaiKhoan; 
	
	public boolean KiemTraTaiKhoanTonTai(String tenTaiKhoan) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT COUNT(*) AS SoLuong FROM TaiKhoan WHERE TenTaiKhoan = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, tenTaiKhoan);
		ResultSet rs = ps.executeQuery();
		boolean check = false;
		if(rs.next()) {
			int soLuong = rs.getInt("SoLuong");
			if(soLuong > 0) {
				check = true;
			}
		}
		rs.close();
		ps.close();
		kn.cn.close();
		return check;
	}
	
	public long DangKyTaiKhoan(TaiKhoan taiKhoan) throws Exception {
		long IDTaiKhoan = 0;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO TaiKhoan(TenTaiKhoan, MatKhau, HoVaTen, SoDienThoai, Email, DiaChiNha, ThanhPho, ChucVu) " +
	                 "OUTPUT INSERTED.IDTaiKhoan VALUES (?, ?, ?, ?, ?, ?, ?, 'NguoiDung')";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, taiKhoan.getTenTaiKhoan());
	        ps.setString(2, taiKhoan.getMatKhau());
	        ps.setString(3, taiKhoan.getHoVaTen());
	        ps.setString(4, taiKhoan.getSoDienThoai());
	        ps.setString(5, taiKhoan.getEmail());
	        ps.setString(6, taiKhoan.getDiaChiNha());
	        ps.setString(7, taiKhoan.getThanhPho());
	        ResultSet rs = ps.executeQuery();
	
	        if (rs.next()) {
	            IDTaiKhoan = rs.getLong("IDTaiKhoan");
	        }

	        // Đóng kết nối
	        rs.close();
	        ps.close();
	        kn.cn.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return IDTaiKhoan;
	}
	
	public ArrayList<TaiKhoan> getTaiKhoan() throws Exception {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM TaiKhoan";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			Long maTaiKhoan = rs.getLong("IDTaiKhoan");
			String tenTaiKhoan = rs.getString("TenTaiKhoan");
			String matKhau = rs.getString("MatKhau");
			String hoVaTen = rs.getString("HoVaTen");
			String soDienThoai = rs.getString("SoDienThoai");
			String email = rs.getString("Email");
			String diaChiNha = rs.getString("DiaChiNha");
			String thanhPho = rs.getString("ThanhPho");
			String chucVu = rs.getString("ChucVu");
			
			dsTaiKhoan.add(new TaiKhoan(maTaiKhoan, tenTaiKhoan, matKhau, hoVaTen, soDienThoai, email, diaChiNha, thanhPho, chucVu));
		}
		rs.close();
		kn.cn.close();
		return dsTaiKhoan;
	}
	
	public ArrayList<TaiKhoan> Tim(String key) throws Exception {
		if(dsTaiKhoan==null || dsTaiKhoan.isEmpty()) {
			dsTaiKhoan = getTaiKhoan();
		}
		ArrayList<TaiKhoan> dsTim = new ArrayList<TaiKhoan>();
		for(TaiKhoan tk : dsTaiKhoan) {
			if(tk.getTenTaiKhoan().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				dsTim.add(tk);
			}
		}
		return dsTim;
	}
	
	public int ThemTaiKhoan(TaiKhoan tk) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "INSERT INTO TaiKhoan(TenTaiKhoan, MatKhau, HoVaTen, SoDienThoai, Email, DiaChiNha, ThanhPho, ChucVu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, tk.getTenTaiKhoan());
			ps.setString(2, tk.getMatKhau());
			ps.setString(3, tk.getHoVaTen());
			ps.setString(4, tk.getSoDienThoai());
			ps.setString(5, tk.getEmail());
			ps.setString(6, tk.getDiaChiNha());
			ps.setString(7, tk.getThanhPho());
			ps.setString(8, tk.getChucVu());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public TaiKhoan getTaiKhoanByMaTaiKhoan(Long matk) {
		TaiKhoan tk = null;
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "SELECT * FROM TaiKhoan WHERE IDTaiKhoan = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, matk);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tk = new TaiKhoan(
						rs.getLong("IDTaiKhoan"), 
						rs.getString("TenTaiKhoan"), 
						rs.getString("MatKhau"), 
						rs.getString("HoVaTen"), 
						rs.getString("SoDienThoai"), 
						rs.getString("Email"), 
						rs.getString("DiaChiNha"),
						rs.getString("ThanhPho"),
						rs.getString("ChucVu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public int CapNhatTaiKhoan(TaiKhoan tk) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE TaiKhoan SET TenTaiKhoan = ?, MatKhau = ?, HoVaTen = ?, SoDienThoai = ?, Email = ?, DiaChiNha = ?, ThanhPho = ?, ChucVu = ? WHERE IDTaiKhoan = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setString(1, tk.getTenTaiKhoan());
			ps.setString(2, tk.getMatKhau());
			ps.setString(3, tk.getHoVaTen());
			ps.setString(4, tk.getSoDienThoai());
			ps.setString(5, tk.getEmail());
			ps.setString(6, tk.getDiaChiNha());
			ps.setString(7, tk.getThanhPho());
			ps.setString(8, tk.getChucVu());
			ps.setLong(9, tk.getIDTaiKhoan());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int XoaTaiKhoan(long mataikhoan) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "DELETE FROM TaiKhoan WHERE IDTaiKhoan = ?";
			PreparedStatement ps = kn.cn.prepareStatement(sql);
			ps.setLong(1, mataikhoan);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
