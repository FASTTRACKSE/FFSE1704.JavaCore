package javacore.qlsvffse.main;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javacore.qlsvffse.entity.*;
import javacore.qlsvffse.util.SVComparator;

public class QuanLiSinhVienFFSE

{
	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập Thông Tin Sinh Viên |");
			System.out.println("|2.In danh sách Sinh Viên   |");
			System.out.println("|3.Xuất danh sách Sv Giỏi   |");
			System.out.println("|4.Sắp Xếp DS SV theo Điểm  |");
			System.out.println("|5.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinSV();
			} else if (N == 2) {
				InDSsinhVien();
			} else if (N == 3) {
				XuatDsSinhVienGioi();
			} else if (N == 4) {
				SapXepDsSinhVienTheoDiem();
			} /*
				 * else if (N == 6) { XoaBienLaiKH(); }
				 */ else {
				System.exit(0);
			}
		}
	}

	public static void NhapThongTinSV() {
		System.out.print("Số Lượng Sinh Viên Cần Nhập");
		N = myInput.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.print("Chọn Loại Sinh Viên Muốn Nhập");
			int k = 0;
			k = myInput.nextInt();
			if (k > 0 && k <= 3) {
				if (k == 1) {
					
					System.out.print("Nhập Tên Sinh Viên :");
					myInput.nextLine();
					String hoTen = myInput.nextLine();
					System.out.print("Nhập Năm Sinh Sinh Viên: ");
					int namSinh = myInput.nextInt();
					myInput.nextLine();
					System.out.print("Nhập Địa Chỉ Sinh Viên: ");
					String diaChi = myInput.nextLine();
					System.out.print("Nhập Điểm Lp0 Sinh Viên: ");
					int lP0 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp1 Sinh Viên: ");
					int lP1 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp2 Sinh Viên: ");
					int lP2 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp3 Sinh Viên: ");
					int lP3 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp4 Sinh Viên: ");
					int lP4 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp5 Sinh Viên: ");
					int lP5 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp6 Sinh Viên: ");
					int lP6 = myInput.nextInt();
					dsSinhVien.add(new SinhVienDaiHan(hoTen, namSinh, diaChi, lP0, lP1, lP2, lP3, lP4, lP5, lP6));
				} else if (k == 2) {
					System.out.print("Nhập Tên Sinh Viên :");
					myInput.nextLine();
					String hoTen = myInput.nextLine();
					System.out.print("Nhập Năm Sinh Sinh Viên: ");
					int namSinh = myInput.nextInt();
					myInput.nextLine();
					System.out.print("Nhập Địa Chỉ Sinh Viên: ");
					String diaChi = myInput.nextLine();
					System.out.print("Nhập Điểm Lp2 Sinh Viên: ");
					int lP2 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp3 Sinh Viên: ");
					int lP3 = myInput.nextInt();
					dsSinhVien.add(new SinhVienWebCapToc(hoTen, namSinh, diaChi, lP2, lP3));
				} else {
					System.out.print("Nhập Tên Sinh Viên :");
					myInput.nextLine();
					String hoTen = myInput.nextLine();
					System.out.print("Nhập Năm Sinh Sinh Viên: ");
					int namSinh = myInput.nextInt();
					myInput.nextLine();
					System.out.print("Nhập Địa Chỉ Sinh Viên: ");
					String diaChi = myInput.nextLine();
					System.out.print("Nhập Điểm Lp4 Sinh Viên: ");
					int lP4 = myInput.nextInt();
					System.out.print("Nhập Điểm Lp5 Sinh Viên: ");
					int lP5 = myInput.nextInt();
					dsSinhVien.add(new SinhVienCapToc(hoTen, namSinh, diaChi, lP4, lP5));
				}
			} else {
				System.out.print("Vui Lòng Nhập Lại\n");
			}
		}
	}

	public static void InDSsinhVien() {
		System.out
				.println("|--------------------------------DANH SÁCH SINH VIÊN--------------------------------------|");
		System.out.printf("\n\t" + "%-10s %-15s %-10s %-12s %-35s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-15s", "STT",
				"Họ và tên", "Tuổi", "Địa Chỉ", "Loại Sinh Viên", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6", "TB",
				"XLoại\n");
		int i = 1;
		for (SinhVien x : dsSinhVien) {
			String sv = "";
			if (x instanceof SinhVienDaiHan) {
				sv = "Sinh Viên Dài Hạn\t   " + ((SinhVienDaiHan) x).getLP0() + "\t    " + ((SinhVienDaiHan) x).getLP1()
						+ "\t   " + ((SinhVienDaiHan) x).getLP2() + "\t\t  " + ((SinhVienDaiHan) x).getLP3() + "\t   "
						+ ((SinhVienDaiHan) x).getLP4() + "\t   " + ((SinhVienDaiHan) x).getLP5() + "\t   "
						+ ((SinhVienDaiHan) x).getLP6();
			} else if (x instanceof SinhVienWebCapToc) {
				sv = "Sinh Viên Web Cấp Tốc " + "NULL\t" + "NULL\t" + ((SinhVienWebCapToc) x).getLP2() + " \t "
						+ ((SinhVienWebCapToc) x).getLP3() + "\tNULL\t" + "NULL\t" + "NULL\t";
			} else if (x instanceof SinhVienCapToc) {
				sv = "Sinh Viên Cấp Tốc \t" + "NULL\t" + "NULL\t" + "NULL\t" + "NULL\t" + ((SinhVienCapToc) x).getLP4()
						+ " \t " + ((SinhVienCapToc) x).getLP5() + "\tNULL";
			}
			System.out.println((i++) + "\t     " + x.getHoTen() + "\t    " + x.soTuoi() + "\t\t " + x.getDiaChi()
					+ "\t   " + sv + "\t" + x.tinhDiemTb() + "\t   " + x.XepLoai());
		}
	}

	public static void XuatDsSinhVienGioi() {
		int i=0;
		for (SinhVien x : dsSinhVien) {
			if (x.XepLoai().equals("Giỏi")) {
				String sv = "";
				if (x instanceof SinhVienDaiHan) {
					sv = "Sinh Viên Dài Hạn\t   " + ((SinhVienDaiHan) x).getLP0() + "\t    " + ((SinhVienDaiHan) x).getLP1()
							+ "\t   " + ((SinhVienDaiHan) x).getLP2() + "\t\t  " + ((SinhVienDaiHan) x).getLP3() + "\t   "
							+ ((SinhVienDaiHan) x).getLP4() + "\t   " + ((SinhVienDaiHan) x).getLP5() + "\t   "
							+ ((SinhVienDaiHan) x).getLP6();
				} else if (x instanceof SinhVienWebCapToc) {
					sv = "Sinh Viên Web Cấp Tốc " + "NULL\t" + "NULL\t" + ((SinhVienWebCapToc) x).getLP2() + " \t "
							+ ((SinhVienWebCapToc) x).getLP3() + "\tNULL\t" + "NULL\t" + "NULL\t";
				} else if (x instanceof SinhVienCapToc) {
					sv = "Sinh Viên Cấp Tốc \t" + "NULL\t" + "NULL\t" + "NULL\t" + "NULL\t" + ((SinhVienCapToc) x).getLP4()
							+ " \t " + ((SinhVienCapToc) x).getLP5() + "\tNULL";
				}
				System.out.println((i++) + "\t     " + x.getHoTen() + "\t    " + x.soTuoi() + "\t\t " + x.getDiaChi()
						+ "\t   " + sv + "\t" + x.tinhDiemTb() + "\t   " + x.XepLoai());
			}
		}
	}

	public static void SapXepDsSinhVienTheoDiem() {
		Collections.sort(dsSinhVien,SVComparator.SinhVienDTBDESComparator);
				int i=0;
				for(SinhVien x:dsSinhVien) {
					String sv = "";
					if (x instanceof SinhVienDaiHan) {
						sv = "Sinh Viên Dài Hạn\t   " + ((SinhVienDaiHan) x).getLP0() + "\t    " + ((SinhVienDaiHan) x).getLP1()
								+ "\t   " + ((SinhVienDaiHan) x).getLP2() + "\t\t  " + ((SinhVienDaiHan) x).getLP3() + "\t   "
								+ ((SinhVienDaiHan) x).getLP4() + "\t   " + ((SinhVienDaiHan) x).getLP5() + "\t   "
								+ ((SinhVienDaiHan) x).getLP6();
					} else if (x instanceof SinhVienWebCapToc) {
						sv = "Sinh Viên Web Cấp Tốc " + "NULL\t" + "NULL\t" + ((SinhVienWebCapToc) x).getLP2() + " \t "
								+ ((SinhVienWebCapToc) x).getLP3() + "\tNULL\t" + "NULL\t" + "NULL\t";
					} else if (x instanceof SinhVienCapToc) {
						sv = "Sinh Viên Cấp Tốc \t" + "NULL\t" + "NULL\t" + "NULL\t" + "NULL\t" + ((SinhVienCapToc) x).getLP4()
								+ " \t " + ((SinhVienCapToc) x).getLP5() + "\tNULL";
					}
					System.out.println((i++) + "\t     " + x.getHoTen() + "\t    " + x.soTuoi() + "\t\t " + x.getDiaChi()
							+ "\t   " + sv + "\t" + x.tinhDiemTb() + "\t   " + x.XepLoai());
				}
	}
		

}
