package fasttrackse.javacore.main;

import java.util.*;

import fasttrackse.javacore.entity.*;
import fasttrackse.javacore.util.*;

public class QuanLySinhVien {

	static int N;
	static Scanner myInput = new Scanner(System.in);
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static ArrayList<SinhVienDaiHan> dsDaiHan = new ArrayList<SinhVienDaiHan>();
	static ArrayList<SinhVienWebCapToc> dsWeb = new ArrayList<SinhVienWebCapToc>();
	static ArrayList<SinhVienJavaCapToc> dsJava = new ArrayList<SinhVienJavaCapToc>();

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
		System.out.println("|3.Sinh viên java cấp tốc             |");
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
				dsDaiHan.add(new SinhVienDaiHan(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP0, diemLP1, diemLP2, diemLP3,
						diemLP4, diemLP5, diemLP6));
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

				dsWeb.add(new SinhVienWebCapToc(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP2, diemLP3));
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

				dsWeb.add(new SinhVienWebCapToc(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP4, diemLP5));
				dsSinhVien.add(new SinhVienWebCapToc(hoDemSV, tenSV, diaChiSV, namSinhSV, diemLP4, diemLP5));

			}
		}

	}
	// in ra danh sách sinh viên theo điểm
		public static void sapXepDiem() {
			Collections.sort(dsSinhVien, SVComparator.sapXepTheoDTB);
			String msg = "";
			int i = 0;
			for (SinhVien o : dsSinhVien) {
				if (o instanceof SinhVienDaiHan) {
					msg = "**** Sinh Viên Dài Hạn ***** \n";
					System.out.println(o);
					System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoDemSV()
							+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + " - năm Sinh: "
							+ ((SinhVienDaiHan) o).getNamSinhSV() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChiSV()
							+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
							+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
							+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n2 - Điểm LP4: "
							+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
							+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
							+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
				}
			}
			for (SinhVien o : dsSinhVien) {
				if (o instanceof SinhVienWebCapToc) {
					msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
					System.out.println(o);
					System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: "
							+ ((SinhVienWebCapToc) o).getHoDemSV() + "\n - Tên Sinh Viên: "
							+ ((SinhVienWebCapToc) o).getTenSV() + " - năm Sinh: " + ((SinhVienWebCapToc) o).getNamSinhSV()
							+ "\n - Địa Chỉ: " + ((SinhVienWebCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
							+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
							+ ((SinhVienWebCapToc) o).getDiemLP3());
				}
			}
			for (SinhVien o : dsSinhVien) {
				if (o instanceof SinhVienJavaCapToc) {
					msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
					System.out.println(o);
					System.out.println(
							"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoDemSV()
									+ "\n - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + " - năm Sinh: "
									+ ((SinhVienJavaCapToc) o).getNamSinhSV() + "\n - Địa Chỉ: "
									+ ((SinhVienJavaCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
									+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
									+ ((SinhVienJavaCapToc) o).getDiemLP5());
				}
			
		}
		}
		// in ra danh sách sinh viên theo bảng chữ cái

		public static void sapXepABC() {
			Collections.sort(dsSinhVien, SVComparator.sapXepTheoABC);
			
				String msg = "";
				int i = 0;
				for (SinhVien o : dsSinhVien) {
					if (o instanceof SinhVienDaiHan) {
						msg = "**** Sinh Viên Dài Hạn ***** \n";
						System.out.println(o);
						System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoDemSV()
								+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + " - năm Sinh: "
								+ ((SinhVienDaiHan) o).getNamSinhSV() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChiSV()
								+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
								+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
								+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n2 - Điểm LP4: "
								+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
								+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
								+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
					}
				}
				for (SinhVien o : dsSinhVien) {
					if (o instanceof SinhVienWebCapToc) {
						msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
						System.out.println(o);
						System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: "
								+ ((SinhVienWebCapToc) o).getHoDemSV() + "\n - Tên Sinh Viên: "
								+ ((SinhVienWebCapToc) o).getTenSV() + " - năm Sinh: " + ((SinhVienWebCapToc) o).getNamSinhSV()
								+ "\n - Địa Chỉ: " + ((SinhVienWebCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
								+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
								+ ((SinhVienWebCapToc) o).getDiemLP3());
					}
				}
				for (SinhVien o : dsSinhVien) {
					if (o instanceof SinhVienJavaCapToc) {
						msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
						System.out.println(o);
						System.out.println(
								"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoDemSV()
										+ "\n - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + " - năm Sinh: "
										+ ((SinhVienJavaCapToc) o).getNamSinhSV() + "\n - Địa Chỉ: "
										+ ((SinhVienJavaCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
										+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
										+ ((SinhVienJavaCapToc) o).getDiemLP5());
					}
				}
		}

		public static void ketThuc() {
			System.out.print("KẾT THÚC !!!!!!!!!!!!");
		}

		public static void backToMainMenu() {
			myInput.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myInput.nextLine();
		}
	// in ra danh sách sinh viên hs giỏi

	public static void SVGioi() {

		int i = 0;
		
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
					System.out.println("**** Sinh Viên Lớp Dài Hạn đạt loại Giỏi ***** \n");
					System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: "
							+ ((SinhVienDaiHan) o).getHoDemSV() + "\n - Tên Sinh Viên: "
							+ ((SinhVienDaiHan) o).getTenSV() + "\n - năm Sinh: " + ((SinhVienDaiHan) o).getNamSinhSV()
							+ " - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChiSV() + "\n - Điểm LP0: "
							+ ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: " + ((SinhVienDaiHan) o).getDiemLP1()
							+ "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2() + "\n - Điểm LP3: "
							+ ((SinhVienDaiHan) o).getDiemLP3() + "\n - Điểm LP4: " + ((SinhVienDaiHan) o).getDiemLP4()
							+ "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5() + "\n - Điểm LP6: "
							+ ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
							+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
				}
			} else if (o instanceof SinhVienWebCapToc) {
					if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
						System.out.println("**** Sinh Viên Lớp Web cấp tốc đạt loại Giỏi ***** \n");
						System.out.println(
								"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoDemSV()
										+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
										+ ((SinhVienWebCapToc) o).getNamSinhSV() + "\n - Địa Chỉ: "
										+ ((SinhVienWebCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
										+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
										+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
										+ ((SinhVienWebCapToc) o).tinhDTB() + "\n - Xếp Loại: "
										+ ((SinhVienWebCapToc) o).xepLoaiSV());
					}
				
				} else if (o instanceof SinhVienJavaCapToc) {
						if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
							System.out.println("**** Sinh Viên Lớp Java cấp tốc đạt loại Giỏi ***** \n");
							System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: "
									+ ((SinhVienJavaCapToc) o).getHoDemSV() + "\n - Tên Sinh Viên: "
									+ ((SinhVienJavaCapToc) o).getTenSV() + "\n - năm Sinh: "
									+ ((SinhVienJavaCapToc) o).getNamSinhSV() + "\n - Địa Chỉ: "
									+ ((SinhVienJavaCapToc) o).getDiaChiSV() + "\n - Điểm LP4: "
									+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP5: "
									+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
									+ ((SinhVienJavaCapToc) o).tinhDTB() + "\n - Xếp Loại: "
									+ ((SinhVienJavaCapToc) o).xepLoaiSV());
						}
					}
				}
			System.out.println("******************************************************");
			}

		

	
	// in ra danh sách sinh viên

	public static void XuatThongTinSV() {
		
		int i = 0;
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				System.out.println( "**** Sinh Viên Dài Hạn ***** \n");
				System.out.println(o);
				System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoDemSV()
						+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + " - năm Sinh: "
						+ ((SinhVienDaiHan) o).getNamSinhSV() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChiSV()
						+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
						+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n2 - Điểm LP4: "
						+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
						+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienWebCapToc) {
				System.out.println( "**** Sinh Viên Web Cấp Tốc ***** \n");
				System.out.println(o);
				System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: "
						+ ((SinhVienWebCapToc) o).getHoDemSV() + "\n - Tên Sinh Viên: "
						+ ((SinhVienWebCapToc) o).getTenSV() + " - năm Sinh: " + ((SinhVienWebCapToc) o).getNamSinhSV()
						+ "\n - Địa Chỉ: " + ((SinhVienWebCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
						+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
						+ ((SinhVienWebCapToc) o).getDiemLP3());
			}
		}
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienJavaCapToc) {
				System.out.println( "**** Sinh Viên Java Cấp Tốc ***** \n");
				System.out.println(o);
				System.out.println(
						"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoDemSV()
								+ "\n - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + " - năm Sinh: "
								+ ((SinhVienJavaCapToc) o).getNamSinhSV() + "\n - Địa Chỉ: "
								+ ((SinhVienJavaCapToc) o).getDiaChiSV() + "\n - Điểm LP2: "
								+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
								+ ((SinhVienJavaCapToc) o).getDiemLP5());
			}
		}
	}
}
// public static void main(String[] args) {
//
//
// System.out.println(">> Menu Chương Trình <<");
// System.out.println("+--------------------------------------+");
// System.out.println("|1.Nhập danh sách sinh viên |");
// System.out.println("|2.Xuất thông tin danh sách sinh viên |");
// System.out.println("|3.Danh sách sinh viên có học lực giỏi |");
// System.out.println("|4.Sắp xếp sinh viên theo điểm |");
// System.out.println("|5.Kết Thúc |");
// System.out.println("+--------------------------------------+");
// System.out.println("Mời Bạn Chọn Chức Năng");
// N = myInput.nextInt();
// if (N == 1) {
// NhapThongTinSV();
// } else if (N == 2) {
// XuatThongTinSV();
//// } else if (N == 3) {
//// SVGioi();
//// } else if (N == 4) {
//// SapXep();
// } else {
// System.exit(0);
// }
//
// }
