package fasttrackse.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.app.entity.SinhVien;

public class SinhVienDAO {
	Connection conn = null;

	// Kết nối database
	public SinhVienDAO() {
		this.getConnect("localhost", "sinhvien", "boll", "12345");
	}

	// Ngắt kết nối database
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

	public ArrayList<SinhVien> getDSKSinhVien() {
		// Kết quả khi gọi phương thức getDSSinhVien là mảng araylist sinhvien
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

		try {
			String queryString = "SELECT * FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int iD = result.getInt("id");
				String lop = result.getString("Lop");
				String maSV = result.getString("MaSV");
				String tenSV = result.getString("TenSV");
				String tuoi = result.getString("Tuoi");
				String gioiTinh = result.getString("GioiTinh");

				dsSV.add(new SinhVien(iD, lop, maSV, tenSV, tuoi,gioiTinh));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

	public void add(SinhVien sv) {
		try {
			String sql = "insert into sinhvien(Lop,MaSV,TenSV,Tuoi,GioiTinh) values(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sv.getLopSinhVien());
			statement.setString(2, sv.getMaSinhVien());
			statement.setString(3, sv.getTenSinhVien());
			statement.setString(4, sv.getTuoiSinhVien());
			statement.setString(5, sv.getGioiTinhSinhVien());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
				// System.out.println("Lưu OK");
				//this.disConnection();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(SinhVien sv) {
		try {
			String sql = "update sinhvien set TenSV=? , Tuoi=?, GioiTinh=? where MaSV=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sv.getTenSinhVien());
			statement.setString(2, sv.getTuoiSinhVien());
			statement.setString(3, sv.getGioiTinhSinhVien());
			statement.setString(4, sv.getMaSinhVien());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");
				// System.out.println("Cập nhật OK");
				//this.disConnection();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(String maSV) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete from sinhvien where MaSV=?");
			statement.setString(1, maSV);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
				// System.out.println("Xóa ok");
				//this.disConnection();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public SinhVien read(int id) {
		SinhVien sv = new SinhVien();

		try {
			String queryString = "SELECT * FROM sinhvien WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			result.next();

			int iD = result.getInt("id");
			String lop = result.getString("Lop");
			String maSV = result.getString("MaSV");
			String tenSV = result.getString("TenSV");
			String tuoi = result.getString("Tuoi");
			String gioiTinh = result.getString("GioiTinh");

			sv = new SinhVien(iD, lop, maSV, tenSV, tuoi,gioiTinh);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sv;
	}
}