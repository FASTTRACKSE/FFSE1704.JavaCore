package ffse1703012.entity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.connect.*;
public class Phuong_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<Phuong> arrPhuong = new ArrayList<>();
	
	public ArrayList<Phuong> selectPhuong(String districtId){
		arrPhuong.clear();
		try {
			String sql = "select * from Phuong where districtid = '"+districtId+"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				String namePhuong = result.getString("name");
				 arrPhuong.add(new Phuong(namePhuong));

			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return arrPhuong;
	}
}
