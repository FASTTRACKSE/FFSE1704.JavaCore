package javacore.qlcanbotruonghoc.main;

import java.util.ArrayList;
import java.util.Scanner;

import javacore.qlcanbotruonghoc.entity.*;

public class QuanLiCanBoGV {
	static int N;
	static ArrayList<QuanLiCanBo> dsCanBo = new ArrayList<QuanLiCanBo>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập Thông Tin Cán Bộ	|");
			System.out.println("|2.In danh sách Sinh Viên   |");
			System.out.println("|3.Xuất danh sách Sv Giỏi   |");
			System.out.println("|4.Sắp Xếp DS SV theo Điểm  |");
			System.out.println("|5.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongCanBo();
			} else if (N == 2) {
				InDsCanBo();
			} else if (N == 3) {
				TongSoLuongPhaiTra();
			} else if (N == 4) {
				SapXepCanBo();
			} /*
				 * else if (N == 6) { XoaBienLaiKH(); }
				 */ else {
				System.exit(0);
			}
		}

	}

	public static void NhapThongCanBo() {
		System.out.print("Số Lượng Cán Bộ Cần Nhập");
		N = myInput.nextInt();
		for (int i = 0; i < N; i++) {

			System.out.print("\n Chọn Loại Cán Bộ Cần Nhập: ");
			System.out.print("\n1 : Nhập Thông Tin Giảng Viên");
			
			System.out.print("\n 2 : Nhập Thông Tin Nhân Viên");
			try {
			int F = myInput.nextInt();

			if (F > 0 && F <= 3) {
				
					if (F == 1) {
						System.out.println("\nMời bạn nhập Thông Tin Giảng Viên!");
						System.out.print("Nhập Tên Giảng Viên :");
						myInput.nextLine();
						String hoTen = myInput.nextLine();

						System.out.print("\nNhập hệ số lương Dạy Giảng Viên :");
						int heSoLuong = myInput.nextInt();

						System.out.print("\nNhập Khoa Của Giảng Viên!!");
						myInput.nextLine();
						String khoa = myInput.nextLine();
						int chonTrinhDo = 0;
						try {
							System.out.print(
									"\nNhập Trình Độ Giảng Viên :\n Chọn 1 Cử Nhân\n Chọn 2 Thạc Sĩ\n Chọn 3 Tiến Sĩ ");
							chonTrinhDo = myInput.nextInt();
							if (chonTrinhDo == 1) {
								System.out.println("Đã Chọn CỬ Nhân");
							} else if (chonTrinhDo == 2) {
								System.out.println("Đã Chọn thạc SĨ");
							} else if (chonTrinhDo == 3) {
								System.out.println("Đã Chọn Tiến Sĩ");
							} else {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("Vui lòng Nhập Tự 1 đến 3 và kiểu số");
							myInput.nextLine();
						}

						System.out.print("\nNhập Số Tiết Dạy Giảng Viên :");
						int soTietDay = myInput.nextInt();

						dsCanBo.add(new GiangVien(hoTen, heSoLuong, khoa, chonTrinhDo, soTietDay));

					} else if (F == 2) {
						System.out.println("Mời bạn nhập Thông Tin Nhân Viên!");
						System.out.print("Nhập Tên Nhân Viên :");
						myInput.nextLine();
						String hoTen = myInput.nextLine();
						System.out.print(
								"\nNhập Trình Độ NV :\n Chọn 1 Nhân Viên\n Chọn 2 Phó Phòng\n Chọn 3 Trưởng Phòng ");
						int chonChucVu = myInput.nextInt();
						System.out.print("\nNhập hệ số lương Dạy Nhân Viên :");
						int heSoLuong = myInput.nextInt();

						System.out.print("\nNhập Phòng Ban Nhân Viên");
						myInput.nextLine();
						String phongBan = myInput.nextLine();

						System.out.print("\nNhập Số Ngày Công Nhân Viên");
						int soNgayCong = myInput.nextInt();

						dsCanBo.add(new NhanVien(hoTen, heSoLuong, phongBan, soNgayCong, chonChucVu));
					}else {
						throw new Exception();
					}
				 /*catch (Exception e) {
				
					System.out.println("Vui Long Nhap Lai Tu 1 => 2");
					
				}*/
			}
			}catch (Exception e) {
				
				System.out.println("Vui Lòng Nhập Tu 1 => 2 và kiểu số");
				myInput.nextLine();
			}
		}
	}

	public static void InDsCanBo() {

		String M = "";
		System.out.println("Bạn muốn thông tin cán bộ thuộc khoa hay phòng ban nào???");
		myInput.nextLine();
		M = myInput.nextLine();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {

					System.out.println("Giảng Viên  Thứ " + (i + 1) + ":\n Họ Tên Giảng Viên: "
							+ ((GiangVien) dsCanBo.get(i)).getHoTen() + "\n - Khoa: "
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
							+ ((NhanVien) dsCanBo.get(i)).getHoTen() + "\n - phòng Ban: "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\n - Chức Vụ: "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\n - Số Ngày Công: "
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\n - Hệ Số Lương: "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void TongSoLuongPhaiTra() {
		double tongtien = 0;
		for (int i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}

	public static void SapXepCanBo() {

	}
}
