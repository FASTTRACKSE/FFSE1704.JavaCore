package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.Phuong;

public class Phuong_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");

	ArrayList<Phuong> arrPhuong = new ArrayList<>();

	public ArrayList<Phuong> selectPhuong(String districtId) {
		
		arrPhuong.clear();
		try {
			String sql = "select * from Phuong where districtid = '" + districtId + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				String namePhuong = result.getString("name");
				arrPhuong.add(new Phuong(namePhuong));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return arrPhuong;
	}
}
