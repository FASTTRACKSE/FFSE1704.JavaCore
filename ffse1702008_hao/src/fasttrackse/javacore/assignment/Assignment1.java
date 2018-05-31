package fasttrackse.javacore.assignment;
import java.util.Scanner;
public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Giải phương trình bậc 1: ax + b = 0");
		Scanner ptbac1 = new Scanner(System.in);
		double a,b;
		//  nhập tham số
		System.out.println("Mời nhập tham số a: ");
		a = ptbac1.nextDouble();
		System.out.println("Mời nhập tham số b: ");
		b = ptbac1.nextDouble();		
		// giải pbbac1
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm.");
			}
			else {
				System.out.println("Phương trình vô nghiệm.");
			}
			
		}
		else {
			System.out.println("Phương trình có nghiêm: " + (-b/a));
		}
	}

}
