/**
 * 
 */
package ffse.quanlynhanvien.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ffse.quanlynhanvien.entity.*;
import ffse.quanlynhanvien.util.NVComparator;

/**
 * @author Support
 *
 */
public class QuanLyNhanVien {
	private static int N;
	private static ArrayList<ThongTin> dsCanBo = new ArrayList<ThongTin>();
	static Scanner nhap = new Scanner(System.in);

	public static void main(String[] args) {
		

		while (true) {
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
			} else {
				System.exit(0);
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
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = nhap.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				nhap.nextLine();

				System.out.print("Nhập Họ Tên Giảng Viên: ");
				String tenCanBo = nhap.nextLine();

				System.out.print("Nhập Khoa : ");
				String khoa = nhap.nextLine();

				System.out.print("Trình Độ Giảng Viên : ");
				String trinhDo = nhap.nextLine();

				System.out.print("Số Tiết Dạy Trong Tháng: ");
				int soTietDay = nhap.nextInt();

				System.out.print("Hệ Số Lương: ");
				double heSoLuong = nhap.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsCanBo.add(new GiangVien(tenCanBo, khoa, trinhDo, soTietDay, heSoLuong));
			}
		}
		// kết thúc vòng lặp nhập
		else {
			if (M == 2) {
				System.out.println("Nhập thông tin Nhân Viên");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Nhân Viên: ");
				N = nhap.nextInt();
				for (int i = 0; i < N; i++) {
					System.out.print("Nhập Thông Tin Nhân Viên thứ " + (i + 1) + "\n");
					nhap.nextLine();

					System.out.print("Nhập Họ Tên Nhân Viên: ");
					String tenCanBo = nhap.nextLine();

					System.out.print("Phòng Ban : ");
					String phongBan = nhap.nextLine();

					System.out.print("Chức Vụ : ");
					String chucVu = nhap.nextLine();

					System.out.print("Số ngày công: ");
					int soNgayCong = nhap.nextInt();

					System.out.print("Hệ Số Lương: ");
					double heSoLuong = nhap.nextDouble();

					System.out.println("------------------------------------------------------------------");

					dsCanBo.add(new NhanVien(tenCanBo, phongBan, chucVu, soNgayCong, heSoLuong));
				}
				// kết thúc vòng lặp nhập
			} else {
				System.err.println("Bạn chỉ được nhập 1 hoặc 2. Hãy Nhập Lại!!!");
			}
			// kết thúc if else
		}
	}// kết thúc bộ nhập

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
		Collections.sort(dsCanBo, NVComparator.CanBoLuongASComparator);
		

		System.out.println(
				"|-------------------------------------------------------------------DANH SÁCH CÁN BỘ-------------------------------------------------------------------------|");
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
				"Khoa", "Phòng Ban", "Trình Độ", "Chức Vụ", "Số Tiết Dạy", "Số Ngày Công", "Hệ số Lương",
				"Lương Được Nhận\n");
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");
		for (ThongTin o : dsCanBo) {
			//Collections.sort(dsCanBo, NVComparator.CBCodeASCComparator);
			if (o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
						((GiangVien) o).getTenCanBo()  , ((GiangVien) o).getKhoa(),"x", ((GiangVien) o).getTrinhDo(),"x",
						((GiangVien) o).getSoTietDay(),"x",((GiangVien) o).getHeSoLuong(),
						((GiangVien) o).tinhLuong() + "\n");
			} else {
				if (o instanceof NhanVien) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
							((NhanVien) o).getTenCanBo() , "x " ,((NhanVien) o).getPhongBan(),"x" ,((NhanVien) o).getChucVu(),"x",
							((NhanVien) o).getSoNgayCong(), ((NhanVien) o).getHeSoLuong(),
							((NhanVien) o).tinhLuong() + "\n");
				}
			}
			System.out.println("");
			System.out.println(
					"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");

		}
	}

}