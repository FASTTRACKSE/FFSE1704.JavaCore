package ffse1703012.assignment;

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import ffse1703012.assignment.*;

public class QuanLySinhVien {
	static int option;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("+---------------------------------------------------+");
			System.out.println("|1.Nhập Thông Tin Sinh Viên                         |");
			System.out.println("|2.Xuất thông tin Sinh Viên                         |");
			System.out.println("|3.Xuất danh sách Sinh Viên học lực Giỏi            |");
			System.out.println("|4.Sắp xếp danh sách Sinh Viên theo điểm            |");
			System.out.println("|5.Sắp xếp danh sách Sinh Viên theo điểm cả trường  |");
			System.out.println("|6.Thoát chương trình                               |");
			System.out.println("+---------------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			option = sc.nextInt();
			if (option == 1) {
				NhapThongTinSV();
			} else if (option == 2) {
				XuatThongTin();
			} else if (option == 3) {
				XuatSvGioi();
			} else if (option == 4) {
				SapXepTheoDiem();
			} else if (option == 5) {
				SapXepCaTruong();
			} else if (option == 6) {
				KetThuc();
			}
		}

	}

	public static void NhapThongTinSV() {
		System.out.println("    Mời chọn Sinh Viên theo khóa học:");
		System.out.println("+----------------------------------------+");
		System.out.println("|1.Sinh viên dài hạn                     |");
		System.out.println("|2.Sinh viên Web Cấp tốc                 |");
		System.out.println("|2.Sinh Viên Java Cấp tốc                |");
		System.out.println("+----------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("Nhập thông tin Sinh Viên Dài Hạn");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				sc.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSV = sc.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSV = sc.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = sc.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				sc.nextLine();
				String diaChi = sc.nextLine();

				System.out.print("Nhập điểm LP0: ");
				double diemLP0 = sc.nextInt();
				System.out.print("Nhập điểm LP1: ");
				double diemLP1 = sc.nextInt();
				System.out.print("Nhập điểm LP2: ");
				double diemLP2 = sc.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP3 = sc.nextInt();
				System.out.print("Nhập điểm LP4: ");
				double diemLP4 = sc.nextInt();
				System.out.print("Nhập điểm LP5: ");
				double diemLP5 = sc.nextInt();
				System.out.print("Nhập điểm LP6: ");
				double diemLP6 = sc.nextInt();

				System.out.println("------------------------------------------------------------------");

				dsSinhVien.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, diemLP0, diemLP1, diemLP2, diemLP3,
						diemLP4, diemLP5, diemLP6));
			}
		} else if (n == 2) {
			System.out.println("Nhập thông tin Sinh Viên Web Cấp Tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				sc.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSV = sc.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSV = sc.nextLine();

				System.out.print("Nhập ngày sinh sinh viên: ");
				int namSinh = sc.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				sc.nextLine();
				String diaChi = sc.nextLine();

				System.out.print("Nhập điểm LP2: ");
				double diemLP2 = sc.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP3 = sc.nextInt();

				System.out.println("------------------------------------------------------------------");

				dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, diemLP2, diemLP3));
			}
		} else if (n == 3) {
			System.out.println("Nhập thông tin Sinh Viên Web Cấp Tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				sc.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSV = sc.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSV = sc.nextLine();

				System.out.print("Nhập ngày sinh sinh viên: ");
				int namSinh = sc.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				sc.nextLine();
				String diaChi = sc.nextLine();

				System.out.print("Nhập điểm LP2: ");
				double diemLP4 = sc.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP5 = sc.nextInt();

				System.out.println("------------------------------------------------------------------");

				dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, diemLP4, diemLP5));
			}
		}
	}

	public static void XuatThongTin() {
		System.out.println("  Mời chọn xuất Sinh Viên theo khóa học:");
		System.out.println("+---------------------------------------------+");
		System.out.println("|1.Xuất Sinh viên dài hạn                     |");
		System.out.println("|2.Xuất Sinh viên Web Cấp tốc                 |");
		System.out.println("|2.Xuất Sinh Viên Java Cấp tốc                |");
		System.out.println("+---------------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN DÀI HẠN--------------------------------------+");
			System.out.println(
					"|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP0   | Điểm LP1 | Điểm LP2 | Điểm LP3  | Điểm LP4 | Điểm LP5 | Điểm LP6 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienDaiHan) {
					System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s %-7s %-7s\n",
							x.getHoSV() + x.getTenSV(), x.getNgaySinh(), x.getDiaChi(),
							((SinhVienDaiHan) x).getDiemLP0(), ((SinhVienDaiHan) x).getDiemLP1(),
							((SinhVienDaiHan) x).getDiemLP2(), ((SinhVienDaiHan) x).getDiemLP3(),
							((SinhVienDaiHan) x).getDiemLP4(), ((SinhVienDaiHan) x).getDiemLP5(),
							((SinhVienDaiHan) x).getDiemLP6(), ((SinhVienDaiHan) x).tinhDTB());
				}

			}
		} else if (n == 2) {
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN WEB CẤP TỐC--------------------------------------+");
			System.out.println("|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP2   | Điểm LP3 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienWebCapToc) {
					System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoSV() + x.getTenSV(), x.getNgaySinh(),
							x.getDiaChi(), ((SinhVienWebCapToc) x).getDiemLP2(), ((SinhVienWebCapToc) x).getDiemLP3(),
							((SinhVienWebCapToc) x).tinhDTB());
				}

			}
		} else if (n == 3) {
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN JAVA CẤP TỐC--------------------------------------+");
			System.out.println("|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP4   | Điểm LP5 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienJavaCapToc) {
					System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoSV() + x.getTenSV(), x.getNgaySinh(),
							x.getDiaChi(), ((SinhVienJavaCapToc) x).getDiemLP4(), ((SinhVienJavaCapToc) x).getDiemLP5(),
							((SinhVienJavaCapToc) x).tinhDTB());
				}
			}
		}
	}

	public static void XuatSvGioi() {
		System.out.println("  Mời chọn xuất Sinh Viên Giỏi theo khóa học:");
		System.out.println("+---------------------------------------------+");
		System.out.println("|1.Xuất Sinh viên dài hạn                     |");
		System.out.println("|2.Xuất Sinh viên Web Cấp tốc                 |");
		System.out.println("|2.Xuất Sinh Viên Java Cấp tốc                |");
		System.out.println("+---------------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			for (SinhVien x : dsSinhVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH SINH VIÊN GIỎI LỚP DÀI HẠN--------------------------------------+");
				System.out.println(
						"|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP0   | Điểm LP1 | Điểm LP2 | Điểm LP3  | Điểm LP4 | Điểm LP5 | Điểm LP6 | Điểm TB |");
				if (x instanceof SinhVienDaiHan) {
					if (((SinhVienDaiHan) x).tinhDTB() >= 8.5) {
						System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s %-7s %-7s\n",
								x.getHoSV() + x.getTenSV(), x.getNgaySinh(), x.getDiaChi(),
								((SinhVienDaiHan) x).getDiemLP0(), ((SinhVienDaiHan) x).getDiemLP1(),
								((SinhVienDaiHan) x).getDiemLP2(), ((SinhVienDaiHan) x).getDiemLP3(),
								((SinhVienDaiHan) x).getDiemLP4(), ((SinhVienDaiHan) x).getDiemLP5(),
								((SinhVienDaiHan) x).getDiemLP6(), ((SinhVienDaiHan) x).tinhDTB());
					}
				}
			}
		} else if (n == 2) {
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN GIỎI LỚP WEB CẤP TỐC--------------------------------------+");
			System.out.println("|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP2   | Điểm LP3 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienWebCapToc) {
					if (((SinhVienWebCapToc) x).tinhDTB() >= 8.5) {
						System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoSV() + x.getTenSV(),
								x.getNgaySinh(), x.getDiaChi(), ((SinhVienWebCapToc) x).getDiemLP2(),
								((SinhVienWebCapToc) x).getDiemLP3(), ((SinhVienWebCapToc) x).tinhDTB());
					}

				}
			}
		} else if (n == 3) {
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN GIỎI LỚP JAVA CẤP TỐC--------------------------------------+");
			System.out.println("|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP4   | Điểm LP5 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienJavaCapToc) {
					if (((SinhVienJavaCapToc) x).tinhDTB() >= 8.5) {
						System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoSV() + x.getTenSV(),
								x.getNgaySinh(), x.getDiaChi(), ((SinhVienJavaCapToc) x).getDiemLP4(),
								((SinhVienJavaCapToc) x).getDiemLP5(), ((SinhVienJavaCapToc) x).tinhDTB());
					}
				}
			}
		}
	}

	public static void SapXepTheoDiem() {
		System.out.println("  Mời chọn sắp xếp Sinh Viên theo khóa học:");
		System.out.println("+---------------------------------------------+");
		System.out.println("|1.Sắp xếp Sinh viên dài hạn                     |");
		System.out.println("|2.Sắp xếp Sinh viên Web Cấp tốc                 |");
		System.out.println("|2.Sắp xếp Sinh Viên Java Cấp tốc                |");
		System.out.println("+---------------------------------------------+");
		int n = sc.nextInt();
		if (n == 1) {
			Collections.sort(dsSinhVien, SVComparator.SinhVienDTBASComparator);
			for (SinhVien x : dsSinhVien) {
				System.out.println(
						"+---------------------------------DANH SÁCH SINH VIÊN DÀI HẠN--------------------------------------+");
				System.out.println(
						"|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP0   | Điểm LP1 | Điểm LP2 | Điểm LP3  | Điểm LP4 | Điểm LP5 | Điểm LP6 | Điểm TB |");
				if (x instanceof SinhVienDaiHan) {
					if (((SinhVienDaiHan) x).tinhDTB() >= 8.5) {
						System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s %-7s %-7s\n",
								x.getHoSV() + x.getTenSV(), x.getNgaySinh(), x.getDiaChi(),
								((SinhVienDaiHan) x).getDiemLP0(), ((SinhVienDaiHan) x).getDiemLP1(),
								((SinhVienDaiHan) x).getDiemLP2(), ((SinhVienDaiHan) x).getDiemLP3(),
								((SinhVienDaiHan) x).getDiemLP4(), ((SinhVienDaiHan) x).getDiemLP5(),
								((SinhVienDaiHan) x).getDiemLP6(), ((SinhVienDaiHan) x).tinhDTB());
					}
				}
			}
		} else if (n == 2) {
			Collections.sort(dsSinhVien, SVComparator.SinhVienDTBASComparator);
			System.out.println(
					"+---------------------------------DANH SÁCH SINH VIÊN GIỎI LỚP WEB CẤP TỐC--------------------------------------+");
			System.out.println("|   Tên SV     |     Ngày sinh      |    Địa Chỉ  | Điểm LP2   | Điểm LP3 | Điểm TB |");
			for (SinhVien x : dsSinhVien) {
				if (x instanceof SinhVienWebCapToc) {
					if (((SinhVienWebCapToc) x).tinhDTB() >= 8.5) {
						System.out.printf("%-10s %-15s %-15s %-7s %-7s %-7s\n", x.getHoSV() + x.getTenSV(),
								x.getNgaySinh(), x.getDiaChi(), ((SinhVienWebCapToc) x).getDiemLP2(),
								((SinhVienWebCapToc) x).getDiemLP3(), ((SinhVienWebCapToc) x).tinhDTB());
					}

				}
			}
		}
	}

	public static void SapXepCaTruong() {

	}

	public static void KetThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
		System.exit(0);
	}
}
