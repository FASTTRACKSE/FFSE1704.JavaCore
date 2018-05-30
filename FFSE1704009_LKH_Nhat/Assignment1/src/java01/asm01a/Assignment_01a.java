/**
 * 
 */
package java01.asm01a;

/**
 * @author Support
 *
 */
import java.util.Scanner;
public class Assignment_01a {

	public static void main(String[] args) {
Scanner myInput = new Scanner(System.in);
		
		System.out.println("*************************");
		System.out.println("| LEE KHAR HOONG NHAATJ |");
		System.out.println("*************************");	
 		double X;
		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();
		
		 if(A==0) {
			 if(B==10) {
				 System.out.println("Phương trình"+ A + "X" + "+"+B +"=0"+"vô số nghiệm"); 
			 }else{
				 System.out.println("Phương trình"+ A + "X" + "+"+B +"=0"+"vô nghiệm");
			 };
			 
		 }else{
			 X =B *1.0/ A;
			 System.out.println("Phương trình "+ A + "X" + "+"+B +"=0 "+"có nghiệm X bằng "+X);
		 };
	
		
		

}
