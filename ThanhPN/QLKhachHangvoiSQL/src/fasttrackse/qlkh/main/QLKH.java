/**
 * 
 */
package fasttrackse.qlkh.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fasttrackse.qlkh.dao.KhachHangDAO;
import fasttrackse.qlkh.entity.KhachHang;

import fasttrackse.qlkh.util.*;

public class QLKH {
	static int n, id, i, SoDT;
	static boolean inputOK;
	static int choose;
	static Scanner myInput = new Scanner(System.in);
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static String MaKH, TenKH, DiaChi, GioiTinh, NgaySinh;

	public static void main(String[] args) {
		int myOption = 0;
		while (myOption != 6) {
			try {
				System.out.println("\nQuản Lý Khách Hàng với SQL");
				System.out.println("---------------------------------------");
				System.out.println("1. in danh sách khách hàng     ");
				System.out.println("2. add thông tin khách hàng     ");
				System.out.println("3. read thông tin khách hàng  ");
				System.out.println("4. update thông tin khách hàng ");
				System.out.println("5. delete thông tin khách hàng ");
				System.out.println("6. Kết Thúc");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {

					select();
				}
				if (myOption == 2) {

					add();
				} else if (myOption == 3) {

					read();
				} else if (myOption == 4) {

					update();
				} else if (myOption == 5) {
					delete();
				} else if (myOption == 6) {
					KetThuc();

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

	private static void select() {

	}

	private static void KetThuc() {
		System.out.println("Kết thúc chương trình, cảm ơn bạn đã sử dụng!!!");
	}

	private static void delete() {
		khachHangDAO.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		System.out.print("Mời bạn nhập ID bạn muốn delete: ");
		id = myInput.nextInt();
		khachHangDAO.delete(id);
	}

	private static void update() {
		khachHangDAO.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		System.out.println("Mời bạn nhập thông tin mới cửa khách hàng !");
		myInput.nextLine();
		System.out.print("Mời bạn nhập ID bạn muốn edit: "); 
		id = myInput.nextInt();
		myInput.nextLine();
		boolean inputOK;


			do {
				try {

					System.out.println("Nhập mã của Khách Hàng");

					MaKH = myInput.nextLine();
					inputOK = true;

					if (MaKH.length() < 1 || MaKH.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.println("Nhập tên của Khách Hàng");

					TenKH = myInput.nextLine();
					inputOK = true;

					if (TenKH.length() < 1 || TenKH.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.println("Nhập địa chỉ của Khách Hàng");

					DiaChi = myInput.nextLine();
					inputOK = true;

					if (DiaChi.length() < 1 || DiaChi.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.print("Nhập ngày sinh của khách hàng(YY-MM-DD): ");
					NgaySinh = myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("ngày sinh là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			}

			while (!inputOK);
			do {
				try {

					System.out.println("Nhập giới tính của Khách Hàng");

					GioiTinh = myInput.nextLine();
					inputOK = true;

					if (GioiTinh.length() < 1 || GioiTinh.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.print("Nhập số điện thoại: ");
					SoDT = myInput.nextInt();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("số điện thoại là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			}

			while (!inputOK);

			KhachHang op = (new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));
			khachHangDAO.edit(op);
		}
		

	

	private static void read() {
		khachHangDAO.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		System.out.print("Mời bạn nhập ID bạn muốn xem:");
		id = myInput.nextInt();
		khachHangDAO.read(id);
		KhachHang khachHang = khachHangDAO.read(id);

		System.out.println();
		System.out.println(khachHang.getID() + "\t " + khachHang.getMaKH() + "\t  " + khachHang.getTenKH() + "\t"
				+ khachHang.getDiaChi() + "\t" + khachHang.getNgaySinh() + "\t" + khachHang.getGioiTinh() + "\t   "
				+ khachHang.getSoDT() + "\t");

	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}

	public static void add() {
		Scanner myInput = new Scanner(System.in);
		khachHangDAO.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

		System.out.println(">> MỜI BẠN NHẬP THÔNG TIN KHÁCH HÀNG <<");
		boolean inputOK;
		myInput.nextLine();
		System.out.println(".Bạn đang nhập thông tin khách hàng");
		myInput.nextLine();
		System.out.println("Nhập số lượng Khách Hàng");
		int X = myInput.nextInt();
		for (int i = 0; i < X; i++) {
			myInput.nextLine();

			System.out.println("Nhập Khách Hàng thứ: " + (i + 1) + "\n");

			do {
				try {

					System.out.println("Nhập mã của Khách Hàng");

					MaKH = myInput.nextLine();
					inputOK = true;

					if (MaKH.length() < 1 || MaKH.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.println("Nhập tên của Khách Hàng");

					TenKH = myInput.nextLine();
					inputOK = true;

					if (TenKH.length() < 1 || TenKH.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.println("Nhập địa chỉ của Khách Hàng");

					DiaChi = myInput.nextLine();
					inputOK = true;

					if (DiaChi.length() < 1 || DiaChi.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.print("Nhập ngày sinh của khách hàng(YY-MM-DD): ");
					NgaySinh = myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("ngày sinh là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			}

			while (!inputOK);
			do {
				try {

					System.out.println("Nhập giới tính của Khách Hàng");

					GioiTinh = myInput.nextLine();
					inputOK = true;

					if (GioiTinh.length() < 1 || GioiTinh.length() > 40) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.out.println(e);
					inputOK = false;
				}
			}

			while (!inputOK);

			do {
				try {

					System.out.print("Nhập số điện thoại: ");
					SoDT = myInput.nextInt();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("số điện thoại là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			}

			while (!inputOK);

			KhachHangDAO.add(new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));
		}

	}
}

//
//
// dsKH = khachHangDAO.getDSKhachHang();
//
// for (KhachHang x : dsKH) {
// System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
//
// }
// KhachHang kh = new KhachHang();
// khachHangDAO.add(kh);

// KhachHang kh1 = new KhachHang("KH005", "Nguyen Thi B1", "Da Nang",
// "2000-01-01", "Nu", "0909");
// khachHangDAO.add(kh1);
//
// KhachHang kh2 = new KhachHang("KH006", "Nguyen Thi B2", "Da Nang",
// "2000-01-01", "Nu", "0909");
// khachHangDAO.add(kh2);
//
// khachHangDAO.add(new KhachHang("KH007", "Nguyễn Thị Hương", "Đà Nẵng",
// "2000-01-01", "Nữ", "0909"));
