package fasttrackse.javacore.main;

import java.util.Scanner;
import java.util.ArrayList;
import fasttrackse.javacore.entity.*;

public class QuanLyTienDien {
	static Scanner myInput = new Scanner(System.in);
	static int n = 0;
	static int thang;
	static int nam;
	static int tongtien = 0;
	static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	private static int chiSoCuoi;

	public static void main(String[] args) {
		chayChuongTrinh();
	}

	public static void nhapThongTinKhachHang() {
		System.out.println("Nhập danh sách khách hàng : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng khách hàng :");
		n = myInput.nextInt();

		for (int i = 0; i < n; i++) {

			myInput.nextLine();

			System.out.println("Nhập Mã khách hàng thứ " + (i + 1) + " : ");
			String maKhachHang = myInput.nextLine();

			System.out.println("Nhập Tên khách hàng thứ " + (i + 1) + " : ");
			String tenKhachHhang = myInput.nextLine();

			System.out.println("Nhập Địa Chỉ khách hàng thứ " + (i + 1) + " : ");
			String diaChi = myInput.nextLine();

			System.out.println("Nhập Mã Công Tơ của khách hàng thứ " + (i + 1) + " : ");
			int maCongTo = myInput.nextInt();

			arrKhachHang.add(new KhachHang(maKhachHang, tenKhachHhang, diaChi, maCongTo));

		}
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();

	}

	public static void nhapThongTinTieuThu() {
		System.out.print("Nhập số biên lai ");
		int soBienLai = myInput.nextInt();
		for (int j = 0; j < soBienLai; j++) {
			System.out.print("Nhập chỉ số điện tiêu thụ của Tháng :  ");
			thang = myInput.nextInt();

			System.out.print("trong năm : ");
			nam = myInput.nextInt();

			for (int i = 0; i < arrKhachHang.size(); i++) {
///*
//				myInput.nextLine();*/

				System.out.println("Tên Khách hàng : " + arrKhachHang.get(i).getTenKhachHang());
				System.out.println("Mã Khách hàng : " + arrKhachHang.get(i).getMaKhachHang());
				System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMaCongTo());

				System.out.println("Nhập Chỉ Số Điện Đầu Kỳ :");
				int chiSoDau = myInput.nextInt();

				System.out.println("Nhập Chỉ Số Điện Cuối Kỳ :");
				int chiSoCuoi = myInput.nextInt();
				arrBienLai.add(new BienLai(arrKhachHang.get(i).getMaKhachHang(), arrKhachHang.get(i).getTenKhachHang(),
						arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMaCongTo(), chiSoDau, chiSoCuoi, thang,
						nam));

			}
//			
//			arrBienLai.add(new BienLai(arrKhachHang.get(j).getMaKhachHang(), arrKhachHang.get(j).getTenKhachHang(),
//					arrKhachHang.get(j).getDiaChi(), arrKhachHang.get(j).getMaCongTo(), chiSoCuoi , chiSoCuoi, thang,
//					nam));
			
		}
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();

	}

	public static void inBienLai() {
		myInput.nextLine();
		System.out.println("nhập mã khách hàng cần in biên lai : ");
		String maKhachHang = myInput.nextLine();

		System.out.println("Biên lai của khách hàng có mã khách hàng là : " + maKhachHang);
		System.out.println(
				"------------------------------------------DANH SÁCH BIÊN LAI CỦA KHÁCH HÀNG----------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		tongtien = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (maKhachHang.equals(arrBienLai.get(k).getMaKhachHang())) {
				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", (i + 1),
						arrBienLai.get(k).getMaKhachHang(), arrBienLai.get(k).getTenKhachHang(),
						arrBienLai.get(k).getDiaChi(), arrBienLai.get(k).getMaCongTo(), arrBienLai.get(k).getThang(),
						arrBienLai.get(k).getNam(), arrBienLai.get(k).getChiSoDau(), arrBienLai.get(k).getChiSoCuoi(),
						arrBienLai.get(k).soTienPhaiTra());
				i = i + 1;
				tongtien += arrBienLai.get(k).soTienPhaiTra();
			}
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.printf(
				"                                                                                                 Tổng tiền:|%,10d\n",
				tongtien);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");

		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}
	
	public static void InBienLaiTheoChuKi() {

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		thang = myInput.nextInt();
		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		nam = myInput.nextInt();
		System.out.println("Danh sách tính tiền điện của khách hàng trong tháng : " + thang + " năm :" + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		tongtien = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (thang == arrBienLai.get(k).getThang() && nam == arrBienLai.get(k).getNam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", (i + 1),
						arrBienLai.get(k).getMaKhachHang(),
						arrBienLai.get(k).getTenKhachHang(),
						arrBienLai.get(k).getDiaChi(),
						arrBienLai.get(k).getMaCongTo(),
						arrBienLai.get(k).getThang(),
						arrBienLai.get(k).getNam(),
						arrBienLai.get(k).getChiSoDau(),
						arrBienLai.get(k).getChiSoCuoi(),
						arrBienLai.get(k).soTienPhaiTra());
				i = i + 1;
				tongtien += arrBienLai.get(k).soTienPhaiTra();
			}
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.printf(
				"                                                                                                 Tổng tiền:|%,10d\n",
				tongtien);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void chayChuongTrinh() {
		while (true) {
			try {
				System.out.println(">>         MENU QUẢN LÝ TIỀN ĐIỆN       <<");
				System.out.println("+----------------------------------------+");
				System.out.println("|1. Nhập thông tin khách hàng            |");
				System.out.println("|2. Nhập thông tin chỉ số tiêu thụ       |");
				System.out.println("|3. In danh sách theo mã khách hàng      |");
				System.out.println("|4. In danh sách theo chu kỳ             |");
				System.out.println("|5. Kết thúc chương trình                |");
				System.out.println("+----------------------------------------+");
				System.out.println(">>            Lựa chọn của bạn?         <<");
				int myOption = myInput.nextInt();
				if (myOption == 1) {
					nhapThongTinKhachHang();
				} else if (myOption == 2) {
					nhapThongTinTieuThu();
				} else if (myOption == 3) {
					inBienLai();
				}else if (myOption == 4) {
					InBienLaiTheoChuKi();
				}else if (myOption == 5) {
					ketThuc();
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Bạn đã nhập sai vui lòng nhập lại!!!Nhập lựa chọn từ 1 đến 4!!!");
				myInput.nextLine();
			}
		}

	}
}
