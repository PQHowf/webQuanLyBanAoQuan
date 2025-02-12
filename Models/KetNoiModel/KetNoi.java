package KetNoiModel;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://HOWF\\SQLEXPRESS:1433;databaseName=AoQuanShop;user=sa;password=123;useUnicode=true&characterEncoding=UTF-8";
		cn = DriverManager.getConnection(url);
		System.out.println("Đã kết nối");
	}
}
