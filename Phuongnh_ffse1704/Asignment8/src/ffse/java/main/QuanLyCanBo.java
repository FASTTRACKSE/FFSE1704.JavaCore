package ffse.java.main;

import java.util.*;

import ffse.java.entity.*;
import ffse.java.util.CBComparator;
import ffse.java.util.MyException;
import ffse.java.util.CBComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Support
 *
 */
public class QuanLyCanBo {
	private static int N;
	private static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static boolean chonOk;
	static Scanner nhap = new Scanner(System.in);

	public static void main(String[] args) {
		int N = 0;
		while (N != 5) {
			try {

				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+----------------------------------------------------+");
				System.out.println("|1.Nhập thông tin cán bộ                             |");
				System.out.println("|2.Xuất thông tin cán bộ                             |");
				System.out.println("|3.Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ  |");
				System.out.println("|4.Danh sách cán bộ toàn trường theo lương           |");
				System.out.println("|5.Kết Thúc                                          |");
				System.out.println("+----------------------------------------------------+");

				N = nhap.nextInt();
				if (N == 1) {
					nhapThongTin();
				} else if (N == 2) {
					xuatThongTin();
				} else if (N == 3) {
					tongLuong();
				} else if (N == 4) {
					SapXep();
				} else if (N == 5) {
					KetThuc();
				} else {

					System.err.println("Chỉ nhập từ 1 đến 5 thôi nhé");
				}
			} finally {
				if (N != 5) {
					BackToMainMenu();
				}

			}
		}
	}

	public static void nhapThongTin() {
		System.out.println(">>Nhập Thông tin Cán Bộ<<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Giảng Viên                          |");
		System.out.println("|2.Nhân Viên                           |");
		System.out.println("+--------------------------------------+");
		int M = nhap.nextInt();
		if (M == 1) {
			String tenCanBo = " ";
			String khoa = " ";
			String trinhDo = " ";
			int soTietDay = 0;
			double heSoLuong = 0;
			int choose;
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = nhap.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				nhap.nextLine();
				// bắt lỗi nhập sai tên
				do {
					try {
						System.out.println("Nhập tên giảng viên ");
						tenCanBo = nhap.nextLine();
						chonOk = true;
						if (tenCanBo.length() > 40 || tenCanBo.length() < 1) {
							throw new MyException(1);
						}
					} catch (MyException e) {
						System.err.println(e);
						chonOk = false;
					}
				} while (!chonOk);

				System.out.print("Nhập Khoa : ");
				khoa = nhap.nextLine();
				// bắt lỗi nhập sai trình độ
				do {
					System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
					choose = nhap.nextInt();
					switch (choose) {
					case 1:
						trinhDo = "Cử nhân";

						break;
					case 2:
						trinhDo = "Thạc sĩ";

						break;
					case 3:
						trinhDo = "Tiến sĩ";

					default:
						System.out.println("Chọn không đúng!");
						break;
					}
				} while (choose < 1 || choose > 3);
				// bắt lỗi tiết dạy
				do {
					try {
						System.out.print("Số tiết dạy Trong Tháng: ");
						soTietDay = nhap.nextInt();
						chonOk = true;
						if (soTietDay <= 0) {
							throw new MyException(3);
						}
					} catch (Exception e) {
						System.err.println("lỗi nhập chữ hoặc số không nguyên dương");
						chonOk =false;
						nhap.nextLine();
					}
				} while (!chonOk);

				do {
					try {
						System.out.print("Hệ số lương ");
						heSoLuong = nhap.nextDouble();
						chonOk = true;
						if (heSoLuong <= 0) {
							throw new MyException(4);
						}
					} catch (MyException e) {
						System.err.println(e);
					}
				} while (!chonOk);

				System.out.println("------------------------------------------------------------------");

			}

			dsCanBo.add(new GiangVien(tenCanBo, khoa, trinhDo, soTietDay, heSoLuong));
		}

