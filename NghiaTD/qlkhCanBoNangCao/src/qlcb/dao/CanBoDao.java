package qlcb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import qlcb.entity.*;
//import qlcb.main.Giangvien;
//import qlcb.main.KhachHang;

public class CanBoDao {

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
	// gọi getveef thì trarveef danh sách kh
	public ArrayList<GiangVien> getDSCanBo(){
		ArrayList<GiangVien> dsCanBo = new ArrayList<GiangVien>();
		try {
			String queryString = "SELECT * FROM giangvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			//duyêt mảng
			while (result.next()) {
				int ID = result.getInt("ID");
				String hoten = result.getString("hoten");
				double hesoluong = result.getDouble("hesoluong");
				String khoa = result.getString("khoa");
				String trinhdo = result.getString("trinhdo");
				int sotietday = result.getInt("sotietday");
				
				dsCanBo.add(new GiangVien(ID, hoten, hesoluong, khoa, trinhdo,sotietday));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsCanBo;
	
	}
	public void add(GiangVien cb) {
		try {
			
			String queryString = "insert into giangvien(hoten, hesoluong, khoa, trinhdo, sotietday) values(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, cb.getHoTen());
			statement.setDouble(2, cb.getHeSoLuong());
			statement.setString(3, cb.getKhoa());
			statement.setString(4, cb.getTrinhDo());
			statement.setInt(5, cb.getSoTietDay());
			

			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void edit(GiangVien gv) {
		try {
			String queryString = "UPDATE giangvien SET  hoten=?, hesoluong=?, khoa=?, trinhdo=?, sotietday=? WHERE id=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, gv.getHoTen());
			statement.setDouble(2, gv.getHeSoLuong());
			statement.setString(3, gv.getKhoa());
			statement.setString(4, gv.getTrinhDo());
			statement.setInt(5, gv.getSoTietDay());
			statement.setInt(6, gv.getID());
			
			
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println(" Sửa thành công rồi  .");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public GiangVien read(int id) {
		GiangVien gv = new GiangVien();

		try {
			String queryString = "SELECT * FROM giangvien WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			result.next();

			int ID = result.getInt("ID");
			String hoten = result.getString("hoten");
			Double hesoluong = result.getDouble("hesoluong");
			String khoa = result.getString("khoa");
			String trinhdo = result.getString("trinhdo");
			Integer sotietday = result.getInt("sotietday");
		

			gv = new GiangVien(ID, hoten, hesoluong, khoa, trinhdo, sotietday);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return gv;
	}
	public void delete(int id) {
		try {
			String queryString = "delete from giangvien where id=?";
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
	}
	


