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

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlymayatm.quanly.entity.QuanLyGiaoDich;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhTrangMayATM;

/**
 * @author QuangDai
 *
 */
public class QuanLyGiaoDichDAO {
	static Connection conn = null;

	/**
	 * @return the conn
	 */

	// Kết nối database
	public QuanLyGiaoDichDAO() {
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

	// Danh sách giao dịch thông qua mã máy
	public static ArrayList<QuanLyGiaoDich> timkiem(String mamay) {
		ArrayList<QuanLyGiaoDich> dsGD = new ArrayList<QuanLyGiaoDich>();
		try {
			String queryString = "SELECT MaGD, MaMay, ql_atm_thongtinkhachhang.TenKH, MaThe, SoTien, ql_atm_loaigiaodich.Mota \r\n"
					+ " FROM ql_atm_giaodich \r\n"
					+ " INNER JOIN ql_atm_thongtinkhachhang \r\n"
					+ " ON ql_atm_giaodich.IDKH = ql_atm_thongtinkhachhang.MaKH \r\n"
					+ " INNER JOIN ql_atm_loaigiaodich \r\n"
					+ " ON ql_atm_giaodich.LoaiGD = ql_atm_loaigiaodich.ID \r\n"
					+ " WHERE MaMay = '" + mamay + "' \r\n" + " ORDER BY MaGD";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);

			while (result.next()) {
				String maGD = result.getString("MaGD");
				String maMay = result.getString("MaMay");
				String tenKH = result.getString("TenKH");
				String maThe = result.getString("MaThe");
				String soTien = result.getString("SoTien");
				String moTa = result.getString("Mota");

				dsGD.add(new QuanLyGiaoDich(maGD, maMay, tenKH, maThe, soTien, moTa));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGD;
	}
}