		// kết thúc vòng lặp nhập
		else if (M == 2) {
			String tenCanBo = " ";
			String chucVu = " ";
			int soNgayCong = 0;
			double heSoLuong = 0;
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = nhap.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				nhap.nextLine();
				// bắt lỗi nhập sai tên
				do {
					try {
						System.out.println("Nhập tên giảng viên ");
						tenCanBo = nhap.nextLine();
						chonOk = true;
						if (tenCanBo.length() > 40 || tenCanBo.length() < 1) {
							throw new MyException(1);
						}
					} catch (MyException e) {
						System.err.println(e);
						chonOk = false;
					}
				} while (!chonOk);

				System.out.print("Nhập Khoa : ");
				String khoa = nhap.nextLine();

				int choose;
				// bắt lỗi nhập sai chức vụ
				do {
					System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
					choose = nhap.nextInt();
					switch (choose) {
					case 1:
						chucVu = "Trưởng phòng";

						break;
					case 2:
						chucVu = "Phó phòng";

						break;
					case 3:
						chucVu = "Nhân viên";

					default:
						System.out.println("Chọn không đúng!");
						break;
					}
				} while (choose < 1 || choose > 3);
				// bắt lỗi nhập sai ngày công 
				do {
					try {
						System.out.print("Số ngày làm Trong Tháng: ");
						soNgayCong = nhap.nextInt();
						chonOk = true;
						if (soNgayCong <= 0) {
							throw new MyException(3);
						}
					} catch (Exception e) {
						System.err.println("lỗi nhập chữ hoặc số không nguyên dương");
						chonOk =false;
						nhap.nextLine();
					}
				} while (!chonOk);
				soNgayCong = nhap.nextInt();

				do {
					try {
						System.out.print("Hệ số lương ");
						heSoLuong = nhap.nextDouble();
						chonOk = true;
						if (heSoLuong <= 0) {
							throw new MyException(4);
						}
					} catch (MyException e) {
						System.err.println(e);
					}
				} while (!chonOk);

				System.out.println("------------------------------------------------------------------");

			}
		}
		// kết thúc if else
	}

	// kết thúc bộ nhập

	public static void xuatThongTin() {

		String M = "";
		System.out.println("Bạn muốn thông tin cán bộ thuộc khoa hay phòng ban nào???");
		nhap.nextLine();
		M = nhap.nextLine();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {

					System.out.println("Giảng Viên  Thứ " + (i + 1) + ":\n Họ Tên Giảng Viên: "
							+ ((GiangVien) dsCanBo.get(i)).getTenCanBo() + "\n - Khoa: "
							+ ((GiangVien) dsCanBo.get(i)).getKhoa() + "\n - Trình Độ: "
							+ ((GiangVien) dsCanBo.get(i)).getTrinhDo() + "\n - Số Tiết Dạy: "
							+ ((GiangVien) dsCanBo.get(i)).getSoTietDay() + "\n - Hệ Số Lương: "
							+ ((GiangVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((GiangVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsCanBo.get(i) instanceof NhanVien) {
				if (M.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {

					System.out.println("Nhân Viên  Thứ " + (i + 1) + ":\n Họ Tên Nhân Viên: "
							+ ((NhanVien) dsCanBo.get(i)).getTenCanBo() + "\n - phòng Ban: "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\n - Chức Vụ: "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\n - Số Ngày Công: "
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\n - Hệ Số Lương: "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void tongLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}

	public static void SapXep() {
		int i = 0;
		Collections.sort(dsCanBo, CBComparator.sapXepLuong);

		System.out.println(
				"|-------------------------------------------------------------------DANH SÁCH CÁN BỘ-------------------------------------------------------------------------|");
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
				"Khoa", "Phòng Ban", "Trình Độ", "Chức Vụ", "Số Tiết Dạy", "Số Ngày Công", "Hệ số Lương",
				"Lương Được Nhận\n");
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");
		for (CanBo o : dsCanBo) {

			if (o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
						((GiangVien) o).getTenCanBo(), ((GiangVien) o).getKhoa(), "x", ((GiangVien) o).getTrinhDo(),
						"x", ((GiangVien) o).getSoTietDay(), "x", ((GiangVien) o).getHeSoLuong(),
						((GiangVien) o).tinhLuong() + "\n");
			} else {
				if (o instanceof NhanVien) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
							((NhanVien) o).getTenCanBo(), "x ", ((NhanVien) o).getPhongBan(), "x",
							((NhanVien) o).getChucVu(), "x", ((NhanVien) o).getSoNgayCong(),
							((NhanVien) o).getHeSoLuong(), ((NhanVien) o).tinhLuong() + "\n");
				}
			}
			System.out.println("");
			System.out.println(
					"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");

		}
	}

	public static void KetThuc() {
		System.err.println("KẾT THÚC CHƯƠNG TRÌNH");
	}

	public static void BackToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
	}

}