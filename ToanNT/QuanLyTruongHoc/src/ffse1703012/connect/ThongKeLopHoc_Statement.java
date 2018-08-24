package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.QuanLyLop;


public class ThongKeLopHoc_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<String> arrNamHoc = new ArrayList<>();
	ArrayList<QuanLyLop> arrDanhSachLop = new ArrayList<>();
	public ArrayList<String> sellectNamHoc(){
		arrNamHoc.clear();
		try {
			String sql = "select distinct Namhoc from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String namHoc = result.getString("Namhoc");
				
				 arrNamHoc.add(namHoc);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrNamHoc;
	}
}
