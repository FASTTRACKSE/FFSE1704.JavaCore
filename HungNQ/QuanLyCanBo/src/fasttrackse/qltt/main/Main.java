package fasttrackse.qltt.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Hệ phương trình bậc nhất 1 ẩn ax+b=0");

				System.out.println("Mời bạn nhập số a = ");
				int a = myInput.nextInt();

				System.out.println("Mời bạn nhập số b = ");
				int b = myInput.nextInt();

				double x = -b*1.0 / a;

				System.out.println("Kết quả của bạn là x = " + x);

			} catch (Exception e) {
				System.out.println("Mời bạn nhập a khác 0!");
			}
		}
	}

}
