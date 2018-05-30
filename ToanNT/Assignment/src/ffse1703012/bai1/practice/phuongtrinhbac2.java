package ffse1703012.bai1.practice;
//////////////////////////////////////
// Giải phương trình bậc hai một ẩn //
/////////////////////////////////////
import java.util.Scanner;

public class phuongtrinhbac2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("|Giải phương trình bậc hai|");
		System.out.println("----------------------------");
		int a;
		System.out.println("Mời nhập sô a: ");
		a = sc.nextInt();
		int b;
		System.out.println("Mời nhập sô b: ");
		b = sc.nextInt();
		int c;
		System.out.println("Mời nhập sô c: ");
		c = sc.nextInt();

		double delta = Math.pow(b, 2) - 4 * a * c;
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("Phương trình vô số nghiệm");
				} else {
					System.out.println("Phương trình vô nghiệm!");
				}
			} else {
				System.out.println("Phương trình có nghiệm X = " + (-b / a));
			}
		} else {

			if (delta > 0) {
				System.out.println("Phương trình có hai nghiệm phân biệt X1= " + (-b + Math.sqrt(delta)) / (2 * a)
						+ " và X2= " + (-b - Math.sqrt(delta)) / (2 * a));
			} else if (delta < 0) {
				System.out.println("Phương trình vô nghiệm!");
			} else if (delta == 0) {
				System.out.println("Phương trình có nghiệm kép X1 = X2 = " + (-b / 2 * a));
			}
		}
	}
}
