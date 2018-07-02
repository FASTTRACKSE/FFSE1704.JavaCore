package fasttrackse.qlkh.main;

import java.util.ArrayList;

import fasttrackse.qlkh.dao.KhachHangDAO;
import fasttrackse.qlkh.entity.KhachHang;

public class QLKH {
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

		int maKHCanXoa = 16;
		khachHangDAO.delete(maKHCanXoa);
		
		dsKH = khachHangDAO.getDSKhachHang();
		
		for (KhachHang x: dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}
		
//		KhachHang kh1 = new KhachHang("KH005", "Nguyen Thi B1", "Da Nang", "2000-01-01", "Nu", "0909");
//		khachHangDAO.add(kh1);
//		
//		KhachHang kh2 = new KhachHang("KH006", "Nguyen Thi B2", "Da Nang", "2000-01-01", "Nu", "0909");
//		khachHangDAO.add(kh2);
//		
		//khachHangDAO.add(new KhachHang("KH007", "Nguyễn Thị Hương", "Đà Nẵng", "2000-01-01", "Nữ", "0909"));
		
		int maKH = 4;
		KhachHang khachHangThanYeu = khachHangDAO.read(maKH);
		System.out.println(khachHangThanYeu.getID() + "-" + khachHangThanYeu.getMaKH() + "-" + khachHangThanYeu.getTenKH());

	}

}
