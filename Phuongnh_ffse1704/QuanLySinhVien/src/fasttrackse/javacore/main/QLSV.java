package fasttrackse.javacore.main;

import java.util.Scanner;

import fasttrackse.javacore.qlsv.SinhVien;

public class QLSV {
	

	public static void main(String[] args) {
		 int N;
		Scanner myInput = new Scanner(System.in);

		System.out.print("nhập tổng số sinh viên ");
		N = myInput.nextInt();
		SinhVien[] sinhvien = new SinhVien[N];
		for (int i = 0; i < N; i++) {
			myInput.nextLine();

			System.out.print("Nhap ten sinh vien: ");
			String ten = myInput.nextLine();
			
			System.out.print("Giới Tính ");
			String gioitinh = myInput.nextLine();
			
			System.out.print("Nhap nam sinh sinh vien: ");
			int namsinh = myInput.nextInt();
			System.out.print("nhập điểm lp1: ");
			int diemlp1 = myInput.nextInt();
			System.out.print("nhập điểm lp2: ");
			int diemlp2 = myInput.nextInt();
			System.out.print("nhập điểm lp3: ");
			int diemlp3 = myInput.nextInt();
			System.out.println("------------------------- ");
			sinhvien[i] = new SinhVien(ten, gioitinh, namsinh, diemlp1, diemlp2, diemlp3);
			
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
		System.out.println("---------------------------Danh Sách Sinh Viên Đã Sắp Xếp---------------------------- ");

		for (int i = 0; i < sinhvien.length; i++) {
			System.out.println("STT       "+"Tên sinh viên    "+"Năm Sinh      "+"Giới Tính     "+ "Điểm Trung Bình     "+"Xếp Loại");
			System.out.println((i + 1) + ". " + "        "+sinhvien[i].toString()+"          "+sinhvien[i].getgioiTinh()+"            "+ sinhvien[i].tinhDiemTrungBinhMon()+"               "   + sinhvien[i].xepLoai());
		System.out.println("------------------------------------------------------------------------------------- ");
		}

		System.exit(0);
	}
}