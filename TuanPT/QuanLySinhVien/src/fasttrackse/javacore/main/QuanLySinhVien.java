package fasttrackse.javacore.main;

import java.util.Scanner;

import fasttrackse.javacore.entity.SinhVien;

public class QuanLySinhVien {
	static int n;
	int sinhvien[];
	int i;

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập số lượng sinh viên : ");
		n = myInput.nextInt();
		SinhVien[] sinhvien = new SinhVien[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập tên sinh viên : ");
			myInput.nextLine();
			String tenSinhVien = myInput.nextLine();

			System.out.print("Nhập năm sinh sinh viên : ");
			int namSinh = myInput.nextInt();

			System.out.print("Nhập giới tính sinh viên: ");
			String gioiTinh = myInput.nextLine();
			myInput.nextLine();
			System.out.print("Nhập điểm LP1 của sinh viên : ");
			int diemLP1 = myInput.nextInt();
			System.out.print("Nhập điểm LP2 của sinh viên : ");
			int diemLP2 = myInput.nextInt();
			System.out.print("Nhập điểm LP3 của sinh viên : ");
			int diemLP3 = myInput.nextInt();

			sinhvien[i] = new SinhVien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
		}
		// SinhVien[] sv=new SinhVien[n];
		// SinhVien sv1 = new SinhVien("Nguyễn Văn Anh", 1997, 9, 8, 8);

		// SinhVien sv2 = new SinhVien();
		// sv2.setTenSinhVien("Bùi Thị Bình");
		// sv2.setNamSinh(1999);
		// sv2.setDiemLP1(9);
		// sv2.setDiemLP2(9);
		// sv2.setDiemLP3(10);

		// // In thông tin sinh viên 1
		// System.out.println(sv1.toString());
		// System.out.println(sv1.tinhDiemTrungBinhMon());

		// // In thông tin sinh viên 2
		// System.out.println(sv2.toString() + " DTB:" +
		// Math.round(sv2.tinhDiemTrungBinhMon()));
		// In thông tin sinh viên
		
		System.out.println("Danh Sách Sinh Viên:");
		
//		System.out.println("*******////////**********");
//		System.out.println("Danh Sách Sinh Viên:");
//
//		for (int i = 0; i < sinhvien.length; i++) {
//			System.out.println("Sinh viên thứ" + (i + 1) + ": " + sinhvien[i].toString() + " Điểm trung bình: "
//					+ Math.round(sinhvien[i].tinhDiemTrungBinhMon()) + " Xếp loại: " + sinhvien[i].xepLoai());
//
//		}
//
//		// sắp xếp giảm dần
//		for (int i = 0; i < sinhvien.length - 1; i++) {
//			for (int j = i + 1; j <= sinhvien.length - 1; j++) {
//				if (sinhvien[j].tinhDiemTrungBinhMon() > sinhvien[i].tinhDiemTrungBinhMon()) {
//					SinhVien tang = sinhvien[i];
//					sinhvien[i] = sinhvien[j];
//					sinhvien[j] = tang;
//				}
//			}
//		}
//
//		// in ra thứ tự tăng
//
//		System.out.println("*******////////********** ");
//		System.out.println("Danh Sách Sinh Viên Đã Sắp Xếp:");
//
//		for (int i = 0; i < sinhvien.length; i++) {
//			System.out.println("Xếp hạng thứ " + (i + 1) + ": " + sinhvien[i].getTenSinhVien() + " điểm: "
//					+ Math.round(sinhvien[i].tinhDiemTrungBinhMon()) + "- Xếp loại: " + sinhvien[i].xepLoai());
//
//		}

		System.exit(0);
	}

}
