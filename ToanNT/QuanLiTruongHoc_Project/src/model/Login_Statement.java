package model;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class Login_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	int kt;
	
	public int check(String taiKhoan, String matKhau) {
		kt = 0;
		try {
			String sql = "select count(*) from user where user_name = " + "'" + taiKhoan + "'" + "and user_password = '" + matKhau + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				kt = result.getInt("COUNT(*)");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return kt;
	}

}
