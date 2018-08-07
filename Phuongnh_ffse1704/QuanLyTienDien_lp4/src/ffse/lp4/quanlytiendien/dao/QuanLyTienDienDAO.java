package ffse.lp4.quanlytiendien.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import ffse.lp4.quanlytiendien.entity.KhachHang;


public class QuanLyTienDienDAO {
	static Connection conn = null;

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
			this.setConn(driver.connect(strConnect, pro));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

		
	public static void add(KhachHang kh)  {
		try {
			String queryString = "insert into khachhang(MaKhachHang, TenKhachHang, DiaChi , MaQuan , Email, SDT, MaCongTo, MaPhuong) values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getMaQuan());
			statement.setString(5, kh.getEmail());
			statement.setString(6, kh.getsDT());
			statement.setString(7, kh.getMaCongTo());
			statement.setString(8, kh.getMaPhuong());

			int x = statement.executeUpdate();
			
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void update(KhachHang kh) {
			try {
				String sql = "update khachhang set TenKhachHang=?, DiaChi=?, MaQuan =?, Email =?, SDT =?, MaCongTo =?, MaPhuong =?  where MaKhachHang=?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, kh.getMaKH());
				statement.setString(2, kh.getTenKH());
				statement.setString(3, kh.getDiaChi());
				statement.setString(4, kh.getMaQuan());
				statement.setString(5, kh.getEmail());
				statement.setString(6, kh.getsDT());
				statement.setString(7, kh.getMaCongTo());
				statement.setString(8, kh.getMaPhuong());
				int x = statement.executeUpdate();
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");
					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
//	public void delete(String maSV ) {
//		try {
//			PreparedStatement statement = conn.prepareStatement("delete from sinhvien1 where MaSV=?");
//			statement.setString(1, maSV);
//			int x = statement.executeUpdate();
//			if (x > 0) {
//				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
//				
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	public ArrayList<SinhVien> getDSinhVien() {
//		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
//
//		try {
//			String queryString = "SELECT * FROM sinhvien1";
//			PreparedStatement statement = conn.prepareStatement(queryString);
//
//			ResultSet result = statement.executeQuery();
//
//			while (result.next()) {
//				
//				
//				String maSinhVien  = result.getString("MaSV");
//				String lopSinhVien = result.getString("Lop");
//				String gioiTinh   = result.getString("GioiTinh");
//				String tenSinhVien   = result.getString("TenSV");
//				String tuoiSinhvien = result.getString("NamSinh");
//
//				dsSV.add(new SinhVien(maSinhVien,lopSinhVien,gioiTinh,tenSinhVien,tuoiSinhvien));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return dsSV;
//	}
//	public void addAdmin(DangNhap dn) {
//		try {
//			String queryString = "insert into login_admin(Uses , Pass) values(?,?)";
//			PreparedStatement statement = conn.prepareStatement(queryString);
//			statement.setString(1, dn.getTaiKhoan());
//			statement.setString(2, dn.getMatKhau());
//			int x = statement.executeUpdate();
//			
//			if (x > 0) {
//				JOptionPane.showMessageDialog(null, "Đăng Kí Thành Công");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	public ArrayList<DangNhap> getDangNhap() {
//		ArrayList<DangNhap> dn = new ArrayList<DangNhap>();
//
//	try {
//		String queryString = "SELECT * FROM login_admin";
//		PreparedStatement statement = conn.prepareStatement(queryString);
//		ResultSet result = statement.executeQuery();
//		while (result.next()) {
//			
//			
//			String taiKhoan  = result.getString("Uses");
//			String matKhau = result.getString("Pass");
//			
//			dn.add(new DangNhap(taiKhoan,matKhau));
//		}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	
//	return dn;
//}

}
