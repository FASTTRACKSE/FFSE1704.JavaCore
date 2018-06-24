package fasttrackse.asm5plus.entity;

import java.util.*;
import fasttrackse.asm5plus.main.*;

public class QuanLyThongTinCanBo {
	static int n;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<NhanVien> arr = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập danh sách Cán bộ|");
			System.out.println("|2.Xuất thông tin Cán bộ |");
			System.out.println("|3.Tổng số lương phải trả|");
			System.out.println("|4.Sắp xếp danh sách Cán bộ|");
			System.out.println("|5.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			n = sc.nextInt();
			if (n == 1) {
				nhapthongtinCanBo();
			} else if (n == 2) {
				xuatCanbo();
			} else if (n == 3) {
				tongLuong();
			} else if (n == 4) {
				sapxep();
			}else if(n==5) {
				System.out.println("Exit done!!!!\nCẢM ƠN BẠN ĐÃ SỬ DỤNG \n Code by Quanlt");
				System.exit(0);
			}else {
				System.out.println("Nhập từ 1->5 thôi man!!!");
			}
		}
	}

	public static void nhapthongtinCanBo() {
		System.out.println("Mời bạn chọn: \n 1. Nhập thông tin Giảng Viên \n 2. Nhập thông tin Nhân Viên");
		int a = sc.nextInt();
		if (a == 1) {
			System.out.println("Nhập số lượng Giảng Viên: ");
			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				System.out.println("Nhập thông tin Giảng viên thứ " + (i + 1) + ": \n");
				String vcl = sc.nextLine();
				System.out.println("Nhập tên Giảng viên : ");
				String tenNv = sc.nextLine();
				System.out.println("Nhập khoa: ");
				String khoaNV = sc.nextLine();
				System.out.println("Nhập trình độ: \n 1.Cử nhân \n 2.Thạc sĩ \n3. Tiến sĩ");
				int phuCap = 0;
				int trinhDo = sc.nextInt();
				if (trinhDo == 1) {
					phuCap = 300;
				} else if (trinhDo == 2) {
					phuCap = 500;
				} else if (trinhDo == 3) {
					phuCap = 1000;
				} else {
					System.out.println("Bạn đã chọn sai!!!");
				}
				System.out.println("Nhập số tiết dạy trong tháng: ");
				int songayCong = sc.nextInt();
				System.out.println("Nhập hệ số lương");
				int hesoLuong = sc.nextInt();
				arr.add(new NhanVien(tenNv, khoaNV, songayCong, hesoLuong, trinhDo, phuCap));
			}
		} else if (a == 2) {
			System.out.println("Nhập số lượng Nhân viên: ");
			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				System.out.println("Nhập thông tin Nhân viên thứ " + (i + 1) + ": \n");
				String vcl = sc.nextLine();
				System.out.println("Nhập tên Nhân viên: ");
				String tenNv = sc.nextLine();
				System.out.println("Nhập phòng ban: ");
				String phongBan = sc.nextLine();
				System.out.println("Nhập số ngày công: ");
				int songayCong = sc.nextInt();
				System.out.println("Nhập hệ số lương: ");
				int hesoLuong = sc.nextInt();
				System.out.println("Nhập chức vụ: \n1. Trưởng phòng \n2. Phó phòng\n3. Nhân viên");
				int phuCap = 0;
				int chucVu = sc.nextInt();
				if (chucVu == 1) {
					phuCap = 2000;
				} else if (chucVu == 2) {
					phuCap = 1000;
				} else if (chucVu == 3) {
					phuCap = 500;
				}
				arr.add(new NhanVien(tenNv, phongBan, hesoLuong, phuCap, songayCong, chucVu));
			}
		}
	}

	public static void xuatCanbo() {
		System.out.println("Nhập cán bộ muốn in\n 1.Giáo Viên \2.Nhân Viên");
		int b = sc.nextInt();
		if (b == 1) {
			String vcl = sc.nextLine();
			System.out.println("Nhập khoa: ");
			String khoa = sc.nextLine();
			for (NhanVien x : arr) {
				if (khoa.equals(x.getKhoaNV()) == true) {
					String td = " ";
					if (((GiangVien) x).getTrinhDo() == 1) {
						td = "Cử nhân";
					} else if (((GiangVien) x).getTrinhDo() == 2) {
						td = "Thạc sĩ";
					} else if (((GiangVien) x).getTrinhDo() == 3) {
						td = "Tiến sĩ";
					}
					System.out.println("Tên giáo viên: " + ((GiangVien) x).getTenNv() + " \nKhoa: "
							+ ((GiangVien) x).getKhoaNV() + " \n Trình độ: " + td + "\n Phụ cấp"
							+ ((GiangVien) x).getPhuCap() + "\n Số tiết dạy:" + ((GiangVien) x).getSongayCong()
							+ "\n Hệ số lương: " + ((GiangVien) x).getHesoLuong());
				}
			}
		} else if (b == 2) {
			String vcl = sc.nextLine();
			System.out.println("Nhập ban: ");
			String ban = sc.nextLine();
			for (NhanVien x : arr) {
				if (ban.equals(x.getKhoaNV()) == true) {
					String ba = " ";
					if (((NhanVien) x).getChucVu() == 1) {
						ba = "Trưởng phòng";
					} else if (((NhanVien) x).getChucVu() == 2) {
						ba = "Phó phòng";
					} else if (((NhanVien) x).getChucVu() == 3) {
						ba = "Nhân viên";
					}
					System.out.println("Tên nhân viên: " + ((NhanVien) x).getTenNv() + "\n Phòng ban: "
							+ ((NhanVien) x).getPhongBan() + "\n Số ngày công: " + ((NhanVien) x).getSongayCong()
							+ "\n Chức vụ: " + ba + "\n Phụ cấp: " + ((NhanVien) x).getPhuCap());
				}
			}
		} else {
			System.out.println("Bạn đã chọn sai");
		}
	}

	public static void tongLuong() {
		double luongGV = 0;
		double luongNV = 0;
		double luong;
		for (NhanVien x : arr) {
			luongGV += ((GiangVien) x).luongNv();
			luongNV += ((NhanVien) x).luongNv();
		}
		luong = luongGV + luongNV;
		System.out.println("Tổng lương: " + luong);
	}
	public static void sapxep() {
		
	}
}
