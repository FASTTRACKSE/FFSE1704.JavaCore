package ffse1703012.entity;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.connect.*;

public class QuanHuyen_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	
	public ArrayList<QuanHuyen> selectQuanHuyen(String provinceId){
		arrQuanHuyen.clear();
		try {
			String sql = "select * from Quan_huyen where provinceid =" + "'"+ provinceId +"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);

			while(result.next())
			{
				 String name = result.getString("name");
				 String districtId = result.getString("districtid");
				 arrQuanHuyen.add(new QuanHuyen(name, districtId));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrQuanHuyen;
	}
}
