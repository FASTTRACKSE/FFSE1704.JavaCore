package fasttrack.quanlythongtin.main;

import fasttrack.quanlythongtin.entity.GiangVien;
import fasttrack.quanlythongtin.entity.NhanVien;
import fasttrack.quanlythongtin.entity.CanBo;
import fasttrack.sinhvien.entity.SinhVien;
import fasttrack.sinhvien.entity.SinhVienDaiHan;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyThongTinCanBo {
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {

		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\n    HỆ THỐNG QUẢN LÝ CÁN BỘ");
				System.out.println("+----------------------------------------------------+");
				System.out.println("| 1. Nhập danh sách cán bộ                           |");
				System.out.println("| 2. Xuất danh sách giang vien hoac nhan vien        |");
				System.out.println("| 3. Tổng số lương trường phải trả cho cán bộ        |");
				System.out.println("| 4. Sắp xếp cán bộ theo lương                       |");
				System.out.println("| 5. Kết thúc                                        |");
				System.out.println("+----------------------------------------------------+");
				System.out.print("Mời bạn chọn chức năng: ");

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

	// thông tin cán bộ
	public static void nhapThongTinCanBo() {
		System.out.println("1.Giang Viên");
		System.out.println("2.Nhân Viên");
		System.out.println("Mời bạn chọn cán bộ :");
		int x = myInput.nextInt();

		// NHẬP DANH SÁCH GIẢNG VIÊN
		if (x == 1) {
			System.out.println("Nhập số lượng  giảng viên : ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Mời bạn nhập họ tên giảng viên thứ" + (i + 1));
				myInput.nextLine();
				String hoTen = myInput.nextLine();

				System.out.println("Mời bạn nhập khóa giảng viên thứ " + (i + 1));
				String khoa = myInput.nextLine();

				System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
				int phuCap = 0;
				int xl = myInput.nextInt();
				String trinhDo = " ";

				if (xl == 1) {
					trinhDo = "Cử nhân";
					phuCap = 300000;
				} else if (xl == 2) {
					trinhDo = "Thạc sĩ";
					phuCap = 500000;
				} else if (xl == 3) {
					trinhDo = "Tiến sĩ";
					phuCap = 1000000;
				}

				System.out.println("Mời bạn nhập số tiết/thang giảng viên thứ " + (i + 1));
				int soTietTrongThang = myInput.nextInt();

				System.out.println("Mời bạn nhập hệ số của giảng viên thứ" + (i + 1));
				double heSo = myInput.nextDouble();

				dsCanBo.add(new GiangVien(hoTen, phuCap, heSo, khoa, trinhDo, soTietTrongThang));

			}
		}

		// NHẬP DANH SÁCH NHÂN VIÊN
		if (x == 2) {
			System.out.println("Số lượng nhân viên : ");
			int n = myInput.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.println("Mời bạn nhập họ tên nhân viên thứ " + (i + 1));
				myInput.nextLine();
				String hoTen = myInput.nextLine();

				System.out.println("Mời bạn nhập phòng ban nhân viên thứ " + (i + 1));
				String phongBan = myInput.nextLine();

				System.out.print("Nhập chức vụ (1 - trưởng phòng, 2 - phó phòng, 3 - nhân viên): ");
				int phuCap = 0;
				int xl = myInput.nextInt();
				String chucVu = " ";

				if (xl == 1) {
					chucVu = "Trưởng phòng";
					phuCap = 2000;
				} else if (xl == 2) {
					chucVu = "Phó phòng";
					phuCap = 1000;
				} else if (xl == 3) {
					chucVu = "Nhân viên";
					phuCap = 500;
				}

				System.out.println("Mời bạn nhập số ngày công nhân viên thứ " + (i + 1));
				int soNgayCong = myInput.nextInt();

				System.out.println("Mời bạn nhập hệ số của nhân viên thứ " + (i + 1));
				double heSo = myInput.nextDouble();

				dsCanBo.add(new NhanVien(hoTen, phuCap, heSo, phongBan, chucVu, soNgayCong));

			}
		}

	}

	public static void xuatThongTinCanBo() {
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
							((NhanVien) x).getPhongBan(), ((NhanVien) x).getChucVu(), ((NhanVien) x).getSoNgayCong(),
							((NhanVien) x).getPhuCap(), ((NhanVien) x).getHeSo(), ((NhanVien) x).tinhLuong());

				}

			}
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
