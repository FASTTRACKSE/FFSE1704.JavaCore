/**
 * 
 */
package ffse1704.javaday1.vidu.vidu1;

import java.util.Scanner;

/**
 * @author Support
 *
 */
import java.util.Scanner;

public class Vidu4 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
Scanner myInput = new Scanner(System.in);
		
		System.out.println("*************************");
		System.out.println("| LEE KHAR HOONG NHAATJ |");
		System.out.println("*************************");
		
 		
		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();
		
		System.out.print("Nhập tham số c = ");
		int C = myInput.nextInt();
		
		
		 if(A==0) {
			 if(B==0) {
				 if(C==0) {
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô số nghiệm"); 
				 }else {
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô  nghiệm");
				 }; 
			 }else {
				double X =C *1.0/ B;
				 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm X bằng "+X);
			 }; 
		 }else{
			 int delta= (B*B)-(4*A*C);
			 if(delta==0) {
				double X = -B/2*A;
				 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm kép X bằng "+X);
			 }else {
				 if(delta>0){
					 double X1 =(-B + delta)/2*A;
					 double X2 =(-B - delta)/2*A;
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm  X1 bằng  "+X1+"  và X2 bằng "+X2);
				 }else {
					 System.out.println("Phương trình"+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô  nghiệm");
				 }
			 }
		 };

	{
		
		
	};

}

}
