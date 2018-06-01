package Assignment1;

import java.util.Scanner;

public class PhuongTrinhBac1 {
	public static void main(String[] args) {
		int a, b;
		double x;
		Scanner myInput = new Scanner(System.in);
		
		System.out.println("Mời bạn nhập tham số a =  ");
		a = myInput.nextInt();
		
		if(a == 0) {
			System.out.println("Phương trình vô nghiệm");
		}
		else {
			System.out.println("Mời bạn nhập tham số b =  ");
			b = myInput.nextInt();
			if(b == 0) {
				System.out.println("Phương trình " + a + "x + " + b + " = 0 " + "có nghiệm là x = 0" );
			}
			else {
				x = -b/a;
				System.out.println("Phương trình " + a + "x + " + b + " = 0 " + "có nghiệm là " + x);
			}
		}		
	}	
}