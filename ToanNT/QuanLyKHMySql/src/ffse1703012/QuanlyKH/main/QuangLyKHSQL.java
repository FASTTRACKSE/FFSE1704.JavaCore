package ffse1703012.QuanlyKH.main;

import java.util.ArrayList;
import java.util.Scanner;

import ffse1703012.QuanlyKH.enity.KhachHang;
import ffse1703012.QuanlyKH.ulti.CbException;
import ffse1703012.QuanlyKH.ulti.KhachHangConn;

public class QuangLyKHSQL {
	static KhachHangConn KetNoi = new KhachHangConn();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		KetNoi.getConnect("localhost", "ffse1703012", "toan", "123");
		if (KetNoi.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("|1.Thêm Thông Tin khách hàng                        |");
			System.out.println("|2.Xuất thông tin Khách hàng                        |");
			System.out.println("|3.Sửa thông tin khách hàng                         |");
			System.out.println("|4.Xóa khách hàng                                   |");
			System.out.println("|5.Thoát chương trình                               |");
			System.out.println("+---------------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			int option = sc.nextInt();
			if (option == 1) {
				nhapThongTinKH();
			} else if (option == 2) {
				xuatThongTin();
			} else if (option == 3) {
				suaThongTin();
			} else if (option == 4) {
				xoaKH();
			} else if (option == 5) {
				ketThuc();
			}
		}
	}

	public static void nhapThongTinKH() {
		int choose;
		boolean inputOK;
		int maKH = 0;
		String tenKH = "";
		String ngaySinh = "";
		String diaChi = "";
		String gioiTinh = "";
		int soDT = 0;
		System.out.println("Nhập thông tin Khách Hàng");
		System.out.println("+------------------------------+");
		System.out.print("Nhập Số Lượng Khách Hàng: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {

			System.out.print("Nhập Thông Tin khách hàng thứ " + (i + 1) + "\n");
			sc.nextLine();
			do {
				try {
					inputOK = true;
					System.out.print("Nhập mã khách hàng: ");
					maKH = sc.nextInt();

				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			do {
				try {
					inputOK = true;
					System.out.print("Nhập tên khách hàng: ");
					tenKH = sc.nextLine();

					if (tenKH.length() < 1 || tenKH.length() > 40) {
						// bẵn lỗi
						throw new CbException(1);
					}
				} catch (Exception e) {
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
					diaChi = sc.nextLine();

					if (diaChi.length() < 1) {
						// bẵn lỗi
						throw new CbException(5);
					}
				} catch (CbException e) {
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
					ngaySinh = sc.nextLine();

					if (ngaySinh.length() < 1) {
						// bẵn lỗi
						throw new CbException(1);
					}
				} catch (CbException e) {
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
					choose = sc.nextInt();

					if (choose == 1) {
						gioiTinh = "Nam";
						inputOK = true;
					} else {
						if (choose == 2) {
							gioiTinh = "Nữ";
							inputOK = true;
						}
					}
				} catch (Exception e) {
					System.err.println("Nhập sai!!!");
					sc.next();
					inputOK = false;
				}
			} while (!inputOK);
			/**
			 * 
			 *
			 */
			do {
				try {
					sc.nextLine();
					inputOK = true;
					System.out.print("Nhập số điện thoại khách hàng: ");
					soDT = sc.nextInt();

				} catch (Exception e) {
					System.err.println(e);
					sc.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			System.out.println("------------------------------------------------------------------");

			KetNoi.add(new KhachHang(maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT));
		}
	}

	public static void xuatThongTin() {
		System.out.print("ID khách hàng muốn xem thông tin: ");
		int maKH = sc.nextInt();
		dsKH = KetNoi.getDSKhachHang(maKH);
		for (KhachHang x : dsKH) {
			System.out.println(x.getMaKH() + "-" + x.getHoTen() + "-" + x.getDiaChi() + "-" + x.getGioiTinh() + "-"
					+ x.getNgaySinh() + "-" + x.getSDT());
		}
	}

	public static void suaThongTin() {
		int choose;
		boolean inputOK;
		int maKH = 0;
		String tenKH = "";
		String ngaySinh = "";
		String diaChi = "";
		String gioiTinh = "";
		int soDT = 0;
		System.out.print("ID khách hàng muốn sửa thông tin: ");
		maKH = sc.nextInt();
		dsKH = KetNoi.getDSKhachHang(maKH);
		for (KhachHang x : dsKH) {
			System.out.println(x.getMaKH() + "-" + x.getHoTen() + "-" + x.getDiaChi() + "-" + x.getGioiTinh() + "-"
					+ x.getNgaySinh() + "-" + x.getSDT());
		}

		sc.nextLine();
		System.out.println("Hãy nhập giá trị mới của khách hàng!");
		do {
			try {
				inputOK = true;
				System.out.print("Nhập mã khách hàng: ");
				maKH = sc.nextInt();

			} catch (Exception e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);

		do {
			try {
				inputOK = true;
				System.out.print("Nhập tên khách hàng: ");
				tenKH = sc.nextLine();

				if (tenKH.length() < 1 || tenKH.length() > 40) {
					// bẵn lỗi
					throw new CbException(1);
				}
			} catch (Exception e) {
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
				diaChi = sc.nextLine();

				if (diaChi.length() < 1) {
					// bẵn lỗi
					throw new CbException(5);
				}
			} catch (CbException e) {
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
				ngaySinh = sc.nextLine();

				if (ngaySinh.length() < 1) {
					// bẵn lỗi
					throw new CbException(1);
				}
			} catch (CbException e) {
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
				choose = sc.nextInt();

				if (choose == 1) {
					gioiTinh = "Nam";
					inputOK = true;
				} else {
					if (choose == 2) {
						gioiTinh = "Nữ";
						inputOK = true;
					}
				}
			} catch (Exception e) {
				System.err.println("Nhập sai!!!");
				sc.next();
				inputOK = false;
			}
		} while (!inputOK);
		/**
		 * 
		 *
		 */
		do {
			try {
				sc.nextLine();
				inputOK = true;
				System.out.print("Nhập số điện thoại khách hàng: ");
				soDT = sc.nextInt();

			} catch (Exception e) {
				System.err.println(e);
				sc.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		System.out.println("------------------------------------------------------------------");
		
		KhachHang kh = new KhachHang(maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT);
		KetNoi.edit(kh);
	}

	public static void xoaKH() {
		System.out.print("ID khách hàng cần xóa là:");
		int maKH = sc.nextInt();
		KetNoi.delete(maKH);
	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}

}

// }
//
// KhachHang kh = new KhachHang();
// KetNoi.add(kh);
// KetNoi.delete(9);
