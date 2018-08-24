package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import entyti.SinhVien;

public class SinhVienDAO {
	Connection conn = null;

	// kết nối database
	public SinhVienDAO() {

		this.getConnect("localhost", "qlsinhvien", "junny789789", "tianh123");
/*		if (this.getConn() != null) {
			System.err.println("Kết nối MYSQL thành công");
		} else {
			System.err.println("Kết nối MYSQL thất bại");
		}*/
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

	public ArrayList<SinhVien> getDSKSinhVien() {// kết quả khi gọi phương thức getDSSinhVien là mảng araylist sinhvien
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

		try {
			String queryString = "SELECT * FROM qlsinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				/*int iD = result.getInt("id");*/

				String maSV = result.getString("masinhvien");
				String tenSV = result.getString("tensinhvien");
				String tuoi = result.getString("Tuoi");
				String lop = result.getString("Lop");

				dsSV.add(new SinhVien(lop, maSV, tenSV, tuoi));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

	public void add(SinhVien sv) {
		try {
			String sql = "insert into qlsinhvien(masinhvien,tensinhvien,tuoi,lop) values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sv.getMasinhvien());
			statement.setString(2, sv.getTensinhvien());
			statement.setString(3, sv.getTuoi());
			statement.setString(4, sv.getLop());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "thêm thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void update(SinhVien sv) {
		try {
			String sql = "update qlsinhvien set tensinhvien=? , tuoi=?, lop=? where masinhvien=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, sv.getTensinhvien());
			statement.setString(2, sv.getTuoi());
			statement.setString(3, sv.getLop());
			statement.setString(4, sv.getMasinhvien());
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

	public void delete(String masinhvien) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete from qlsinhvien where masinhvien=?");
			statement.setString(1, masinhvien);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
				// System.out.println("Xóa ok");
				// this.disConnection();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
