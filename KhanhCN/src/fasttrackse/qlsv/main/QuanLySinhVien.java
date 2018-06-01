package fasttrackse.qlsv.main;

import java.util.Scanner;

import fasttrackse.qlsv.entity.SinhVien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		int n;
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nhập số lương sinh viên : ");
		n = myInput.nextInt();
		SinhVien[] danhsach = new SinhVien[n];

		for (int i = 0; i < n; i++) {

			System.out.println("Nhập thông tinh sinh viên thứ " + i + " :");

			System.out.println("Nhập họ tên sinh viên : ");
			myInput.nextLine();
			String tenSinhVien = myInput.nextLine();

			System.out.println("Nhập năm sinh của bạn : ");
			int namSinh = myInput.nextInt();

			System.out.println("Nhập giới tính của bạn : ");
			myInput.nextLine();
			String gioiTinh = myInput.nextLine();

			System.out.println("Nhập điểm LP1 của bạn : ");
			int diemLP1 = myInput.nextInt();

			System.out.println("Nhập điểm LP2 của bạn : ");
			int diemLP2 = myInput.nextInt();

			System.out.println("Nhập điểm LP3 của bạn : ");
			int diemLP3 = myInput.nextInt();

			danhsach[i] = new SinhVien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
			
		}

		int stt = 0;
		System.out.println("\t \t \t\tDANH SÁCH SINH VIÊN");
		System.out.println("\t \t \t *********************************");
		System.out.printf("\n" + "%-10s %-15s %-10s %-12s %-8s %-8s %-8s %-8s %-8s", "STT", "Họ và tên", "Năm Sinh",
				"Giới tính", "LP1", "LP2", "LP3", "TB", "XLoại");
		System.out.println("\n---------------------------------------------------------------------------------------------");

		for (int i = 0; i < n; i++) {

			stt++;
			System.out.printf("\n" + stt + danhsach[i].toString() + danhsach[i].tinhDiemTrungBinh() + "\t"
					+ danhsach[i].xepLoaiSinhVien());
		}
		System.out.println("/n");
		System.out.println("\n---------------------------------------------------------------------------------------------");

		// sắp xếp điểm trung bình từ cao đến thấp

		
		for (int i = 0; i < danhsach.length - 1; i++) {
			for (int j = i + 1; j <= danhsach.length - 1; j++) {
				if (danhsach[j].tinhDiemTrungBinh() > danhsach[i].tinhDiemTrungBinh()) {
					SinhVien tang = danhsach[i];
					danhsach[i] = danhsach[j];
					danhsach[j] = tang;
				}
			}
		}

		System.out.println("\n\t \t \t\tDANH SÁCH SINH VIÊN ĐÃ SẮP XẾP");
		System.out.println("\t \t \t *******************************************");
		System.out.printf("\n" + "%-10s %-15s %-10s %-12s %-8s %-8s %-8s %-8s %-8s", "STT", "Họ và tên", "Năm Sinh",
				"Giới tính", "LP1", "LP2", "LP3", "TB", "XLoại");

		for (int i = 0; i < danhsach.length; i++) {

			stt++;
			System.out.printf("\n" + stt + danhsach[i].toString() + danhsach[i].tinhDiemTrungBinh() + "\t"
					+ danhsach[i].xepLoaiSinhVien());
		}
		

	}

}
