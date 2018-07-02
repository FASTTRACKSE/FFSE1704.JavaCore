package ftse.qlkh.main;

import java.util.ArrayList;

import ftse.qlkh.dao.KhachHangDao;
import ftse.qlkh.entity.KhachHang;

public class QLKH {
	static KhachHangDao khachHangDAO = new KhachHangDao();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "quanlysinhvien_ffse1704007", "nghia111", "123456");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		dsKH = khachHangDAO.getDSKhachHang();
		
		for (KhachHang x: dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}
		KhachHang kh1 = new KhachHang("kh111","abc","xyz","lmn","cka","12222");
		KhachHangDao.add(kh1);
		
	}

}