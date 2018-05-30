/***************************************
 * giải Bất PT
 * Phạm Ngọc Thành
 * 29/5/2018
 */
package GiaiPTBac2;
import java.util.Scanner;
public class GiaiPTBac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		float  a,b,c;
		
		// Nhập a , b, c
		System.out.print("Nhập Số a : ");
		a = scanner.nextInt();
		System.out.print("Nhập Số b : ");
		b= scanner.nextInt();
		System.out.print("Nhập Số c : ");
		c= scanner.nextInt();
		// Kiểm Tra các số đã nhập
		if(a==0) {
			if(b==0) {
				System.out.println("PT vô nghiệm");
			}else {
				System.out.println("PT có 1 nghiệm x= "+ (-c/b));
			}
			
		}
		else { 
			
		}
		
	 float denta = (b*b)-(4*a*c);
		
		//Kiểm tra denta
		if(denta < 0) {
			System.out.println("PT vô Nghiệm");
			
		}else if(denta == 0) {
		
			System.out.println("PT có nghiệm kép x1=x2= " + (-b/(2*a)));
		}else {
			System.out.println("PT có 2 nghiệm phân biệt:");
			System.out.println("PT có Nghiệm x1= "+ (-b + Math.sqrt(denta))/(2*a));
			System.out.println("PT có Nghiệm x2= "+ (-b - Math.sqrt(denta))/(2*a));
			
		}

	}

}