package fasttrackse.baitap.asm;

import java.util.Scanner;

public class PhuongTrinhBac1 {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);

		System.out.println("+----------------------------+");
		System.out.println("| Giải phương trình bậc nhất |");
		System.out.println("+----------------------------+");
		double X;
		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();

		if (A == 0) {
			if (B == 0) {
				System.out.println("Phương trình " + A + "X " + "+ " + B + " = q0" + " vô số nghiệm");
			} else {
				System.out.println("Phương trình " + A + "X " + "+ " + B + " = 0" + " vô nghiệm");
			};

		} else {
			X = B * 1.0 / A;
			System.out.println("Phương trình " + A + "X " + "+ " + B + " = 0 " + "có nghiệm X bằng " + X);
		}
	}
}