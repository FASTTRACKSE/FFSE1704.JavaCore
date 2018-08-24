package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.PhanMon;
import ffse1703012.entity.QuanLyMonHoc;

public class PhanMon_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<QuanLyMonHoc> arrPhanMon = new ArrayList<>();
	ArrayList<PhanMon> arrAllPhanMon = new ArrayList<>();

	public ArrayList<QuanLyMonHoc> sellecPhanMon(String ma) {
		
		arrPhanMon.clear();
		try {
			String sql = "select Mon_hoc.Tenmon, Phan_mon.Mamon from Mon_hoc left join Phan_mon on Mon_hoc.Mamon = Phan_mon.Mamon where Phan_mon.Malop ="
					+ "'" + ma + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String tenMon = result.getString("Mon_hoc.Tenmon");
				String maMon = result.getString("Phan_mon.Mamon");
				arrPhanMon.add(new QuanLyMonHoc(tenMon,maMon));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrPhanMon;
	}


	public void insertPhanMon(String maLop, String maMon) {
		try {
			String sql = "insert into Phan_mon values('" + 0 + "','" + maLop + "', '" + maMon + "')";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletePhanMon(String maLop, String maMon) {
		try {
			String sql = "delete from Phan_mon where Mamon='" + maMon + "'" + "and" + " Malop='" + maLop + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteLopPhanMon(String maLop) {
		try {
			String sql = "delete from Phan_mon where Malop='" + maLop + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
