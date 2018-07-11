package ftse.qlkh.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import ftse.qlkh.dao.KhachHangDao;
import ftse.qlkh.entity.KhachHang;
import ftse.qlkh.entity.until;

public class QLKH {
	static int i , N , SoDT , id;
	static int choose;
	static boolean inputOK;
	static Scanner myInput = new Scanner(System.in);
	static KhachHangDao khachHangDAO = new KhachHangDao();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static String MaKH, TenKH, DiaChi, GioiTinh, NgaySinh;

	public static void main(String[] args) {

		khachHangDAO.getConnect("localhost", "quanlysinhvien_ffse1704007", "nghia111", "123456");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		dsKH = khachHangDAO.getDSKhachHang();
		while (true) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+-------------------------------------------+");
				System.out.println("|1.Thêm thông tin cán bộ               |");
				System.out.println("|2.Sửa         |");
				System.out.println("|3.Hiển thị                                |");
				System.out.println("|4.Sửa                                 |");
				System.out.println("|5.Out                              |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				int N = myInput.nextInt();
				if (N == 1) {
					add();
				} else if (N == 2) {
					edit();
				
				} else if (N == 3) {
					show();
				} else if (N == 4) {
					delete();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {

				System.out.println("Bạn chỉ được nhập từ 1 tới 5");
			} finally {
				//
				// Back();
				//
				// }
			}
		}
	
	
		
		
		
		
	}
	public static void show() {
		dsKH = KhachHangDao.getDSKhachHang();
		System.out.printf("%2s %10s %12s %20s %17s %12s %9s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();

		for (KhachHang o : dsKH) {
			System.out.println(o.getID() + "\t " + o.getMaKH() + "\t  " + o.getTenKH() + "\t" + o.getDiaChi() + "\t"
					+ o.getNgaySinh() + "\t" + o.getGioiTinh() + "\t   " + o.getSoDT());
		}
		
	}
	public static void add() {
		System.out.println("NHẬP THÔNG TIN KHÁCH HÀNG");
		System.out.println("-------------------------------");
		System.out.print("Nhập số lượng khách hàng :");
		int N = myInput.nextInt();
		for (i = 0; i <N ; i++) {
			System.out.println("Nhập thông tin khách hàng thứ :" + (i + 1));
			System.out.println("----------------------------------------");

			// nhập id khách hàng

			do {
				try {

					System.out.print("Nhập id khách hàng: ");
					id = myInput.nextInt();
					myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("id phải là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			} while (!inputOK);
			do {

				try {
					inputOK = true;
					System.out.print("Nhập mã khách hàng: ");
					MaKH = myInput.nextLine();
					if (MaKH.length() < 1 || MaKH.length() > 30) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			do {

				try {
					inputOK = true;
					System.out.print("Nhập họ tên Khách Hàng: ");
					TenKH = myInput.nextLine();
					if (TenKH.length() < 1 || TenKH.length() > 30) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			do {

				try {
					inputOK = true;
					System.out.print("Nhập địa chỉ Khách Hàng: ");
					DiaChi = myInput.nextLine();
					if (DiaChi.length() < 1 || DiaChi.length() > 50) {

						throw new until(1);
					}
				} catch (until e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			do {
				try {

					System.out.print("Nhập ngày sinh của khách hàng( năm-tháng-ngày): ");
					NgaySinh = myInput.nextLine();
					inputOK = true;

				} catch (InputMismatchException e) {

					System.err.println("ngày sinh là số thực");
					myInput.nextLine();
					inputOK = false;

				}
			} while (!inputOK);
			do {
				System.out.print("Mời bạn chọn giới tính (1 - Nam, 2 - Nữ): ");
				choose = myInput.nextInt();
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
			} while (!inputOK);
		}
		khachHangDAO.add(new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));
	}
	public static void edit() {
		System.out.print("Mời bạn nhập (Id) khách hàng mà bạn muốn sửa:");
		id = myInput.nextInt();
		KhachHang khachHang = khachHangDAO.read(id);
		System.out.printf("%2s %10s %12s %20s %17s %12s %9s ", "Id", "MaKH", "TenKH", "DiaChi", "NgaySinh", "GioiTinh",
				"SoDT");
		System.out.println();
		System.out.println(khachHang.getID() + "\t " + khachHang.getMaKH() + "\t  " + khachHang.getTenKH() + "\t"
				+ khachHang.getDiaChi() + "\t" + khachHang.getNgaySinh() + "\t" + khachHang.getGioiTinh() + "\t   "
				+ khachHang.getSoDT());
		System.out.println("----------------------------------------");
		System.out.println("Mời bạn nhập thông tin mới cửa khách hàng !");
		do {

			try {
				inputOK = true;
				System.out.print("Nhập mã khách hàng: ");
				MaKH = myInput.nextLine();
				if (MaKH.length() < 1 || MaKH.length() > 30) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		do {

			try {
				inputOK = true;
				System.out.print("Nhập họ tên Khách Hàng: ");
				TenKH = myInput.nextLine();
				if (TenKH.length() < 1 || TenKH.length() > 30) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		do {

			try {
				inputOK = true;
				System.out.print("Nhập địa chỉ Khách Hàng: ");
				DiaChi = myInput.nextLine();
				if (DiaChi.length() < 1 || DiaChi.length() > 50) {

					throw new until(1);
				}
			} catch (until e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		do {
			try {

				System.out.print("Nhập ngày sinh của khách hàng( năm-tháng-ngày): ");
				NgaySinh = myInput.nextLine();
				inputOK = true;

			} catch (InputMismatchException e) {

				System.err.println("ngày sinh là số thực");
				myInput.nextLine();
				inputOK = false;

			}
		} while (!inputOK);
		do {
			System.out.print("Mời bạn chọn giới tính (1 - Nam, 2 - Nữ): ");
			choose = myInput.nextInt();
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
		} while (!inputOK);
	

	KhachHang kh = (new KhachHang(id, MaKH, TenKH, DiaChi, NgaySinh, GioiTinh, SoDT));
	khachHangDAO.edit(kh);
}
	
public static void delete() {
	System.out.print("Bạn muốn xóa id nào: ");
	int id = myInput.nextInt();
	khachHangDAO.delete(id);
	
	}
}