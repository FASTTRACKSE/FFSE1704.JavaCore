/**
 *	Prog: QUẢN LÝ TIỀN ĐIỆN
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 07/06/2018
 */
package Assignment_5_ArrayList.src.ffse.quanlytiendien.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Assignment_5_ArrayList.src.ffse.quanlytiendien.entity.*;

public class Main {
	static int N;
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập Thông Tin Khách Hàng|");
			System.out.println("|2.Nhập Biên Lai  Khách Hàng|");
			System.out.println("|3.In Hóa Đơn Tiền điện KH  |");
			System.out.println("|4.DS Tiêu Thụ Theo Chu Kỳ  |");
			System.out.println("|5.Xóa 1 Khách Hàng         |");
			System.out.println("|6.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				generateDataKH();
			} else if (N == 2) {
				generateDataBienLai();
			} else if (N == 3) {
				printReport();
			} else if (N == 4) {
				InDsTieuThuTheoChuKy();
			} else if (N == 5) {
				xoaKH();
			} /*
				 * else if (N == 6) { XoaBienLaiKH(); }
				 */ else {
				System.exit(0);
			}
		}
	}



public static void generateDataKH() {

	Scanner nhap = new Scanner(System.in);
	System.out.println("Nhập số khách hàng: ");
	int n = nhap.nextInt();

	for (int i = 0; i < n; i++) {
		nhap.nextLine();
		KhachHang x = new KhachHang();
		System.out.println("Thông tin khách hàng thứ " + (i + 1));

		System.out.print("Mã Khách Hàng: ");
		x.setMaKH(nhap.nextLine());

		System.out.print("Họ và Tên: ");
		x.setTenKH(nhap.nextLine());

		System.out.print("Địa chỉ: ");
		x.diaChiKH = nhap.nextLine();

		dsKH.add(x);
	}
}

public static void generateDataBienLai() {
	String M = "";
	System.out.print("Nhập Tên khách hàng muốn nhập biên lai?: ");
	myInput.nextLine();
	M = myInput.nextLine();
	for (int i = 0; i < dsKH.size(); i++) {
		if (M.equals(dsKH.get(i).getKhachHang())) {
			System.out.print("Nhập Thông Tin Biên Lai Khách Hàng Thứ " + (i + 1) + "\n");
			System.out.print("Nhập Mã Công Tơ");
			String maCongTo = myInput.nextLine();
			System.out.print("Nhập Chỉ Số Cũ");
			int chiSoCu = myInput.nextInt();
			System.out.print("Nhập Chỉ Số mới");
			int chiSoMoi = myInput.nextInt();
			System.out.print("Nhập Chu Kỳ Tháng:");
			int ckThang = myInput.nextInt();
			System.out.print("Nhập Chu Kỳ Năm:");
			int ckNam = myInput.nextInt();
			dsKH.get(i).addToDsBienLai(new BienLai(maCongTo, chiSoCu, chiSoMoi, ckThang, ckNam));
		}
	}
}

public static void ketThuc() {
	System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
}

public static void InDsTieuThuTheoChuKy() {
	int C = 0;
	System.out.print("Nhập Chu Kì Muốn In");
	C = myInput.nextInt();
	for (KhachHang x : dsKH) {
		System.out.println(" Mã KH : " + x.getMaKH() + " Tên KH :" + x.getKhachHang() + "\t"
				+ "CS Cũ" + "\t" + "CS Mới" + "\t" + "Tháng/Năm" + "\t" + "Tổng tiền");
		for (BienLai o : x.getDsBienLai()) {
			if (o.getCkThang() == C) {
				System.out.println("\t\t\t\t" + o.getCsDauKy() + " \t" + o.getCsCuoiKy() + "\t " + o.getCkThang()
						+ "/" + o.getCkNam() + "\t\t" + o.tinhTienTrongKy() + " VNĐ");
				break;
			}
		}
	}
}

public static void xoaKH() {
	String X;
	System.out.print("Nhập Tên Khách Hàng Cần Xóa!!!");
	myInput.nextLine();
	X = myInput.nextLine();
	for (KhachHang x : dsKH) {
		if (X.equals(x.getKhachHang())) {
			dsKH.remove(x);
		}
	}
}

public static void backToMainMenu() {
	myInput.nextLine();
	System.out.println("Ấn Enter để về menu chính");
	myInput.nextLine();
}

public static void printReport() {

	System.out.println(
			"--------------------------------------------------------------------------------------------");
	Collections.sort(dsKH);

	for (KhachHang x : dsKH) {
		System.out.println("=> Khu Vực: " + x.getDiaChiKH());
		System.out.println(x.getMaKH() + ":" + x.getTenKH() + "\t");
		for (BienLai o : x.getDsBienLai()) {
			System.out.println("\t\t\t" + o.getMaCongTo() + " - " + o.getCkThang() + "/" + o.getCkNam() + " - "
					+ o.getCsDauKy() + "\t:\t" + o.getCsCuoiKy() + "\t->\t" + o.tinhTienTrongKy() + " VNĐ");
		}
		System.out.println(
				"*******************************************************************************************");
	}

	System.out.println(
			"--------------------------------------------------------------------------------------------");
}
}
