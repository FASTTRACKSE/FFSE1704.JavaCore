/**
 * 
 */
package ffse.quanlysinhvien.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ffse.quanlysinhvien.entity.*;

/**
 * @author Support
 *
 */
public class QuanLySinhVien {

	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		System.out.println(">> Sinh viên thuộc chương trình nào <<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Sinh viên dài hạn                   |");
		System.out.println("|2.Sinh viên web cấp tốc               |");
		System.out.println("|3.Sinh viên java cấp tốc             |");
		System.out.println("+--------------------------------------+");
		int M = n.nextInt();
		if (M == 1) {
			System.out.println("Nhập thông tin Sinh Viên Dài Hạn");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			N = myInput.nextInt();
			// ArrayList<SinhVienDaiHan> svDaiHan = new ArrayList<SinhVienDaiHan>();
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

				System.out.print("Nhập điểm LP0: ");
				double diemLP0 = myInput.nextInt();
				System.out.print("Nhập năm LP1: ");
				double diemLP1 = myInput.nextInt();
				System.out.print("Nhập năm LP2: ");
				double diemLP2 = myInput.nextInt();
				System.out.print("Nhập năm LP3: ");
				double diemLP3 = myInput.nextInt();
				System.out.print("Nhập năm LP4: ");
				double diemLP4 = myInput.nextInt();
				System.out.print("Nhập năm LP5: ");
				double diemLP5 = myInput.nextInt();
				System.out.print("Nhập năm LP6: ");
				double diemLP6 = myInput.nextInt();

				System.out.println("------------------------------------------------------------------");
				dsSinhVien.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, diemLP0, diemLP1, diemLP2, diemLP3,
						diemLP4, diemLP5, diemLP6));
			}
		} else {
			if (M == 2) {
				System.out.println("Nhập thông tin Sinh Viên Web Cấp Tốc");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Sinh viên: ");
				N = myInput.nextInt();
				// ArrayList<SinhVienWebCapToc> svWeb = new ArrayList<SinhVienWebCapToc>();
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

					System.out.print("Nhập năm LP2: ");
					double diemLP2 = myInput.nextInt();
					System.out.print("Nhập năm LP3: ");
					double diemLP3 = myInput.nextInt();

					System.out.println("------------------------------------------------------------------");
					dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, diemLP2, diemLP3));
				}
			} else {
				if (M == 3) {
					System.out.println("Nhập thông tin Sinh Viên Java Cấp Tốc");
					System.out.println("+------------------------------+");
					System.out.print("Nhập Số Lượng Sinh viên: ");
					N = myInput.nextInt();
					// ArrayList<SinhVienJavaCapToc> svJava = new ArrayList<SinhVienJavaCapToc>();
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

						System.out.print("Nhập năm LP4: ");
						double diemLP4 = myInput.nextInt();
						System.out.print("Nhập năm LP5: ");
						double diemLP5 = myInput.nextInt();

						System.out.println("------------------------------------------------------------------");
						dsSinhVien.add(new SinhVienJavaCapToc(hoSV, tenSV, namSinh, diaChi, diemLP4, diemLP5));
					}
				} else {
					System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
				}
			}
		}

	}

	public static void XuatThongTinSV() {
		int i = 0;
		String msg = "";
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				msg = "**** Sinh Viên Dài Hạn ***** \n";
				System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoSV()
						+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + " - năm Sinh: "
						+ ((SinhVienDaiHan) o).getNamSinh() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChi()
						+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
						+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n+ - Điểm LP4: "
						+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
						+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
			} else {
				if (o instanceof SinhVienWebCapToc) {
					msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
					System.out
							.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
									+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
									+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
									+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
									+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
									+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
									+ ((SinhVienWebCapToc) o).tinhDTB() + "\n - Xếp Loại: "
									+ ((SinhVienWebCapToc) o).xepLoaiSV());
				} else {

					if (o instanceof SinhVienJavaCapToc) {
						msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
						System.out.println(
								"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
										+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + "\n - năm Sinh: "
										+ ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
										+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP4: "
										+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP5: "
										+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
										+ ((SinhVienJavaCapToc) o).tinhDTB() + "\n - Xếp Loại: "
										+ ((SinhVienJavaCapToc) o).xepLoaiSV());
					}
				}
			}

		}
		System.out.println("******************************************************");
	}

	public static void SVGioi() {
		
		int i = 0;
		String msg = "";
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
					msg = "**** Sinh Viên Lớp Dài Hạn đạt loại Giỏi ***** \n";
					System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoSV()
							+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + "\n - năm Sinh: "
							+ ((SinhVienDaiHan) o).getNamSinh() + " - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChi()
							+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
							+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
							+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n - Điểm LP4: "
							+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
							+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
							+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
				}
			} else {
				if (o instanceof SinhVienWebCapToc) {
					if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
						msg = "**** Sinh Viên lớp Web Cấp Tốc đạt loại Giỏi ***** \n";
						System.out.println(
								"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
										+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
										+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
										+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
										+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
										+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
										+ ((SinhVienWebCapToc) o).tinhDTB() + "\n - Xếp Loại: "
										+ ((SinhVienWebCapToc) o).xepLoaiSV());
					}
				} else {

					if (o instanceof SinhVienJavaCapToc) {
						if (((SinhVienDaiHan) o).tinhDTB() >= 8.5) {
							msg = "**** Sinh Viên lớp Java Cấp Tốc đạt Loại Giỏi ***** \n";
							System.out.println(
									"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
											+ "\n - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV()
											+ "\n - năm Sinh: " + ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
											+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP4: "
											+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP5: "
											+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
											+ ((SinhVienJavaCapToc) o).tinhDTB() + "\n - Xếp Loại: "
											+ ((SinhVienJavaCapToc) o).xepLoaiSV());
						}
					}
				}
			}

		}
		System.out.println("******************************************************");
	}

	public static void SapXep() {
		Collections.sort(dsSinhVien);
		int i = 0;
		String msg = "";
		for (SinhVien o : dsSinhVien) {
			if (o instanceof SinhVienDaiHan) {
				msg = "**** Sinh Viên Dài Hạn ***** \n";
				System.out.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienDaiHan) o).getHoSV()
						+ "\n - Tên Sinh Viên: " + ((SinhVienDaiHan) o).getTenSV() + " - năm Sinh: "
						+ ((SinhVienDaiHan) o).getNamSinh() + "\n - Địa Chỉ: " + ((SinhVienDaiHan) o).getDiaChi()
						+ "\n - Điểm LP0: " + ((SinhVienDaiHan) o).getDiemLP0() + "\n - Điểm LP1: "
						+ ((SinhVienDaiHan) o).getDiemLP1() + "\n - Điểm LP2: " + ((SinhVienDaiHan) o).getDiemLP2()
						+ "\n - Điểm LP3: " + ((SinhVienDaiHan) o).getDiemLP3() + "\n+ - Điểm LP4: "
						+ ((SinhVienDaiHan) o).getDiemLP4() + "\n - Điểm LP5: " + ((SinhVienDaiHan) o).getDiemLP5()
						+ "\n - Điểm LP6: " + ((SinhVienDaiHan) o).getDiemLP6() + "\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDTB() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiSV());
			} else {
				if (o instanceof SinhVienWebCapToc) {
					msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
					System.out
							.println("Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
									+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
									+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
									+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
									+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
									+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
									+ ((SinhVienWebCapToc) o).tinhDTB() + "\n - Xếp Loại: "
									+ ((SinhVienWebCapToc) o).xepLoaiSV());
				} else {

					if (o instanceof SinhVienJavaCapToc) {
						msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
						System.out.println(
								"Sinh Viên  Thứ " + (++i) + ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
										+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + "\n - năm Sinh: "
										+ ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
										+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP4: "
										+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP5: "
										+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
										+ ((SinhVienJavaCapToc) o).tinhDTB() + "\n - Xếp Loại: "
										+ ((SinhVienJavaCapToc) o).xepLoaiSV());
					}
				}
			}

		}
		System.out.println("******************************************************");
	}
}
