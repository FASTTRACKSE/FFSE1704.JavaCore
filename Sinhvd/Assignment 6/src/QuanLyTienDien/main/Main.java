package QuanLyTienDien.main;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;

import QuanLyTienDien.entity.*;

public class Main {
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\nHệ thống quản lý Tiền Điện");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập danh sách Khách Hàng");
				System.out.println("2. Nhập thông tin Biên Lai");
				System.out.println("3. In báo cáo tiêu thụ điện");
				System.out.println("4. Xoá 1 khách hàng");
				System.out.println("5. Kết thúc chương trình");
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
		dsKH.add(new KhachHang("KH002", "Trần Thị Trinh", "Cẩm Lệ, Đà Nẵng"));
		dsKH.add(new KhachHang("KH003", "Chu Cẩm Hà", "Hải Châu, Đà Nẵng"));
		dsKH.add(new KhachHang("KH004", "Nguyễn Anh Huấn", "Sơn Trà, Đà Nẵng"));
		dsKH.add(new KhachHang("KH005", "Bùi Đức Việt", "Ngũ Hành Sơn, Đà Nẵng"));
	}

	public static void generateDataBienLai() {
		// Biên lai khách hàng số 1
		ArrayList<BienLai> blKH1 = new ArrayList<BienLai>();
		blKH1.add(new BienLai("CT001", 1, 2018, 0, 100));
		blKH1.add(new BienLai("CT001", 2, 2018, 100, 120));
		blKH1.add(new BienLai("CT001", 3, 2018, 120, 150));
		blKH1.add(new BienLai("CT001", 4, 2018, 150, 200));
		dsKH.get(0).setdsBienLai(blKH1);

		dsKH.get(0).addTodsBienLai(new BienLai("CT001", 5, 2018, 200, 250));

		// Biên lai khách hàng số 2
		ArrayList<BienLai> blKH2 = new ArrayList<BienLai>();
		blKH2.add(new BienLai("CT002", 3, 2018, 0, 150));
		blKH2.add(new BienLai("CT002", 4, 2018, 150, 300));
		dsKH.get(1).setdsBienLai(blKH2);

		// Biên lai khách hàng số 3
		ArrayList<BienLai> blKH3 = new ArrayList<BienLai>();
		blKH3.add(new BienLai("CT003", 4, 2018, 0, 180));
		blKH3.add(new BienLai("CT003", 5, 2018, 180, 310));
		dsKH.get(2).setdsBienLai(blKH3);

		// Biên lai khách hàng số 4
		dsKH.get(3).addTodsBienLai(new BienLai("CT004", 5, 2018, 0, 150));

		// Biên lai khách hàng số 5
		dsKH.get(4).addTodsBienLai(new BienLai("CT005", 5, 2018, 0, 90));
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
		Collections.sort(dsKH);

		for (KhachHang x : dsKH) {
			System.out.println(x.getMaKh() + ":" + x.getTenKh() + "\t");
			for (BienLai o : x.getdsBienLai()) {
				System.out.println("\t\t\t" + o.getMaCongTo() + " - " + o.getCkThang() + "/" + o.getCkNam() + " - "
						+ o.getCsDauKy() + "\t:\t" + o.getCsCuoiKy() + "\t->\t" + o.TinhTongSoKy());
			}
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}
}
