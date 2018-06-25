package fasttrack.quanlycanbo.main;

import fasttrack.quanlycanbo.entity.CanBo;
import fasttrack.quanlycanbo.entity.GiangVien;
import fasttrack.quanlycanbo.entity.NhanVien;
import fasttrack.quanlycanbo.util.myException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyThongTinCanBo {
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);
	static int x;
	static int n;
	static int myOption = 0;
	static boolean ketqua;

	public static void main(String[] args) {

		while (myOption != 5) {
			try {
				System.out.println("\n    HỆ THỐNG QUẢN LÝ CÁN BỘ");
				System.out.println("+----------------------------------------------------+");
				System.out.println("| 1. Nhập danh sách cán bộ                           |");
				System.out.println("| 2. Xuất danh sách giang viên hoac nhan vien        |");
				System.out.println("| 3. Tổng số lương trường phải trả cho cán bộ        |");
				System.out.println("| 4. Sắp xếp cán bộ theo lương                       |");
				System.out.println("| 5. Kết thúc                                        |");
				System.out.println("+----------------------------------------------------+");

				System.out.print("Mời bạn chọn chức năng: ");
				// myInput.nextLine();
				myOption = myInput.nextInt();
				if (myOption == 1) {
					nhapThongTinCanBo();
				} else if (myOption == 2) {
					xuatThongTinCanBo();
				} else if (myOption == 3) {
					tongSoLuongCanBo();
				} else if (myOption == 4) {
					sapXepTheoLuong();
				} else if (myOption == 5) {
					ketThuc();
				} else {
					throw new myException(7);
				}
			} catch (myException e) {
				System.out.println(e);
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}

	// thông tin cán bộ
	public static void nhapThongTinCanBo() {
		try {
			System.out.println("1.Giang Viên");
			System.out.println("2.Nhân Viên");
			System.out.println("Mời bạn chọn cán bộ :");
			x = myInput.nextInt();
		} catch (Exception e) {
			System.out.println("Chỉ nhập 1 hoặc 2, you OK....");
		}

		// NHẬP DANH SÁCH GIẢNG VIÊN
		if (x == 1) {

			String hoTen = "";
			double heSo = 0;
			int phuCap = 0;
			String trinhDo = " ";
			int soTietTrongThang = 0;
			int xl = 0;

			// NHẬP SỐ GV
			
			System.out.println("Nhập số lượng  giảng viên : ");
			n = myInput.nextInt();

			for (int i = 0; i < n; i++) {

				// HỌ TÊN GV
				do {
					try {
						myInput.nextLine();
						System.out.println("Mời bạn nhập tên giảng viên thứ " + (i + 1));
						hoTen = myInput.nextLine();
						ketqua = true;

						if (hoTen.length() > 40 || hoTen.length() < 1) {

							throw new myException(1);
						}
					} catch (myException e) {
						System.out.println(e);
						ketqua = false;
						
					}
				} while (!ketqua);

				// KHÓA GV
				System.out.println("Mời bạn nhập khóa giảng viên thứ " + (i + 1) + ":");
				String khoa = myInput.nextLine();

				// TRÌNH ĐỘ GV
				do {
					try {

						System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
						xl = myInput.nextInt();
						if (xl == 1) {
							trinhDo = "Cử nhân";
							phuCap = 300;
							ketqua = true;
						} else if (xl == 2) {
							trinhDo = "Thạc sĩ";
							phuCap = 500;
							ketqua = true;
						} else if (xl == 3) {
							trinhDo = "Tiến sĩ";
							phuCap = 1000;
							ketqua = true;
						} else {
							ketqua = false;
							System.out.println("Bạn đã nhập sai trình độ, hãy chọn lại Trình độ!!!");
						}
					} catch (InputMismatchException e) {
						System.out.println("Bạn đã nhập sai trình độ, hãy chọn lại Trình độ!!!");
						ketqua = false;
						myInput.nextLine();
					}
				} while (!ketqua);

				// SỐ TIẾN/THÁNG GV
				do {
					try {
						System.out.println("Mời bạn nhập số tiết/thang giảng viên thứ " + (i + 1) + ":");
						soTietTrongThang = myInput.nextInt();
						ketqua = true;
						if (soTietTrongThang < 0) {
							throw new myException(3);
						}
					} catch (myException e) {
						System.out.println(e);
						ketqua = false;
					}
				} while (!ketqua);

				// HỆ SỐ GV
				do {
					try {

						System.out.println("Mời bạn nhập hệ số của giảng viên thứ" + (i + 1) + ":");
						heSo = myInput.nextDouble();
						ketqua = true;
					} catch (InputMismatchException e) {
						System.out.println("Hệ số lương là số thực, vui lòng nhập lại !!!");
						ketqua = false;
						myInput.nextLine();
					}
				} while (!ketqua);

				dsCanBo.add(new GiangVien(hoTen, phuCap, heSo, khoa, trinhDo, soTietTrongThang));

			}
		}

		// NHẬP DANH SÁCH NHÂN VIÊN
		else if (x == 2) {

			// NHẬP SỐ NV
			System.out.println("Nhập số lượng nhân viên : ");
		n = myInput.nextInt();

		for (int i = 0; i < n; i++) {

			String hoTen = "";
			int soNgayCong = 0;
			double heSo = 0;
			int phuCap = 0;
			String chucVu = " ";

			// HỌ TÊN NV
			do {
				try {
					System.out.println("Mời bạn tên nhân viên thứ " + (i + 1));
					myInput.nextLine();
					hoTen = myInput.nextLine();

					ketqua = true;

					if (hoTen.length() > 40 || hoTen.length() < 1) {

						throw new myException(1);
					}
				} catch (myException e) {
					System.out.println(e);
					ketqua = false;
				}
			} while (!ketqua);

			// PHONG BAN NV
			System.out.println("Mời bạn nhập phòng ban nhân viên thứ " + (i + 1) + ":");
			String phongBan = myInput.nextLine();

			// CHỨC VỤ NV
			do {
				try {
					System.out.print("Nhập chức vụ (1 - trưởng phòng, 2 - phó phòng, 3 - nhân viên): ");
					int xl = myInput.nextInt();
					if (xl == 1) {
						chucVu = "Trưởng phòng";
						phuCap = 2000;
						ketqua = true;
					} else if (xl == 2) {
						chucVu = "Phó phòng";
						phuCap = 1000;
						ketqua = true;
					} else if (xl == 3) {
						chucVu = "Nhân viên";
						phuCap = 500;
						ketqua = true;
					} else {
						ketqua = false;
						System.out.println("Bạn đã nhập sai chức vụ, hãy chọn lại ");
					}

				} catch (InputMismatchException e) {
					System.out.println("Bạn đã nhập sai chức vụ, hãy chọn lại !!!");
					myInput.nextLine();
					ketqua = false;
					
				}
			} while (!ketqua);

			// NGÀY CÔNG NV
			do {
				try {
					System.out.println("Mời bạn nhập số ngày công nhân viên thứ " + (i + 1) + ":");
					soNgayCong = myInput.nextInt();
					ketqua = true;
					if (soNgayCong < 0) {
						throw new myException(3);
					}
				} catch (Exception e) {
					System.out.println(e);
					ketqua = false;
					myInput.next();
				}
			} while (!ketqua);

			// HỆ SỐ LƯƠNG NV
			do {
				try {
					System.out.println("Mời bạn nhập hệ số của nhân viên thứ " + (i + 1) + ":");
					heSo = myInput.nextInt();
					ketqua = true;
				} catch (InputMismatchException e) {
					System.out.println("Hệ số lương là số thực, vui lòng nhập lại !!!");
					ketqua = false;
					myInput.nextLine();
				}
			} while (!ketqua);

			dsCanBo.add(new NhanVien(hoTen, phuCap, heSo, phongBan, chucVu, soNgayCong));

		}
	}
	}

	public static void xuatThongTinCanBo() {
		try {
			System.out.println("Nhập cán bộ bạn muốn in \n 1. Giang Viên \n 2.Nhân Viên");
			int nhap = myInput.nextInt();
			myInput.nextLine();

			// XUẤT DANH SÁCH GIẢNG VIÊN
			if (nhap == 1) {

				System.out.println("Mời bạn nhập khóa : ");
				String khoa = myInput.nextLine();

				for (CanBo x : dsCanBo) {

					if (((GiangVien) x).getKhoa().equals(khoa)) {

						System.out.println(
								"------------------------DANH SÁCH GIANG VIÊN------------------------------------------");
						System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s ", "Họ và", "Khoa",
								"Trình Độ", "Số Tiết Dạy", "Phụ cấp", "Hệ số Lương", "Lương Nhận\n");

						System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s ", (x.getHoTen()),
								((GiangVien) x).getKhoa(), ((GiangVien) x).getTrinhDo(),
								((GiangVien) x).getSoTietTrongThang(), ((GiangVien) x).getPhuCap(),
								((GiangVien) x).getHeSo(), ((GiangVien) x).tinhLuong());

					}

				}

			}

			// XUẤT DANH SÁCH NHÂN VIÊN
			if (nhap == 2) {

				System.out.println("Mời bạn nhập khóa : ");
				String phongban = myInput.nextLine();

				for (CanBo x : dsCanBo) {

					if (((NhanVien) x).getPhongBan().equals(phongban)) {

						System.out.println(
								"------------------------DANH SÁCH NHÂN VIÊN------------------------------------------");
						System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s ", "Họ tên ", "PhongBan",
								"Chức Vụ", "Ngày Công", "Phụ cấp", "Hệ số Lương", "Lương Nhận\n");

						System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s ", (x.getHoTen()),
								((NhanVien) x).getPhongBan(), ((NhanVien) x).getChucVu(),
								((NhanVien) x).getSoNgayCong(), ((NhanVien) x).getPhuCap(), ((NhanVien) x).getHeSo(),
								((NhanVien) x).tinhLuong());

					}

				}
			}
		} catch (Exception e) {
			System.out.println("Chỉ nhập 1 hoặc 2 .. ahihi");
		}
	}

	public static void tongSoLuongCanBo() {
		int tongLuong = 0;

		for (CanBo x : dsCanBo) {
			tongLuong += x.tinhLuong();
		}

		System.out.println("Tổng lương số lương của cán bộ là : " + tongLuong + "VND");

	}

	public static void sapXepTheoLuong() {

		Collections.sort(dsCanBo, new Comparator<CanBo>() {

			public int compare(CanBo cb1, CanBo cb2) {
				if (cb2.tinhLuong() < cb1.tinhLuong()) {
					return 1;
				} else if (cb2.tinhLuong() > cb1.tinhLuong()) {
					return -1;
				} else {
					return cb1.getHoTen().compareTo(cb2.getHoTen());
				}
			}

		});
		for (CanBo x : dsCanBo) {
			System.out.println("----------------------DANH SÁCH CÁN BỘ ĐÃ ĐƯỢC SẮP XẾP ------------------------");

			if (x instanceof NhanVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s ", "Họ tên ", "PhongBan", "Chức Vụ",
						"Ngày Công", "Phụ cấp", "Hệ số Lương", "Lương Nhận\n");

				System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s ", (x.getHoTen()),
						((NhanVien) x).getPhongBan(), ((NhanVien) x).getChucVu(), ((NhanVien) x).getSoNgayCong(),
						((NhanVien) x).getPhuCap(), ((NhanVien) x).getHeSo(), ((NhanVien) x).tinhLuong());

			} else if (x instanceof GiangVien) {

				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s ", "Họ tên", "Khoa", "Trình Độ",
						"Số Tiết Dạy", "Phụ cấp", "Hệ số Lương", "Lương Nhận\n");

				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s ", (x.getHoTen()),
						((GiangVien) x).getKhoa(), ((GiangVien) x).getTrinhDo(), ((GiangVien) x).getSoTietTrongThang(),
						((GiangVien) x).getPhuCap(), ((GiangVien) x).getHeSo(), ((GiangVien) x).tinhLuong());
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
}
