package fasttrackse.qlsv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.qlsv.entity.SinhVien;

public class QLSVDao {
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

	public void update(SinhVien sv) {
		try {
			String queryString = "update sinhvien set ho=?, ten=?, gioitinh =? , namsinh=?, lop=? WHERE ma =?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			
			statement.setString(1, sv.getHoSV());
			statement.setString(2, sv.getTenSV());
			statement.setString(3, sv.getGioitinhSV());
			statement.setString(4, sv.getNamsinhSV());
			statement.setString(5, sv.getLopSV());
			statement.setString(6, sv.getMaSV());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "SỬA thành công!!!");
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn SV để SỬA, bấm OK để thoát!!!");
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void add(SinhVien sv) {

		try {
			String queryString = "insert into sinhvien(ma,ho,ten,gioitinh,namsinh,lop" + 
					") values(?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, sv.getMaSV());
			statement.setString(2, sv.getHoSV());
			statement.setString(3, sv.getTenSV());
			statement.setString(4, sv.getGioitinhSV());
			statement.setString(5, sv.getNamsinhSV());
			statement.setString(6, sv.getLopSV());
			

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "THÊM thành công !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
public void delete(SinhVien sv) {
	try {
		String queryString = "delete from sinhvien where ma=?";
		PreparedStatement statement = conn.prepareStatement(queryString);

		statement.setString(1, sv.getMaSV());
		
		int x = statement.executeUpdate();
		if (x > 0) {
			JOptionPane.showMessageDialog(null, "XOÁ thành công!");
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn SV để XOÁ, bấm OK để thoát!!!!!");
			System.exit(0);
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		
	}

}
public ArrayList<SinhVien> getDSinhVien() {
	ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

	try {
		String queryString = "SELECT * FROM sinhvien";
		PreparedStatement statement = conn.prepareStatement(queryString);

		ResultSet result = statement.executeQuery();

		while (result.next()) {
			String maSV = result.getString("ma");
			String hoSV= result.getString("ho");
			String tenSV  = result.getString("ten");
			String namsinhSV = result.getString("namsinh");
			String gioitinhSV = result.getString("gioitinh");
			String lopSV = result.getString("lop");

			dsSV.add(new SinhVien(maSV, hoSV,tenSV,gioitinhSV,namsinhSV, lopSV));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return dsSV;
}
}
