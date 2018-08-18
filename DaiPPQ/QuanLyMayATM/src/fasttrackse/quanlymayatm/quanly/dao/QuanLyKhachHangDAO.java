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
import java.time.Year;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;

/**
 * @author QuangDai
 *
 */
public class QuanLyKhachHangDAO {
	static Connection conn = null;

	/**
	 * @return the conn
	 */

	// Kết nối database
	public QuanLyKhachHangDAO() {
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

	public static ArrayList<QuanLyKhachHang> getDSKhachHang() {
		ArrayList<QuanLyKhachHang> dsKH = new ArrayList<QuanLyKhachHang>();
		try {
			String queryString = "SELECT MaKH, TenKH, SoCMND, NamSinh, GioiTinh, DiaChi, \r\n"
					+ " ql_atm_tinhthanhpho.TenTP, ql_atm_quanhuyen.TenQuan, ql_atm_phuongxa.TenPhuong, \r\n"
					+ " Email, SoDT, SoTaiKhoang, SoDu \r\n" + " FROM ql_atm_thongtinkhachhang\r\n"
					+ " INNER JOIN ql_atm_tinhthanhpho\r\n"
					+ " ON ql_atm_thongtinkhachhang.ThanhPho = ql_atm_tinhthanhpho.MaTP\r\n"
					+ " INNER JOIN ql_atm_quanhuyen\r\n"
					+ " ON (ql_atm_thongtinkhachhang.ThanhPho = ql_atm_quanhuyen.MaTP AND ql_atm_thongtinkhachhang.Quan = ql_atm_quanhuyen.MaQuan)\r\n"
					+ " INNER JOIN ql_atm_phuongxa\r\n"
					+ " ON (ql_atm_thongtinkhachhang.ThanhPho = ql_atm_phuongxa.MaTP AND ql_atm_thongtinkhachhang.Quan = ql_atm_phuongxa.MaQuan AND ql_atm_thongtinkhachhang.Phuong = ql_atm_phuongxa.MaPhuong)\r\n"
					+ " ORDER BY MaKH";
			PreparedStatement statement = conn.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String soCMND = result.getString("SoCMND");
				String namSinh = result.getString("NamSinh");
				String gioiTinh = result.getString("GioiTinh");
				String diaChi = result.getString("DiaChi");
				String thanhPho = result.getString("TenTP");
				String quan = result.getString("TenQuan");
				String phuong = result.getString("TenPhuong");
				String email = result.getString("Email");
				String soDT = result.getString("SoDT");
				String soTaiKhoang = result.getString("SoTaiKhoang");
				String soDu = result.getString("SoDu");

				dsKH.add(new QuanLyKhachHang(maKH, tenKH, soCMND, namSinh, gioiTinh, diaChi, thanhPho, quan, phuong,
						email, soDT, soTaiKhoang, soDu));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	// Sửa thông tin máy ATM
	public static void update(QuanLyKhachHang id) {
		try {
			String queryString = "UPDATE ql_atm_thongtinkhachhang SET TenKH = ?, SoCMND = ?, NamSinh = ?, GioiTinh = ?, DiaChi = ? , ThanhPho = ?, Quan = ?, "
					+ " Phuong = ?, Email = ?, SoDT = ?, SoTaiKhoang = ?, SoDu = ? WHERE MaKH = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, id.getTenKH());
			statement.setString(2, id.getSoCMND());
			statement.setString(3, id.getNamSinh());
			statement.setString(4, id.getGioiTinh());
			statement.setString(5, id.getDiaChi());
			statement.setString(6, id.getThanhPho());
			statement.setString(7, id.getQuan());
			statement.setString(8, id.getPhuong());
			statement.setString(9, id.getEmail());
			statement.setString(10, id.getSoDT());
			statement.setString(11, id.getSoTaiKhoang());
			statement.setString(12, id.getSoDu());

			statement.setString(13, id.getMaKH());
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
			PreparedStatement statement = conn.prepareStatement("DELETE FROM ql_atm_thongtinkhachhang WHERE MaKH = ?");
			statement.setString(1, maMay);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Thêm mới khách hàng
	public static void add(QuanLyKhachHang qlkh) {
		try {
			String queryString = "INSERT INTO ql_atm_thongtinkhachhang(TenKH, SoCMND, NamSinh, GioiTinh, DiaChi , ThanhPho, Quan, Phuong, Email, SoDT, SoTaiKhoang, SoDu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, qlkh.getTenKH());
			statement.setString(2, qlkh.getSoCMND());
			statement.setString(3, qlkh.getNamSinh());
			statement.setString(4, qlkh.getGioiTinh());
			statement.setString(5, qlkh.getDiaChi());
			statement.setString(6, qlkh.getThanhPho());
			statement.setString(7, qlkh.getQuan());
			statement.setString(8, qlkh.getPhuong());
			statement.setString(9, qlkh.getEmail());
			statement.setString(10, qlkh.getSoDT());
			statement.setString(11, qlkh.getSoTaiKhoang());
			statement.setString(12, qlkh.getSoDu());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Tìm kiếm khách hàng thông qua tên khách hàng nhập ở ô
	public static ArrayList<QuanLyKhachHang> timkiem(String tk) {
		ArrayList<QuanLyKhachHang> dsKH = new ArrayList<QuanLyKhachHang>();
		try {
			String queryString = "SELECT MaKH, TenKH, SoCMND, NamSinh, GioiTinh, DiaChi, \r\n"
					+ " ql_atm_tinhthanhpho.TenTP, ql_atm_quanhuyen.TenQuan, ql_atm_phuongxa.TenPhuong, \r\n"
					+ " Email, SoDT, SoTaiKhoang, SoDu \r\n" + " FROM ql_atm_thongtinkhachhang\r\n"
					+ " INNER JOIN ql_atm_tinhthanhpho\r\n"
					+ " ON ql_atm_thongtinkhachhang.ThanhPho = ql_atm_tinhthanhpho.MaTP\r\n"
					+ " INNER JOIN ql_atm_quanhuyen\r\n"
					+ " ON (ql_atm_thongtinkhachhang.ThanhPho = ql_atm_quanhuyen.MaTP AND ql_atm_thongtinkhachhang.Quan = ql_atm_quanhuyen.MaQuan)\r\n"
					+ " INNER JOIN ql_atm_phuongxa\r\n"
					+ " ON (ql_atm_thongtinkhachhang.ThanhPho = ql_atm_phuongxa.MaTP AND ql_atm_thongtinkhachhang.Quan = ql_atm_phuongxa.MaQuan AND ql_atm_thongtinkhachhang.Phuong = ql_atm_phuongxa.MaPhuong)\r\n"
					+ " WHERE TenKH LIKE N'%" + tk + "%' \r\n" + " ORDER BY MaKH";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);

			while (result.next()) {
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String soCMND = result.getString("SoCMND");
				String namSinh = result.getString("NamSinh");
				String gioiTinh = result.getString("GioiTinh");
				String diaChi = result.getString("DiaChi");
				String thanhPho = result.getString("TenTP");
				String quan = result.getString("TenQuan");
				String phuong = result.getString("TenPhuong");
				String email = result.getString("Email");
				String soDT = result.getString("SoDT");
				String soTaiKhoang = result.getString("SoTaiKhoang");
				String soDu = result.getString("SoDu");

				dsKH.add(new QuanLyKhachHang(maKH, tenKH, soCMND, namSinh, gioiTinh, diaChi, thanhPho, quan, phuong,
						email, soDT, soTaiKhoang, soDu));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public static ArrayList<QuanLyKhachHang> timkiem(int idTP, int idQH, int idPX) {
		ArrayList<QuanLyKhachHang> dskh = new ArrayList<QuanLyKhachHang>();
		try {
			String queryString = "SELECT MaKH, TenKH, SoCMND, NamSinh, GioiTinh, DiaChi, Email, SoDT, SoTaiKhoang, SoDu"
					+ "	ql_atm_danhsachmayatm.ViTri, ql_atm_tinhtrangmayatm.MoTa, ql_atm_danhsachmayatm.TongTien\r\n"
					+ "	FROM ql_atm_danhsachmayatm\r\n" 
					+ " WHERE ThanhPho LIKE N'" + idTP + "' AND Quan LIKE N'" + idQH + "' AnD Phuong LIKE N'" + idPX
					+ "'  \r\n" + " ORDER BY MaMay";

			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(queryString);

			while (result.next()) {
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String soCMND = result.getString("SoCMND");
				String namSinh = result.getString("NamSinh");
				String gioiTinh = result.getString("GioiTinh");
				String diaChi = result.getString("DiaChi");
				String email = result.getString("Email");
				String soDT = result.getString("SoDT");
				String soTaiKhoang = result.getString("SoTaiKhoang");
				String soDu = result.getString("SoDu");

				dskh.add(new QuanLyKhachHang(maKH, tenKH, soCMND, namSinh, gioiTinh, diaChi,
						email, soDT, soTaiKhoang, soDu));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dskh;
	}
}
