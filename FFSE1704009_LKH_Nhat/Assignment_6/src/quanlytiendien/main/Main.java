/************************
 *Prop: QUẢN LÝ TIỀN ĐIỆN
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 4/06/2018
 **********************/
package quanlytiendien.main;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Support
 *
 */
import java.util.Scanner;

import quanlytiendien.entity.*;

public class Main {
	


		static int N;
		static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
		static Scanner myInput = new Scanner(System.in);

		public static void main(String[] args) {
			// TODO Auto-generated method stub

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

		// dsKH = new ArrayList<KhachHang>();
		// dsKH.add(new KhachHang("KH001", "Nguyễn Văn Anh", "Hải Châu, Đà Nẵng"));
		// dsKH.add(new KhachHang("KH002", "Trần Thị Trinh", "Cẩm Lệ, Đà Nẵng"));
		// dsKH.add(new KhachHang("KH003", "Chu Cẩm Hà", "Hải Châu, Đà Nẵng"));
		// dsKH.add(new KhachHang("KH004", "Nguyễn Anh Huấn", "Sơn Trà, Đà Nẵng"));
		// dsKH.add(new KhachHang("KH005", "Bùi Đức Việt", "Ngũ Hành Sơn, Đà Nẵng"));
		// dsKH.add(new KhachHang("KH006", "Lê Khả Hồng Nhật", "Ngũ Hành Sơn, Đà
		// Nẵng"));
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

		// // Biên lai khách hàng số 1
		// ArrayList<BienLai> blKH1 = new ArrayList<BienLai>();
		// blKH1.add(new BienLai("CT001", 1, 2018, 0, 100));
		// blKH1.add(new BienLai("CT001", 2, 2018, 100, 120));
		// blKH1.add(new BienLai("CT001", 3, 2018, 120, 150));
		// blKH1.add(new BienLai("CT001", 4, 2018, 150, 200));
		// dsKH.get(0).setDsBienLai(blKH1);
		//
		// dsKH.get(0).addToDsBienLai(new BienLai("CT001", 5, 2018, 200, 250));
		//
		// // Biên lai khách hàng số 2
		// ArrayList<BienLai> blKH2 = new ArrayList<BienLai>();
		// blKH2.add(new BienLai("CT002", 3, 2018, 0, 150));
		// blKH2.add(new BienLai("CT002", 4, 2018, 150, 300));
		// dsKH.get(1).setDsBienLai(blKH2);
		//
		// // Biên lai khách hàng số 3
		// ArrayList<BienLai> blKH3 = new ArrayList<BienLai>();
		// blKH3.add(new BienLai("CT003", 4, 2018, 0, 180));
		// blKH3.add(new BienLai("CT003", 5, 2018, 180, 310));
		// dsKH.get(2).setDsBienLai(blKH3);
		//
		// // Biên lai khách hàng số 4
		// dsKH.get(3).addToDsBienLai(new BienLai("CT004", 5, 2018, 0, 150));
		//
		// // Biên lai khách hàng số 5
		// dsKH.get(4).addToDsBienLai(new BienLai("CT005", 5, 2018, 0, 90));
		//
		// // Biên lai khách hàng số 6
		// dsKH.get(5).addToDsBienLai(new BienLai("CT006", 7, 2018, 0, 100));

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
