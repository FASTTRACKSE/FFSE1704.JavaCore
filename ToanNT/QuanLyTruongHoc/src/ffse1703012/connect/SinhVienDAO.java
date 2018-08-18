package ffse1703012.connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class SinhVienDAO {


	public Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";

		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	//Đăng nhập
//	public boolean login(String username, String password) {
//		try {
//			PreparedStatement statement = conn
//					.prepareStatement("select * from user where user_name = ? and user_password = ?");
//			statement.setString(1, username);
//			statement.setString(2, password);
//			ResultSet result = statement.executeQuery();
//			if (result.next()) {
//				return true;
//
//			} else {
//				return false;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}


	
	

}
