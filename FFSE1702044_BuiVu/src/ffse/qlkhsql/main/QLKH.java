package ffse.qlkhsql.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ffse.qlkhsql.dao.KhachHangDAO;
import ffse.qlkhsql.utity.KhachHang;
import ffse.qlkhsql.utity.myException;

public class QLKH {
	static int N;
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			try {

				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+---------------------------+");
				System.out.println("|1.Kết Nối DataBase         |");
				System.out.println("|2.In danh sách DataBase    |");
				System.out.println("|3. Thêm DS Khách Hàng      |");
				System.out.println("|4.XÓa Khách Hàng           |");
				System.out.println("|5.Sửa KH                   |");
				System.out.println("|6.Đọc KH                   |");
				System.out.println("|7.Kết Thúc CT              |");
				System.out.println("+---------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				N = myInput.nextInt();
				if (N == 1) {
					KetNoiDB();
				} else if (N == 2) {
					InDSKH();
				} else if (N == 3) {
					ThemDsKH();
				} else if (N == 4) {
					XoaKH();
				} else if (N == 5) {
					EditKH();
				} else if (N == 6) {
					ReadKH();
				} else if (N == 7) {
					Exit();
				} else {
					throw new myException(2);
				}

			} catch (InputMismatchException e) {
				System.err.println("Vui Lòng Nhập Kiểu Số\n");
				myInput.next();
			} catch (myException e) {
				System.err.print(e);
				System.err.println("\n1 để nhập lại CT");
				myInput.nextInt();
			}
		}

		/*
		 * KhachHang kh4 = new KhachHang("KH004", "Từ Văn Trần","Đà Nẵng" ,"1998-11-03"
		 * ,"Nam" ,"0917789555"); khachHangDAO.add(kh4);
		 */

	}

	public static void KetNoiDB() {
		khachHangDAO.getConnect("localhost", "test", "test", "test");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public static void InDSKH() {
		dsKH = khachHangDAO.getDSKhachHang();
		for (KhachHang x : dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}

	}

	public static void ThemDsKH() {
		int N = 0;
		System.out.println("Mời bạn nhập số lượng cần nhập!!");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn " + N + " Số Lượng");
			} else {
				throw new myException(6);
			}
		} catch (myException e) {
			System.out.println(e);
		}

		for (int i = 0; i < N; i++) {

			System.out.println("Mời Bạn Nhập Mã Khách Hàng!");
			myInput.nextLine();
			String maKH = myInput.nextLine();

			System.out.println("Mời Bạn Nhập Tên KH!!!");
			String tenKH = myInput.nextLine();
			System.out.println("Mời Bạn Nhập ĐỊa CHỉ Khách Hàng!!");
			String diaChiKH = myInput.nextLine();
			System.out.println("mời Bạn nhập năm sinh KH. Theo Thứ tự YY/MM/DD");
			String namSinhKH = myInput.nextLine();
			System.out.println("Mời Bạn Nhập Giới Tính!!!");
			String gioiTinhKH = myInput.nextLine();
			System.out.println("Mời Bạn Nhập Số Điện Thoại");
			String soDT = myInput.nextLine();
			KhachHang kh = new KhachHang(maKH, tenKH, diaChiKH, namSinhKH, gioiTinhKH, soDT);
			khachHangDAO.add(kh);

		}
	}

	public static void EditKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần Sửa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		System.out.println("Mời Bạn Nhập Tên KH!!!");
		myInput.nextLine();
		String tenKH = myInput.nextLine();
		System.out.println("mời Bạn nhập năm sinh KH. Theo Thứ tự YY/MM/DD");
		String namSinhKH = myInput.nextLine();
		KhachHang kh = new KhachHang(N, tenKH, namSinhKH);
		khachHangDAO.edit(kh);

	}

	public static void XoaKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần XÓa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		khachHangDAO.delete(N);
	}

	public static void ReadKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần Xem");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		khachHangDAO.read(N);
	}

	public static void Exit() {
		System.out.println("Chương Trình Đã Kết Thúc!!!");
		System.exit(0);
	}
}
