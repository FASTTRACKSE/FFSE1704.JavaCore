package ffse1703012.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import ffse1703012.entity.*;

public class SinhVienDAO {
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

	public ArrayList<SinhVien> getDsSinhVien() {
		ArrayList<SinhVien> dsSv = new ArrayList<SinhVien>();
		try {
			String queryString = "SELECT * FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String maSV = result.getString("MaSV");
				String tenSV = result.getString("TenSV");
				String tuoiSV = result.getString("TuoiSV");
				String ngaySinh = result.getString("LopSV");
				String gioiTinh = result.getString("GioiTinh");
				dsSv.add(new SinhVien(maSV, tenSV, tuoiSV, ngaySinh, gioiTinh));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSv;
	}
	public boolean add(SinhVien sv) {
		try {
			String queryString = "insert into sinhvien(MaSV,TenSV, TuoiSV, LopSV, GioiTinh) values (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, sv.getMaSV());
			statement.setString(2, sv.getTenSV());
			statement.setString(3, sv.getTuoiSV());
			statement.setString(4, sv.getLopSV());
			statement.setString(5, sv.getGioiTinh());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Luu ok!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void edit(SinhVien sv) {
		try {
			String sql = "update sinhvien set TenSV=?,TuoiSV=?,GioiTinh=? where MaSV=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, sv.getTenSV());
			statement.setString(2, sv.getTuoiSV());
			statement.setString(3, sv.getGioiTinh());
			statement.setString(4, sv.getMaSV());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Cập nhật OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean delete(String MaSV) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete from sinhvien where MaSV=?");
			statement.setString(1, MaSV);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa ok");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	public boolean login(String username, String password) {
		try {
			PreparedStatement statement = conn.prepareStatement("select * from user where user_name = ? and user_password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
				
			}else {
				return false;
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
