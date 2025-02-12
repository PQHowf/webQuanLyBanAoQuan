package DangNhapModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import KetNoiModel.KetNoi;

public class DangNhapDAO {
	public DangNhap kiemtradangnhap(String tenTaiKhoan, String matKhau) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM TaiKhoan WHERE TenTaiKhoan=? AND MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenTaiKhoan);
		cmd.setString(2, matKhau);
		ResultSet rs = cmd.executeQuery();
		DangNhap dn = null;
		if(rs.next()) {
			long IDTaiKhoan = rs.getLong("IDTaiKhoan");
			String TenTaiKhoan = rs.getString("TenTaiKhoan");
			String MatKhau = rs.getString("MatKhau");
			String HoVaTen = rs.getString("HoVaTen");
			String SoDienThoai = rs.getString("SoDienThoai");
			String Email = rs.getString("Email");
			String DiaChiNha = rs.getString("DiaChiNha");
			String ThanhPho = rs.getString("ThanhPho");
			String ChucVu = rs.getString("ChucVu");
			
			dn = new DangNhap(IDTaiKhoan, TenTaiKhoan, MatKhau, HoVaTen, SoDienThoai, Email, DiaChiNha, ThanhPho, ChucVu);
		}
		rs.close();
		kn.cn.close();
		return dn;
	}
}
