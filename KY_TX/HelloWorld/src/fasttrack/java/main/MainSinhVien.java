package fasttrack.java.main;

import java.util.Scanner;

import fasttrackse.java.a.*;

public class MainSinhVien {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập số lượng sinh viên: ");
		int n = myInput.nextInt();
		SinhVien[] sv = new SinhVien[n];
		myInput.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập tên sinh viên: ");
			String ten = myInput.nextLine();
			System.out.print("Nhập năm sinh sinh viên: ");
			int namsinh = myInput.nextInt();
			System.out.print("Nhập điểm LP1 sinh viên: ");
			int lp1 = myInput.nextInt();
			System.out.print("Nhập điểm LP2 sinh viên: ");
			int lp2 = myInput.nextInt();
			System.out.print("Nhập điểm LP3 sinh viên: ");
			int lp3 = myInput.nextInt();
			myInput.nextLine();
			sv[i] = new SinhVien(ten, namsinh, lp1, lp2, lp3);
		}
		// In thông tin sinh viên
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ". " + sv[i].toString());
			System.out.println("Điểm trung bình sinh viên là: " + sv[i].tinhDiemTrungBinhMon());
		}
	}

}