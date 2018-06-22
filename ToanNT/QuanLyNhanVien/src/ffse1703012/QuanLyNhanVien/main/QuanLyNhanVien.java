package ffse1703012.QuanLyNhanVien.main;

import java.util.ArrayList;
import java.util.Collections;

import ffse1703012.QuanLyNhanVien.entity.*;
import java.util.Scanner;

import ffse1703012.QuanLyNhanVien.comparator.*;

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
		System.out.println("    Nhập thông tin");
		System.out.println("    Mời chọn Loại cán bộ:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Cán bộ Giảng viên                     |");
		System.out.println("|2.Cán bộ Hành Chính                     |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			boolean inputOK;
			int N = 0;
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			do {
				try {
					inputOK = true;
					System.out.print("Nhập Số Lượng Giảng viên: ");
					N = sc.nextInt();
					if (N < 0) {
						throw new CbException(2);
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);

			String hoTen = "";
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Giảng viên thứ " + (i + 1) + "\n");
				sc.nextLine();

				do {
					try {
						inputOK = true;
						System.out.print("Nhập Tên Giảng viên: ");
						hoTen = sc.nextLine();
						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new CbException(1);
						}

					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					} finally {
					}
				} while (!inputOK);

				double heSoLuong = 0;
				do {
					try {
						inputOK = true;
						System.out.print("Nhập hệ số lương: ");
						heSoLuong = sc.nextDouble();
						if (heSoLuong < 0) {
							throw new CbException(4);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);
				sc.nextLine();
				String khoa = "";
				// sc.nextLine();
				do {
				try {
					inputOK = true;
					System.out.print("Nhập Khoa: ");
					khoa = sc.nextLine();
					if (khoa.length() == 0) {
						throw new CbException(6);
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}}while(!inputOK);
				int phuCap = 0;
				String trinhDo = null;
				int choose;
				do {
					System.out.print("Nhập trình độ: 1.Cử nhân  2.Thạc sĩ  3.Tiến sĩ ");
					try {
						inputOK= true;
						choose = sc.nextInt();
						if(choose > 3) {
							throw new CbException(3);
						}
					}catch(Exception e) {
						System.err.println(e);
						inputOK=false;
					}
					choose = sc.nextInt();
					switch (choose) {
					case 1:
						trinhDo = "Trình độ: Cử nhân";
						System.out.print("Phụ cấp: 300.000 VNĐ \n");
						phuCap = 300000;
						break;
					case 2:
						trinhDo = "Trình độ: Thạc sĩ";
						System.out.print("Phụ cấp: 500.000 VNĐ \n");
						phuCap = 500000;
						break;
					case 3:
						trinhDo = "Trình độ: Tiến sĩ";
						System.out.print("Phụ cấp: 1.000.000 VNĐ \n");
						phuCap = 1000000;
						break;
					}
				} while (choose < 1 || choose > 3);
				// if (j == 1) {
				// trinhDo = "Trình độ: Cử nhân";
				// System.out.print("Phụ cấp: 300.000 VNĐ \n");
				// phuCap = 300000;
				// } else if (j == 2) {
				// trinhDo = "Trình độ: Thạc sĩ";
				//
				// System.out.print("Phụ cấp: 500.000 VNĐ \n");
				// phuCap = 500000;
				// } else if (j == 3) {
				// trinhDo = "Trình độ: Tiến sĩ";
				// System.out.print("Phụ cấp: 1.000.000 VNĐ \n");
				// phuCap = 1000000;
				// }
				sc.nextLine();

				int soTietDay = 0;
				do {
					try {
						inputOK = true;
						System.out.print("Nhập Số tiết dạy: ");
						soTietDay = sc.nextInt();
						if (soTietDay < 0) {
							throw new CbException(2);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);
				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(hoTen, heSoLuong, phuCap, khoa, trinhDo, soTietDay));
			}

			// Nhap can bo
		} else if (n == 2) {
			boolean inputOK;
			int N = 0;
			System.out.println("Nhập thông tin cán bộ");
			System.out.println("+------------------------------+");
			do {
				try {
					inputOK = true;
					System.out.print("Nhập Số Lượng Cán bộ: ");
					N = sc.nextInt();
					if (N < 0) {
						throw new CbException(2);
					}
				} catch (Exception e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);
			String hoTen = "";
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Cán bộ thứ " + (i + 1) + "\n");
				sc.nextLine();
				do {
					try {
						inputOK = true;
						System.out.print("Nhập Tên Cán bộ: ");
						hoTen = sc.nextLine();
						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new CbException(1);
						}

					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					} finally {
					}
				} while (!inputOK);

				double heSoLuong = 0;
				do {
					try {
						inputOK = true;
						System.out.print("Nhập hệ số lương: ");
						heSoLuong = sc.nextDouble();
						if (heSoLuong < 0) {
							throw new CbException(4);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);
				sc.nextLine();

				System.out.print("Nhập Phòng ban: ");
				String phongBan = sc.nextLine();

				int phuCap = 0;
				String chucVu = null;
				int choose;
				do {
					System.out.print("Nhập chức vụ: 1.Trưởng phòng  2.Phó phòng  3.Nhân viên ");
					choose = sc.nextInt();
					switch (choose) {
					case 1:
						chucVu = "Chức vụ: Trưởng phòng";
						System.out.println("phụ cấp: 2.000.000 VNĐ \n");
						phuCap = 2000000;
						break;
					case 2:
						chucVu = "Chức vụ: Phó Phòng";

						System.out.println(" phụ cấp: 1.000.000 VNĐ \n");
						phuCap = 1000000;
						break;
					case 3:
						chucVu = "Chức vụ: Nhân viên";

						System.out.println(" phụ cấp: 500.000 VNĐ \n");
						phuCap = 500000;
						break;
					}
				} while (choose < 1 || choose > 3);
				// System.out.print("Nhập chức vụ: 1.Trưởng phòng 2.Phó phòng 3.Nhân viên ");
				// int j = sc.nextInt();
				// String chucVu = null;
				// int phuCap = 0;
				// if (j == 1) {
				// chucVu = "Chức vụ: Trưởng phòng";
				// System.out.println("phụ cấp: 2.000.000 VNĐ \n");
				// phuCap = 2000000;
				// } else if (j == 2) {
				// chucVu = "Chức vụ: Phó Phòng";
				//
				// System.out.println(" phụ cấp: 1.000.000 VNĐ \n");
				// phuCap = 1000000;
				// } else if (j == 3) {
				// chucVu = "Chức vụ: Nhân viên";
				//
				// System.out.println(" phụ cấp: 500.000 VNĐ \n");
				// phuCap = 500000;
				// }
				// System.out.print("Nhập Số ngày công: ");
				// int soNgayCong = sc.nextInt();
				int soNgayCong = 0;
				do {
					try {
						inputOK = true;
						System.out.print("Nhập Số ngày công: ");
						soNgayCong = sc.nextInt();
						if (soNgayCong < 0) {
							throw new CbException(2);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);
				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(hoTen, heSoLuong, phuCap, chucVu, phongBan, soNgayCong));
			}
		}
	}

	public static void XuatThongTin() {
		System.out.println("    Xuất Thông Tin");
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
					System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(),
							((GiangVien) x).getTrinhDo(), x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(),
							((GiangVien) x).getSoTietDay(), ((GiangVien) x).tinhLuong());
				}
			}
		} else if (n == 2) {
			System.out.print("Mời bạn nhập phòng ban của cán bộ: ");
			String phongBan = sc.nextLine();
			for (NhanVien x : dsNhanVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				if (((NvHanhChinh) x).getPhongBan().equals(phongBan)) {
					System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(),
							((NvHanhChinh) x).getPhongBan(), x.getHeSoLuong(), x.getPhuCap(),
							((NvHanhChinh) x).getChucVu(), ((NvHanhChinh) x).getSoNgayCong());
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
		Collections.sort(dsNhanVien, NvComparator.CanBoLuongASComparator);
		for(NhanVien x : dsNhanVien) {
			if(x instanceof GiangVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ GIẢNG VIÊN--------------------------------------+");
				System.out.println(
						"|   Tên GV     |     Trình độ      |Hệ số lương|   Phụ cấp   | Khoa |  Số tiết  |   Tiền lương   |");
				System.out.printf("%-15s %-19s %-11s %-13s %-7s %-7s %-16s\n", x.getHoTen(),
						((GiangVien) x).getTrinhDo(), x.getHeSoLuong(), x.getPhuCap(), ((GiangVien) x).getKhoa(),
						((GiangVien) x).getSoTietDay(), ((GiangVien) x).tinhLuong());
			}else if(x instanceof NvHanhChinh) {
				System.out.println(
						"+---------------------------------DANH SÁCH CÁN BỘ HÀNH CHÍNH--------------------------------------+");
				System.out.println(
						"|   Tên CB    |     Phòng ban     |    Hệ số lương  |   Phụ cấp   | Chức vụ |  Số ngày công  |");
				System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoTen(),
						((NvHanhChinh) x).getPhongBan(), x.getHeSoLuong(), x.getPhuCap(),
						((NvHanhChinh) x).getChucVu(), ((NvHanhChinh) x).getSoNgayCong());
			}
		}
	}

	public static void KetThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}
}
