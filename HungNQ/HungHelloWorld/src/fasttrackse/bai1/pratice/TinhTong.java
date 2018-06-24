package fasttrackse.bai1.pratice;

import java.util.Scanner;

public class TinhTong {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập số A:");
		int soA = myInput.nextInt();

		System.out.print("Nhập số B:");
		int soB = myInput.nextInt();

		int tongHaiSo = soA + soB;

		System.out.println("Tổng hai số " + soA + " và " + soB + " là " + tongHaiSo);
	}
}
