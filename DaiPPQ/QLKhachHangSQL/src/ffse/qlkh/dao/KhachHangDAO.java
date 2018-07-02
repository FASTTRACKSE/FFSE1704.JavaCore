package ffse.qlkh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import ffse.qlkh.entity.KhachHang;

public class KhachHangDAO {
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

	public ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			String queryString = "SELECT * FROM khachhang";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int iD = result.getInt("ID");
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinhKH = result.getString("NgaySinh");
				String gioiTinhKH = result.getString("GioiTinh");
				String sdt = result.getString("SoDT");
				
				dsKH.add(new KhachHang(iD , maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public void add(KhachHang kh) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			String queryString = "INSERT INTO khachhang(`MaKH`, `TenKH`, `DiaChi`, `NgaySinh`, `GioiTinh`, `SoDT`) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setString(6, kh.getSoDT());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Lưu xong");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(KhachHang kh) {
		try {
			String queryString = "UPDATE khachhang SET MaKH = ?, TenKH = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, SoDT = ? WHERE iD = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setString(6, kh.getSoDT());
			
			statement.setInt(7, kh.getID());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Update OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public KhachHang delete(String idKH) {
		try {
			String queryString = "delete from khachhang where MaKH = ?";
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

	public KhachHang read(String idKH) {
		KhachHang kh = new KhachHang();
		try {
			String queryString = "SELECT * FROM khachhang WHERE MaKH = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, idKH);

			ResultSet result = statement.executeQuery();

			result.next();

			int iD = result.getInt("ID");
			String maKH = result.getString("MaKH");
			String tenKH = result.getString("TenKH");
			String diaChi = result.getString("DiaChi");
			String ngaySinhKH = result.getString("NgaySinh");
			String gioiTinhKH = result.getString("GioiTinh");
			String sdt = result.getString("SoDT");

			kh = new KhachHang(iD, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}