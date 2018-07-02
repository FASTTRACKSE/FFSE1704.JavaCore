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

	public ArrayList<KhachHang> getDSKhachHang() {
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
				String sdt = result.getString("SoDT");
				
				dsKH.add(new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt));
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
		statement.setString(3, kh.getNgaySinh());
		statement.setString(4, kh.getGioiTinh());
		statement.setString(5, kh.getSoDT());
		
		
		
		
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
		//
	}

	public void delete(int idKH) {
		//
	}

	public KhachHang read(int idKH) {
		KhachHang kh = new KhachHang();

		return kh;
	}

}