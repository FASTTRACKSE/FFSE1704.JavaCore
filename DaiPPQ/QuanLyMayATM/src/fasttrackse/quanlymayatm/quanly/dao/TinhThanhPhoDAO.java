/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;

/**
 * @author QuangDai
 * @param <Tinh>
 *
 */
public class TinhThanhPhoDAO<Tinh> {
	static Connection conn = null;

	/**
	 * @return the conn
	 */

	// Kết nối database
	public TinhThanhPhoDAO() {
		this.getConnect("localhost", "ql_atm", "mido", "0933237480");
	}

	// ngắt kết nối database
	public void disConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	// lấy danh sách tỉnh thành phố
	public static ArrayList<TinhThanhPho> getDSTinhThanhPho() {
		ArrayList<TinhThanhPho> dsTinhThanhPho = new ArrayList<TinhThanhPho>();

		try {
			String queryString = "SELECT * FROM ql_atm_tinhthanhpho";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int maTP = result.getInt("MaTP");
				String tenTP = result.getString("TenTP");

				dsTinhThanhPho.add(new TinhThanhPho(maTP, tenTP));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinhThanhPho;
	}

	// lấy danh sách quận huyện
	public static ArrayList<QuanHuyen> getDSQuanHuyen(int idTP) {
		ArrayList<QuanHuyen> DSQuanHuyen = new ArrayList<QuanHuyen>();
		try {
			String queryString = "SELECT MaQuan, TenQuan FROM ql_atm_quanhuyen WHERE MaTP ='" + idTP + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);
			while (result.next()) {
				QuanHuyen item = new QuanHuyen();
				item.setTenQuan(result.getString(2));
				item.setMaQuan(result.getInt(1));
				DSQuanHuyen.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return DSQuanHuyen;
	}

	// lấy danh sách phường xã
	public static ArrayList<PhuongXa> getDSPhuongXa(int idTP, int idQH) {
		ArrayList<PhuongXa> DSPhuongXa = new ArrayList<PhuongXa>();
		try {
			String queryString = "SELECT MaPhuong, TenPhuong FROM ql_atm_phuongxa WHERE MaTP = '" + idTP + "' AND MaQuan = '" + idQH + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);
			while (result.next()) {
				PhuongXa item = new PhuongXa();
				item.setTenPhuong(result.getString(2));
				item.setMaPhuong(result.getInt(1));
				DSPhuongXa.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DSPhuongXa;
	}

	public static ArrayList<PhuongXa> getDSPhuongXa(int idQH) {
		ArrayList<PhuongXa> DSPhuongXa = new ArrayList<PhuongXa>();
		try {
			String queryString = "SELECT MaPhuong, TenPhuong FROM ql_atm_phuongxa WHERE MaQuan = '" + idQH + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);
			while (result.next()) {
				PhuongXa item = new PhuongXa();
				item.setTenPhuong(result.getString(2));
				item.setMaPhuong(result.getInt(1));
				DSPhuongXa.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DSPhuongXa;
	}
}
