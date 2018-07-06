package ffse1703012.QuanlyKH.ulti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import ffse1703012.QuanlyKH.enity.KhachHang;

public class KhachHangConn {
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

	public ArrayList<KhachHang> getDSKhachHang(int MaKH) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			String queryString = "SELECT * FROM khachhang WHERE MaKH = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, MaKH);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int maKh = result.getInt("MaKH");
				String tenKH = result.getString("TenKH");
				String diaChi = result.getString("DiaChi");
				String ngaySinh = result.getString("NgaySinh");
				String gioiTinh = result.getString("GioiTInh");
				int sDT = result.getInt("SoDT");
				dsKH.add(new KhachHang(maKh, tenKH, diaChi, ngaySinh, gioiTinh,sDT));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	public void add(KhachHang kh) {
		try {
			String queryString = "insert into khachhang(TenKH, DiaChi, NgaySinh, GioiTinh, SoDT) values (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, kh.getHoTen());
			statement.setString(2, kh.getDiaChi());
			statement.setString(3, kh.getNgaySinh());
			statement.setString(4, kh.getGioiTinh());
			statement.setLong(5, kh.getSDT());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Luu ok!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(KhachHang kh) {
		try
		{
		String sql="update khachhang set TenKH=?,DiaChi=?,NgaySinh=?,GioiTinh=? , SoDT=? where MaKH=?";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1,kh.getHoTen());
		statement.setString(2, kh.getNgaySinh());
		statement.setString(3,kh.getGioiTinh());
		statement.setInt(4,kh.getSDT());
		statement.setInt(5,kh.getMaKH());
		int x=statement.executeUpdate();
		if(x>0)
		{
		System.out.println("Cập nhật OK");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}

	public void delete(int MaKH) {
		try
		{
		PreparedStatement statement=conn.prepareStatement
		("delete from khachhang where MaKH=?");
		statement.setInt(1,MaKH);
		int x=statement.executeUpdate();
		if(x>0)
		{
		System.out.println("Xóa ok");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}

//	public KhachHang read(int idKH) {
//		KhachHang kh = new KhachHang();
//
//		return kh;
//	}

}
