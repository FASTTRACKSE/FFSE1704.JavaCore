package javacore.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javacore.entity.*;

public class QuanLy {
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 6) {
			try {
				System.out.println("\nHệ thống quản lý Tiền Điện");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập danh sách Khách Hàng");
				System.out.println("2. Nhập thông tin Biên Lai");
				System.out.println("3. In báo cáo tiêu thụ điện");
				System.out.println("4. Xoá 1 khách hàng");
				System.out.println("5. In báo cáo tiêu thụ điện");
				System.out.println("6. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					// Generate data
					generateDataKH();
				} else if (myOption == 2) {
					// Sort student list by Name
					generateDataBienLai();
				} else if (myOption == 3) {
					// Sort student list by Name
					printReport("Thống kê tình hình tiêu thụ điện");
				} else if (myOption == 4) {
					xoaKH(1);
					// Sort student list by Name
					printReport("Thống kê tình hình tiêu thụ điện");
				} else if (myOption == 5) {
					// Sort student list by Name
					inDsTheoChuKy();
				} else if (myOption == 6) {
					// Hiển thị thông báo kết thúc
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại nhé bạn hiền!");
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}

	public static void generateDataKH() {
		dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH001", "Nguyễn Văn Anh", "Hải Châu, Đà Nẵng"));
		dsKH.add(new KhachHang("KH002", "Trần Thị Bình", "Cẩm Lệ, Đà Nẵng"));
		dsKH.add(new KhachHang("KH003", "Chu Cẩm Hà", "Hải Châu, Đà Nẵng"));
		dsKH.add(new KhachHang("KH004", "Nguyễn Anh Tuấn", "Sơn Trà, Đà Nẵng"));
		dsKH.add(new KhachHang("KH005", "Bùi Đức Việt", "Ngũ Hành Sơn, Đà Nẵng"));
		dsKH.add(new KhachHang("KH006", "Bùi Đức Trung", "OKE, Đà Nẵng"));
		dsKH.add(new KhachHang("KH007", "Phạm Ngọc Thành", "CallMe, Đà Nẵng"));
	
	}

	public static void generateDataBienLai() {
		ArrayList<BienLai> blKH1 = new ArrayList<BienLai>();
		blKH1.add(new BienLai("CT001", 1, 2018, 0, 100));
		blKH1.add(new BienLai("CT001", 2, 2018, 100, 120));
		blKH1.add(new BienLai("CT001", 3, 2018, 120, 150));
		blKH1.add(new BienLai("CT001", 4, 2018, 150, 200));
		dsKH.get(0).setDsBienLai(blKH1);
		dsKH.get(0).addDsBienLai(new BienLai("CT001", 5, 2018, 200, 250));

		// Biên lai khách hàng số 2
		ArrayList<BienLai> blKH2 = new ArrayList<BienLai>();
		blKH2.add(new BienLai("CT002", 3, 2018, 0, 150));
		blKH2.add(new BienLai("CT002", 4, 2018, 150, 300));
		dsKH.get(1).setDsBienLai(blKH2);

		// Biên lai khách hàng số 3
		ArrayList<BienLai> blKH3 = new ArrayList<BienLai>();
		blKH3.add(new BienLai("CT003", 4, 2018, 0, 180));
		blKH3.add(new BienLai("CT003", 5, 2018, 180, 310));
		dsKH.get(2).setDsBienLai(blKH3);

		// Biên lai khách hàng số 4
		dsKH.get(3).addDsBienLai(new BienLai("CT004", 5, 2018, 0, 150));

		// Biên lai khách hàng số 5
		dsKH.get(4).addDsBienLai(new BienLai("CT005", 5, 2018, 0, 90));
		// Biên lai khách hàng số 6
		dsKH.get(5).addDsBienLai(new BienLai("CT006", 7, 2018, 120, 100));

		ArrayList<BienLai> blKH7 = new ArrayList<BienLai>();
		blKH7.add(new BienLai("CT007", 1, 2018, 120, 190));
		blKH7.add(new BienLai("CT007", 2, 2018, 200, 230));
		blKH7.add(new BienLai("CT007", 3, 2018, 170, 250));
		dsKH.get(6).setDsBienLai(blKH7);
		
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public static void xoaKH(int i) {
		if (!dsKH.isEmpty()) {
			dsKH.remove(i);
		}
	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}

	public static void printReport(String title) {
		System.out.println("\n" + title);
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		// Sắp Xếp
		Collections.sort(dsKH, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang kh1, KhachHang kh2) {
				return (kh1.tenKhachHang.compareTo(kh2.tenKhachHang));

			}
		});
		
		for (KhachHang x : dsKH) {
			System.out.println(x.getMaKhachHang() + " : " + x.getTenKhachHang() + "  -  " + x.getDiaChi() + "\t");
			for (BienLai o : x.getDsBienLai()) {
				System.out.println("\t\t\t\t\t\t" + o.getMaCongTo() + " - " + o.getCkThang() + "/" + o.getCkNam()
						+ " - " + o.getChiSoCu() + "\t:\t" + o.getChiSoMoi() + "\t->\t" + o.tinhTienTrongKy()
						+ " VNĐ ");
			}
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}

	public static void inDsTheoChuKy() {
		int nhap;
		System.out.println("Mời bạn nhập chu kỳ tháng :  ");
		nhap = myInput.nextInt();

		for (KhachHang x : dsKH) {

			for (BienLai o : x.getDsBienLai()) {
				if (nhap == o.getCkThang()) {

					System.out.println(x.getMaKhachHang() + ":" + x.getTenKhachHang() + "\t" + "MãCT" + "\t" + "Tháng/Nam" + "\t"
							+ "CS Đầu Kỳ" + "\t" + "CS Cuối Kỳ" + "\t" + "Tổng tiền");

					System.out.println("\t\t\t" + o.getMaCongTo() + "\t" + o.getCkThang() + "/" + o.getCkNam() + "\t\t"
							+ o.getChiSoCu() + "\t\t  " + o.getChiSoMoi() + "\t\t" + o.tinhTienTrongKy() + ".VND");

					System.out.println(
							"\n---------------------------------------------------------------------------------------------");
				}
			}

		}

	}
	}


// dsKH = new ArrayList<KhachHang>();
//
// Scanner myInput = new Scanner(System.in);
// System.out.print(" Nhập Số Lượng Khách Hàng :");
// int n = myInput.nextInt();
//
// ArrayList<KhachHang> listKH = new ArrayList();
// for (int i = 0; i < n; i++) {
// System.out.print("\nNhập Mã Khách Hàng :");
//
// int maKhachHang = myInput.nextInt();
//
// System.out.print("Nhập Tên Khách Hàng :");
// myInput.nextLine();
// String tenKhachHang = myInput.nextLine();
//
// System.out.print("Nhập Địa Chỉ Khách Hàng :");
// String diaChi = myInput.nextLine();
//
// System.out.print("Nhập Số Công Tơ :");
// int maCongTo = myInput.nextInt();
//
// System.out.print("Nhập Kỳ Tiêu Thụ :");
// myInput.nextLine();
// int kyTieuThu = myInput.nextInt();
//
// System.out.print("Nhập Chỉ Số Cũ :");
// int chiSoCu = myInput.nextInt();
//
// System.out.print("Nhập Chỉ Số Mới :");
// int chiSoMoi = myInput.nextInt();
//
// KhachHang KhachHang = new KhachHang(maKhachHang, tenKhachHang, diaChi,
// maCongTo);
//// }//
//
// System.out.println("\nDanh Sách Khách Hàng: ");
// for (int i = 0; i < n; i++) {
// System.out.println((i + 1) + listKH.get(i).getTenKhachHang() +
// listKH.get(i).getMaKhachHang());
// }
// }
