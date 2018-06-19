/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.main;

import java.util.ArrayList;
import java.util.Scanner;

import ffse.quanlythongtincanbo.entity.*;

import ffse.quanlythongtincanbo.entity.NhanVien;

public class Main {
	
	static int N;
	static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	static Scanner myInput = new Scanner(System.in);
	
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

			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinNV();
			} else if (N == 2) {
				xuatThongTin();
			} else if (N == 3) {
				tongLuong();
			} else if (N == 4) {
				
			} else {
				System.exit(0);
			}
		}
	}
	public static void NhapThongTinNV() {
		
		Scanner n = new Scanner(System.in);
		int M = 0;
		System.out.print("Nhập Số Lượng Nhân viên: ");
		N = myInput.nextInt();
		
		for (;;) {
			System.out.println(">>     Nhân viên thuộc     <<");
			System.out.println("+---------------------------+");
			System.out.println("|1. Giảng viên              |");
			System.out.println("|2. Nhân viên hành chính    |");
			System.out.println("+---------------------------+");
			M = n.nextInt();
			if (M == 1 ||M == 2)
				break;
		}
		
		if (M == 1) {
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập Họ Tên Giảng Viên: ");
				String tenGV = myInput.nextLine();

				System.out.print("Nhập Khoa : ");
				String khoa = myInput.nextLine();

				System.out.print("Trình Độ Giảng Viên : ");
				String trinhDo = myInput.nextLine();

				System.out.print("Số Tiết Dạy Trong Tháng: ");
				int soTietDay = myInput.nextInt();

				System.out.print("Hệ Số Lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(tenGV, khoa, trinhDo, soTietDay, heSoLuong));
			}
		} else {
			System.out.println("Nhập thông tin Nhân Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Nhân Viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Nhân Viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập Họ Tên Nhân Viên: ");
				String tenNV = myInput.nextLine();

				System.out.print("Phòng Ban : ");
				String phongBan = myInput.nextLine();

				System.out.print("Chức Vụ : ");
				String chucVu = myInput.nextLine();

				System.out.print("Số ngày công: ");
				int soNgayCong = myInput.nextInt();

				System.out.print("Hệ Số Lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new NhanVienHanhChinh(tenNV, phongBan, chucVu, soNgayCong, heSoLuong));
			}
		
		}
	}
	
	public static void xuatThongTin() {

		String M = "";
		System.out.println("Bạn muốn thông tin cán bộ thuộc khoa hay phòng ban nào???");
		myInput.nextLine();
		M = myInput.nextLine();
		for (int i = 0; i < dsNhanVien.size(); i++) {
			if (dsNhanVien.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsNhanVien.get(i)).getKhoa())) {
					
					System.out.println("Giảng Viên  Thứ " + (i + 1) + ":\n Họ Tên Giảng Viên: "
							+ ((GiangVien) dsNhanVien.get(i)).getTenGV() + "\n - Khoa: "
							+ ((GiangVien) dsNhanVien.get(i)).getKhoa() + "\n - Trình Độ: "
							+ ((GiangVien) dsNhanVien.get(i)).getTrinhDo() + "\n - Số Tiết Dạy: "
							+ ((GiangVien) dsNhanVien.get(i)).getsoTietDayTrongThang() + "\n - Hệ Số Lương: "
							+ ((GiangVien) dsNhanVien.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((GiangVien) dsNhanVien.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsNhanVien.get(i) instanceof NhanVienHanhChinh) {
				if (M.equals(((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan())) {

					System.out.println("Nhân Viên  Thứ " + (i + 1) + ":\n Họ Tên Nhân Viên: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).getTenNV() + "\n - phòng Ban: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan() + "\n - Chức Vụ: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).getChucVu() + "\n - Số Ngày Công: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).getSoNgayCong() + "\n - Hệ Số Lương: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((NhanVienHanhChinh) dsNhanVien.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void tongLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsNhanVien.size(); i++) {
			tongtien += dsNhanVien.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}

}
