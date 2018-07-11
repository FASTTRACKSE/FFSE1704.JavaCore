package ffse.qlkh.main;

import java.util.ArrayList;

import ffse.qlkh.dao.KhachHangDAO;
import ffse.qlkh.entity.KhachHang;

public class QLKH {
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "ffse1702052", "ffse1702052", "ffse1702052tung");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		dsKH = khachHangDAO.getDSKhachHang();
		
		for (KhachHang x: dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}
	}

}