
/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 29/06/2018
 */
package fasttrackse.database.quanlysinhvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.database.quanlysinhvien.entity.SinhVien;

public class QuanLySinhVienDAO {
	Connection conn = null;

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
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

	public ArrayList<SinhVien> getDSKhachHang() {
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
		try {
			String queryString = "SELECT * FROM khachhang";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int iD = result.getInt("ID");
				String ho = result.getString("Ho");
				String ten = result.getString("Ten");
				String gioiTinh = result.getString("GioiTinh");
				String namSinh = result.getString("NamSinh");
				String lop = result.getString("Lop");
				
				dsKH.add(new SinhVien(iD , ho, ten, gioiTinh, namSinh, lop));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public void add(SinhVien kh) {
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
		try {
			String queryString = "INSERT INTO khachhang(`Ho`, `Ten`, `GioiTinh`, `NamSinh`, 'Lop') VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getHo());
			statement.setString(2, kh.getTen());
			statement.setString(3, kh.getGioiTinh());
			statement.setString(4, kh.getNamSinh());
			statement.setString(5, kh.getLop());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Lưu xong");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(SinhVien kh, String idKH) {
		try {
			String queryString = "UPDATE khachhang SET Ho = ?, Ten = ?, GioiTinh = ?, NamSinh = ?, Lop = ? WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getHo());
			statement.setString(2, kh.getTen());
			statement.setString(3, kh.getGioiTinh());
			statement.setString(4, kh.getNamSinh());
			statement.setString(5, kh.getLop());
			
			statement.setString(6, idKH);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Update OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public SinhVien delete(String idKH) {
		try {
			String queryString = "delete from khachhang where ID = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, idKH);

			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Delete OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public SinhVien read(String idKH) {
		SinhVien kh = new SinhVien();
		try {
			String queryString = "SELECT * FROM khachhang WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, idKH);

			ResultSet result = statement.executeQuery();

			result.next();

			int iD = result.getInt("ID");
			String ho = result.getString("Ho");
			String ten = result.getString("Ten");
			String gioiTinh = result.getString("GioiTinh");
			String namSinh = result.getString("NamSInh");
			String lop = result.getString("Lop");

			kh = new SinhVien(iD, ho, ten, gioiTinh, namSinh, lop);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}