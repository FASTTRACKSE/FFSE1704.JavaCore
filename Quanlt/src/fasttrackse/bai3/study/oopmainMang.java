package fasttrackse.bai3.study;

import java.util.Arrays;
import java.util.Scanner;

import fasttrackse.bai3.study.oopMang;

public class oopmainMang {
	static int n, i;

	public static void main(String[] args) {
		System.out.print("Nhập số lượng sinh viên: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		oopMang[] mang = new oopMang[n];

		for (i = 0; i < n; i++) {
			System.out.println("Nhập thông tin sinh viến thứ " + (i + 1));
			mang[i] = new oopMang();
			mang[i].nhapMang();

		}
		for (i = 0; i < n; i++) {
			System.out.println("Thông tin sinh viên thứ " + (i + 1));
			mang[i].xuatMang();
			mang[i].tinhDiemTrungBinh();
			mang[i].xepLoaiSV();
		}
	}
}