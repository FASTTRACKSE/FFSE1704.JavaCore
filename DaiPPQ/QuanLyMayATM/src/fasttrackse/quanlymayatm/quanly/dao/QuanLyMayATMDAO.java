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

import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhTrangMayATM;

/**
 * @author QuangDai
 * @param <Tinh>
 *
 */
public class QuanLyMayATMDAO<Tinh> {
	static Connection conn = null;

	/**
	 * @return the conn
	 */

	// Kết nối database
	public QuanLyMayATMDAO() {
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

	public static ArrayList<QuanLyMayATM> getDSMayATM() {
		ArrayList<QuanLyMayATM> dsMayATM = new ArrayList<QuanLyMayATM>();
		try {
			String queryString = "SELECT ql_atm_danhsachmayatm.MaMay, ql_atm_tinhthanhpho.TenTP, ql_atm_quanhuyen.TenQuan, ql_atm_phuongxa.TenPhuong, "
					+ "	ql_atm_danhsachmayatm.ViTri, ql_atm_tinhtrangmayatm.MoTa, ql_atm_danhsachmayatm.TongTien\r\n"
					+ "	FROM ql_atm_danhsachmayatm\r\n" + "	INNER JOIN ql_atm_tinhthanhpho\r\n"
					+ "	ON ql_atm_danhsachmayatm.ThanhPho = ql_atm_tinhthanhpho.MaTP\r\n"
					+ "	INNER JOIN ql_atm_quanhuyen\r\n"
					+ "	ON (ql_atm_danhsachmayatm.ThanhPho = ql_atm_quanhuyen.MaTP AND ql_atm_danhsachmayatm.Quan = ql_atm_quanhuyen.MaQuan)\r\n"
					+ "	INNER JOIN ql_atm_phuongxa\r\n"
					+ "	ON (ql_atm_danhsachmayatm.ThanhPho = ql_atm_phuongxa.MaTP AND ql_atm_danhsachmayatm.Quan = ql_atm_phuongxa.MaQuan AND ql_atm_danhsachmayatm.Phuong = ql_atm_phuongxa.MaPhuong)\r\n"
					+ "	INNER JOIN ql_atm_tinhtrangmayatm\r\n"
					+ "	ON ql_atm_danhsachmayatm.TinhTrang = ql_atm_tinhtrangmayatm.MaTT\r\n" + " ORDER BY MaMay";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String maMay = result.getString("MaMay");
				String tenTP = result.getString("TenTP");
				String tenQuan = result.getString("TenQuan");
				String tenPhuong = result.getString("TenPhuong");
				String viTri = result.getString("ViTri");
				String moTa = result.getString("MoTa");
				String tongTien = result.getString("TongTien");

				dsMayATM.add(new QuanLyMayATM(maMay, tenTP, tenQuan, tenPhuong, viTri, moTa, tongTien));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsMayATM;
	}

	public static ArrayList<TinhTrangMayATM> getDSTinhTrangMayATM() {
		ArrayList<TinhTrangMayATM> dsTinhTrang = new ArrayList<TinhTrangMayATM>();

		try {
			String queryString = "SELECT * FROM ql_atm_tinhtrangmayatm";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int maTT = result.getInt("MaTT");
				String moTa = result.getString("MoTa");

				dsTinhTrang.add(new TinhTrangMayATM(maTT, moTa));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinhTrang;
	}

	// Sửa thông tin máy ATm
	public static void update(QuanLyMayATM qlmatm) {
		try {
			String queryString = "UPDATE ql_atm_danhsachmayatm SET ThanhPho = ?, Quan = ?, Phuong = ?, ViTri = ? , TinhTrang = ?, TongTien = ? WHERE MaMay = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, qlmatm.getThanhPho());
			statement.setString(2, qlmatm.getQuan());
			statement.setString(3, qlmatm.getPhuong());
			statement.setString(4, qlmatm.getViTri());
			statement.setString(5, qlmatm.getTinhTrang());
			statement.setString(6, qlmatm.getTongTien());

			statement.setString(7, qlmatm.getMaMay());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Xóa thông tin máy ATM
	public static void delete(String maMay) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM ql_atm_danhsachmayatm WHERE MaMay = ?");
			statement.setString(1, maMay);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Thêm thông tin máy ATM
	public static void add(QuanLyMayATM qlmatm) {
		try {
			String queryString = "INSERT INTO ql_atm_danhsachmayatm(ThanhPho, Quan, Phuong, ViTri, TinhTrang, TongTien) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, qlmatm.getThanhPho());
			statement.setString(2, qlmatm.getQuan());
			statement.setString(3, qlmatm.getPhuong());
			statement.setString(4, qlmatm.getViTri());
			statement.setString(5, qlmatm.getTinhTrang());
			statement.setString(6, qlmatm.getTongTien());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Tìm kiếm DS máy ATM
	public static ArrayList<QuanLyMayATM> timkiem(int idTP, int idQH, int idPX) {
		ArrayList<QuanLyMayATM> dsMayATM = new ArrayList<QuanLyMayATM>();
		try {
			String queryString = "SELECT ql_atm_danhsachmayatm.MaMay, ql_atm_tinhthanhpho.TenTP, ql_atm_quanhuyen.TenQuan, ql_atm_phuongxa.TenPhuong, "
					+ "	ql_atm_danhsachmayatm.ViTri, ql_atm_tinhtrangmayatm.MoTa, ql_atm_danhsachmayatm.TongTien\r\n"
					+ "	FROM ql_atm_danhsachmayatm\r\n" + "	INNER JOIN ql_atm_tinhthanhpho\r\n"
					+ "	ON ql_atm_danhsachmayatm.ThanhPho = ql_atm_tinhthanhpho.MaTP\r\n"
					+ "	INNER JOIN ql_atm_quanhuyen\r\n"
					+ "	ON (ql_atm_danhsachmayatm.ThanhPho = ql_atm_quanhuyen.MaTP AND ql_atm_danhsachmayatm.Quan = ql_atm_quanhuyen.MaQuan)\r\n"
					+ "	INNER JOIN ql_atm_phuongxa\r\n"
					+ "	ON (ql_atm_danhsachmayatm.ThanhPho = ql_atm_phuongxa.MaTP AND ql_atm_danhsachmayatm.Quan = ql_atm_phuongxa.MaQuan AND ql_atm_danhsachmayatm.Phuong = ql_atm_phuongxa.MaPhuong)\r\n"
					+ "	INNER JOIN ql_atm_tinhtrangmayatm\r\n"
					+ "	ON ql_atm_danhsachmayatm.TinhTrang = ql_atm_tinhtrangmayatm.MaTT\r\n"
					+ " WHERE ThanhPho LIKE N'" + idTP + "' AND Quan LIKE N'" + idQH + "' AnD Phuong LIKE N'" + idPX
					+ "'  \r\n" + " ORDER BY MaMay";

			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);

			while (result.next()) {
				String maMay = result.getString("MaMay");
				String tenTP = result.getString("TenTP");
				String tenQuan = result.getString("TenQuan");
				String tenPhuong = result.getString("TenPhuong");
				String viTri = result.getString("ViTri");
				String moTa = result.getString("MoTa");
				String tongTien = result.getString("TongTien");

				dsMayATM.add(new QuanLyMayATM(maMay, tenTP, tenQuan, tenPhuong, viTri, moTa, tongTien));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsMayATM;
	}

}
