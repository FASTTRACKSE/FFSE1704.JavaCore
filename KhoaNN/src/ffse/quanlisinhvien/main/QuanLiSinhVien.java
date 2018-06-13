package ffse.quanlisinhvien.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import ffse.quanlisinhvien.enity.*;
import java.util.Comparator;

public class QuanLiSinhVien {
	
	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while(true){
			System.out.println(">>              Menu Chương Trình             <<");
			System.out.println("+----------------------------------------------+");
			System.out.println("| 1 : Nhập Danh Sách Sinh Viên                 |");
			System.out.println("| 2 : Xuất thông tin danh sách sinh viên       |");
			System.out.println("| 3 : Xuất danh sách sinh viên có học lực giỏi |");
			System.out.println("| 4 : Sắp xếp danh sách sinh viên theo điểm    |");
			System.out.println("| 5 : Kết Thúc                                 |");
			System.out.println("+----------------------------------------------+");
			System.out.print(" >> Mời Bạn Chọn : << ");
			
			Scanner scanner = new Scanner(System.in);
			int answer = scanner.nextInt();
			if(answer == 1 ) {
				NhapDanhSachSinhVien();
			}else if (answer == 2) {
				InThongTinSinhVien();
			}else if (answer == 3) {
				InThongTinSinhVienGioi();
			}else if (answer == 4) {
				SapXepSinhVien();
			}else if (answer == 5) {
				System.exit(0);
			}
			}
		}

	private static void NhapDanhSachSinhVien() {
		Scanner n = new Scanner(System.in);
		System.out.println(">> Sinh viên thuộc chương trình nào <<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Sinh viên dài hạn                   |");
		System.out.println("|2.Sinh viên web cấp tốc               |");
		System.out.println("|3.Sinh viên java cấp tốc              |");
		System.out.println("+--------------------------------------+");
		int k = n.nextInt();
		if (k == 1) {
			System.out.println("Nhập thông tin Sinh Viên Dài Hạn");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			N = myInput.nextInt();
			
			for (int i = 0 ; i < N ; i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String hoTen = myInput.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = myInput.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.print("Nhập điểm LP0: ");
				int LP0 = myInput.nextInt();
				System.out.print("Nhập điểm LP1: ");
				int LP1 = myInput.nextInt();
				System.out.print("Nhập điểm LP2: ");
				int LP2 = myInput.nextInt();
				System.out.print("Nhập điểm LP3: ");
				int LP3 = myInput.nextInt();
				System.out.print("Nhập điểm LP4: ");
				int LP4 = myInput.nextInt();
				System.out.print("Nhập điểm LP5: ");
				int LP5 = myInput.nextInt();
				System.out.print("Nhập điểm LP6: ");
				int LP6 = myInput.nextInt();

				System.out.println("------------------------------------------------------------------");
				
				dsSinhVien.add(new SinhVienDaiHan( hoTen, namSinh, diaChi, LP0, LP1, LP2, LP3,
						LP4, LP5, LP6));
			}
			
		}else {
			if (k == 2) {
				System.out.println("Nhập thông tin Sinh Viên Web Cấp Tốc");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Sinh viên: ");
				N = myInput.nextInt();
				// ArrayList<SinhVienWebCapToc> svWeb = new ArrayList<SinhVienWebCapToc>();
				for (int i = 0; i < N; i++) {
					System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
					myInput.nextLine();


					System.out.print("Nhập tên sinh viên: ");
					String hoTen = myInput.nextLine();

					System.out.print("Nhập năm sinh sinh viên: ");
					int namSinh = myInput.nextInt();

					System.out.print("Nhập địa chỉ sinh viên: ");
					myInput.nextLine();
					String diaChi = myInput.nextLine();

					System.out.print("Nhập điểm LP2: ");
					int diemLP2 = myInput.nextInt();
					System.out.print("Nhập điểm LP3: ");
					int diemLP3 = myInput.nextInt();

					System.out.println("------------------------------------------------------------------");
					
					dsSinhVien.add(new SinhVienWebCapToc(hoTen,  namSinh, diaChi, diemLP2, diemLP3));
				
			
			}
			
		}else {
			if (k == 3) {
				System.out.println("Nhập thông tin Sinh Viên Java Cấp Tốc");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Sinh viên: ");
				N = myInput.nextInt();
				// ArrayList<SinhVienJavaCapToc> svJava = new ArrayList<SinhVienJavaCapToc>();
				for (int i = 0; i < N; i++) {
					System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
					myInput.nextLine();
					System.out.print("Nhập tên sinh viên: ");
					String hoTen = myInput.nextLine();

					System.out.print("Nhập năm sinh sinh viên: ");
					int namSinh = myInput.nextInt();

					System.out.print("Nhập địa chỉ sinh viên: ");
					myInput.nextLine();
					String diaChi = myInput.nextLine();

					System.out.print("Nhập điểm LP4: ");
					int diemLP4 = myInput.nextInt();
					System.out.print("Nhập điểm LP5: ");
					int diemLP5 = myInput.nextInt();

					System.out.println("------------------------------------------------------------------");
					
					dsSinhVien.add(new SinhVienJavaCapToc(hoTen,  namSinh, diaChi, diemLP4, diemLP5));
				}
			} else {
				System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
			}
		}
	}



	}

	private static void InThongTinSinhVien() {
		int i = 0;
		String msg = "";
		for (SinhVien x : dsSinhVien) {
			if (x instanceof SinhVienDaiHan) {
				msg = "**** Sinh Viên Dài Hạn ***** \n";
				System.out.println("Sinh Viên  Thứ " + (++i)+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) x).getHoTen() + "\n - năm Sinh: "
						+ ((SinhVienDaiHan) x).getNamSinh() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) x).getDiaChi()
						+ "\n - Điểm LP0: " + ((SinhVienDaiHan) x).getLP0() + "\n - Điểm LP1: "
						+ ((SinhVienDaiHan) x).getLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) x).getLP2()
						+ "\n - Điểm LP3: " + ((SinhVienDaiHan) x).getLP3() + "\n - Điểm LP4: "
						+ ((SinhVienDaiHan) x).getLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) x).getLP5()
						+ "\n - Điểm LP6: " + ((SinhVienDaiHan) x).getLP6() + "\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) x).tinhDiemTb() + "\n - Xếp Loại: " + ((SinhVienDaiHan) x).XepLoai());
			}else {
				if (x instanceof SinhVienWebCapToc) {
					msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
					System.out.println(
							"Sinh Viên  Thứ " + (++i)
									+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) x).getHoTen() 
									+ "\n - năm Sinh: "    + ((SinhVienWebCapToc) x).getNamSinh() 
									+ "\n - Địa Chỉ: "     + ((SinhVienWebCapToc) x).getDiaChi() 
									+ "\n - Điểm LP2: "    + ((SinhVienWebCapToc) x).getLP2() 
									+ "\n - Điểm LP3: "    + ((SinhVienWebCapToc) x).getLP3() 
									+ "\n - Điểm Trung Bình: "+ ((SinhVienWebCapToc) x).tinhDiemTb() 
									+ "\n - Xếp Loại: "    + ((SinhVienWebCapToc) x).XepLoai());
				
		}else {

			if (x instanceof SinhVienJavaCapToc) {
				msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
				System.out.println(
						"Sinh Viên  Thứ " + (++i) 
								+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) x).getHoTen() 
								+ "\n - năm Sinh: "    + ((SinhVienJavaCapToc) x).getNamSinh() 
								+ "\n - Địa Chỉ: "     + ((SinhVienJavaCapToc) x).getDiaChi() 
								+ "\n - Điểm LP4: "    + ((SinhVienJavaCapToc) x).getLP4() 
								+ "\n - Điểm LP5: "    + ((SinhVienJavaCapToc) x).getLP5() 
								+ "\n - Điểm Trung Bình: "+ ((SinhVienJavaCapToc) x).tinhDiemTb() 
								+ "\n - Xếp Loại: "    + ((SinhVienJavaCapToc) x).XepLoai());
			}
		}
		}
	

		}
