package fasttrackse.javacore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.javacore.entity.QuanLiDiaChi;
import fasttrackse.javacore.entity.QuanLiThongTinQuan1;
import fasttrackse.javacore.entity.QuanLiPhuong1;
public class DBTinh {
	static Connection conn = null;

	/**
	 * @return the conn
	 */
	public static Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		DBTinh.conn = conn;
	}

	public ArrayList<QuanLiDiaChi> getList() {
		ArrayList<QuanLiDiaChi> dsTinh = new ArrayList<QuanLiDiaChi>();
		try {
			String queryString = "SELECT provinceid,name FROM `province`";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String id = result.getString("provinceid");
				String Tinh = result.getString("name");
				dsTinh.add(new QuanLiDiaChi(id, Tinh));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinh;
	}


	public ArrayList<QuanLiThongTinQuan1> getListQuan(String idTinh) {
		ArrayList<QuanLiThongTinQuan1> dsQuan = new ArrayList<QuanLiThongTinQuan1>();
		try {
			String queryString = "SELECT * FROM `district` where provinceid='"+idTinh+"'";
			PreparedStatement statement = conn.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String id = result.getString("districtid");
				String Tinh = result.getString("name");
				dsQuan.add(new QuanLiThongTinQuan1(id, Tinh));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsQuan;
	}
	public ArrayList<QuanLiPhuong1> getListPhuong(String idQuan) {
		ArrayList<QuanLiPhuong1> dsPhuong = new ArrayList<QuanLiPhuong1>();
		try {
			String queryString = "SELECT wardid,name FROM `ward`where districtid='"+idQuan+"'";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String id = result.getString("wardid");
				String Tinh = result.getString("name");
				dsPhuong.add(new QuanLiPhuong1(id, Tinh));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsPhuong;
	}
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=yes&characterEncoding=UTF-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
