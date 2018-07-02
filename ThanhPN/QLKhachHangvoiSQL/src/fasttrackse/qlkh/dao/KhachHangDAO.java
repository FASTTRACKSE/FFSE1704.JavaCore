package fasttrackse.qlkh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.qlkh.entity.KhachHang;

public class KhachHangDAO {

	static Connection conn = null;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		KhachHangDAO.conn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
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
				int ID = result.getInt("ID");
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinhKH = result.getString("NgaySinh");
				String gioiTinhKH = result.getString("GioiTinh");
				int sdt = result.getInt("SoDT");

				dsKH.add(new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public static void add(KhachHang op) {
		try {
			String queryString = "insert into khachhang(id,MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, op.getID());
			statement.setString(2, op.getMaKH());
			statement.setString(3, op.getTenKH());
			statement.setString(4, op.getDiaChi());
			statement.setString(5, op.getNgaySinh());
			statement.setString(6, op.getGioiTinh());
			statement.setInt(7, op.getSoDT());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(KhachHang kh) {
		try {
			String queryString = "UPDATE khachhang SET  MaKH=?, TenKH=?, DiaChi=?, NgaySinh=?, GioiTinh=?, SoDT=? WHERE id=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setInt(6, kh.getSoDT());
			statement.setInt(7, kh.getID());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("Update OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			String queryString = "delete from khachhang where id=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, id);

			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("Delete OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public KhachHang read(int id) {
		
		KhachHang kh = new KhachHang();

		try {
			String queryString = "SELECT * FROM khachhang WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			result.next();

			int ID = result.getInt("ID");
			String maKH = result.getString("MaKH");
			String tenKH = result.getString("TenKH");
			String diaChi = result.getString("DiaChi");
			String ngaySinhKH = result.getString("NgaySinh");
			String gioiTinhKH = result.getString("GioiTinh");
			int sdt = result.getInt("SoDT");

			kh = new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	

		
	}

}
