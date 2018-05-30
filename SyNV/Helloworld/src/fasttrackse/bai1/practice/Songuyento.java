package fasttrackse.bai1.practice;

import java.util.Scanner;

public class Songuyento {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("************************* ");
		System.out.println("| KIEM TRA SO NGUYEN TO |");
		System.out.println("************************* ");

		System.out.println("Moi ban nhap n : ");
		n = sc.nextInt();
		if (snt(n) == true)
			System.out.println("La so nguyen to");
		else
			System.out.println("Khong phai so nguyen to");

	}

	public static boolean snt(int n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}
}
