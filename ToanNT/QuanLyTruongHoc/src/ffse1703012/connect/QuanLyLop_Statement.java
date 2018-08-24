package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.QuanLyLop;

public class QuanLyLop_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<QuanLyLop> arrLop = new ArrayList<>();
	int soLuongSinhVien;

	public ArrayList<QuanLyLop> sellectAllLop() {
		
		arrLop.clear();
		try {
			String sql = "select * from Lop";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String maLop = result.getString("Malop");
				String tenLop = result.getString("Tenlop");
				String namHoc = result.getString("Namhoc");
				arrLop.add(new QuanLyLop(maLop, tenLop, namHoc));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrLop;
	}

	public void insertLopHoc(String maLop, String tenLop, String namHoc) {
		try {
			String sql = "insert into Lop values('" + 0 + "','" + maLop + "', '" + tenLop + "', '" + namHoc + "')";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm lớp học thành công!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateLopHoc(String maLop, String tenLop, String namHoc) {
		try {
			String sql = "update Lop set Tenlop='" + tenLop + "', Namhoc='" + namHoc + "' where Malop='" + maLop + "'";
			Statement statement = conn.createStatement();
			int y = statement.executeUpdate(sql);
			if (y > 0) {
				JOptionPane.showMessageDialog(null, "Sửa lớp học thành công!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteLopHoc(String maLop) {
		try {
			String sql = "delete from Lop where Malop='" + maLop + "'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa lớp học thành công!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int demSoSinhVien(String maLop) {
		try {
			String sql = "select count(*) from Sinh_vien where Malop = " + "'" + maLop + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				soLuongSinhVien = result.getInt("COUNT(*)");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return soLuongSinhVien;
	}
}
