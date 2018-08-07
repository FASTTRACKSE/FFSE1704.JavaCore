package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Login_Statement {
	final static Connection conn = (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123",
			"123");

	public static boolean login(String taikhoan, String matKhau) {
		try {
			String sql = "select count(*) from user where user_name = " + "'" + taikhoan + "'" + "and user_password = '" + matKhau + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			if(result.next())
			{
				return true;
				
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	}
