package fasttrackse.javacore.practice;

import fasttrackse.javacore.sinhvien.SinhVien;
import java.util.Scanner;


public class MenuMain {
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
			sinhvien[i].tinhDiemTrungBinhMon();
		}

		System.out.println("+--------------------------+");
		System.out.println("Danh Sách Sinh Viên:");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Sinh viên thứ" + (i + 1) + ": " + sinhvien[i].toString() + " Điểm trung bình: "
					+ Math.round(sinhvien[i].tinhDiemTrungBinhMon()) + " Xếp loại: " + sinhvien[i].xepLoai());

		}

		// sắp xếp giảm dần
		for (int i = 0; i < sinhvien.length - 1; i++) {
			for (int j = i + 1; j <= sinhvien.length - 1; j++) {
				if (sinhvien[j].tinhDiemTrungBinhMon() > sinhvien[i].tinhDiemTrungBinhMon()) {
					SinhVien tang = sinhvien[i];
					sinhvien[i] = sinhvien[j];
					sinhvien[j] = tang;
				}
			}
		}

		// in ra thứ tự tăng

		System.out.println("+--------------------------+");
		System.out.println("Danh Sách Sinh Viên Đã Sắp Xếp:");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Xếp hạng thứ " + (i + 1) + ": " + sinhvien[i].getTenSinhVien() +" điểm: "
					+ Math.round(sinhvien[i].tinhDiemTrungBinhMon())  + "- Xếp loại: " + sinhvien[i].xepLoai());

		}

		System.exit(0);
	}

}