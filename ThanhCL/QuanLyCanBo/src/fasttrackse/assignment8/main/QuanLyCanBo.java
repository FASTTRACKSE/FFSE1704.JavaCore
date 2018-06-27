package fasttrackse.assignment8.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import fasttrackse.assignment8.entity.CanBo;
import fasttrackse.assignment8.entity.GiangVien;
import fasttrackse.assignment8.entity.NhanVien;
import fasttrackse.assignment8.util.CBComparator;

public class QuanLyCanBo {
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);
	
	public static void NhapDanhSachCanBo() {
		// Nhập danh sách cán bộ
		System.out.print("Bạn muốn nhập bao nhiêu cán bộ: ");
		int soluong = myInput.nextInt();

		String hoTen, khoa, phongBan, trinhDo, chucVu;
		int soNgayCong, soTietDay;
		double hsLuong = 0;
		long phuCap = 0;

		for (int i = 0; i < soluong; i++) {
			System.out.print("Nhập thông tin cán bộ thứ " + (i + 1));
			System.out.print("Loại cán bộ (1- Nhân Viên, 2- Giảng Viên): ");
			int loai = myInput.nextInt();
			if (loai == 1) {
				myInput.nextLine(); // bỏ ký tự enter khi nhập họ tên
				System.out.print("Họ tên: ");
				hoTen = myInput.nextLine();

				System.out.print("Phòng ban: ");
				phongBan = myInput.nextLine();

				System.out.print("Chức vụ: ");
				chucVu = myInput.nextLine();

				System.out.print("Số ngày công: ");
				soNgayCong = myInput.nextInt();

				System.out.print("Hệ số lương: ");
				hsLuong = myInput.nextDouble();

				switch (chucVu) {
				case "Trưởng Phòng":
					phuCap = 2000;
					break;
				case "Phó Phòng":
					phuCap = 1000;
					break;
				case "Nhân Viên":
					phuCap = 500;
					break;
				}

				dsCanBo.add(new NhanVien(hoTen, phuCap, hsLuong, phongBan, chucVu, soNgayCong));
			} else if (loai == 2) {
				myInput.nextLine(); // bỏ ký tự enter khi nhập họ tên
				System.out.print("Họ tên: ");
				hoTen = myInput.nextLine();

				System.out.print("Khoa: ");
				khoa = myInput.nextLine();

				System.out.print("Trình độ: ");
				trinhDo = myInput.nextLine();

				System.out.print("Số tiết dạy: ");
				soTietDay = myInput.nextInt();

				System.out.print("Hệ số lương: ");
				hsLuong = myInput.nextDouble();

				switch (trinhDo) {
				case "Cử Nhân":
					phuCap = 300;
					break;
				case "Thạc Sỹ":
					phuCap = 500;
					break;
				case "Tiến Sỹ":
					phuCap = 1000;
					break;
				}

				dsCanBo.add(new GiangVien(hoTen, phuCap, hsLuong, khoa, trinhDo, soTietDay));
			}

		}		
	}

	public static void main(String[] args) {
		dsCanBo.add(new GiangVien("Thành Tiến Sỹ", 1000, 1.8, "Tin Học Cơ Sở", "Tiến Sỹ", 20));
		dsCanBo.add(new GiangVien("Thành Thạc Sỹ", 500, 1.8, "Tin Học Cơ Sở", "Thạc Sỹ", 40));
		dsCanBo.add(new GiangVien("Thành Cử Nhân", 300, 1.8, "Tin Học Văn Phòng", "Cử Nhân", 60));
		
		dsCanBo.add(new NhanVien("Lê Trưởng Phòng", 2000, 8, "Đào Tạo", "Trưởng Phòng", 22));
		dsCanBo.add(new NhanVien("Lê Phó Phòng", 1000, 4, "Đào Tạo", "Phó Phòng", 22));
		dsCanBo.add(new NhanVien("Lê Nhân Viên", 500, 1, "CTSV", "Nhân Viên", 22));
		dsCanBo.add(new NhanVien("Cao Nhân Viên", 500, 1, "CTSV", "Nhân Viên", 22));
		dsCanBo.add(new NhanVien("Thanh Nhân Viên", 500, 1, "CTSV", "Nhân Viên", 22));
		
		Collections.sort(dsCanBo, CBComparator.CBLuongDESCTenCBASCComparator);
		
		InDanhSachCanBoTruong();
		
	}
	
	public static void InDanhSachCanBoTruong() {
		// In danh sách cán bộ
		for (CanBo o : dsCanBo) {
			System.out.println(o.getTenCB() + "--" + o.getPhuCap() + "--" + o.tinhLuong());					
		}

	}
	
	public static void InCanBoTheoPhongBan() {
		System.out.print("In danh sách cán bộ (1- Nhân Viên, 2- Giảng Viên)");
		int loai = myInput.nextInt();
		System.out.print("Tên Phòng Ban/ Khoa: ");
		myInput.nextLine();
		String ten = myInput.nextLine();

		// In danh sách cán bộ
		for (CanBo o : dsCanBo) {
			if (loai == 1) {
				if (o instanceof NhanVien) {
					if (ten.equals(((NhanVien) o).getPhongBan())) {
						System.out.println(o.getTenCB() + "--" + o.getPhuCap() + "--" + o.tinhLuong());					
					}
				}
			} else if (loai == 2) {
				if (o instanceof GiangVien) {
					if (ten.equals(((GiangVien) o).getTenKhoa())) {
						System.out.println(o.getTenCB() + "--" + o.getPhuCap() + "--" + o.tinhLuong());					
					}
				}
			}
		}

	}

}
