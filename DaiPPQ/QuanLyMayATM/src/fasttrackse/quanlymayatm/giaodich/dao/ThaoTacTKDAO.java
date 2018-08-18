/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.giaodich.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlymayatm.giaodich.entity.ThaoTacTaiKhoang;

/**
 * @author QuangDai
 *
 */
public class ThaoTacTKDAO {
	static Connection conn = null;

	/**
	 * @return the conn
	 */

	// Kết nối database
	public ThaoTacTKDAO() {
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

	// update số PIN
	public static void update(ThaoTacTaiKhoang id) {
		try {
			String queryString = "UPDATE ql_atm_theatm SET PIN = ? WHERE MaThe = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, id.getPIN());
			statement.setString(2, id.getMaThe());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
