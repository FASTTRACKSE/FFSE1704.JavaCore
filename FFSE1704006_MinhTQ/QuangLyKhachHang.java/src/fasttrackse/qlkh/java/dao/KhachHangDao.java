package fasttrackse.qlkh.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.qlkh.java.entity.KhachHang;

public class KhachHangDao {
	Connection conn = null;

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
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

	public void add(KhachHang kh) {
		try {
			String queryString = "insert into khachhang(id,MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, kh.getId());
			statement.setString(2, kh.getMaKH());
			statement.setString(3, kh.getTenKH());
			statement.setString(4, kh.getDiaChi());
			statement.setString(5, kh.getNgaySinh());
			statement.setString(6, kh.getGioiTinh());
			statement.setInt(7, kh.getSoDT());

			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("WoW...Thành công rồi anh em ơi !");
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
			statement.setInt(7, kh.getId());
		
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println(" Bạn Update thành công rồi ! .");
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
				System.err.println(" Bạn đã xóa thành công");
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

			int ID = result.getInt("id");
			String maKH = result.getString("MaKH");
			String tenKH = result.getString("TenKH");
			String diaChi = result.getString("DiaChi");
			String ngaySinhKH = result.getString("NgaySinh");
			String gioiTinhKH = result.getString("GioiTinh");
			int sdt = result.getInt("SoDT");

			kh = new KhachHang(id, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}
