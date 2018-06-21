package fasttrackse.bai3.study;

import java.util.Scanner;

public class sinhVienmian {
	static int n, i;

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);

		System.out.print("nhập số sinh viên : ");
		n = nhap.nextInt();
		sinhVien[] oopMang = new sinhVien[n];
		for (int i = 0; i < n; i++) {

			System.out.print("Nhập tên sinh viên thứ " + (i + 1) + ": ");
			nhap.nextLine();
			String tenSinhVien = nhap.nextLine();

			System.out.print("Giới tính sinh viên thứ " + (i + 1) + ": ");
			String gioiTinh = nhap.nextLine();

			System.out.print("Tuổi sinh viên thứ " + (i + 1) + ": ");
			int namSinh = nhap.nextInt();

			System.out.print("Điểm LP1 sinh viên thứ " + (i + 1) + ": ");
			int diemLP1 = nhap.nextInt();

			System.out.print("Điểm LP2 sinh viên thứ " + (i + 1) + ": ");
			int diemLP2 = nhap.nextInt();

			System.out.print("Điểm LP3 sinh viên thứ " + (i + 1) + ": ");
			int diemLP3 = nhap.nextInt();

			oopMang[i] = new sinhVien(tenSinhVien, gioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
			oopMang[i].tinhDiemTrungBinhMon();

		}
		System.out.println("\nDanh sách sinh viên:");

		for (int i = 0; i < n; i++) {
			System.out.println("Sinh viên thứ" + (i + 1) + ": " + oopMang[i].toString() + " \nĐiểm trung bình: "
					+ oopMang[i].tinhDiemTrungBinhMon() + " \n Xếp loại: " + oopMang[i].xepLoai());

		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				if (oopMang[j].tinhDiemTrungBinhMon() > oopMang[i].tinhDiemTrungBinhMon()) {
					sinhVien a = oopMang[i];
					oopMang[i] = oopMang[j];
					oopMang[j] = a;
				}
			}
		}

		System.out.println(" ");
		System.out.println("Xếp loại SV:");

		for (int i = 0; i < n; i++) {
			System.out.println("Xếp hạng thứ " + (i + 1) + ": \nTên SV: " + oopMang[i].getSinhVien() + "\nĐiểm TB: "
					+ oopMang[i].tinhDiemTrungBinhMon() + "\nXếp loại: " + oopMang[i].xepLoai());

		}

		System.exit(0);
	}
}
