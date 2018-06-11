package ffse1703012.bai1.practice;

import ffse1703012.bai1.practice.sinhvien;
import java.util.Scanner;
public class RunProgram {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

	static int n, sinhvien[], i;
		System.out.print("Nhập số sinh viên : ");
		n = sc.nextInt();
		SinhVien[] sinhvien = new SinhVien[n];
		for (int i = 0; i < n; i++) {

			System.out.print("Nhập tên sinh viên: ");
			sc.nextLine();
			String tenSinhVien = sc.nextLine();

			System.out.print("Nhập giới tính sinh viên: ");
			String gioiTinh = sc.nextLine();

			System.out.print("Nhập năm sinh sinh viên: ");
			int namSinh = sc.nextInt();

			System.out.print("Nhập điểm LP1 của sinh viên: ");
			int diemLP1 = sc.nextInt();

			System.out.print("Nhập điểm LP2 của sinh viên: ");
			int diemLP2 = sc.nextInt();

			System.out.print("Nhập điểm LP3 của sinh viên: \n");
			int diemLP3 = sc.nextInt();

			System.out.println("********************************");
			sinhvien[i] = new SinhVien(tenSinhVien, gioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
			

		}
		System.out.println(" ");
		System.out.println("******************** DANH SÁCH SINH VIÊN ************************");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Sinh viên thứ" + (i + 1) + ": " + sinhvien[i].toString() + " Điểm trung bình: "
					+ sinhvien[i].tinhDiemTrungBinhMon() + " ***** Xếp loại: " + sinhvien[i].xepLoai());

		}

		//giảm dần
		for (int i = 0; i < sinhvien.length - 1; i++) {
			for (int j = i + 1; j <= sinhvien.length - 1; j++) {
				if (sinhvien[j].tinhDiemTrungBinhMon() > sinhvien[i].tinhDiemTrungBinhMon()) {
					SinhVien tang = sinhvien[i];
					sinhvien[i] = sinhvien[j];
					sinhvien[j] = tang;
				}
			}
		}

		System.out.println(" ");
		System.out.println("Danh Sách Sinh Viên Đã Sắp Xếp");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Xếp hạng thứ " + (i + 1) + ": " + sinhvien[i].getSinhVien() + " ***** "
					+ sinhvien[i].tinhDiemTrungBinhMon() + " điểm ***** " + "Xếp loại: " + sinhvien[i].xepLoai());

		}

		System.exit(0);
	}

}
