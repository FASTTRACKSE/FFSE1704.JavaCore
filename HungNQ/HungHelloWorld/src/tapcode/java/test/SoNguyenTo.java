/**
 * code tập java
 */
package tapcode.java.test;

import java.util.Scanner;

/**
 * @author Admin
 * 
 */
public class SoNguyenTo {
	public static void main(String[] args) {

		System.out.println("********************");
		System.out.println("****Số Nguyên Tố****");
		System.out.println("********************");

		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số n: ");
		n = sc.nextInt();
		if (n > 0) {
			if (kiemtrasonguyento(n) == 1) {
				System.out.println(n + " Là số nguyên tố");
			} else {
				System.out.println(n + " Không phải là số nguyên tố");
			}
		}
	}

	public static int kiemtrasonguyento(int n) {
		int dem = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				dem++;
			}
		}
		if (dem == 2) {
			return 1;
		} else {
			return 0;
		}
	}
}