System.out.println("******************************************************");
}

		

	private static void InThongTinSinhVienGioi() {
		
		int i = 0;
		String msg = "";
		for (SinhVien x : dsSinhVien) {
			if (x instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) x).tinhDiemTb() >= 8.5) {
					msg = "**** Sinh Viên Lớp Dài Hạn đạt loại Giỏi ***** \n";
					System.out.println("Sinh Viên  Thứ " + (++i) 
							+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) x).getHoTen() + "\n - năm Sinh: "
							+ ((SinhVienDaiHan) x).getNamSinh() + " - Địa Chỉ: " + ((SinhVienDaiHan) x).getDiaChi()
							+ "\n - Điểm LP0: " + ((SinhVienDaiHan) x).getLP0() + "\n - Điểm LP1: "
							+ ((SinhVienDaiHan) x).getLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) x).getLP2()
							+ "\n - Điểm LP3: " + ((SinhVienDaiHan) x).getLP3() + "\n - Điểm LP4: "
							+ ((SinhVienDaiHan) x).getLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) x).getLP5()
							+ "\n - Điểm LP6: " + ((SinhVienDaiHan) x).getLP6() + "\n - Điểm Trung Bình: "
							+ ((SinhVienDaiHan) x).tinhDiemTb() + "\n - Xếp Loại: " + ((SinhVienDaiHan) x).XepLoai());
				}
			} else {
				if (x instanceof SinhVienWebCapToc) {
					if (((SinhVienWebCapToc) x).tinhDiemTb() >= 8.5) {
						msg = "**** Sinh Viên lớp Web Cấp Tốc đạt loại Giỏi ***** \n";
						System.out.println(
								"Sinh Viên  Thứ " + (++i) 
										+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) x).getHoTen() + "\n - năm Sinh: "
										+ ((SinhVienWebCapToc) x).getNamSinh() + "\n - Địa Chỉ: "
										+ ((SinhVienWebCapToc) x).getDiaChi() + "\n - Điểm LP2: "
										+ ((SinhVienWebCapToc) x).getLP2() + "\n - Điểm LP3: "
										+ ((SinhVienWebCapToc) x).getLP3() + "\n - Điểm Trung Bình: "
										+ ((SinhVienWebCapToc) x).tinhDiemTb() + "\n - Xếp Loại: "
										+ ((SinhVienWebCapToc) x).XepLoai());
					}
				} else {

					if (x instanceof SinhVienJavaCapToc) {
						if (((SinhVienJavaCapToc) x).tinhDiemTb() >= 8.5) {
							msg = "**** Sinh Viên lớp Java Cấp Tốc đạt Loại Giỏi ***** \n";
							System.out.println("Sinh Viên  Thứ " + (++i)  + "\n - Tên Sinh Viên: "
									+ ((SinhVienJavaCapToc) x).getHoTen() + "\n - năm Sinh: "
									+ ((SinhVienJavaCapToc) x).getNamSinh() + "\n - Địa Chỉ: "
									+ ((SinhVienJavaCapToc) x).getDiaChi() + "\n - Điểm LP4: "
									+ ((SinhVienJavaCapToc) x).getLP4() + "\n - Điểm LP5: "
									+ ((SinhVienJavaCapToc) x).getLP5() + "\n - Điểm Trung Bình: "
									+ ((SinhVienJavaCapToc) x).tinhDiemTb() + "\n - Xếp Loại: "
									+ ((SinhVienJavaCapToc) x).XepLoai());
						}
					}
				}
			}
		}
	}

	private static void SapXepSinhVien() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int b = sc.nextInt();
		int i=0;
		System.out.println("SẮP XẾP \n");
		if (b == 1) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien x1, SinhVien x2) {
					if (x1.tinhDiemTb() < x2.tinhDiemTb()) {
						return 1;
					} else if (x1.tinhDiemTb() > x2.tinhDiemTb()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for (SinhVien x : dsSinhVien) {

				System.out.println("Sinh Viên  Thứ " + (++i) 
						+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) x).getHoTen() + " - năm Sinh: "
						+ ((SinhVienDaiHan) x).getNamSinh() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) x).getDiaChi()
						+ "\n - Điểm LP0: " + ((SinhVienDaiHan) x).getLP0() + "\n - Điểm LP1: "
						+ ((SinhVienDaiHan) x).getLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) x).getLP2()
						+ "\n - Điểm LP3: " + ((SinhVienDaiHan) x).getLP3() + "\n - Điểm LP4: "
						+ ((SinhVienDaiHan) x).getLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) x).getLP5()
						+ "\n - Điểm LP6: " + ((SinhVienDaiHan) x).getLP6() + "\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) x).tinhDiemTb() + "\n - Xếp Loại: " + ((SinhVienDaiHan) x).XepLoai());

			}
		} else {
			if (b == 2) {
				Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
					@Override
					public int compare(SinhVien x1, SinhVien x2) {
						if (x1.tinhDiemTb() < x2.tinhDiemTb()) {
							return 1;
						} else if (x1.tinhDiemTb() > x2.tinhDiemTb()) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				for (SinhVien x : dsSinhVien) {

					System.out.println(
							"Sinh Viên  Thứ " + (++i) 
									+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) x).getHoTen() + "\n - năm Sinh: "
									+ ((SinhVienWebCapToc) x).getNamSinh() + "\n - Địa Chỉ: "
									+ ((SinhVienWebCapToc) x).getDiaChi() + "\n - Điểm LP2: "
									+ ((SinhVienWebCapToc) x).getLP2() + "\n - Điểm LP3: "
									+ ((SinhVienWebCapToc) x).getLP3() + "\n - Điểm Trung Bình: "
									+ ((SinhVienWebCapToc) x).tinhDiemTb() + "\n - Xếp Loại: "
									+ ((SinhVienWebCapToc) x).XepLoai());
				}

			} else {
				if (b == 3) {
					Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
						@Override
						public int compare(SinhVien x1, SinhVien x2) {
							if (x1.tinhDiemTb() < x2.tinhDiemTb()) {
								return 1;
							} else if (x1.tinhDiemTb() > x2.tinhDiemTb()) {
								return -1;
							} else {
								return 0;
							}
						}
					});

					for (SinhVien x : dsSinhVien) {

						System.out.println(
								"Sinh Viên  Thứ " + (++i) 
										+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) x).getHoTen() + "\n - năm Sinh: "
										+ ((SinhVienJavaCapToc) x).getNamSinh() + "\n - Địa Chỉ: "
										+ ((SinhVienJavaCapToc) x).getDiaChi() + "\n - Điểm LP2: "
										+ ((SinhVienJavaCapToc) x).getLP4() + "\n - Điểm LP3: "
										+ ((SinhVienJavaCapToc) x).getLP5() + "\n - Điểm Trung Bình: "
										+ ((SinhVienJavaCapToc) x).tinhDiemTb() + "\n - Xếp Loại: "
										+ ((SinhVienJavaCapToc) x).XepLoai());
					}

				} else {
					System.out.println(" Bạn phải nhập trong khoảng từ 1 đến 3. hãy nhập lại !!!");
				}
			}
		}
		

	}
}
		
	

	



