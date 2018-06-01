/************************
 *Prog: QUẢN LÝ SINH VIÊN
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 31/05/2018
 **********************/
package ffse.quanlysinhvien.main;

/**
 * @author Support
 *
 */
import java.util.Scanner;

import ffse.quanlysinhvien.entity.SinhVien;

public class Main {
	static int N, sinhvien[], i;

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập số sinh viên : ");
		N = nhap.nextInt();
		SinhVien[] sinhvien = new SinhVien[N];
		for (int i = 0; i < N; i++) {

			System.out.print("Nhập tên sinh viên: ");
			nhap.nextLine();
			String tenSinhVien = nhap.nextLine();

			System.out.print("Nhập giới tính sinh viên: ");
			String gioiTinh = nhap.nextLine();

			System.out.print("Nhập năm sinh sinh viên: ");
			int namSinh = nhap.nextInt();

			System.out.print("Nhập điểm LP1 của sinh viên: ");
			int diemLP1 = nhap.nextInt();

			System.out.print("Nhập điểm LP2 của sinh viên: ");
			int diemLP2 = nhap.nextInt();

			System.out.print("Nhập điểm LP3 của sinh viên: \n");		
			int diemLP3 = nhap.nextInt();
			
			System.out.println("********************************");
			sinhvien[i] = new SinhVien(tenSinhVien, gioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
			sinhvien[i].tinhDiemTrungBinhMon();

		}

		// if (sinhvien[i].tinhDiemTrungBinhMon() <= 5) {
		//
		// System.out.println("Yếu");

		// } else if (sinhvien[i].tinhDiemTrungBinhMon() <= 7) {
		//
		// System.out.println("Trung Bình");

		// } else if (sinhvien[i].tinhDiemTrungBinhMon() <= 8.5) {
		//
		// System.out.println("Khá");

		// } else {
		//
		// System.out.println("Giỏi");

		// }

		// in danh sách ban đầu
		System.out.println(" ");
		System.out.println("******************** DANH SÁCH SINH VIÊN ************************");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Sinh viên thứ" + (i + 1) + ": " + sinhvien[i].toString() + " Điểm trung bình: "
					+ sinhvien[i].tinhDiemTrungBinhMon() + " ***** Xếp loại: " + sinhvien[i].xepLoai());

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

		System.out.println(" ");
		System.out.println("***************Danh Sách Sinh Viên Đã Sắp Xếp******************");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("Xếp hạng thứ " + (i + 1) + ": " + sinhvien[i].getSinhVien() + " ***** "
					+ sinhvien[i].tinhDiemTrungBinhMon() + " điểm ***** "+"Xếp loại: "+sinhvien[i].xepLoai());

		}

		System.exit(0);
	}
}
