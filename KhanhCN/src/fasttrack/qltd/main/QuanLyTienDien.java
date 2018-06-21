package fasttrack.qltd.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fasttrack.qltd.entity.*;

public class QuanLyTienDien {
	static ArrayList<KhachHang> danhsachKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\n    HỆ THỐNG QUẢN LÝ TIỀN ĐIỆN");
				System.out.println("+-----------------------------------+");
				System.out.println("| 1. Nhập danh sách Khách Hàng      |");
				System.out.println("| 2. Nhập thông tin Biên Lai        |");
				System.out.println("| 3. In báo cáo tiêu thụ điện       |");
				System.out.println("| 4. In danh sách theo chu kỳ       |");
				System.out.println("| 5. Xoá 1 khách hàng               |");
				System.out.println("| 6. Kết thúc chương trình          |");
				System.out.println("+-----------------------------------+");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					generateDataKH();
				} else if (myOption == 2) {
					generateDataBienLai();
				} else if (myOption == 3) {
					printReport("\t\t\tTHỐNG KÊ TÌNH HÌNH TIÊU THỤ ĐIỆN ");
				} else if (myOption == 4) {
					inDsTheoChuKy();
				} else if (myOption == 5) {
					xoaKH();
				} else if (myOption == 6) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại nhé bạn hiền!");
			} finally {
				if (myOption != 6) {
					backToMainMenu();
				}
			}
		}
	}

	public static void generateDataKH() {
		danhsachKH = new ArrayList<KhachHang>();
		danhsachKH.add(new KhachHang("KH001", "Vũ Văn Thanh ", "Hải Châu, Đà Nẵng"));
		danhsachKH.add(new KhachHang("KH002", "Bùi Tiến Dũng", "Cẩm Lệ, Đà Nẵng"));
		danhsachKH.add(new KhachHang("KH003", "Lê Trọng Quân", "Hải Châu, Đà Nẵng"));
		danhsachKH.add(new KhachHang("KH004", "Đỗ Duy Mạnh", "Sơn Trà, Đà Nẵng"));
		danhsachKH.add(new KhachHang("KH005", "Nguyễn Quang Hải", "Ngũ Hành Sơn, Đà Nẵng"));
	}

	public static void generateDataBienLai() {
		// Biên lai khách hàng số 1
		ArrayList<BienLai> blKH1 = new ArrayList<BienLai>();
		blKH1.add(new BienLai("CT001", 1, 2018, 0, 100));
		blKH1.add(new BienLai("CT001", 2, 2018, 100, 120));
		blKH1.add(new BienLai("CT001", 3, 2018, 120, 150));
		blKH1.add(new BienLai("CT001", 4, 2018, 150, 200));
		danhsachKH.get(0).setDsBienLai(blKH1);

		danhsachKH.get(0).addToDsBienLai(new BienLai("CT001", 5, 2018, 200, 250));

		// Biên lai khách hàng số 2
		ArrayList<BienLai> blKH2 = new ArrayList<BienLai>();
		blKH2.add(new BienLai("CT002", 3, 2018, 0, 150));
		blKH2.add(new BienLai("CT002", 4, 2018, 150, 300));
		danhsachKH.get(1).setDsBienLai(blKH2);

		// Biên lai khách hàng số 3
		ArrayList<BienLai> blKH3 = new ArrayList<BienLai>();
		blKH3.add(new BienLai("CT003", 4, 2018, 0, 180));
		blKH3.add(new BienLai("CT003", 5, 2018, 180, 310));
		danhsachKH.get(2).setDsBienLai(blKH3);

		// Biên lai khách hàng số 4
		danhsachKH.get(3).addToDsBienLai(new BienLai("CT004", 5, 2018, 0, 150));

		// Biên lai khách hàng số 5
		danhsachKH.get(4).addToDsBienLai(new BienLai("CT005", 5, 2018, 0, 90));
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public static void xoaKH() {
		String i;
		System.out.println("Nhập mã khách hàng bạn cần xóa :");
		i = myInput.next();
		for (KhachHang x : danhsachKH) {
			if (x.getMaKH().equals(i)) {
				danhsachKH.remove(x);
			}
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

		// Sắp xếp theo tên khách hàng
		Collections.sort(danhsachKH, new Comparator<KhachHang>() {

			public int compare(KhachHang khachhang1, KhachHang khachhang2) {

				return (khachhang1.getTenKH().compareTo(khachhang2.getTenKH()));

			}
		});

		for (KhachHang x : danhsachKH) {

			System.out.println(x.getMaKH() + ":" + x.getTenKH() + "\t" + "MãCT" + "\t" + "Tháng/Nam" + "\t"
					+ "CS Đầu Kỳ" + "\t" + "CS Cuối Kỳ" + "\t" + "Tổng tiền");

			for (BienLai o : x.getDsBienLai()) {

				System.out.println("\t\t\t" + o.getMaCongTo() + "\t" + o.getCkThang() + "/" + o.getCkNam() + "\t\t"
						+ o.getCsDauKy() + "\t\t  " + o.getCsCuoiKy() + "\t\t" + o.tinhTienTrongKy() + ".VND");
				System.out.println(
						"\n---------------------------------------------------------------------------------------------");
			}
		}

	}

	public static void inDsTheoChuKy() {
		int nhap;
		System.out.println("Mời bạn nhập chu kỳ tháng :  ");
		nhap = myInput.nextInt();

		for (KhachHang x : danhsachKH) {

			for (BienLai o : x.getDsBienLai()) {
				if (nhap == o.getCkThang()) {

					System.out.println(x.getMaKH() + ":" + x.getTenKH() + "\t" + "MãCT" + "\t" + "Tháng/Nam" + "\t"
							+ "CS Đầu Kỳ" + "\t" + "CS Cuối Kỳ" + "\t" + "Tổng tiền");

					System.out.println("\t\t\t" + o.getMaCongTo() + "\t" + o.getCkThang() + "/" + o.getCkNam() + "\t\t"
							+ o.getCsDauKy() + "\t\t  " + o.getCsCuoiKy() + "\t\t" + o.tinhTienTrongKy() + ".VND");

					System.out.println(
							"\n---------------------------------------------------------------------------------------------");
				}
			}

		}

	}

}