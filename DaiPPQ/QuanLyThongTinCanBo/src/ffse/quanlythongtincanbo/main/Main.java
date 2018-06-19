/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ffse.quanlythongtincanbo.entity.*;
import ffse.quanlythongtincanbo.util.SVComparator;

public class Main {
	
	static int N;
	static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	static Scanner myInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+----------------------------------------------------+");
			System.out.println("|1.Nhập thông tin cán bộ                             |");
			System.out.println("|2.Xuất thông tin cán bộ                             |");
			System.out.println("|3.Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ  |");
			System.out.println("|4.Danh sách cán bộ toàn trường theo lương           |");
			System.out.println("|5.Kết Thúc                                          |");
			System.out.println("+----------------------------------------------------+");
			System.out.print("Mời Bạn Chọn Chức Năng: ");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinNV();
			} else if (N == 2) {
				xuatThongTin();
			} else if (N == 3) {
				tongLuong();
			} else if (N == 4) {
				sapXep();
			} else {
				System.exit(0);
			}
		}
	}
	public static void NhapThongTinNV() {
		
		Scanner n = new Scanner(System.in);
		int M = 0;
		for (;;) {
			System.out.println(">>     Nhân viên thuộc     <<");
			System.out.println("+---------------------------+");
			System.out.println("|1. Giảng viên              |");
			System.out.println("|2. Nhân viên hành chính    |");
			System.out.println("+---------------------------+");
			System.out.print("Mời Bạn Chọn: ");
			M = n.nextInt();
			if (M == 1 ||M == 2)
				break;
		}
		
		if (M == 1) {
			System.out.println("Nhập Rhông Tin Giảng Viên ");
			System.out.println("+------------------------------+");
			System.out.print("Nhập số lượng giảng viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập thông tin giảng viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập họ tên giảng viên: ");
				String ten = myInput.nextLine();

				System.out.print("Nhập Khoa: ");
				String khoa = myInput.nextLine();
				
				int TD = 0;
				for (;;) {
					System.out.println(">> Trình Độ Giảng Viên <<");
					System.out.println("+-----------------------+");
					System.out.println("|1. Cử nhân             |");
					System.out.println("|2. Thạc sỉ             |");
					System.out.println("|3. Tiến  sỉ            |");
					System.out.println("+-----------------------+");
					System.out.print("Mời Bạn Chọn: ");
					TD = n.nextInt();
					if (TD == 1 ||TD == 2 || TD == 3)
						break;
				}
				int phuCap = 0;
				String trinhDo = null;
				if(TD == 1) {
					trinhDo = "Cử nhân";
					phuCap = 300;
				} else if(TD == 2) {
					trinhDo = "Thạc sỉ";
					phuCap = 500;
				} else if (TD == 3) {
					trinhDo = "Tến sỉ";
					phuCap = 1000;
				}

				System.out.print("Số tiết dạy: ");
				int soTietDayTrongThang = myInput.nextInt();

				System.out.print("Hệ số lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(ten, khoa, trinhDo, phuCap, soTietDayTrongThang, heSoLuong));
			}
		} else {
			System.out.println("Nhập Thông Tin Nhân Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập số lượng nhân viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập thông tin nhân viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập họ tên nhân viên: ");
				String ten = myInput.nextLine();

				System.out.print("Nhân viên thuộc phòng: ");
				String phongBan = myInput.nextLine();
				
				int TD = 0;
				for (;;) {
					System.out.println(">>       Chức Vụ       <<");
					System.out.println("+-----------------------+");
					System.out.println("|1. Trưởng phòng        |");
					System.out.println("|2. Phó phòng           |");
					System.out.println("|3. Nhân viên           |");
					System.out.println("+-----------------------+");
					System.out.print("Mời Bạn Chọn: ");
					TD = n.nextInt();
					if (TD == 1 ||TD == 2 || TD == 3)
						break;
				}
				int phuCap = 0;
				String chucVu = null;
				if(TD == 1) {
					chucVu = "Trưởng phòng";
					phuCap = 2000;
				} else if(TD == 2) {
					chucVu = "Phó phòng";
					phuCap = 1000;
				} else if (TD == 3) {
					chucVu = "Nhân viên";
					phuCap = 500;
				}

				System.out.print("Số ngày công: ");
				int soNgayCong = myInput.nextInt();

				System.out.print("Hệ Số Lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new NhanVienHanhChinh(ten, phongBan, chucVu, phuCap, soNgayCong, heSoLuong));
			}
		
		}
	}
	
	public static void xuatThongTin() {

		Scanner n = new Scanner(System.in);
		int M = 0;
		for (;;) {
			System.out.println(">> Xuất Thông Tin Của Nhóm <<");
			System.out.println("+---------------------------+");
			System.out.println("|1. Giảng viên              |");
			System.out.println("|2. Nhân viên hành chính    |");
			System.out.println("+---------------------------+");
			System.out.print("Mời Bạn Chọn: ");
			M = n.nextInt();
			if (M == 1 ||M == 2)
				break;
		}
		
		if (M == 1) {
			String K = "";
			System.out.print("Bạn muốn thông tin giảng viên thuộc khoa: ");
			myInput.nextLine();
			K = myInput.nextLine();
			System.out.println("--------------------------------------------------");
			System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
					"Khoa", "Trình Độ", "Phụ Cấp", "Số Tiết Dạy", "Hệ số Lương", "Lương Được Nhận");
			System.out.println("\n -----------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < dsNhanVien.size(); i++) {
				if (K.equals(((GiangVien) dsNhanVien.get(i)).getKhoa())) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", (i+1),
							((GiangVien) dsNhanVien.get(i)).getTen(),
							((GiangVien) dsNhanVien.get(i)).getKhoa(),
							((GiangVien) dsNhanVien.get(i)).getTrinhDo(),
							((GiangVien) dsNhanVien.get(i)).getPhuCap(),
							((GiangVien) dsNhanVien.get(i)).getsoTietDayTrongThang(),
							((GiangVien) dsNhanVien.get(i)).getHeSoLuong(),
							((GiangVien) dsNhanVien.get(i)).tinhLuong()
							);
					System.out.println();
				}
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} else if (M == 2) {
			String P = "";
			System.out.print("Bạn muốn thông tin giảng viên thuộc phòng: ");
			myInput.nextLine();
			P = myInput.nextLine();
			System.out.println("--------------------------------------------------");
			System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
					"Phòng Ban", "Chức Vụ", "Phụ Cấp", "Số Ngày Công", "Hệ số Lương", "Lương Được Nhận");
			System.out.println("\n -----------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < dsNhanVien.size(); i++) {
				if (P.equals(((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan())) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", (i+1),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getTen(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getChucVu(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getPhuCap(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getSoNgayCong(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getHeSoLuong(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).tinhLuong()
							);
					System.out.println();
				}
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}
	}

	public static void tongLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsNhanVien.size(); i++) {
			tongtien += dsNhanVien.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}
	
	public static void sapXep() {
		int i = 0;
		Collections.sort(dsNhanVien, SVComparator.NhanVienLuongASComparator);

		System.out.println("-------------------------------------------------------------------DANH SÁCH CÁN BỘ-------------------------------------------------------------------------");
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
				"Khoa", "Phòng Ban", "Trình Độ", "Chức Vụ", "Số Tiết Dạy", "Số Ngày Công", "Hệ số Lương",
				"Lương Được Nhận\n");
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (NhanVien o : dsNhanVien) {

			if (o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
						((GiangVien) o).getTen(), ((GiangVien) o).getKhoa(), "x", ((GiangVien) o).getTrinhDo(),
						"x", ((GiangVien) o).getsoTietDayTrongThang(), "x", ((GiangVien) o).getHeSoLuong(),
						((GiangVien) o).tinhLuong() + "\n");
			} else {
				if (o instanceof NhanVienHanhChinh) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
							((NhanVienHanhChinh) o).getTen(), "x ", ((NhanVienHanhChinh) o).getPhongBan(), "x",
							((NhanVienHanhChinh) o).getChucVu(), "x", ((NhanVienHanhChinh) o).getSoNgayCong(),
							((NhanVienHanhChinh) o).getHeSoLuong(), ((NhanVienHanhChinh) o).tinhLuong() + "\n");
				}
			}
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}
}
