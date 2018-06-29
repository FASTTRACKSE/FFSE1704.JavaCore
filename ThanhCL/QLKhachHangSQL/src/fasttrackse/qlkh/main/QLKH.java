package fasttrackse.qlkh.main;

import java.sql.Connection;
import java.util.ArrayList;

import fasttrackse.qlkh.dao.KhachHangDAO;
import fasttrackse.qlkh.entity.KhachHang;

public class QLKH {
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		Connection conn = khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

}
