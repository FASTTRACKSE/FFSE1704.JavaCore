package LP4.JavaCore;

import java.util.Scanner;

/**
 GIẢI PHƯƠNG TRÌNH BẬC 2 
 ***********************
 |   ax2 + bx +c = 0   |
 ***********************
 ---------------
 nếu a = 0 => có nghiệm là x = -c/b
 ---------------
 nếu a !=0 => delta  = b2 - 4ac
 ---------------
 nếu delta < 0 => phương trình vô nghiệm
 ---------------
 delta = 0 => x =  -b/2a
 ---------------
 delta > 0 => có hai nghiệm : 
 
  x1 = (-b - sqrt(delta))/(2a)
 --------------
  x2 = (-b + sqrt(delta))/(2a)
 
 * */ 
public class GiaiPTBac2 {
	public static void main(String[]args) {
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("Nhập vào số a : ");
		float a = nhap.nextFloat();
		
		System.out.println("Nhập vào số b :");
		float b = nhap.nextFloat();
		
		System.out.println("Nhập vào số c ");
		float c = nhap.nextFloat();
		
		if(a==0) {
			if(b==0) {
				System.out.println(" Phương trình " + a +"x2 + " + b+"x + " +c+" = 0 vô nghiệm");
			}else {
				System.out.println(" Phương trình " + a +"x2 + " + b+"x + " +c+" = 0 có nghiệm là : "+ (-c/b));
			}
			return;
		}
		
		 float delta = (b*b) - (4*a*c);
	
		if(delta > 0 ) { 
			
			float x1 = (float) ((-b) + Math.sqrt(delta)) / (2*a);
			float x2 = (float) ((-b) - Math.sqrt(delta))/(2*a);
			 
			System.out.println("Phương trình " + a +"x2 + " + b+"x + " +c+" = 0 có 2  nghiệm là : ");
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
			
	}else if(delta == 0) {
		
		float x = (-b/(2*a));
		System.out.println("Phương trình " + a +"x2 + " + b+"x + " +c+" = 0 có nghiệm là :" + x);
		
	}else {
		
		System.out.println("Phương trình " + a +"x2 + " + b+"x + " +c+" = 0 vô nghiệm");
	}
	
	}
}


