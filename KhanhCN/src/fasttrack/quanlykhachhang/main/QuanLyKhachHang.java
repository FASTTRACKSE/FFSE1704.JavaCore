package fasttrack.quanlykhachhang.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fasttrack.quanlycanbo.util.myException;
import fasttrack.quanlykhachhang.DAO.KhachHangDAO;
import fasttrack.quanlykhachhang.entity.KhachHang;

public class QuanLyKhachHang {
	static Scanner myInput = new Scanner(System.in);
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static String ID;
	static String maKH;
	static String tenKH;
	static String diaCHi;
	static String ngaySinh;
	static String gioiTinh;
	static String soDT;
	static int n;

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");

		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\n    HỆ THỐNG QUẢN LÝ CÁN BỘ");
				System.out.println("+--------------------------------+");
				System.out.println("| 1. Add khách hàng              |");
				System.out.println("| 2. Edit khách hàng             |");
				System.out.println("| 3. Read thông tin khách hàng   |");
				System.out.println("| 4. Delete khách hàng           |");
				System.out.println("| 5. Kết thúc                    |");
				System.out.println("+--------------------------------+");
				System.out.print("Mời bạn chọn chức năng: ");
				myOption = myInput.nextInt();

				if (myOption == 1) {
					addKH();
				} else if (myOption == 2) {
					editKH();
				} else if (myOption == 3) {
					readKH();
				} else if (myOption == 4) {
					deleteKH();
				} else if (myOption == 5) {
					ketThuc();
				} else {
					throw new myException(7);
				}
			} catch (myException e) {
				System.out.println(e);
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}

	// Thêm Một Khách Hàng

	public static void addKH() {


		System.out.println("NHẬP THÔNG TIN KHÁCH HÀNG");
		System.out.println("-------------------------------");

		System.out.print("Mời bạn nhập số lượng khách hàng :");
		n = myInput.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Nhập thông tin khách hàng thứ :" + (i + 1));
			System.out.println("----------------------------------------");

			
			boolean inputOK;

			// nhập mã khách hàng

			do {

				try {
					myInput.nextLine();
					inputOK = true;
					System.out.print("Nhập mã khách hàng: ");
					maKH = myInput.nextLine();
					if (maKH.length() < 1 || maKH.length() > 30) {

						throw new myException(1);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập họ tên khách hàng
			do {

				try {
					inputOK = true;
					System.out.print("Nhập họ tên Khách Hàng: ");
					tenKH = myInput.nextLine();
					if (tenKH.length() < 1 || tenKH.length() > 30) {

						throw new myException(1);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập điạ chỉ khách hàng
			do {

				try {
					inputOK = true;
					System.out.print("Nhập địa chỉ Khách Hàng: ");
					diaCHi = myInput.nextLine();
					if (diaCHi.length() < 1 || diaCHi.length() > 30) {

						throw new myException(1);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập ngày sinh của khách hàng
			do {
				try {

					System.out.print("Nhập ngày sinh của khách hàng: ");
					ngaySinh = myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("ngày sinh là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			} while (!inputOK);

			// nhập giới tính khách hàng
			do {

				try {
					inputOK = true;
					System.out.print("Nhập giới tính Khách Hàng: ");
					gioiTinh = myInput.nextLine();
					if (gioiTinh.length() < 1 || gioiTinh.length() > 30) {

						throw new myException(1);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			// nhập số điện thoại của khách hàng

			do {
				try {

					System.out.print("Nhập số điện thoại: ");
					soDT = myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("số điện thoại là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			} while (!inputOK);

		}

		khachHangDAO.add(new KhachHang( maKH, tenKH, diaCHi, ngaySinh, gioiTinh, soDT));

	}

	public static void editKH() {
		
		khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");
		int n;
		System.out.println("Nhập ID của khách hàng bạn cần edit : ");
		n = myInput.nextInt();
		try {
			if (n > 0) {
				System.out.println("Bạn đã chọn Id :" + n);
			} else {
				throw new myException(7);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		boolean inputOK;

		// nhập mã khách hàng

		do {

			try {
				myInput.nextLine();
				inputOK = true;
				System.out.print("Nhập mã khách hàng: ");
				maKH = myInput.nextLine();
				if (maKH.length() < 1 || maKH.length() > 30) {

					throw new myException(1);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập họ tên khách hàng
		do {

			try {
				inputOK = true;
				System.out.print("Nhập họ tên Khách Hàng: ");
				tenKH = myInput.nextLine();
				if (tenKH.length() < 1 || tenKH.length() > 30) {

					throw new myException(1);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập điạ chỉ khách hàng
		do {

			try {
				inputOK = true;
				System.out.print("Nhập địa chỉ Khách Hàng: ");
				diaCHi = myInput.nextLine();
				if (diaCHi.length() < 1 || diaCHi.length() > 30) {

					throw new myException(1);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập ngày sinh của khách hàng
		do {
			try {

				System.out.print("Nhập ngày sinh của khách hàng: ");
				ngaySinh = myInput.nextLine();
				inputOK = true;

			} catch (InputMismatchException e) {

				System.err.println("ngày sinh là số thực");
				myInput.nextLine();
				inputOK = false;

			}
		} while (!inputOK);

		// nhập giới tính khách hàng
		do {

			try {
				inputOK = true;
				System.out.print("Nhập giới tính Khách Hàng: ");
				gioiTinh = myInput.nextLine();
				if (gioiTinh.length() < 1 || gioiTinh.length() > 30) {

					throw new myException(6);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		// nhập số điện thoại của khách hàng

		do {
			try {

				System.out.print("Nhập số điện thoại: ");
				soDT = myInput.nextLine();
				inputOK = true;

			} catch (InputMismatchException e) {

				System.err.println("số điện thoại là số thực");
				myInput.nextLine();
				inputOK = false;

			}
		} while (!inputOK);

		
		KhachHang kh = new KhachHang(n,maKH, tenKH, diaCHi, ngaySinh, gioiTinh, soDT);
		
		khachHangDAO.edit(kh);
		
		
	}

	public static void readKH() {
		khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");
		int n;
		System.out.println("Nhập ID của khách hàng bạn cần xem : ");
		n = myInput.nextInt();
		try {
			if (n > 0) {
				System.out.println("Bạn đã chọn Id :" + n);
			} else {
				throw new myException(7);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		KhachHang dsKH = khachHangDAO.read(n);
		System.out.printf("%5s %10s %15s %20s %20s %15s %15s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();
		System.out.printf("%5s %10s %15s %20s %20s %15s %15s ", 
				dsKH.getID(),
				dsKH.getMaKH(),
				dsKH.getTenKH(),
				dsKH.getDiaCHi(),
				dsKH.getNgaySinh(),
				dsKH.getGioiTinh(),
				dsKH.getSoDT());
	}


	public static void deleteKH() {
		khachHangDAO.getConnect("localhost", "qlkhjava", "qlkhjava", "qlkhjava123");
		int n;
		System.out.println("Nhập ID của khách hàng bạn cần xóa : ");
		n = myInput.nextInt();
		try {
			if (n > 0) {
				System.out.println("Bạn đã chọn Id :" + n);
			} else {
				throw new myException(7);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		khachHangDAO.delete(n);
	}

	public static void backToMainMenu() {

		myInput.nextLine();
		System.out.println("\n Ấn Enter để về menu chính");
		myInput.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

}