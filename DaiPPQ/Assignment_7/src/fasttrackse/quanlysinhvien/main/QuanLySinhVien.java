/**
 *	Prog: QUẢN LÝ SINH VIÊN
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 11/06/2018
 */
package fasttrackse.quanlysinhvien.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

import fasttrackse.quanlysinhvien.entity.*;
import fasttrackse.quanlysinhvien.util.*;

/**
 * @author Support
 *
 */
public class QuanLySinhVien {

	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+--------------------------------------+");
			System.out.println("|1.Nhập danh sách sinh viên            |");
			System.out.println("|2.Xuất thông tin danh sách sinh viên  |");
			System.out.println("|3.Danh sách sinh viên có học lực giỏi |");
			System.out.println("|4.Sắp xếp sinh viên theo điểm         |");
			System.out.println("|5.Kết Thúc                            |");
			System.out.println("+--------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinSV();
			} else if (N == 2) {
				XuatThongTinSV();
			} else if (N == 3) {
				SVGioi();
			} else if (N == 4) {
				SapXep();
			} else {
				System.exit(0);
			}
		}

	}
	
	public static void NhapThongTinSV() {
		Scanner n = new Scanner(System.in);
		
		System.out.print("Nhập Số Lượng Sinh viên: ");
		N = myInput.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
			myInput.nextLine();
			
			System.out.print("Nhập Họ sinh viên: ");
			String hoSV = myInput.nextLine();

			System.out.print("Nhập tên sinh viên: ");
			String tenSV = myInput.nextLine();

			System.out.print("Nhập năm sinh sinh viên: ");
			int namSinh = myInput.nextInt();
			
			System.out.print("Nhập địa chỉ sinh viên: ");
			myInput.nextLine();
			String diaChi = myInput.nextLine();
			
			System.out.println(">> Sinh viên thuộc chương trình nào <<");
			System.out.println("+--------------------------------------+");
			System.out.println("|1.Sinh viên dài hạn                   |");
			System.out.println("|2.Sinh viên web cấp tốc               |");
			System.out.println("|3.Sinh viên java cấp tốc              |");
			System.out.println("+--------------------------------------+");
			int M = n.nextInt();
			if (M == 1) {
				System.out.print("Nhập điểm LP0: ");
				double diemLP0 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP1: ");
				double diemLP1 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP2: ");
				double diemLP2 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP3: ");
				double diemLP3 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP4: ");
				double diemLP4 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP5: ");
				double diemLP5 = myInput.nextInt();
				
				System.out.print("Nhập điểm LP6: ");
				double diemLP6 = myInput.nextInt();
				
				System.out.println("------------------------------------------------------------------");
				dsSinhVien.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, diemLP0, diemLP1, diemLP2, diemLP3,
						diemLP4, diemLP5, diemLP6));
			} else {
				if (M == 2) {
					System.out.print("Nhập điểm LP2: ");
					double diemLP2 = myInput.nextInt();
					
					System.out.print("Nhập điểm LP3: ");
					double diemLP3 = myInput.nextInt();
					
					System.out.println("------------------------------------------------------------------");
					dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, diemLP2, diemLP3));
				} else {
					System.out.print("Nhập điểm LP4: ");
					double diemLP4 = myInput.nextInt();
					
					System.out.print("Nhập điểm LP5: ");
					double diemLP5 = myInput.nextInt();

					System.out.println("------------------------------------------------------------------");
					dsSinhVien.add(new SinhVienJavaCapToc(hoSV, tenSV, namSinh, diaChi, diemLP4, diemLP5));
				}
			}
		}
		
	}

	public static void XuatThongTinSV() {
		int i = 0;

		System.out.println("\t\t\t ***** Danh Sách Sinh Viên *****");
		System.out.println("STT \t Họ tên \t Năm sinh \t Địa chỉ \t lớp \t LP0 \t LP1 \t LP2 \t LP3 \t LP4 \t LP5 \t LP6 \t Điểm trung bình \t Xếp loại");
		System.out.println("\t\t\t --------------------------------");
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {

				System.out.println((++i) + "\t" 
						+ ((SinhVienDaiHan) o).getHoSV() + " " + ((SinhVienDaiHan) o).getTenSV() + "\t"
						+ ((SinhVienDaiHan) o).getNamSinh() + "\t\t" 
						+ ((SinhVienDaiHan) o).getDiaChi() + "\t Dài hạn \t" 
						+ ((SinhVienDaiHan) o).getDiemLP0() + "\t"
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP2() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP3() + "\t"
						+ ((SinhVienDaiHan) o).getDiemLP4() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP5() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP6() + "\t"
						+ ((SinhVienDaiHan) o).tinhDTB() + "\t" 
						+ ((SinhVienDaiHan) o).xepLoaiSV());
			} else {
				if (o instanceof SinhVienWebCapToc) {

					System.out.println((++i) + "\t" 
							+ ((SinhVienWebCapToc) o).getHoSV() + " " + ((SinhVienWebCapToc) o).getTenSV() + "\t"
							+ ((SinhVienWebCapToc) o).getNamSinh() + "\t\t"
							+ ((SinhVienWebCapToc) o).getDiaChi() + "\t Web cấp tốc \t"
							+ "x \t x \t"
							+ ((SinhVienWebCapToc) o).getDiemLP2() + "\t"
							+ ((SinhVienWebCapToc) o).getDiemLP3() + "\t"
							+ "x \t x \t x \t"
							+ ((SinhVienWebCapToc) o).tinhDTB() + "\t"
							+ ((SinhVienWebCapToc) o).xepLoaiSV());
				} else {

					if (o instanceof SinhVienJavaCapToc) {

						System.out.println((++i) + "\t" 
								+ ((SinhVienJavaCapToc) o).getHoSV() + " " + ((SinhVienJavaCapToc) o).getTenSV() + "\t"
										+ ((SinhVienJavaCapToc) o).getNamSinh() + "\t\t"
										+ ((SinhVienJavaCapToc) o).getDiaChi() + "\t Java cấp tốc \t"
										+ "x \t x \t x \t x \t"
										+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\t"
										+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\t"
										+ "x \t"
										+ ((SinhVienJavaCapToc) o).tinhDTB() + "\t"
										+ ((SinhVienJavaCapToc) o).xepLoaiSV());
					}
				}
			}

		}
		System.out.println("******************************************************");
	}

	public static void SVGioi() {
		int i = 0;
		
		System.out.println("\t\t\t ***** Danh Sách Sinh Viên Giỏi *****");
		System.out.println("STT \t Họ tên \t Năm sinh \t Địa chỉ \t lớp \t  Điểm trung bình \t Xếp loại");
		System.out.println("\t\t\t ------------------------------------");
		String msg = "";
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDTB() > 8.5) {
					msg = "**** Sinh Viên Lớp Dài Hạn đạt loại Giỏi ***** \n";
					System.out.println((++i) + "\t" 
							+ ((SinhVienDaiHan) o).getHoSV() + " " + ((SinhVienDaiHan) o).getTenSV() + "\t"
							+ ((SinhVienDaiHan) o).getNamSinh() + "\t"
							+ ((SinhVienDaiHan) o).getDiaChi() + "\t Dài hạn \t"
							+ ((SinhVienDaiHan) o).tinhDTB() + "\t" 
							+ ((SinhVienDaiHan) o).xepLoaiSV());
				}
			} else {
				if (o instanceof SinhVienWebCapToc) {
					if (((SinhVienWebCapToc) o).tinhDTB() > 8.5) {
						msg = "**** Sinh Viên lớp Web Cấp Tốc đạt loại Giỏi ***** \n";
						System.out.println((++i) + "\t" 
								+ ((SinhVienWebCapToc) o).getHoSV() + " " + ((SinhVienWebCapToc) o).getTenSV() + "\t"
								+ ((SinhVienWebCapToc) o).getNamSinh() + "\t"
								+ ((SinhVienWebCapToc) o).getDiaChi() + "\t Web cấp tốc \t"
								+ ((SinhVienWebCapToc) o).tinhDTB() + "\t"
								+ ((SinhVienWebCapToc) o).xepLoaiSV());
					}
				} else {

					if (o instanceof SinhVienJavaCapToc) {
						if (((SinhVienJavaCapToc) o).tinhDTB() > 8.5) {
							msg = "**** Sinh Viên lớp Java Cấp Tốc đạt Loại Giỏi ***** \n";
							System.out.println((++i) + "\t"
									+ ((SinhVienJavaCapToc) o).getHoSV() + " " + ((SinhVienJavaCapToc) o).getTenSV() + "\t"
									+ ((SinhVienJavaCapToc) o).getNamSinh() + "\t"
									+ ((SinhVienJavaCapToc) o).getDiaChi() + "\t Java cấp tốc \t"
									+ ((SinhVienJavaCapToc) o).tinhDTB() + "\t"
									+ ((SinhVienJavaCapToc) o).xepLoaiSV());
						}
					}
				}
			}

		}
		System.out.println("******************************************************");
	}
	
	public static void SapXep() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int k = sc.nextInt();
		int i = 0;
		System.out.println("SẮP XẾP \n");
		if (k == 1) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien o1, SinhVien o2) {
					if (o1.tinhDTB() < o2.tinhDTB()) {
						return 1;
					} else if (o1.tinhDTB() > o2.tinhDTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for (SinhVien o : dsSinhVien) {

				System.out.println((++i) + "\t" 
						+ ((SinhVienDaiHan) o).getHoSV() + " " + ((SinhVienDaiHan) o).getTenSV() + "\t"
						+ ((SinhVienDaiHan) o).getNamSinh() + "\t" 
						+ ((SinhVienDaiHan) o).getDiaChi() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP0() + "\t"
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP2() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP3() + "\t"
						+ ((SinhVienDaiHan) o).getDiemLP4() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP5() + "\t" 
						+ ((SinhVienDaiHan) o).getDiemLP6() + "\t"
						+ ((SinhVienDaiHan) o).tinhDTB() + "\t" 
						+ ((SinhVienDaiHan) o).xepLoaiSV());

			}
		} else {
			if (k == 2) {
				Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
					@Override
					public int compare(SinhVien o1, SinhVien o2) {
						if (o1.tinhDTB() < o2.tinhDTB()) {
							return 1;
						} else if (o1.tinhDTB() > o2.tinhDTB()) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				for (SinhVien o : dsSinhVien) {

					System.out.println((++i) + "\t" 
							+ ((SinhVienWebCapToc) o).getHoSV() + "  " + ((SinhVienWebCapToc) o).getTenSV() + "\t"
							+ ((SinhVienWebCapToc) o).getNamSinh() + "\t"
							+ ((SinhVienWebCapToc) o).getDiaChi() + "\t"
							+ ((SinhVienWebCapToc) o).getDiemLP2() + "\t"
							+ ((SinhVienWebCapToc) o).getDiemLP3() + "\t"
							+ ((SinhVienWebCapToc) o).tinhDTB() + "\t"
							+ ((SinhVienWebCapToc) o).xepLoaiSV());
				}

			} else {
				if (k == 3) {
					Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
						@Override
						public int compare(SinhVien o1, SinhVien o2) {
							if (o1.tinhDTB() < o2.tinhDTB()) {
								return 1;
							} else if (o1.tinhDTB() > o2.tinhDTB()) {
								return -1;
							} else {
								return 0;
							}
						}
					});

					for (SinhVien o : dsSinhVien) {

						System.out.println((++i) + "\t" 
								+ ((SinhVienJavaCapToc) o).getHoSV() + " " + ((SinhVienJavaCapToc) o).getTenSV() + "\t"
								+ ((SinhVienJavaCapToc) o).getNamSinh() + "\t"
								+ ((SinhVienJavaCapToc) o).getDiaChi() + "\t"
								+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\t"
								+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\t"
								+ ((SinhVienJavaCapToc) o).tinhDTB() + "\t"
								+ ((SinhVienJavaCapToc) o).xepLoaiSV());
					}

				} else {
					System.out.println(" Bạn phải nhập trong khoảng từ 1 đến 3. hãy nhập lại !!!");
				}
			}
		}

	}
}