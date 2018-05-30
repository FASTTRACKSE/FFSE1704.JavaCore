package LP4.JavaCore;

import java.util.Scanner;

public class GiaiPTBacNhat {

	public static void main(String[] args) {
      Scanner nhap = new Scanner(System.in);
		
		System.out.println("Nhập vào số a : ");
		int a = nhap.nextInt();
		
		System.out.println("Nhập vào số b : ");
		int b = nhap.nextInt();
		
		if(a==0) {
			if(b==0) {
				System.out.println(" Phương trình " + a +"x + " + b +" = 0 có vô số nghiệm");
			}else {
				System.out.println(" Phương trình "  + a +"x + " + b +" = 0 có vô số nghiệm");
			}
		}else {
		
			float x ; 
			x = (-b/a);
			System.out.println("Phương trình có nghiệm là x = "+x);
		}

	}

}
