/************************
 *Prog: QUẢN LÝ KHÁCH HÀNG
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 22/06/2018
 **********************/
package ffse.qlkh.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import ffse.qlkh.dao.KhachHangDAO;
import ffse.qlkh.entity.KhachHang;
import ffse.qlkh.util.KHException;

public class QLKH {

	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner nhap = new Scanner(System.in);

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "ffse1704009_mysql", "ffse1704009_mysql", "123456");
		menu();
		// if (khachHangDAO.getConn() != null) {
		// System.err.println("Kết nối MYSQL thành công");
		// } else {
		// System.err.println("Kết nối MYSQL thất bại");
		// }

	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 6) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+----------------------------------------------------+");
				System.out.println("|1.Thêm thông tin Khách hàng                         |");
				System.out.println("|2.Xem Thông Tin khách hàng                          |");
				System.out.println("|3.Sửa thông tin khách hàng                          |");
				System.out.println("|4.Xóa Thông Tin Khách Hàng                          |");
				System.out.println("|5.Xuất Danh Sách Khách Hàng                         |");
				System.out.println("|6.Kết Thúc                                          |");
				System.out.println("+----------------------------------------------------+");

				myOption = nhap.nextInt();
				if (myOption == 1) {

					themThongTin();
				} else if (myOption == 2) {

					xemThongTin();
				} else if (myOption == 3) {

					suaThongTin();

				} else if (myOption == 4) {
					xoaThongTin();

				} else if (myOption == 5) {
					hienThiThongTin();

				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 6, nhập lại!");
			} finally {
				if (myOption != 6) {
					backToMainMenu();
				}
			}
		}
	}

	private static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();

	}

	public static void themThongTin() {
		int choose;
		boolean inputOK;
		String maKH = "";
		String tenKH = "";
		String ngaySinh = "";
		String diaChi = "";
		String gioiTinh = "";
		String soDT = "";
		System.out.println("Nhập thông tin Khách Hàng");
		System.out.println("+------------------------------+");
		System.out.print("Nhập Số Lượng Khách Hàng: ");
		int N = nhap.nextInt();
		for (int i = 0; i < N; i++) {

			System.out.print("Nhập Thông Tin khách hàng thứ " + (i + 1) + "\n");
			nhap.nextLine();

			do {
				try {
					inputOK = true;
					System.out.print("Nhập mã khách hàng: ");
					maKH = nhap.nextLine();

					if (maKH.length() < 1 || maKH.length() > 40) {
						// bẵn lỗi
						throw new KHException(2);
					}
				} catch (KHException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			/**
			 * 
			 *
			 */

			do {
				try {
					inputOK = true;
					System.out.print("Nhập tên khách hàng: ");
					tenKH = nhap.nextLine();

					if (tenKH.length() < 1 || tenKH.length() > 40) {
						// bẵn lỗi
						throw new KHException(1);
					}
				} catch (KHException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			/**
			 *
			 *
			 */
			do {
				try {
					inputOK = true;
					System.out.print("Nhập địa chỉ khách hàng: ");
					diaChi = nhap.nextLine();

					if (diaChi.length() < 1) {
						// bẵn lỗi
						throw new KHException(5);
					}
				} catch (KHException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			/**
			 *
			 *
			 */
			do {
				try {
					inputOK = true;
					System.out.print("Nhập ngày sinh khách hàng: (năm-tháng-ngày)");
					ngaySinh = nhap.nextLine();

					if (ngaySinh.length() < 1) {
						// bẵn lỗi
						throw new KHException(1);
					}
				} catch (KHException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			/**
			 * 
			 *
			 */

			do {
				try {

					System.out.print("Nhập giới tính khách hàng (1 - Nam, 2 - Nữ): ");
					choose = nhap.nextInt();

					if (choose == 1) {
						gioiTinh = "Nam";
						inputOK = true;
					} else {
						if (choose == 2) {
							gioiTinh = "Nữ";
							inputOK = true;
						}
					}
				} catch (InputMismatchException e) {
					System.err.println("Nhập sai!!!");
					nhap.next();
					inputOK = false;
				}
			} while (!inputOK);
			/**
			 * 
			 *
			 */
			do {
				try {
					nhap.nextLine();
					inputOK = true;
					System.out.print("Nhập số điện thoại khách hàng: ");
					soDT = nhap.nextLine();

					if (soDT.length() < 1 || soDT.length() > 11) {
						// bẵn lỗi
						throw new KHException(4);
					}
				} catch (KHException e) {
					System.err.println(e);
					nhap.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			System.out.println("------------------------------------------------------------------");

			khachHangDAO.add(new KhachHang((N + 1), maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT));
		}
	}

	public static void xemThongTin() {
		System.out.print("ID khách hàng muốn xem thông tin: ");
		int maKH = nhap.nextInt();
		KhachHang khachHangThanYeu = khachHangDAO.read(maKH);
		System.out
				.println(khachHangThanYeu.getID() + "-" + khachHangThanYeu.getMaKH() + "-" + khachHangThanYeu.getTenKH()
						+ "-" + khachHangThanYeu.getDiaChi() + "-" + khachHangThanYeu.getNgaySinh() + "-"
						+ khachHangThanYeu.getGioiTinh() + "-" + khachHangThanYeu.getSoDT());
	}

	public static void suaThongTin() {

		int choose;
		boolean inputOK;
		String maKH = "";
		String tenKH = "";
		String ngaySinh = "";
		String diaChi = "";
		String gioiTinh = "";
		String soDT = "";

		System.out.print("ID khách hàng muốn sửa thông tin: ");
		int id = nhap.nextInt();
		KhachHang khachHang = khachHangDAO.read(id);

		System.out.println(
				khachHang.getID() + "-" + khachHang.getMaKH() + "-" + khachHang.getTenKH() + "-" + khachHang.getDiaChi()
						+ "-" + khachHang.getNgaySinh() + "-" + khachHang.getGioiTinh() + "-" + khachHang.getSoDT());

		nhap.nextLine();
		System.out.println("Hãy nhập giá trị mới của khách hàng!");
		do {
			try {
				inputOK = true;
				System.out.print("Nhập mã khách hàng: ");
				maKH = nhap.nextLine();

				if (maKH.length() < 1 || maKH.length() > 40) {
					// bẵn lỗi
					throw new KHException(2);
				}
			} catch (KHException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		/**
		 * 
		 *
		 */

		do {
			try {
				inputOK = true;
				System.out.print("Nhập tên khách hàng: ");
				tenKH = nhap.nextLine();

				if (tenKH.length() < 1 || tenKH.length() > 40) {
					// bẵn lỗi
					throw new KHException(1);
				}
			} catch (KHException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		/**
		 *
		 *
		 */
		do {
			try {
				inputOK = true;
				System.out.print("Nhập địa chỉ khách hàng: ");
				diaChi = nhap.nextLine();

				if (diaChi.length() < 1) {
					// bẵn lỗi
					throw new KHException(5);
				}
			} catch (KHException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		/**
		 *
		 *
		 */
		do {
			try {
				inputOK = true;
				System.out.print("Nhập ngày sinh khách hàng: (năm-tháng-ngày)");
				ngaySinh = nhap.nextLine();

				if (ngaySinh.length() < 1) {
					// bẵn lỗi
					throw new KHException(1);
				}
			} catch (KHException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		/**
		 * 
		 *
		 */

		do {
			try {

				System.out.print("Nhập giới tính khách hàng (1 - Nam, 2 - Nữ): ");
				choose = nhap.nextInt();

				if (choose == 1) {
					gioiTinh = "Nam";
					inputOK = true;
				} else {
					if (choose == 2) {
						gioiTinh = "Nữ";
						inputOK = true;
					}
				}
			} catch (InputMismatchException e) {
				System.err.println("Nhập sai!!!");
				nhap.next();
				inputOK = false;
			}
		} while (!inputOK);
		/**
		 * 
		 *
		 */
		do {
			try {
				nhap.nextLine();
				inputOK = true;
				System.out.print("Nhập số điện thoại khách hàng: ");
				soDT = nhap.nextLine();

				if (soDT.length() < 1 || soDT.length() > 11) {
					// bẵn lỗi
					throw new KHException(4);
				}
			} catch (KHException e) {
				System.err.println(e);
				nhap.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		System.out.println("------------------------------------------------------------------");
		KhachHang kh = new KhachHang(id, maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT);// đưa mọi thông tin mới vào 1
																						// biến
		khachHangDAO.update(kh);// truyền biến đó vào hàm update

	}

	public static void xoaThongTin() {
		System.out.print("ID khách hàng cần xóa là:");
		int maKHCanXoa = nhap.nextInt();
		khachHangDAO.delete(maKHCanXoa);
	}

	public static void hienThiThongTin() {

		System.out.println(
				"|-----------------------------------------------------------------------------DANH SÁCH KHÁCH HÀNG-----------------------------------------------------------------------------------|");
		System.out.printf("\n" + "%-10s %-25s %-25s %-25s  %-15s  %-15s %-15s", "STT", "Họ và tên", "Mã khách hàng",
				"Địa Chỉ", "Ngày Sinh", "Giới Tính", "Số Điện Thoại\n");
		System.out.println("");
		System.out.println(
				"-----------------------------------------------------------------------------*******************-----------------------------------------------------------------------------------");

		dsKH = khachHangDAO.getDSKhachHang();

		for (KhachHang x : dsKH) {
			

			System.out.printf("\n" + "%-10s %-25s %-25s %-25s  %-15s  %-15s %-15s ", x.getID(), x.getTenKH(),"KH"+
					x.getMaKH(), x.getDiaChi(), x.getNgaySinh(), x.getGioiTinh(), x.getSoDT() + "\n");
			System.out.println("");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		}

	}
}
