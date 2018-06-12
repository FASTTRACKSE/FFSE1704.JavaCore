package javacore.qlsvffse.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import javacore.qlsvffse.entity.*;

public class QuanLiSinhVienFFSE {
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
		for (SinhVien x : dsSinhVien) {
			/*
			 * System.out.print(x.getHoTen()+"\t"+x.XepLoai() +"\t"+ x.tinhDiemTb()+"\n");
			 */
			String sv = "";
			if (x instanceof SinhVienDaiHan) {
				sv = "Sinh Viên Dài Hạn - Điểm LP0: " + ((SinhVienDaiHan) x).getLP0() + " - Điểm LP1: "
						+ ((SinhVienDaiHan) x).getLP1() + " - Điểm LP2: " + ((SinhVienDaiHan) x).getLP2() + " - Điểm LP3: "
						+ ((SinhVienDaiHan) x).getLP3() + " - Điểm LP4: " + ((SinhVienDaiHan) x).getLP4() + " - Điểm LP5: "
						+ ((SinhVienDaiHan) x).getLP5() + " - Điểm LP6: " + ((SinhVienDaiHan) x).getLP6()+"\n";
			} else if (x instanceof SinhVienWebCapToc) {
				sv = "Sinh Viên Web Cấp Tốc- Điểm LP2: " + ((SinhVienWebCapToc) x).getLP2() + " - Điểm LP3: "
						+ ((SinhVienWebCapToc) x).getLP3()+"\n";
			} else if (x instanceof SinhVienCapToc) {
				sv = "Sinh Viên Cấp Tốc- Điểm LP4: " + ((SinhVienCapToc) x).getLP4() + " - Điểm LP5: "
						+ ((SinhVienCapToc) x).getLP5()+"\n";
			}
			System.out.println(x.getHoTen() +"\t"+ x.getDiaChi()+"\t"+ x.getNamSinh()+"\n"+sv+"\tĐiểm Trung Bình: "+ x.tinhDiemTb()+"\tXếp Loại: "+x.XepLoai());
		}
	}

	public static void XuatDsSinhVienGioi() {
		for(SinhVien o:dsSinhVien) {
			if(o.XepLoai().equals("Giỏi")) {
				System.out.println(o.getHoTen() +"\t"+ o.getDiaChi()+"\t"+ o.getNamSinh()+"\t"+ o.tinhDiemTb()+"\tXếp Loại: "+o.XepLoai());
			}
		}
	}

	public static void SapXepDsSinhVienTheoDiem() {
		
	}

}
