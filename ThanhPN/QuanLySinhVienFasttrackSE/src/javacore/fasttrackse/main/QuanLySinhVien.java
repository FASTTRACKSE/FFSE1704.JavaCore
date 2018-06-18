/**
 * 
 */
package javacore.fasttrackse.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javacore.fasttrackse.util.Util;

import javacore.fasttrackse.entity.*;

/**
 * @author GOS ThanhRTCD
 *
 */
public class QuanLySinhVien {
	static ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 6) {
			try {
				System.out.println("\nH? th?ng qu?n lý Sinh Viên FastTrackSE ");
				System.out.println("---------------------------------------");
				System.out.println("1. Nh?p danh sách Sinh Viên");
				System.out.println("2. Xu?t thông tin danh sách Sinh Viên");
				System.out.println("3. Xu?t danh sách sinh viên có h?c l?c gi?i ");
				System.out.println("4. S?p x?p danh sách sinh viên theo di?m");
				System.out.println("5. K?t Thúc");
				System.out.println("---------------------------------------");
				System.out.print("M?i b?n ch?n ch?c nang: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {

					nhapDSSV();
				} else if (myOption == 2) {

					xuatthongtinDSSV();
				} else if (myOption == 3) {

					xuatXLSV();
				} else if (myOption == 4) {
					sapxepDSSV();

				} else if (myOption == 5) {

					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Ch? nh?p t? 1 d?n 5, nh?p l?i nhé b?n hi?n!");
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}

	public static void nhapDSSV() {
		System.out.println("Nh?p khóa sinh viên: ");
		int x = myInput.nextInt();
		if (x == 1) {

			System.out.print("Nh?p s? lu?ng sinh viên: ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Nh?p h? sinh viên th? " + (i + 1) + ":");
				myInput.nextLine();
				String hoSV = myInput.nextLine();

				System.out.print("Nh?p tên Sinh Viên th? " + (i + 1) + ":");
				String tenSV = myInput.nextLine();

				System.out.print("Nh?p Nam Sinh Sinh Viên th? " + (i + 1) + ":");
				int namSinh = myInput.nextInt();

				System.out.print("Nh?p d?a ch? Sinh Viên th? " + (i + 1) + ":");
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.print("Nh?p di?m LP0 : ");
				double LP0 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP1 : ");
				double LP1 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP2 : ");
				double LP2 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP3 : ");
				double LP3 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP4 : ");
				double LP4 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP5 : ");
				double LP5 = myInput.nextDouble();
				System.out.print("Nh?p di?m LP6 : ");
				double LP6 = myInput.nextDouble();

				dsSV.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, LP0, LP1, LP2, LP3, LP4, LP5, LP6));
			}
		}

		else {
			if (x == 2) {

				System.out.print("Nh?p s? lu?ng sinh viên: ");
				int n = myInput.nextInt();

				for (int i = 0; i < n; i++) {
					System.out.println("Nh?p h? sinh viên th? " + (i + 1) + ":");
					myInput.nextLine();
					String hoSV = myInput.nextLine();

					System.out.print("Nh?p tên Sinh Viên th? " + (i + 1) + ":");
					String tenSV = myInput.nextLine();

					System.out.print("Nh?p Nam Sinh Sinh Viên th? " + (i + 1) + ":");
					int namSinh = myInput.nextInt();

					System.out.print("Nh?p d?a ch? Sinh Viên th? " + (i + 1) + ":");
					myInput.nextLine();
					String diaChi = myInput.nextLine();

					System.out.print("Nh?p di?m LP2 : ");
					double LP2 = myInput.nextDouble();
					System.out.print("Nh?p di?m LP3 : ");
					double LP3 = myInput.nextDouble();

					dsSV.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, LP2, LP3));
				}
			} else {
				if (x == 3) {

					System.out.print("Nh?p s? lu?ng sinh viên: ");
					int n = myInput.nextInt();

					for (int i = 0; i < n; i++) {
						System.out.println("Nh?p h? sinh viên th? " + (i + 1) + ":");
						myInput.nextLine();
						String hoSV = myInput.nextLine();

						System.out.print("Nh?p tên Sinh Viên th? " + (i + 1) + ":");
						String tenSV = myInput.nextLine();

						System.out.print("Nh?p Nam Sinh Sinh Viên th? " + (i + 1) + ":");
						int namSinh = myInput.nextInt();

						System.out.print("Nh?p d?a ch? Sinh Viên th? " + (i + 1) + ":");
						myInput.nextLine();
						String diaChi = myInput.nextLine();

						System.out.print("Nh?p di?m LP4 : ");
						double LP4 = myInput.nextDouble();
						System.out.print("Nh?p di?m LP5 : ");
						double LP5 = myInput.nextDouble();

						dsSV.add(new SinhVienJavaCapToc(hoSV, tenSV, namSinh, diaChi, LP4, LP5));
					}
				}
			}
		}

	}

	public static void xuatthongtinDSSV() {
		System.out.println("\n");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		int i = 0;
		String smg = "";

		for (SinhVien o : dsSV) {
			if (o instanceof SinhVienDaiHan) {

				smg = " Sinh Viên Dài H?n \n";

				System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + ((SinhVienDaiHan) o).getHoSV() + " - "
						+ " Tên: " + ((SinhVienDaiHan) o).getTenSV() + " - " + " Nam Sinh "
						+ ((SinhVienDaiHan) o).getNamSinh() + " - " + " Ð?a Ch? " + ((SinhVienDaiHan) o).getDiaChi()
						+ " - " + " Ði?m LP0 " + ((SinhVienDaiHan) o).getLP0() + " Ði?m LP1 "
						+ ((SinhVienDaiHan) o).getLP1() + " Ði?m LP2 " + ((SinhVienDaiHan) o).getLP2() + " Ði?m LP3 "
						+ ((SinhVienDaiHan) o).getLP3() + " Ði?m LP4 " + ((SinhVienDaiHan) o).getLP4() + " Ði?m LP5 "
						+ ((SinhVienDaiHan) o).getLP5() + " Ði?m LP6 " + ((SinhVienDaiHan) o).getLP6() + "\n"
						+ " Ði?m Trung Bình " + ((SinhVienDaiHan) o).tinhDTB() + " - " + " X?p Lo?i "
						+ ((SinhVienDaiHan) o).xepLoaiSV());

			} else {
				if (o instanceof SinhVienWebCapToc) {

					smg = " Sinh Viên Web C?p T?c \n";

					System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + " - "
							+ ((SinhVienWebCapToc) o).getHoSV() + " Tên: " + ((SinhVienWebCapToc) o).getTenSV() + " - "
							+ " Nam Sinh " + ((SinhVienWebCapToc) o).getNamSinh() + " - " + " Ð?a Ch? "
							+ ((SinhVienWebCapToc) o).getDiaChi() + " - " + " Ði?m LP2 "
							+ ((SinhVienWebCapToc) o).getLP2() + " Ði?m LP3 " + ((SinhVienWebCapToc) o).getLP3() + "\n"
							+ " Ði?m Trung Bình " + ((SinhVienWebCapToc) o).tinhDTB() + " - " + " X?p Lo?i "
							+ ((SinhVienWebCapToc) o).xepLoaiSV());
				} else {
					if (o instanceof SinhVienJavaCapToc) {

						smg = " Sinh Viên Java C?p T?c \n";

						System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + " - "
								+ ((SinhVienJavaCapToc) o).getHoSV() + " Tên: " + ((SinhVienJavaCapToc) o).getTenSV()
								+ " - " + " Nam Sinh " + ((SinhVienJavaCapToc) o).getNamSinh() + " - " + " Ð?a Ch? "
								+ ((SinhVienJavaCapToc) o).getDiaChi() + " - " + " Ði?m LP4 "
								+ ((SinhVienJavaCapToc) o).getLP4() + " Ði?m LP5 " + ((SinhVienJavaCapToc) o).getLP5()
								+ "\n" + " Ði?m Trung Bình " + ((SinhVienJavaCapToc) o).tinhDTB() + " - " + " X?p Lo?i "
								+ ((SinhVienJavaCapToc) o).xepLoaiSV());

					}
				}
			}
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}

	public static void xuatXLSV() {
		System.out.println("\n");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		int i = 0;
		String smg = "";
		for (SinhVien o : dsSV) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDTB() > 8.5) {
					smg = " Sinh Viên Dài H?n Ð?t Lo?i gi?i \n";

					System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + ((SinhVienDaiHan) o).getHoSV()
							+ " - " + " Tên: " + ((SinhVienDaiHan) o).getTenSV() + " - " + " Nam Sinh "
							+ ((SinhVienDaiHan) o).getNamSinh() + " - " + " Ð?a Ch? " + ((SinhVienDaiHan) o).getDiaChi()
							+ " - " + "\n" + " Ði?m Trung Bình " + ((SinhVienDaiHan) o).tinhDTB() + " - " + " X?p Lo?i "
							+ ((SinhVienDaiHan) o).xepLoaiSV());

				} else {
					if (o instanceof SinhVienWebCapToc) {
						if (((SinhVienWebCapToc) o).tinhDTB() > 8.5) {
							smg = " Sinh Viên Web C?p T?c d?t lo?i gi?i \n";

							System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + " - "
									+ ((SinhVienWebCapToc) o).getHoSV() + " Tên: " + ((SinhVienWebCapToc) o).getTenSV()
									+ " - " + " Nam Sinh " + ((SinhVienWebCapToc) o).getNamSinh() + " - " + " Ð?a Ch? "
									+ ((SinhVienWebCapToc) o).getDiaChi() + " - " + "\n" + " Ði?m Trung Bình "
									+ ((SinhVienWebCapToc) o).tinhDTB() + " - " + " X?p Lo?i "
									+ ((SinhVienWebCapToc) o).xepLoaiSV());
						} else {
							if (o instanceof SinhVienJavaCapToc) {
								if (((SinhVienJavaCapToc) o).tinhDTB() > 8.5) {
									smg = " Sinh Viên Java C?p T?c d?t lo?i gi?i \n";

									System.out.println(" Sinh Viên Th? " + (++i) + "\n" + " H?: " + " - "
											+ ((SinhVienJavaCapToc) o).getHoSV() + " Tên: "
											+ ((SinhVienJavaCapToc) o).getTenSV() + " - " + " Nam Sinh "
											+ ((SinhVienJavaCapToc) o).getNamSinh() + " - " + " Ð?a Ch? "
											+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n" + " Ði?m Trung Bình "
											+ ((SinhVienJavaCapToc) o).tinhDTB() + " - " + " X?p Lo?i "
											+ ((SinhVienJavaCapToc) o).xepLoaiSV());

								}
							}
						}
					}

				}
			}

		}

		System.out.println(
				"--------------------------------------------------------------------------------------------");

	}

	public static void sapxepDSSV() {
		Collections.sort(dsSV, Util.SinhVienDTBDESComparator);
		for (SinhVien x : dsSV) {
			System.out.println(x.getTenSV() + "\t" + x.getDiaChi() + "\t" + x.getNamSinh() + "\t" + x.tinhDTB()
					+ "\tX?p Lo?i: " + x.xepLoaiSV());
		}
	}

	public static void ketThuc() {
		System.out.println("K?t thúc chuong trình, cám on b?n dã s? d?ng!!!");
	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("?n Enter d? v? menu chính");
		myInput.nextLine();
	}

}