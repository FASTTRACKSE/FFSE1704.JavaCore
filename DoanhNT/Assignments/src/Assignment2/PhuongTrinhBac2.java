package Assignment2;

import java.util.Scanner;

public class PhuongTrinhBac2 {
	public static void main(String[] args) {
		int a, b, c;
		double x;
		//double delta = Math.pow(b, 2) - 4*a*c;
		Scanner myInput = new Scanner(System.in);
		
		System.out.println("Mời bạn nhập tham số a = ");
		a = myInput.nextInt();
		
		//Nếu a=0 thì phương trình trở thành phương trình bật nhất ax + b = 0
		if(a == 0) {
			System.out.println("Mời bạn nhập tham số b = ");
			b = myInput.nextInt();
			if(b == 0) {
				System.out.println("Phương trình vô nghiệm");
			}
			else {
				System.out.println("Mời bạn nhập tham số c = ");
				c = myInput.nextInt();
				if(c == 0) {
					System.out.println("Phương trình có nghiệm là x = 0");
				}
				else {
					x = -c/b;
					System.out.println("Phương trình có nghiệm là " + x);
				}
			}
		}

		else {
			System.out.println("Mời bạn nhập tham số b = ");
			b = myInput.nextInt();
			
			System.out.println("Mời bạn nhập tham số c = ");
			c = myInput.nextInt();
			
			double delta = Math.pow(b, 2) - 4*a*c;
			if(delta == 0) {
				x = -b/(2*a);
				System.out.println("Phương trình " + a + "x^2 + " + b + "x + " + c + " = 0 " + "có nghiệm kép là x = " + x);
			}
			else {
				if(delta < 0) {
					System.out.println("Phương trình " + a + "x^2 + " + b + "x + " + c + " = 0 " + "vô nghiệm");
				}
				else {
					double x1 = (-b + Math.sqrt(delta))/(2*a);
					double x2 = (-b - Math.sqrt(delta))/(2*a);
					System.out.println("Phương trình " + a + "x^2 + " + b + "x + " + c + " = 0 " + "có 2 nghiệm là x1 = " + x1 + " và x2 = " + x2);
				}
			}
		}
	}
}
