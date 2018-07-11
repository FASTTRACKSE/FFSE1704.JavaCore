package fasttrackse.qlkh.main;

import java.sql.Connection;
import java.util.ArrayList;

import fasttrackse.qlkh.dao.KhachHangDAO;
import fasttrackse.qlkh.entity.KhachHang;

public class QLKH {
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "ffse1702016", "ffse1702016", "ffse123");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		dsKH = khachHangDAO.getDSKhachHang();

		for (KhachHang x : dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}

		KhachHang kh1 = new KhachHang("KH03", "Nguyen Van A", "Da Nang", "1990-02-02", "Nam", "01227656298");
		khachHangDAO.add(kh1);

		KhachHang kh2 = new KhachHang("KH04", "Nguyen Van B", "Da Nang", "1990-02-02", "Nam", "01227656298");
		khachHangDAO.add(kh2);
	}

}