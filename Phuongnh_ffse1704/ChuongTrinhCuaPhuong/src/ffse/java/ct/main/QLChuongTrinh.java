package ffse.java.ct.main;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import ffse.java.ct.dao.SinhVienDAO;
import ffse.java.ct.entity.SinhVien;
import ffse.java.ct.ui.*;

public class QLChuongTrinh {
	static SinhVienDAO sinhVienDAO = new SinhVienDAO();
	static ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();

	public static void main(String[] args) {
		ChuongTrinhUI QLCT = new ChuongTrinhUI("rgre");
		QLCT.showWindow();
		sinhVienDAO.getConnect("localhost", "ffse1703009", "phuonghanh", "phuonghanh123");

	}
}

