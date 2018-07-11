package fasttrackse.qlkh.java.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fasttrackse.qlkh.java.dao.KhachHangDao;
import fasttrackse.qlkh.java.entity.KhachHang;
import fasttrackse.qlkh.java.entity.until;

public class QuanLyKhachHang {
	static int n, id, i, SoDT;
	static boolean inputOK;
	static int choose;
	static Scanner nhap = new Scanner(System.in);
	static KhachHangDao khachHangDAO = new KhachHangDao();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static String MaKH, TenKH, DiaChi, GioiTinh, NgaySinh;

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		while (true) {

			try {
				System.out.println("\nHệ Thống Quản lý Khách Hàng");
				System.out.println("---------------------------------------");
				System.out.println("1. Danh sách khách hàng. ");
				System.out.println("2. Bạn muốn Thêm khách hàng.  ");
				System.out.println("3. Bạn muốn sửa một khách hàng .");
				System.out.println("4. Bạn muốn xóa một khách hàng .");
				System.out.println("5. Bạn muốn xem thông tin khách hàng");
				System.out.println("6. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				n = nhap.nextInt();
				if (n == 1) {
					select();
				} else if (n == 2) {

					add();
				} else if (n == 3) {
					edit();
				} else if (n == 4) {
					delete();

				} else if (n == 5) {

					read();
				} else if (n == 6) {

					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.err.println("Vui lòng nhập lại bạn hiền !");
			} finally {
				if (n != 6) {
					backToMainMenu();
				}
			}
		}
	}

	public static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để trở về menu.");
		nhap.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Chương trình kết thúc ,cảm ơn bạn đã sử dụng !");
	}

