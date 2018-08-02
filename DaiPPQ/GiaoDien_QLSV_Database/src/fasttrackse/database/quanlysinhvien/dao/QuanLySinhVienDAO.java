
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
	
	// Kết nối database
	public QuanLySinhVienDAO() {
		this.getConnect("localhost", "ffse1704002", "mido", "0933237480");
	}
	
	//ngắt kết nối database
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

	public ArrayList<SinhVien> getDSSinhVien() {
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {
			String queryString = "SELECT * FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String maSV = result.getString("MaSV");
				String ho = result.getString("Ho");
				String ten = result.getString("Ten");
				String gioiTinh = result.getString("GioiTinh");
				String namSinh = result.getString("NamSinh");
				String lop = result.getString("Lop");
				
				dsSV.add(new SinhVien(maSV, ho, ten, gioiTinh, namSinh, lop));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

	public void add(SinhVien sv) {
		try {
			String queryString = "INSERT INTO sinhvien(MaSV, Ho, Ten, GioiTinh, NamSinh, Lop) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, sv.getMaSV());
			statement.setString(2, sv.getHo());
			statement.setString(3, sv.getTen());
			statement.setString(4, sv.getGioiTinh());
			statement.setString(5, sv.getNamSinh());
			statement.setString(6, sv.getLop());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Lưu xong");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(SinhVien sv) {
		try {
			String queryString = "UPDATE sinhvien SET Ho = ?, Ten = ?, GioiTinh = ?, NamSinh = ?, Lop = ? WHERE MaSV = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, sv.getHo());
			statement.setString(2, sv.getTen());
			statement.setString(3, sv.getGioiTinh());
			statement.setString(4, sv.getNamSinh());
			statement.setString(5, sv.getLop());		
			statement.setString(6, sv.getMaSV());
			
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Update OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public SinhVien delete(String maSV) {
		try {
			String queryString = "delete from sinhvien where MaSV = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, maSV);

			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Delete OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public SinhVien read(String idsv) {
		SinhVien kh = new SinhVien();
		try {
			String queryString = "SELECT * FROM sinhvien WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, idsv);

			ResultSet result = statement.executeQuery();

			result.next();

			int iD = result.getInt("ID");
			String maSV = result.getString("MaSV");
			String ho = result.getString("Ho");
			String ten = result.getString("Ten");
			String gioiTinh = result.getString("GioiTinh");
			String namSinh = result.getString("NamSInh");
			String lop = result.getString("Lop");

			kh = new SinhVien(maSV, ho, ten, gioiTinh, namSinh, lop);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}