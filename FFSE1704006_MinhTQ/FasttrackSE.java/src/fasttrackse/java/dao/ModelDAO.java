package fasttrackse.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.java.entity.SinhVien;

public class ModelDAO {
	Connection conn = null;

	public ModelDAO() {
		this.getConnect("localhost", "sinhvienffse", "Truongquangminh", "quangminh123");
		// if (this.getConn() != null) {
		// System.err.println("Kết nối MYSQL thành công");
		// } else {
		// System.err.println("Kết nối MYSQL thất bại");
		// }
	}

	public void stopConnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
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

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+ "?useUnicode=true&characterEncoding=utf-8";
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

	public ArrayList<SinhVien> getDSSinhVien() {
		ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

		try {
			String queryString = "SELECT * FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String maSinhVien = result.getString("maSV");
				String lopSinhVien = result.getString("lopSV");
				String tenSinhVien = result.getString("tenSV");
				String gioiTinh = result.getString("GioiTinh");
				String tuoiSinhVien = result.getString("tuoiSV");

				dsSinhVien.add(new SinhVien(maSinhVien, lopSinhVien, tenSinhVien, gioiTinh ,tuoiSinhVien));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSinhVien;
	}

	public void delete(String maSV) {
		try {
			String queryString = "delete from sinhvien where maSV=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, maSV);

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(SinhVien sv) {
		try {
			String queryString = "UPDATE sinhvien SET LopSV=?, TenSV=?, GioiTinh=?, TuoiSV=? WHERE maSV=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, sv.getLopSinhVien());
			statement.setString(2, sv.getTenSinhVien());
			statement.setString(4, sv.getTuoiSinhVien());
			statement.setString(3, sv.getGioiTinhSinhVien());
			statement.setString(5, sv.getMaSinhVien());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã update thành công ");
			}else {
				System.out.println("chưa được");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void add(SinhVien sv) {
		try {
			String queryString = "insert into sinhvien(MaSV,LopSV,TenSV,GioiTinh,TuoiSV) values(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, sv.getMaSinhVien());
			statement.setString(2, sv.getLopSinhVien());
			statement.setString(3, sv.getTenSinhVien());
			statement.setString(4, sv.getGioiTinhSinhVien());
			statement.setString(5, sv.getTuoiSinhVien());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công ");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