	// xem toàn bộ khách hàng
	public static void select() {
		khachHangDAO.getConnect("localhost", "quanlykhachhang", "quanlykhachhang", "quangminh123");
		dsKH = khachHangDAO.getDSKhachHang();
		System.out.printf("%2s %10s %12s %20s %17s %12s %9s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();

		for (KhachHang o : dsKH) {
			System.out.println(o.getId() + "\t " + o.getMaKH() + "\t  " + o.getTenKH() + "\t" + o.getDiaChi() + "\t"
					+ o.getNgaySinh() + "\t" + o.getGioiTinh() + "\t   " + o.getSoDT());
		}

	}

	// Thêm Một Khách Hàng

	public static void add() {
		khachHangDAO.getConnect("localhost", "quanlykhachhang", "quanlykhachhang", "quangminh123");
		System.out.println("NHẬP THÔNG TIN KHÁCH HÀNG");
		System.out.println("-------------------------------");
		System.out.print("Nhập số lượng khách hàng :");
		n = nhap.nextInt();
		for (i = 0; i < n; i++) {
			System.out.println("Nhập thông tin khách hàng thứ :" + (i + 1));
			System.out.println("----------------------------------------");

			// nhập id khách hàng

			do {
				try {

					System.out.print("Nhập id khách hàng: ");
					id = nhap.nextInt();
					nhap.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("id phải là số thực");
					nhap.nextLine();
					inputOK = false;

				}
			} while (!inputOK);

			// nhập mã khách hàng

			do {

				try {
					inputOK = true;
					System.out.print("Nhập mã khách hàng: ");
					MaKH = nhap.nextLine();
					if (MaKH.length() < 1 || MaKH.length() > 30) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					nhap.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập họ tên khách hàng
			do {

				try {
					inputOK = true;
					System.out.print("Nhập họ tên Khách Hàng: ");
					TenKH = nhap.nextLine();
					if (TenKH.length() < 1 || TenKH.length() > 30) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					nhap.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập điạ chỉ khách hàng
			do {

				try {
					inputOK = true;
					System.out.print("Nhập địa chỉ Khách Hàng: ");
					DiaChi = nhap.nextLine();
					if (DiaChi.length() < 1 || DiaChi.length() > 50) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					nhap.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập ngày sinh của khách hàng
			do {
				try {

					System.out.print("Nhập ngày sinh của khách hàng( năm-tháng-ngày): ");
					NgaySinh = nhap.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("ngày sinh là số thực");
					nhap.nextLine();
					inputOK = false;

				}
			} while (!inputOK);

			// nhập giới tính khách hàng
			do {
				System.out.print("Mời bạn chọn giới tính (1 - Nam, 2 - Nữ): ");
				choose = nhap.nextInt();
				switch (choose) {
				case 1:
					GioiTinh = "Nam";

					break;
				case 2:
					GioiTinh = "Nữ";

					break;
				
				default:
					System.err.println("Chọn không đúng!" + "\nMời chọn lại:");

					break;
				}
			} while (choose < 1 || choose > 3);
			
			// nhập số điện thoại của khách hàng

			do {
				try {

					System.out.print("Nhập số điện thoại: ");
					SoDT = nhap.nextInt();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("số điện thoại là số thực");
					nhap.nextLine();
					inputOK = false;

				}
			} while (!inputOK);

		}

		khachHangDAO.add(new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));

	}

	// Sửa Một Khách Hàng
	public static void edit() {
		khachHangDAO.getConnect("localhost", "quanlykhachhang", "quanlykhachhang", "quangminh123");
		System.out.print("Mời bạn nhập (Id) khách hàng mà bạn muốn sửa:");
		id = nhap.nextInt();
		KhachHang khachHang = khachHangDAO.read(id);
		System.out.printf("%2s %10s %12s %20s %17s %12s %9s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();
		System.out.println(khachHang.getId() + "\t " + khachHang.getMaKH() + "\t  " + khachHang.getTenKH() + "\t"
				+ khachHang.getDiaChi() + "\t" + khachHang.getNgaySinh() + "\t" + khachHang.getGioiTinh() + "\t   "
				+ khachHang.getSoDT());
		System.out.println("----------------------------------------");
		System.out.println("Mời bạn nhập thông tin mới cửa khách hàng !");

		// nhập mã khách hàng

		do {

			try {
				inputOK = true;
				nhap.nextLine();
				System.out.print("Nhập mã khách hàng: ");
				MaKH = nhap.nextLine();
				if (MaKH.length() < 1 || MaKH.length() > 30) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				nhap.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập họ tên khách hàng
		do {

			try {
				inputOK = true;
				System.out.print("Nhập họ tên Khách Hàng: ");
				TenKH = nhap.nextLine();
				if (TenKH.length() < 1 || TenKH.length() > 30) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				nhap.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập điạ chỉ khách hàng
		do {

			try {
				inputOK = true;
				System.out.print("Nhập địa chỉ Khách Hàng: ");
				DiaChi = nhap.nextLine();
				if (DiaChi.length() < 1 || DiaChi.length() > 30) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				nhap.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập ngày sinh của khách hàng
		do {
			try {

				System.out.print("Nhập ngày sinh của khách hàng( năm-tháng-ngày): ");
				NgaySinh = nhap.nextLine();
				inputOK = true;

			} catch (InputMismatchException e) {

				System.err.println("Ngày sinh phải là số thực");
				nhap.nextLine();
				inputOK = false;

			}
		} while (!inputOK);

		// nhập giới tính khách hàng
		do {
			System.out.print("Mời bạn chọn giới tính (1 - Nam, 2 - Nữ): ");
			choose = nhap.nextInt();
			switch (choose) {
			case 1:
				GioiTinh = "Nam";

				break;
			case 2:
				GioiTinh = "Nữ";

				break;
			
			default:
				System.err.println("Chọn không đúng!" + "\nMời chọn lại:");

				break;
			}
		} while (choose < 1 || choose > 3);
		// nhập số điện thoại của khách hàng

		do {
			try {

				System.out.print("Nhập Số điện thoại khách hàng: ");
				SoDT = nhap.nextInt();
				inputOK = true;

			} catch (InputMismatchException e) {

				System.err.println("Số điện thoại phải là số thực");
				nhap.nextLine();
				inputOK = false;

			}
		} while (!inputOK);
		KhachHang kh = (new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));
		khachHangDAO.edit(kh);
	}

	// xóa Một Khách Hàng
	public static void delete() {
		khachHangDAO.getConnect("localhost", "quanlykhachhang", "quanlykhachhang", "quangminh123");
		System.out.print("Mời bạn nhập (Id) khách hàng mà bạn muốn xóa: ");
		id = nhap.nextInt();

		khachHangDAO.delete(id);

	}

	// Xem Thông tinh khách hàng

	public static void read() {
		khachHangDAO.getConnect("localhost", "quanlykhachhang", "quanlykhachhang", "quangminh123");
		System.out.print("Mời bạn nhập (Id) khách hàng mà bạn muốn xem:");
		id = nhap.nextInt();
		KhachHang khachHang = khachHangDAO.read(id);

		System.out.printf("%2s %10s %12s %20s %17s %12s %9s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();
		System.out.println(khachHang.getId() + "\t " + khachHang.getMaKH() + "\t  " + khachHang.getTenKH() + "\t"
				+ khachHang.getDiaChi() + "\t" + khachHang.getNgaySinh() + "\t" + khachHang.getGioiTinh() + "\t   "
				+ khachHang.getSoDT());
	}
}
