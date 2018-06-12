package fasttrack.sinhvien.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import fassttrack.sinhvien.entity.SinhVien;
import fassttrack.sinhvien.entity.SinhVienDaiHan;
import fassttrack.sinhvien.entity.SinhVienWebCapToc;
import fassttrack.sinhvien.entity.SinhVienJavaCapToc;;

public class UngDungQuanLySinhVien {
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	/*static ArrayList<SinhVienDaiHan> svDaiHan = new ArrayList<>();
	static ArrayList<SinhVienWebCapToc> svWebCapToc = new ArrayList<>();
	static ArrayList<SinhVienJavaCapToc> svJavaCapToc = new ArrayList<>();*/
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {

		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\n    HỆ THỐNG QUẢN LÝ SINH VIÊN");
				System.out.println("+-----------------------------------+");
				System.out.println("| 1. Nhập danh sách sinh viên       |");
				System.out.println("| 2. In danh sách sinh viên         |");
				System.out.println("| 3. In sinh viên học sinh giỏi     |");
				System.out.println("| 4. Sắp xếp sinh viên              |");
				System.out.println("| 5. Kết thúc                       |");
				System.out.println("+-----------------------------------+");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					nhapSinhVien();
				} else if (myOption == 2) {
					xuatSinhVien();
				} else if (myOption == 3) {
					xuatSinhVienHLG();
				} else if (myOption == 4) {
					SapXepDTB();
				} else if (myOption == 5) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại nhé bạn hiền!");
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	// Nhập danh sách sinh viên 
	public static void nhapSinhVien() {

		System.out.println("Mời bạn chọn khóa sinh viên :  ");
		int x = myInput.nextInt();

		// Sinh viên dài hạn
		if (x == 1) {
			System.out.println("Nhập số lương sinh viên : ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Mời bạn nhập họ  sinh viên thư : " + (i + 1));
				myInput.nextLine();
				String hoSV = myInput.nextLine();

				System.out.println("Mời bạn nhập tên sinh viên thứ : " + (i + 1));
				String tenSV = myInput.nextLine();

				System.out.println("Mời bạn nhập năm sinh sinh viên thứ : " + (i + 1));
				int namSinh = myInput.nextInt();

				System.out.println("Mời bạn nhập địa chỉ sinh viên thứ : " + (i + 1));
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.println("Điểm LP0");
				double LP0 = myInput.nextDouble();

				System.out.println("Điểm LP1");
				double LP1 = myInput.nextDouble();

				System.out.println("Điểm LP2");
				double LP2 = myInput.nextDouble();

				System.out.println("Điểm LP3");
				double LP3 = myInput.nextDouble();

				System.out.println("Điểm LP4");
				double LP4 = myInput.nextDouble();

				System.out.println("Điểm LP5");
				double LP5 = myInput.nextDouble();

				System.out.println("Điểm LP6");
				double LP6 = myInput.nextDouble();

				dsSinhVien.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, LP0, LP1, LP2, LP3, LP4, LP5, LP6));

			}
		}

		// Sinh viên Web cấp tóc
		else if (x == 2) {
			System.out.println("Nhập số lương sinh viên : ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Mời bạn nhập họ  sinh viên thư : " + (i + 1));
				myInput.nextLine();
				String hoSV = myInput.nextLine();

				System.out.println("Mời bạn nhập tên sinh viên thứ : " + (i + 1));
				String tenSV = myInput.nextLine();

				System.out.println("Mời bạn nhập năm sinh sinh viên thứ : " + (i + 1));
				int namSinh = myInput.nextInt();

				System.out.println("Mời bạn nhập địa chỉ sinh viên thứ : " + (i + 1));
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.println("Điểm LP2");
				int LP2 = myInput.nextInt();

				System.out.println("Điểm LP3");
				int LP3 = myInput.nextInt();

				dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, LP2, LP3));

			}
		}

		// Sinh viên Java cấp tóc .
		else if (x == 3) {
			System.out.println("Nhập số lương sinh viên : ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Mời bạn nhập họ sinh viên thứ : " + (i + 1));
				myInput.nextLine();
				String hoSV = myInput.nextLine();

				System.out.println("Mời bạn nhập tên sinh viên thứ : " + (i + 1));
				String tenSV = myInput.nextLine();

				System.out.println("Mời bạn nhập năm sinh sinh viên thứ : " + (i + 1));
				int namSinh = myInput.nextInt();

				System.out.println("Mời bạn nhập địa chỉ sinh viên thứ : " + (i + 1));
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.println("Điểm LP4");
				int LP4 = myInput.nextInt();

				System.out.println("Điểm LP5");
				int LP5 = myInput.nextInt();

				dsSinhVien.add(new SinhVienJavaCapToc(hoSV, tenSV, namSinh, diaChi, LP4, LP5));

			}
		}

	}
	
	// Xuất thông tin danh sách sinh viên 
	public static void xuatSinhVien() {

		System.out.println("1. Sinh viên dài hạn ");
		System.out.println("2. Sinh viên web cấp tóc  ");
		System.out.println("3. Sinh viên java cấp tóc ");

		System.out.println("Mời bạn chọn khóa sinh viên : ");
		int khoa = myInput.nextInt();

		if (khoa == 1) {
			System.out.println("\t \t \t KHÓA SINH VIÊN DÀI HẠN");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s %-8s %-8s %-8s %-8s  %-8s ", "HọSV",
					"TênSV", "Năm Sinh", "Địa chỉ", "LP0", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6", "Điểm TB");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------");
			for (SinhVien x : dsSinhVien) {

				System.out.println("\n" + x.toString());
			}
		} else if (khoa == 2) {
			System.out.println("\t \t \t KHÓA SINH VIÊN WEB CẤP TÓC");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s", "HọSV", "TênSV", "Năm Sinh", "Địa chỉ",
					"LP2", "LP3", "Điểm TB");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------");

			for (SinhVien x : dsSinhVien) {

				System.out.println(x.toString());
			}
		}

		else if (khoa == 3) {
			System.out.println("\t \t \t KHÓA SINH VIÊN JAVA CẤP TÓC");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s", "HọSV", "TênSV", "Năm Sinh", "Địa chỉ",
					"LP4", "LP5", "Điểm TB");
			System.out.println(
					"\n---------------------------------------------------------------------------------------------");
			for (SinhVien x : dsSinhVien) {

				System.out.println(x.toString());
			}
		}

	}

	// Xuất danh sách sinh viên có học lực giỏi 
	public static void xuatSinhVienHLG() {

		System.out.println("1. Sinh viên dài hạn ");
		System.out.println("2. Sinh viên web cấp tóc  ");
		System.out.println("3. Sinh viên java cấp tóc ");

		System.out.println("Mời bạn chọn khóa sinh viên : ");
		int khoa = myInput.nextInt();
		
		// sinh viên dài hạn
		if (khoa == 1) {
			System.out.println("\t \t \t DANH SÁCH SINH VIÊN CÓ HỌC LỰC GIỎI");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s %-8s %-8s %-8s %-8s  %-8s ", "HọSV",
					"TênSV", "Năm Sinh", "Địa chỉ", "LP0", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6", "Điểm TB");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------");

			for (SinhVien x : dsSinhVien) {
				if (x.tinhDTB() > 8.5) {
					System.out.println("\n" + x.toString());
				}
			}
			// sinh viên web cấp tóc
		} else if (khoa == 2) {
			System.out.println("\t \t \t DANH SÁCH SINH VIÊN CÓ HỌC LỰC GIỎI");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s", "HọSV", "TênSV", "Năm Sinh", "Địa chỉ",
					"LP2", "LP3", "Điểm TB");
			System.out.println(
					"\n------------------------------------------------------------------------------------------");

			for (SinhVien x : dsSinhVien) {
				if (x.tinhDTB() > 8.5) {
					System.out.println("\n" + x.toString());
				}
			}
			
			//sinh viên java cấp tóc
		} else if (khoa == 3) {
			System.out.println("\t \t \tDANH SÁCH SINH VIÊN CÓ HỌC LỰC GIỎI");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s", "HọSV", "TênSV", "Năm Sinh",
					"Địa chỉ", "LP4", "LP5", "Điểm TB");
			System.out.println(
					"\n---------------------------------------------------------------------------------------------");
			
			for (SinhVien x : dsSinhVien) {
				if (x.tinhDTB() > 8.5) {
					System.out.println("\n" + x.toString());
				}
			}
		}

	}
	
	// sắp xếp sinh viên theo điểm trung bình
	public static void SapXepDTB() {

		System.out.println("1. Sinh viên dài hạn ");
		System.out.println("2. Sinh viên web cấp tóc  ");
		System.out.println("3. Sinh viên java cấp tóc ");

		System.out.println("Mời bạn chọn khóa sinh viên cần sắp xếp : ");
		int khoa = myInput.nextInt();

		if (khoa == 1) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien vitri1, SinhVien vitri2) {
					if (vitri1.tinhDTB() < vitri2.tinhDTB()) {
						return 1;
					} else if (vitri1.tinhDTB() > vitri2.tinhDTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			System.out.println("\t \t \t KHÓA SINH VIÊN DÀI HẠN");
			System.out.printf("\n" + "%-9s %-14s %-14s %-14s %-8s %-8s %-8s %-8s %-8s %-8s %-8s  %-8s ", "HọSV",
					"TênSV", "Năm Sinh", "Địa chỉ", "LP0", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6", "Điểm TB");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------");
			for (SinhVien x : dsSinhVien) {

				System.out.println("\n" + x.toString());
			}
		} else if (khoa == 2) {
			
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien vitri1, SinhVien vitri2) {
					if (vitri1.tinhDTB() < vitri2.tinhDTB()) {
						return 1;
					} else if (vitri1.tinhDTB() > vitri2.tinhDTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			System.out.println("\t \t \t KHÓA SINH VIÊN WEB CẤP TÓC");
			System.out.printf("\n" + "%-9s %-14s %-14s %-14s %-8s %-8s %-8s", "HọSV", "TênSV", "Năm Sinh", "Địa chỉ",
					"LP2", "LP3", "Điểm TB");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------");

			for (SinhVien x : dsSinhVien) {

				System.out.println(x.toString());
			}
		}

		else if (khoa == 3) {
			
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien vitri1, SinhVien vitri2) {
					if (vitri1.tinhDTB() < vitri2.tinhDTB()) {
						return 1;
					} else if (vitri1.tinhDTB() > vitri2.tinhDTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			System.out.println("\t \t \t KHÓA SINH VIÊN JAVA CẤP TÓC");
			System.out.printf("\n" + "%-10s %-14s %-14s %-14s %-8s %-8s %-8s ", "HọSV", "TênSV", "Năm Sinh",
					"Địa chỉ", "LP4", "LP5", "Điểm TB");
			System.out.println(
					"\n---------------------------------------------------------------------------------------------");
			for (SinhVien x : dsSinhVien) {

				System.out.println(x.toString());
			}
		}

	}

	

}
