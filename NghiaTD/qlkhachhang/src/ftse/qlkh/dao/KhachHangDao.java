package ftse.qlkh.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import ftse.qlkh.entity.KhachHang;

public class KhachHangDao {
	static Connection conn = null;

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

	public static ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

		try {
			String queryString = "SELECT * FROM khachhang" ;
			PreparedStatement statement = conn.prepareStatement(queryString);
//			statement.setString(1,"kh1");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int ID = result.getInt("ID");
				String maKH = result.getString("MaKH");
				String tenKH = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinhKH = result.getString("NgaySinh");
				String gioiTinhKH = result.getString("GioiTinh");
				int soDT = result.getInt("SoDT");
				
				dsKH.add(new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, soDT));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsKH;
	}

	public static void add(KhachHang kh) {
		try {
		String queryString="insert into khachhang(MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?)";
		PreparedStatement statement=conn.prepareStatement(queryString);
		statement.setString(1, kh.getMaKH());
		statement.setString(2, kh.getTenKH());
		statement.setString(3, kh.getDiaChi());
		statement.setString(4, kh.getNgaySinh());
		statement.setString(5, kh.getGioiTinh());
		statement.setInt(6, kh.getSoDT());
		
		
		
		
		int x=statement.executeUpdate();
		if(x>0)
		{
		System.out.println("Lưu OK");
		}
		}
		catch(Exception ex)
		{
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
				System.err.println(" Sửa thành công rồi chúng mày ơi .");
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
				System.out.println("Delete OK");
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
			Integer sdt = result.getInt("SoDT");

			kh = new KhachHang(id, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}