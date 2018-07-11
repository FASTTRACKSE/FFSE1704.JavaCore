package ffse.asm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.mysql.jdbc.Driver;

import ffse.asm.util.SinhVien;

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

	public ArrayList<SinhVien> getDSSinhVien() {
		ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
		try {
			String queryString = "SELECT * FROM sinhvien ";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int ID = result.getInt("ID");
				String maSV = result.getString("MaKH");
				String tenSV = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinhSV = result.getString("NgaySinh");
				String gioiTinhSV = result.getString("GioiTinh");
				String sdt = result.getString("SoDT");

				dsKH.add(new SinhVien(ID, maSV, tenSV, diaChi, ngaySinhSV, gioiTinhSV));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public void add(SinhVien kh) {
		//
		try {
			String queryString = "insert into sinhvienfe(MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?)";
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

	public void edit(SinhVien kh) {
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
			PreparedStatement statement = conn.prepareStatement("DELETE FROM `sinhvienfe` WHERE id=?");
			statement.setLong(1, idKH);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa ok");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public SinhVien read(int idKH) {
		SinhVien kh = new SinhVien();

		try {
			String queryString = "SELECT * FROM sinhvienfe WHERE id = ?";
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

			kh = new SinhVien(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}