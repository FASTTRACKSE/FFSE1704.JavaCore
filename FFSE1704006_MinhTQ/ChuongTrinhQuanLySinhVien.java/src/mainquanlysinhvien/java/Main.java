package mainquanlysinhvien.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanlysinhvien.java.SinhVien;
import quanlysinhvien.java.SinhVienCapToc;
import quanlysinhvien.java.SinhVienDaiHan;
import quanlysinhvien.java.SinhVienJavaCapToc;

public class Main {
	static int n, i;
	static String msg = "";
	static Scanner nhap = new Scanner(System.in);
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

	public static void main(String[] args) {

		menu();
	}

	public static void menu() {

		while (n != 5) {

			try {
				System.out.println("\nHệ thống quản lý Sinh Viên");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập danh sách sinh viên");
				System.out.println("2. In thông tin danh sách sinh viên ");
				System.out.println("3. Danh sách sinh viên có học lực giỏi");
				System.out.println("4. Sắp xếp sinh viên theo điểm");
				System.out.println("5. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				n = nhap.nextInt();
				if (n == 1) {
					nhapthongtinsinhvien();
				} else if (n == 2) {

					inthongtindanhsachsinhvien();
				} else if (n == 3) {

					danhsachsinhviencohoclucgioi();
				} else if (n == 4) {
					sapxeptheodiem();

				} else if (n == 5) {

					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {

			} finally {
				if (n != 5) {
					backToMainMenu();
				}
			}
		}
	}

	public static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public static void nhapthongtinsinhvien() {

		System.out.println("\n SINH VIÊN THUỘC CHƯƠNG TRÌNH NÀO");
		System.out.println("--------------------------------------");
		System.out.println("1: Sinh viên dài hạn");
		System.out.println("2: Sinh viên khóa cấp tốc");
		System.out.println("3: Sinh viên khóa java cấp tốc");
		System.out.println("--------------------------------------");
		n = nhap.nextInt();
		if (n == 1) {
			System.out.println("Nhập thông tin Sinh Viên Dài Hạn");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			n = nhap.nextInt();

			for (i = 0; i < n; i++) {

				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				nhap.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSinhVien = nhap.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSinhVien = nhap.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = nhap.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				nhap.nextLine();
				String diaChi = nhap.nextLine();

				System.out.print("Nhập điểm LP0: ");
				double diemLP0 = nhap.nextInt();
				System.out.print("Nhập điểm LP1: ");
				double diemLP1 = nhap.nextInt();
				System.out.print("Nhập điểm LP2: ");
				double diemLP2 = nhap.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP3 = nhap.nextInt();
				System.out.print("Nhập điểm LP4: ");
				double diemLP4 = nhap.nextInt();
				System.out.print("Nhập điểm LP5: ");
				double diemLP5 = nhap.nextInt();
				System.out.print("Nhập điểm LP6: ");
				double diemLP6 = nhap.nextInt();

				dsSinhVien.add(new SinhVienDaiHan(hoSinhVien, tenSinhVien, namSinh, diaChi, diemLP0, diemLP1, diemLP2,
						diemLP3, diemLP4, diemLP5, diemLP6));
			}
		} else if (n == 2) {
			System.out.println("Nhập thông tin sinh viên khóa cấp tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			n = nhap.nextInt();

			for (i = 0; i < n; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				nhap.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSinhVien = nhap.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSinhVien = nhap.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = nhap.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				nhap.nextLine();
				String diaChi = nhap.nextLine();

				System.out.print("Nhập điểm LP2: ");
				double diemLP2 = nhap.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP3 = nhap.nextInt();
				dsSinhVien.add(new SinhVienCapToc(hoSinhVien, tenSinhVien, namSinh, diaChi, diemLP2, diemLP3));
			}
		} else if (n == 3) {
			System.out.println("Nhập thông tin sinh viên khóa java cấp tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			n = nhap.nextInt();

			for (i = 0; i < n; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				nhap.nextLine();

				System.out.print("Nhập Họ sinh viên: ");
				String hoSinhVien = nhap.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSinhVien = nhap.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = nhap.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				nhap.nextLine();
				String diaChi = nhap.nextLine();

				System.out.print("Nhập điểm LP2: ");
				double diemLP4 = nhap.nextInt();
				System.out.print("Nhập điểm LP3: ");
				double diemLP5 = nhap.nextInt();
				dsSinhVien.add(new SinhVienJavaCapToc(hoSinhVien, tenSinhVien, namSinh, diaChi, diemLP4, diemLP5));
			}
		}

	}

	public static void inthongtindanhsachsinhvien() {

		System.out.println("\n SINH VIÊN THUỘC CHƯƠNG TRÌNH NÀO");
		System.out.println("--------------------------------------");
		System.out.println("1: In sinh viên dài hạn");
		System.out.println("2: In sinh viên khóa cấp tốc");
		System.out.println("3: In sinh viên khóa java cấp tốc");
		System.out.println("--------------------------------------");
		n = nhap.nextInt();
		if (n == 1) {
			msg = "\n Sinh Viên Dài hạn";
			System.out.printf("\n" + "%-8s %-8s %-8s %-8s %-10s %-8s %-8s %-8s %-8s %-8s %-8s  %-9s ", "STT", "Họ", "tên",
					"NămSinh", "địa chỉ", "LP0", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6");
			System.out.println("");
			for (SinhVien o : dsSinhVien) {
				System.out.print((i++) + "\t" + ((SinhVienDaiHan) o).getHoSinhVien() + "\t  "
						+ ((SinhVienDaiHan) o).getTenSinhSinh() + "\t   " + ((SinhVienDaiHan) o).getNamSinh() + "\t   "
						+ ((SinhVienDaiHan) o).getDiaChi() + "\t " + ((SinhVienDaiHan) o).getDiemLP0() + "\t  "
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\t  " + ((SinhVienDaiHan) o).getDiemLP2() + "\t   "
						+ ((SinhVienDaiHan) o).getDiemLP3() + "\t   " + ((SinhVienDaiHan) o).getDiemLP4() + "\t   "
						+ ((SinhVienDaiHan) o).getDiemLP5() + "\t     " + ((SinhVienDaiHan) o).getDiemLP6() + "\t \n");
			}
		} else if (n == 2) {
			msg = "\n Sinh Viên Cấp Tốc";
			System.out.printf(" %1s %5s %10s %11s %10s %8s %9s ", "STT", "Họ", "tên", "Năm Sinh", "địa chỉ", "LP2",
					"LP3");
			System.out.println();
			for (SinhVien o : dsSinhVien) {
				System.out.print((i++) + "\t" + ((SinhVienCapToc) o).getHoSinhVien() + "\t "
						+ ((SinhVienCapToc) o).getTenSinhSinh() + "\t  " + ((SinhVienCapToc) o).getNamSinh() + "\t   "
						+ ((SinhVienCapToc) o).getDiaChi() + "\t " + ((SinhVienCapToc) o).getDiemLP2() + "\t    "
						+ ((SinhVienCapToc) o).getDiemLP3() + "\t \n");
				System.out.println();
			}
		} else if (n == 3) {
			msg = "\n Sinh Viên Java Cấp Tốc";
			System.out.printf("%1s %5s %10s %11s %10s %8s %9s  ", "STT", "Họ", "tên", "Năm Sinh", "địa chỉ", "LP4",
					"LP5");
			System.out.println();
			for (SinhVien o : dsSinhVien) {

				System.out.print((i++) + "\t" + ((SinhVienJavaCapToc) o).getHoSinhVien() + "\t "
						+ ((SinhVienJavaCapToc) o).getTenSinhSinh() + "\t" + ((SinhVienJavaCapToc) o).getNamSinh()
						+ "\t   " + ((SinhVienJavaCapToc) o).getDiaChi() + "\t " + ((SinhVienJavaCapToc) o).getDiemLP4()
						+ "\t    " + ((SinhVienJavaCapToc) o).getDiemLP5() + "\n");

			}
		}
	}

	public static void danhsachsinhviencohoclucgioi() {
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDiemTrungBinh() >= 8.5) {
					msg = "\n danh sách học sinh giỏi của khóa dài hạn";
					System.out.println(
							"STT     Họ        tên        Năm Sinh        địachỉ       LP0      LP1       LP2       LP3       LP4       LP5        LP6      DTB     xếploại");
					System.out.printf("%1s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s", (i++)
							+ "\t" + ((SinhVienDaiHan) o).getHoSinhVien() + "\t\t" + ((SinhVienDaiHan) o).getTenSinhSinh()
							+ "\t" + ((SinhVienDaiHan) o).getNamSinh() + "\t\t" + ((SinhVienDaiHan) o).getDiaChi() + "\t"
							+ ((SinhVienDaiHan) o).getDiemLP0() + "\t" + ((SinhVienDaiHan) o).getDiemLP1() + "\t"
							+ ((SinhVienDaiHan) o).getDiemLP2() + "\t" + ((SinhVienDaiHan) o).getDiemLP3() + "\t"
							+ ((SinhVienDaiHan) o).getDiemLP4() + "\t" + ((SinhVienDaiHan) o).getDiemLP5() + "\t"
							+ ((SinhVienDaiHan) o).getDiemLP6() + "\t" + ((SinhVienDaiHan) o).tinhDiemTrungBinh() + "\t"
							+ ((SinhVienDaiHan) o).xepLoai() + "\t\n");
					System.out.println();
				} else if (o instanceof SinhVienCapToc) {
					if (((SinhVienCapToc) o).tinhDiemTrungBinh() >= 8.5) {
						msg = "\n Sinh Viên Cấp Tốc";
						System.out.println(
								"  stt    HoSV     TênSV     NamSinhSV    DiaChi     ĐiểmLP2      ĐiểmLP3      DTB     xếploại");

						System.out.printf(" %1s  %10s  %10s  %10s  %10s  %10s  %10s %10s %10s", (i++) + "\t"
								+ ((SinhVienCapToc) o).getHoSinhVien() + ((SinhVienCapToc) o).getTenSinhSinh() + "\t"
								+ ((SinhVienCapToc) o).getNamSinh() + "\t" + ((SinhVienCapToc) o).getDiaChi() + "\t"
								+ ((SinhVienCapToc) o).getDiemLP2() + "\t" + ((SinhVienCapToc) o).getDiemLP3() + "\t"
								+ ((SinhVienCapToc) o).tinhDiemTrungBinh() + "\t" + ((SinhVienCapToc) o).xepLoai()
								+ "\t\n");
						System.out.println();
					}
				} else if (o instanceof SinhVienCapToc) {
					if (((SinhVienJavaCapToc) o).tinhDiemTrungBinh() >= 8.5)
						msg = "\n Sinh Viên Java Cấp Tốc";
					System.out.println(
							" stt     HoSV     TênSV     NamSinhSV      DiaChi       ĐiểmLP4       ĐiểmLP5      DTB      xếploại ");

					System.out.printf("%1s %10s %10s %10s %10s %10s %10s %10s %10s ", (i++) + "\t"
							+ ((SinhVienJavaCapToc) o).getHoSinhVien() + "\t"
							+ ((SinhVienJavaCapToc) o).getTenSinhSinh() + "\t" + ((SinhVienJavaCapToc) o).getNamSinh()
							+ "\t" + ((SinhVienJavaCapToc) o).getDiaChi() + "\t" + ((SinhVienJavaCapToc) o).getDiemLP4()
							+ "\t" + ((SinhVienJavaCapToc) o).getDiemLP5() + "\t"
							+ ((SinhVienCapToc) o).tinhDiemTrungBinh() + "\t" + ((SinhVienCapToc) o).xepLoai()
							+ "\t\n");
					System.out.println();
				}

			}
		}
	}

	public static void sapxeptheodiem() {

		System.out.println("1 : Sinh viên khóa dài hạn");
		System.out.println("2 : Sinh viên khóa cấp tốc");
		System.out.println("3 : Sinh viên khóa Java cấp tốc ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
		n = nhap.nextInt();
		Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien SV1, SinhVien SV2) {
				if (SV1.tinhDiemTrungBinh() < SV2.tinhDiemTrungBinh()) {
					return 1;
				} else if (SV1.tinhDiemTrungBinh() > SV2.tinhDiemTrungBinh()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		if (n == 1) {
			System.out.println("Sắp xếp theo điểm trung bình của sinh viên khóa dài hạn");

			for (SinhVien o : dsSinhVien) {
				System.out.println(
						"stt     HoSV     TênSV     NamSinhSV      DiaChi       ĐiểmLP0       ĐiểmLP1       ĐiểmLP2      ĐiểmLP3      ĐiểmLP4       ĐiểmLP5      ĐiểmLP6      DTB ");
				System.out.printf("%1s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s  ",
						(i++) + "\t" + ((SinhVienDaiHan) o).getHoSinhVien() + "\t"
								+ ((SinhVienDaiHan) o).getTenSinhSinh() + "\t" + ((SinhVienDaiHan) o).getNamSinh()
								+ "\t" + ((SinhVienDaiHan) o).getDiaChi() + "\t" + ((SinhVienDaiHan) o).getDiemLP0()
								+ "\t" + ((SinhVienDaiHan) o).getDiemLP1() + "\t" + ((SinhVienDaiHan) o).getDiemLP2()
								+ "\t" + ((SinhVienDaiHan) o).getDiemLP3() + "\t" + ((SinhVienDaiHan) o).getDiemLP4()
								+ "\t" + ((SinhVienDaiHan) o).getDiemLP5() + "\t" + ((SinhVienDaiHan) o).getDiemLP6()
								+ "\t" + ((SinhVienDaiHan) o).tinhDiemTrungBinh() + "\n");
			}
		} else if (n == 2) {
			System.out.println("Sắp xếp theo điểm trung bình của sinh viên khóa cấp tốc");

			for (SinhVien o : dsSinhVien) {

				System.out.println(
						"stt     HoSV     TênSV     NamSinhSV      DiaChi       ĐiểmLP4       ĐiểmLP5      DTB ");
				System.out.printf(" %1s  %10s  %10s  %10s  %10s  %10s  %10s  ",
						(i++) + "\t" + ((SinhVienCapToc) o).getHoSinhVien() + "\t"
								+ ((SinhVienCapToc) o).getTenSinhSinh() + "\t" + ((SinhVienCapToc) o).getNamSinh()
								+ "\t" + ((SinhVienCapToc) o).getDiaChi() + "\t" + ((SinhVienCapToc) o).getDiemLP2()
								+ "\t" + ((SinhVienCapToc) o).getDiemLP3() + "\t"
								+ ((SinhVienCapToc) o).tinhDiemTrungBinh() + "\n");
			}
		} else if (n == 3) {
			System.out.println("Sắp xếp theo điểm trung bình của sinh viên khóa java cấp tốc");

			for (SinhVien o : dsSinhVien) {
				System.out.println(
						"stt     HoSV     TênSV     NamSinhSV      DiaChi       ĐiểmLP4       ĐiểmLP5      DTB ");
				System.out.printf("%1s %10s %10s %10s %10s %10s %10s %10s %10s ", (i) + "\t"
						+ ((SinhVienJavaCapToc) o).getHoSinhVien() + "\t" + ((SinhVienJavaCapToc) o).getTenSinhSinh()
						+ "\t" + ((SinhVienJavaCapToc) o).getNamSinh() + "\t" + ((SinhVienJavaCapToc) o).getDiaChi()
						+ "\t" + ((SinhVienJavaCapToc) o).getDiemLP4() + "\t" + ((SinhVienJavaCapToc) o).getDiemLP5()
						+ "\t" + ((SinhVienJavaCapToc) o).tinhDiemTrungBinh() + "\t\n");
			}
		}

	}

}
