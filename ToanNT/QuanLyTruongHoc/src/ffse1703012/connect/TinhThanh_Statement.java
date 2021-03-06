package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.TinhThanh;


public class TinhThanh_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	public ArrayList<TinhThanh> selectAll() {
	

		try {
			//ps = (PreparedStatement) conn.prepareStatement("select * from Tinh_thanh");
			//ResultSet result = ps.executeQuery();
			String sql = "select * from Tinh_thanh";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while (result.next()) {
				String provinceId = result.getString("provinceid");
				String name = result.getString("name");
				arrTinhThanh.add(new TinhThanh(provinceId, name));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrTinhThanh;
	}
}
