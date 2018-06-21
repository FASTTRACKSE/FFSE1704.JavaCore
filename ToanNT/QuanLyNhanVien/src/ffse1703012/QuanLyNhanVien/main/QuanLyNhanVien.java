package ffse1703012.QuanLyNhanVien.main;

import java.util.ArrayList;
import java.util.Scanner;

import ffse1703012.QuanLyNhanVien.entity.*;

public class QuanLyNhanVien {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	static long tongLuong = 0;
	static long luong;

	public static void main(String[] args) {
		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("|1.Nhập Thông Cán Bộ                                |");
			System.out.println("|2.Xuất thông tin Giảng Viên, Cán bộ hành chính     |");
			System.out.println("|3.Tổng số lương phải trả cho cán bộ                |");
			System.out.println("|4.Sắp xếp Cán bộ                                   |");
			System.out.println("|5.Thoát chương trình                               |");
			System.out.println("+---------------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			int option = sc.nextInt();
			if (option == 1) {
				NhapThongTinNv();
			} else if (option == 2) {
				XuatThongTin();
			} else if (option == 3) {
				TongSoLuong();
			} else if (option == 4) {
				SapXepNV();
			} else if (option == 5) {
				KetThuc();
			}
		}
	}

	public static void NhapThongTinNv() {
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng viên: ");
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Giảng viên thứ " + (i + 1) + "\n");
				sc.nextLine();
				System.out.print("Nhập Tên Giảng viên: ");
				String hoTen = sc.nextLine();
				System.out.print("Nhập hệ số lương: ");
				double heSoLuong = sc.nextInt();
				sc.nextLine();
				System.out.print("Nhập Khoa: ");
				String khoa = sc.nextLine();
				System.out.print("Nhập trình độ: 1.Cử nhân  2.Thạc sĩ  3.Tiến sĩ ");
				int j = sc.nextInt();
				int phuCap = 0;
				String trinhDo = null;
				if (j == 1) {
					trinhDo = "Trình độ: Cử nhân";
					System.out.print("Phụ cấp: 300.000 VNĐ \n");
					phuCap = 300000;
				} else if (j == 2) {
					trinhDo = "Trình độ: Thạc sĩ";

					System.out.print("Phụ cấp: 500.000 VNĐ \n");
					phuCap = 500000;
				} else if (j == 3) {
					trinhDo = "Trình độ: Tiến sĩ";

					System.out.print("Phụ cấp: 1.000.000 VNĐ \n");
					phuCap = 1000000;
				}
				sc.nextLine();
				System.out.print("Nhập Số tiết dạy: ");
				int soTietDay = sc.nextInt();
				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(hoTen, heSoLuong, phuCap, khoa, trinhDo, soTietDay));
			}

		} else if (n == 2) {
			System.out.println("Nhập thông tin cán bộ");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Cán bộ: ");
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Cán bộ thứ " + (i + 1) + "\n");
				sc.nextLine();
				System.out.print("Nhập Tên Cán bộ: ");
				String hoTen = sc.nextLine();
				System.out.print("Nhập hệ số lương: ");
				double heSoLuong = sc.nextInt();
				System.out.print("Nhập Phòng ban: ");
				String phongBan = sc.nextLine();
				System.out.print("Nhập chức vụ: 1.Trưởng phòng  2.Phó phòng  3.Nhân viên ");
				int j = sc.nextInt();
				String chucVu = null;
				int phuCap = 0;
				if (j == 1) {
					chucVu = "Chức vụ: Trưởng phòng";
					System.out.println("phụ cấp: 2.000.000 VNĐ \n");
					phuCap = 2000000;
				} else if (j == 2) {
					chucVu = "Chức vụ: Phó Phòng";

					System.out.println(" phụ cấp: 1.000.000 VNĐ \n");
					phuCap = 1000000;
				} else if (j == 3) {
					chucVu = "Chức vụ: Nhân viên";

					System.out.println(" phụ cấp: 500.000 VNĐ \n");
					phuCap = 500000;
				}
				System.out.print("Nhập Số tiết dạy: ");
				int soNgayCong = sc.nextInt();
				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(hoTen, heSoLuong, phuCap, chucVu, phongBan, soNgayCong));
			}
		}
	}

	public static void XuatThongTin() {
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		sc.nextLine();
		if (n == 1) {
			System.out.println("Mời bạn nhập khoa của giảng viên: ");
			String khoa = sc.nextLine();
			sc.nextLine();
			for (NhanVien x : dsNhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");
				if (((GiangVien) x).getKhoa().equals(khoa)) {
					System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(), ((GiangVien) x).getTrinhDo(),
							x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(), ((GiangVien) x).getSoTietDay(), ((GiangVien)x).tinhLuong());
				}
			}
		} else if (n == 2) {
			System.out.print("Mời bạn nhập phòng ban của cán bộ: ");
			String phongBan = sc.nextLine();
			for (NhanVien x : dsNhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				if(((NvHanhChinh)x).getPhongBan().equals(phongBan)) {
					System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(), ((NvHanhChinh)x).getPhongBan(), x.getHeSoLuong(), x.getPhuCap(), ((NvHanhChinh)x).getChucVu(), ((NvHanhChinh)x).getSoNgayCong());
				}
			}

		}

	}

	public static void TongSoLuong() {
		for (NhanVien x : dsNhanVien) {
			luong = x.tinhLuong();
			tongLuong = luong;
		}
		System.out.println("Tổng lương phải trả cho cán bộ = " + tongLuong);
	}

	public static void SapXepNV() {
		
	}

	public static void KetThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}
}
