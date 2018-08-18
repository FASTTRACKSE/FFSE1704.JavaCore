package ffse.lp4.quanlytiendien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import ffse.lp4.quanlytiendien.entity.KhachHang;
import ffse.lp4.quanlytiendien.entity.QuanPhuong;

public class KhachHangModel {
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

	public void add(KhachHang kh) {
		try {
			String queryString = "insert into khachhang(MaKhachHang, TenKhachHang, DiaChi , MaCongTo, Email, SDT, idquan , idphuong) values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getMaCongTo());
			statement.setString(5, kh.getEmail());
			statement.setString(6, kh.getsDT());
			statement.setInt(7, kh.getMaQuan());
			statement.setInt(8, kh.getMaPhuong());

			int x = statement.executeUpdate();

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(KhachHang kh) {
		try {
			String sql = "update khachhang set TenKhachHang=?, DiaChi=?, MaCongTo =?, Email =?, SDT =?, idquan =?, idphuong =? where MaKhachHang =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kh.getTenKH());
			statement.setString(2, kh.getDiaChi());
			statement.setString(3, kh.getMaCongTo());
			statement.setString(4, kh.getEmail());
			statement.setString(5, kh.getsDT());
			statement.setInt(6, kh.getMaQuan());
			statement.setInt(7, kh.getMaPhuong());
			statement.setString(8, kh.getMaKH());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(String maKH) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete from khachhang where MaKhachHang=?");
			statement.setString(1, maKH);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> dSKH = new ArrayList<KhachHang>();
		try {
			String queryString = "SELECT * FROM khachhang";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maKhachHang = result.getString("MaKhachHang");
				String tenKhachHang = result.getString("TenKhachHang");
				String diaChi = result.getString("DiaChi");
				String maCongTo = result.getString("MaCongTo");
				String email = result.getString("Email");
				String soDT = result.getString("SDT");
				int idPhuong = result.getInt("idphuong");
				int idQuan = result.getInt("idquan");

				dSKH.add(new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo, email, soDT,idQuan, idPhuong));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dSKH;
	}

	public ArrayList<QuanPhuong> getQuanKH() {
		ArrayList<QuanPhuong> listPhuong = new ArrayList<QuanPhuong>();
		try {
			String sql = "select idquan,tenquan from quan WHERE idquan>=1 AND idquan<=7";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			
			
			
			while (result.next()) {
				QuanPhuong quan= new QuanPhuong();
				quan.setId(result.getInt(1));
				quan.setTen(result.getString(2));
				listPhuong.add(quan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhuong;
	}
	

	public  ArrayList<QuanPhuong> getPhuongKH(int idQuan ) {
		ArrayList<QuanPhuong> listPhuong = new ArrayList<>();
		try {
			String sql = "select tenphuong, idphuong from phuong where idquan = '"+idQuan+"'";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				QuanPhuong phuong = new QuanPhuong();
				phuong.setTen(result.getString(1));
				phuong.setId(result.getInt(2));
				listPhuong.add(phuong);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return listPhuong;
	}
	public static String getNameQuan(int id) {
		String Quan = "";
		try {
			String sql = "SELECT * from quan WHERE idquan = '"+id+"'" ;
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Quan = rs.getString("tenquan");
			}
		} catch (Exception e) {
			e.printStackTrace(	);
		}
		return Quan;
	}
	public static String getNamePhuong(int id) {
		String Quan = "";
		try {
			String sql = "SELECT * from phuong WHERE idphuong = '"+id+"'" ;
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Quan = rs.getString("tenphuong");
			}
		} catch (Exception e) {
			e.printStackTrace(	);
		}
		return Quan;
	}
	
	public ArrayList<KhachHang> getDSKhachHangTheoQuanPhuong() {
		ArrayList<KhachHang> dSKH = new ArrayList<KhachHang>();
		try {
			String queryString = "SELECT * FROM khachhang ";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maKhachHang = result.getString("MaKhachHang");
				String tenKhachHang = result.getString("TenKhachHang");
				String diaChi = result.getString("DiaChi");
				String maCongTo = result.getString("MaCongTo");
				String email = result.getString("Email");
				String soDT = result.getString("SDT");
				int idPhuong = result.getInt("idphuong");
				int idQuan = result.getInt("idquan");

				dSKH.add(new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo, email, soDT,idQuan, idPhuong));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dSKH;
	}



}
