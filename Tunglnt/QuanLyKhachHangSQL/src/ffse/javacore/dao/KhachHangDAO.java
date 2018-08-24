package ffse.javacore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.mysql.jdbc.Driver;

import ffse.javacore.util.KhachHang;

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

	public Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

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

	public ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			String queryString = "SELECT * FROM khachhang ";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int ID = result.getInt("ID");
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinhKH = result.getString("NgaySinh");
				String gioiTinhKH = result.getString("GioiTinh");
				String sdt = result.getString("SoDT");

				dsKH.add(new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public void add(KhachHang kh) {
		//
		try {
			String queryString = "insert into khachhang(MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setString(6, kh.getSoDT());

			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("Thêm OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(KhachHang kh) {
		//
		try {
			String sql = "update khachhang set TenKH=?,NgaySinh=? where id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kh.getTenKH());
			statement.setString(2, kh.getNgaySinh());
			statement.setLong(3, kh.getID());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println("Cập nhật OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(int idKH) {
		//
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM `khachhang` WHERE id=?");
			statement.setLong(1, idKH);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa ok");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public KhachHang read(int idKH) {
		KhachHang kh = new KhachHang();

		try {
			String queryString = "SELECT * FROM khachhang WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, idKH);

			ResultSet result = statement.executeQuery();

			result.next();

			int ID = result.getInt("ID");
			String maKH = result.getString("MaKH");
			String tenKH = result.getString("TenKH");
			String diaChi = result.getString("DiaChi");
			String ngaySinhKH = result.getString("NgaySinh");
			String gioiTinhKH = result.getString("GioiTinh");
			String sdt = result.getString("SoDT");

			kh = new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}