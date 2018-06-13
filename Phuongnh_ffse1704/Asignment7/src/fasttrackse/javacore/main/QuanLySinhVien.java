/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::          THIS IS QUAN LY SINH VIEN PROGRAM MADE BY ME          :*/
/*::        	 Executable : Nguyễn Hoàng Phương			        :*/
/*::        	 Date : 12-06-2018							        :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
package fasttrackse.javacore.main;

import java.text.DecimalFormat;
import java.util.*;

import fasttrackse.javacore.entity.*;
import fasttrackse.javacore.util.*;

public class QuanLySinhVien {

	static int N;
	static Scanner myInput = new Scanner(System.in);
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	// static ArrayList<SinhVienDaiHan> dsDaiHan = new ArrayList<SinhVienDaiHan>();
	// static ArrayList<SinhVienWebCapToc> dsWeb = new
	// ArrayList<SinhVienWebCapToc>();
	// static ArrayList<SinhVienJavaCapToc> dsJava = new
	// ArrayList<SinhVienJavaCapToc>();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int N = 0;
		while (N != 5) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+--------------------------------------+");
				System.out.println("|1.Nhập danh sách sinh viên            |");
				System.out.println("|2.Xuất thông tin danh sách sinh viên  |");
				System.out.println("|3.Danh sách sinh viên có học lực giỏi |");
				System.out.println("|4.Sắp xếp sinh viên theo ABC          |");
				System.out.println("|5.Sắp xếp sinh viên theo điểm         |");
				System.out.println("|6.Kết Thúc                            |");
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
					sapXepABC();

				} else if (N == 5) {
					sapXepDiem();

				} else if (N == 6) {
					// Hiển thị thông báo kết thúc
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 6, nhập lại nhé bạn hiền!");
			} finally {
				if (N != 6) {
					backToMainMenu();
				}
			}
		}
	}

	public static void NhapThongTinSV() {
		Scanner nhaptt = new Scanner(System.in);
		System.out.println(">> Sinh viên thuộc chương trình nào <<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Sinh viên dài hạn                   |");
		System.out.println("|2.Sinh viên web cấp tốc               |");
		System.out.println("|3.Sinh viên java cấp tốc              |");
		System.out.println("+--------------------------------------+");
		int M = nhaptt.nextInt();
		if (M == 1) {
			System.out.println("Nhập số lượng sinh viên");
			int Sl = myInput.nextInt();
			for (int i = 0; i < Sl; i++) {
				System.out.println("Nhập thông tin Sinh viên thứ " + (i + 1));
				myInput.nextLine();

				System.out.println("Nhập họ đệm sinh viên ");
				String hoDemSV = myInput.nextLine();

				System.out.println("Nhập tên sinh viên");
				String tenSV = myInput.nextLine();

				System.out.println("Nhập địa chỉ sinh viên");
				String diaChiSV = myInput.nextLine();

				System.out.println("Nhập năm sinh sinh viên");
				int namSinhSV = myInput.nextInt();

				System.out.println("Điểm LP0");
				double diemLP0 = myInput.nextInt();

				System.out.println("Điểm LP1");
				double diemLP1 = myInput.nextInt();

				System.out.println("Điểm LP2");
				double diemLP2 = myInput.nextInt();

				System.out.println("Điểm LP3");
				double diemLP3 = myInput.nextInt();

				System.out.println("Điểm LP4");
				double diemLP4 = myInput.nextInt();

				System.out.println("Điểm LP5");
				double diemLP5 = myInput.nextInt();

				System.out.println("Điểm LP6");
				double diemLP6 = myInput.nextInt();
				
				dsSinhVien.add(new SinhVienDaiHan(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP0, diemLP1, diemLP2,
						diemLP3, diemLP4, diemLP5, diemLP6));

			}
		}
		if (M == 2) {
			System.out.println("Nhập số lượng sinh viên");
			int Sl2 = myInput.nextInt();
			for (int i = 0; i < Sl2; i++) {
				System.out.println("Nhập thông tin Sinh viên thứ " + (i + 1));
				myInput.nextLine();

				System.out.println("Nhập họ đệm sinh viên ");
				String hoDemSV = myInput.nextLine();

				System.out.println("Nhập tên sinh viên");
				String tenSV = myInput.nextLine();

				System.out.println("Nhập địa chỉ sinh viên");
				String diaChiSV = myInput.nextLine();

				System.out.println("Nhập năm sinh sinh viên");

				int namSinhSV = myInput.nextInt();

				System.out.println("Điểm LP2");
				double diemLP2 = myInput.nextInt();

				System.out.println("Điểm LP3");
				double diemLP3 = myInput.nextInt();

				
				dsSinhVien.add(new SinhVienWebCapToc(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP2, diemLP3));

			}
		}
		if (M == 3) {
			System.out.println("Nhập số lượng sinh viên");
			int Sl3 = myInput.nextInt();
			for (int i = 0; i < Sl3; i++) {
				System.out.println("Nhập thông tin Sinh viên thứ " + (i + 1));
				myInput.nextLine();

				System.out.println("Nhập họ đệm sinh viên ");
				String hoDemSV = myInput.nextLine();

				System.out.println("Nhập tên sinh viên");
				String tenSV = myInput.nextLine();

				System.out.println("Nhập địa chỉ sinh viên");
				String diaChiSV = myInput.nextLine();

				System.out.println("Nhập năm sinh sinh viên");

				int namSinhSV = myInput.nextInt();

				System.out.println("Điểm LP4");
				double diemLP4 = myInput.nextInt();

				System.out.println("Điểm LP5");
				double diemLP5 = myInput.nextInt();

				
				dsSinhVien.add(new SinhVienWebCapToc(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP4, diemLP5));

			}
		}

	}
	// in ra danh sách sinh viên

	public static void XuatThongTinSV() {

		int i = 0;
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				DecimalFormat formatter = new DecimalFormat("#,#.0");
				
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Dài Hạn ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
				,"Điểm LP0","Điểm LP1","Điểm LP2","Điểm LP3","Điểm LP4","Điểm LP5","Điểm LP6","ĐTB",
				"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienDaiHan) o).getTenSV() 
						,  ((SinhVienDaiHan) o).getNamSinhSV()
						,  ((SinhVienDaiHan) o).getDiaChiSV() 		   
						,  ((SinhVienDaiHan) o).getDiemLP0() 
						,  ((SinhVienDaiHan) o).getDiemLP1() 
						,  ((SinhVienDaiHan) o).getDiemLP2()  
						,  ((SinhVienDaiHan) o).getDiemLP3()  
						,  ((SinhVienDaiHan) o).getDiemLP4() 
						,  ((SinhVienDaiHan) o).getDiemLP5()  
						,  ((SinhVienDaiHan) o).getDiemLP6() 
						,  ((SinhVienDaiHan) o).tinhDTB()    
						,  ((SinhVienDaiHan) o).xepLoaiSV()+"\n");
				
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienWebCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Web Cấp Tốc ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP2","Điểm LP3","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienWebCapToc) o).getTenSV() 
						,  ((SinhVienWebCapToc) o).getNamSinhSV()
						,  ((SinhVienWebCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienWebCapToc) o).getDiemLP2()  
						,  ((SinhVienWebCapToc) o).getDiemLP3()  
						,  ((SinhVienWebCapToc) o).tinhDTB()    
						,  ((SinhVienWebCapToc) o).xepLoaiSV()+"\n");
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienJavaCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP4","Điểm LP5","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienJavaCapToc) o).getTenSV() 
						,  ((SinhVienJavaCapToc) o).getNamSinhSV()
						,  ((SinhVienJavaCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienJavaCapToc) o).getDiemLP4()  
						,  ((SinhVienJavaCapToc) o).getDiemLP5()  
						,  ((SinhVienJavaCapToc) o).tinhDTB()    
						,  ((SinhVienJavaCapToc) o).xepLoaiSV()+"\n");
			}
		}
	}
	// in ra danh sách sinh viên hs giỏi

	public static void SVGioi() {

		int i = 0;

		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
					DecimalFormat formatter = new DecimalFormat("#,###.0");
					System.out.println("**** Sinh Viên Lớp Dài Hạn đạt loại Giỏi ***** \n");
					System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
							,"Điểm LP0","Điểm LP1","Điểm LP2","Điểm LP3","Điểm LP4","Điểm LP5","Điểm LP6","ĐTB",
							"Xếp Loại");
							System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
									,((SinhVienDaiHan) o).getTenSV() 
									,  ((SinhVienDaiHan) o).getNamSinhSV()
									,  ((SinhVienDaiHan) o).getDiaChiSV() 		   
									,  ((SinhVienDaiHan) o).getDiemLP0() 
									,  ((SinhVienDaiHan) o).getDiemLP1() 
									,  ((SinhVienDaiHan) o).getDiemLP2()  
									,  ((SinhVienDaiHan) o).getDiemLP3()  
									,  ((SinhVienDaiHan) o).getDiemLP4() 
									,  ((SinhVienDaiHan) o).getDiemLP5()  
									,  ((SinhVienDaiHan) o).getDiemLP6() 
									,  ((SinhVienDaiHan) o).tinhDTB()    
									,  ((SinhVienDaiHan) o).xepLoaiSV()+"\n");
				}
			} else if (o instanceof SinhVienWebCapToc) {
				if (((SinhVienWebCapToc) o).tinhDTB() >= 8.5) {
					DecimalFormat formatter = new DecimalFormat("#,###.0");
					System.out.println("**** Sinh Viên Lớp Web Cấp Tốc đạt loại Giỏi ***** \n");
					System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
							,"Điểm LP2","Điểm LP3","ĐTB",
							"Xếp Loại");
					System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
							,((SinhVienWebCapToc) o).getTenSV() 
							,  ((SinhVienWebCapToc) o).getNamSinhSV()
							,  ((SinhVienWebCapToc) o).getDiaChiSV() 		   
							,  ((SinhVienWebCapToc) o).getDiemLP2()  
							,  ((SinhVienWebCapToc) o).getDiemLP3()  
							,  ((SinhVienWebCapToc) o).tinhDTB()    
							,  ((SinhVienWebCapToc) o).xepLoaiSV()+"\n");
				}

			} else if (o instanceof SinhVienJavaCapToc) {
				if (((SinhVienJavaCapToc) o).tinhDTB() >= 8.5) {
					DecimalFormat formatter = new DecimalFormat("#,###.0");
					System.out.println("*********************** Sinh Viên Lớp Java Cấp Tốc đạt loại Giỏi ************************* \n");
					System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
							,"Điểm LP4","Điểm LP5","ĐTB",
							"Xếp Loại");
					System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
							,((SinhVienJavaCapToc) o).getTenSV() 
							,  ((SinhVienJavaCapToc) o).getNamSinhSV()
							,  ((SinhVienJavaCapToc) o).getDiaChiSV() 		   
							,  ((SinhVienJavaCapToc) o).getDiemLP4()  
							,  ((SinhVienJavaCapToc) o).getDiemLP5()  
							,  ((SinhVienJavaCapToc) o).tinhDTB()    
							,  ((SinhVienJavaCapToc) o).xepLoaiSV()+"\n");
				}
			}
		}
		System.out.println("******************************************************");
	}

	// in ra danh sách sinh viên theo điểm
	public static void sapXepDiem() {
		Collections.sort(dsSinhVien, SVComparator.sapXepTheoDTB);
		int i = 0;
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Dài Hạn ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
				,"Điểm LP0","Điểm LP1","Điểm LP2","Điểm LP3","Điểm LP4","Điểm LP5","Điểm LP6","ĐTB",
				"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienDaiHan) o).getTenSV() 
						,  ((SinhVienDaiHan) o).getNamSinhSV()
						,  ((SinhVienDaiHan) o).getDiaChiSV() 		   
						,  ((SinhVienDaiHan) o).getDiemLP0() 
						,  ((SinhVienDaiHan) o).getDiemLP1() 
						,  ((SinhVienDaiHan) o).getDiemLP2()  
						,  ((SinhVienDaiHan) o).getDiemLP3()  
						,  ((SinhVienDaiHan) o).getDiemLP4() 
						,  ((SinhVienDaiHan) o).getDiemLP5()  
						,  ((SinhVienDaiHan) o).getDiemLP6() 
						,  ((SinhVienDaiHan) o).tinhDTB()    
						,  ((SinhVienDaiHan) o).xepLoaiSV()+"\n");
				
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienWebCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Web Cấp Tốc ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP2","Điểm LP3","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienWebCapToc) o).getTenSV() 
						,  ((SinhVienWebCapToc) o).getNamSinhSV()
						,  ((SinhVienWebCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienWebCapToc) o).getDiemLP2()  
						,  ((SinhVienWebCapToc) o).getDiemLP3()  
						,  ((SinhVienWebCapToc) o).tinhDTB()    
						,  ((SinhVienWebCapToc) o).xepLoaiSV()+"\n");
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienJavaCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP4","Điểm LP5","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienJavaCapToc) o).getTenSV() 
						,  ((SinhVienJavaCapToc) o).getNamSinhSV()
						,  ((SinhVienJavaCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienJavaCapToc) o).getDiemLP4()  
						,  ((SinhVienJavaCapToc) o).getDiemLP5()  
						,  ((SinhVienJavaCapToc) o).tinhDTB()    
						,  ((SinhVienJavaCapToc) o).xepLoaiSV()+"\n");
			}
		}
	}
	// in ra danh sách sinh viên theo bảng chữ cái

	public static void sapXepABC() {
		Collections.sort(dsSinhVien, SVComparator.sapXepTheoABC);

		int i = 0;
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Dài Hạn ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
				,"Điểm LP0","Điểm LP1","Điểm LP2","Điểm LP3","Điểm LP4","Điểm LP5","Điểm LP6","ĐTB",
				"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienDaiHan) o).getTenSV() 
						,  ((SinhVienDaiHan) o).getNamSinhSV()
						,  ((SinhVienDaiHan) o).getDiaChiSV() 		   
						,  ((SinhVienDaiHan) o).getDiemLP0() 
						,  ((SinhVienDaiHan) o).getDiemLP1() 
						,  ((SinhVienDaiHan) o).getDiemLP2()  
						,  ((SinhVienDaiHan) o).getDiemLP3()  
						,  ((SinhVienDaiHan) o).getDiemLP4() 
						,  ((SinhVienDaiHan) o).getDiemLP5()  
						,  ((SinhVienDaiHan) o).getDiemLP6() 
						,  ((SinhVienDaiHan) o).tinhDTB()    
						,  ((SinhVienDaiHan) o).xepLoaiSV()+"\n");
				
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienWebCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.println("*********************************  Danh Sách Sinh Viên Lớp Web Cấp Tốc ************************************* \n");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP2","Điểm LP3","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienWebCapToc) o).getTenSV() 
						,  ((SinhVienWebCapToc) o).getNamSinhSV()
						,  ((SinhVienWebCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienWebCapToc) o).getDiemLP2()  
						,  ((SinhVienWebCapToc) o).getDiemLP3()  
						,  ((SinhVienWebCapToc) o).tinhDTB()    
						,  ((SinhVienWebCapToc) o).xepLoaiSV()+"\n");
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienJavaCapToc) {
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				System.out.printf( "\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-7s %-20s","STT","Họ và Tên","Năm Sinh","Địa Chỉ"
						,"Điểm LP4","Điểm LP5","ĐTB",
						"Xếp Loại");
				System.out.printf("\n"+"%-10s %-25s %-12s %-15s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-20s %-2.1f", (i++) 
						,((SinhVienJavaCapToc) o).getTenSV() 
						,  ((SinhVienJavaCapToc) o).getNamSinhSV()
						,  ((SinhVienJavaCapToc) o).getDiaChiSV() 		   
						,  ((SinhVienJavaCapToc) o).getDiemLP4()  
						,  ((SinhVienJavaCapToc) o).getDiemLP5()  
						,  ((SinhVienJavaCapToc) o).tinhDTB()    
						,  ((SinhVienJavaCapToc) o).xepLoaiSV()+"\n");
			}
		}
	}

	public static void ketThuc() {
		System.out.print("!!!!!!!!!!!!!  KẾT THÚC !!!!!!!!!!!!");
	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("\n"+"Ấn Enter để về menu chính");
		myInput.nextLine();
	}
}
