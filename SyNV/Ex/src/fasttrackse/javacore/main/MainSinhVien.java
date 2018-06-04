package fasttrackse.javacore.main;

import java.util.Scanner;

import fasttrackse.javacore.entity.*;

public class MainSinhVien {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien: ");
		int n = myInput.nextInt();
		SinhVien[] sv = new SinhVien[n];
		myInput.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.print("Nhap ten sinh vien: ");
			String ten = myInput.nextLine();
			System.out.print("Nhap nam sinh sinh vien: ");
			int namsinh = myInput.nextInt();
			System.out.print("Nhap diem LP1 sinh vien: ");
			int lp1 = myInput.nextInt();
			System.out.print("Nhap diem LP2 sinh vien: ");
			int lp2 = myInput.nextInt();
			System.out.print("Nhap diem LP3 sinh vien: ");
			int lp3 = myInput.nextInt();
			myInput.nextLine();
			sv[1] = new SinhVien(ten, namsinh, lp1, lp2, lp3);
		}
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ". " + sv[i].toString());
			System.out.println("Diem trung binh sinh vien la: " + sv[i].tinhDiemTrungBinhMon());
			System.out.println(sv[i].xeploai());
		}
		for (int i = 0; i < sv.length - 1; i++) {
			for (int j = i + 1; j <= sv.length - 1; j++) {
			if (sv[j].tinhDiemTrungBinhMon() > sv[i].tinhDiemTrungBinhMon()) {
				SinhVien tang = sv[i];
				sv[i] = sv[j];
				sv[j] = tang;
			}
		}
	}
	System.out.println("-----------------------Sap xep theo chieu giam dan------------------------");
	for (int i = 0; i < sv.length - 1; i++) {
		System.out.println("Sinh vien thu " + (i+1) + "la: " + sv[i].tenSinhVien());
		
	}
	for (int i = 0; i < sv.length - 1; i++) {
		for (int j = i + 1; j <= sv.length - 1; j++) {
			if (sv[j].tinhDiemTrungBinhMon() < sv[i].tinhDiemTrungBinhMon()) {
				SinhVien tang = sv[i];
				sv[i] = sv[j];
				sv[j] = tang;
			}
		}
	}
	System.out.println("-----------------------Sap xep theo chieu tang------------------------");
	for (int i = 0; i < sv.length; i++) {
		System.out.println("Sinh vien thu: " + (i+1) + "la: " + sv[i].tenSinhVien());
	}
		
	}

}
