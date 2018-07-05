/************************
 *Prog: QUẢN LÝ KHÁCH HÀNG
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 22/06/2018
 **********************/
package ffse.qlkh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import ffse.qlkh.entity.KhachHang;

public class KhachHangDAO {
	Connection conn = null;

	public Connection getConn() {
		return conn;
	}

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

	public ArrayList<KhachHang> getDSKhachHang() {//kết quả khi gọi phương thức getDSkhachhang là mảng araylist khachhang
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

		try {
			String queryString = "SELECT * FROM khachhang";
			PreparedStatement statement = conn.prepareStatement(queryString);

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

	public void add(KhachHang kh) {
		try {
			String sql = "insert into khachhang(MaKH,tenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setString(6, kh.getSoDT());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(KhachHang kh) {
		try {
			String sql = "update khachhang set MaKH=?, TenKH=?,DiaChi=? , NgaySinh=?, GioiTinh=?, SoDT=? where ID=?"; 
			PreparedStatement statement = conn.prepareStatement(sql); 
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getNgaySinh());
			statement.setString(5, kh.getGioiTinh());
			statement.setString(6, kh.getSoDT());
			statement.setInt(7, kh.getID());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Cập nhật OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(int ID) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete from khachhang where ID=?");
			statement.setInt(1, ID);
			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Xóa ok");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public KhachHang read(int idKH) {
		KhachHang kh = new KhachHang();

		try {
			String queryString = "SELECT * FROM khachhang WHERE id = ?";
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

			kh = new KhachHang(ID, maKH, tenKH, diaChi, ngaySinhKH, gioiTinhKH, sdt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kh;
	}

}
