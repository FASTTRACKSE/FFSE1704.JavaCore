package PhuongTrinhBacHai;

import java.util.Scanner;

public class GiaiPhuongTrinhBacHaiMotAn {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập số a = ");
		int a = nhap.nextInt();
		System.out.println("nhập số b =");
		int b = nhap.nextInt();
		System.out.println("Nhập số c =");
		int c = nhap.nextInt();

		System.out.println("phương trình bậc hai có dạng :" + a + "x*x " + " + " + b + "x" + " + " + c + " = 0");
		int delta = b * b - 4 * a * c;
        System.out.println("delta = b*b-4*a*c" + " = " + (b*b-4*a*c));
        if(delta>0){
        	System.out.println("phương trình có hai nghiệm phân biệt");
        	System.out.println("X1= "+ (-b+Math.sqrt(delta))/(2*a));
        	System.out.println("X2="+ (-b-Math.sqrt(delta))/(2*a));
        }if(delta==0) {
        	System.out.println("phương trình có nghiệm kép X1 = X2 = "+ (-b/(2*a)));
    	}if(delta<0){
    		System.out.println("phương trình vô nghiệm");
    	}
	}

}
