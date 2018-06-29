package fasttrackse.qlkh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.qlkh.entity.KhachHang;

public class KhachHangDAO {
	
	public Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
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
		return conn;
	}
	
	public ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		return dsKH;
	}
	
	public void add(KhachHang kh) {
		//
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
