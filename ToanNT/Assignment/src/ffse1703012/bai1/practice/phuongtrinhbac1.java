///////////////////////////////////////////
/// Giải phương trình bâc nhất : ax + b = 0
///////////////////////////////////////////
package ffse1703012.bai1.practice;
import java.util.Scanner;
public class phuongtrinhbac1 {
	
	public static void main(String[] args) {
		 int soA, soB;
		 
		 Scanner sc = new Scanner(System.in);
		 
		 	System.out.println("----------------------------");
		 	System.out.println("|Giải phương trình bậc nhất|");
		 	System.out.println("----------------------------");
			System.out.println("Nhập số a: ");
			soA= sc.nextInt();
			System.out.println("Nhập số b: ");
			soB= sc.nextInt();
		if(soA == 0) {
			if(soB ==0) {
				System.out.println("Phương trình vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm!");
			}
		}else {
			System.out.println("Phương trình có nghiệm X = " + (-soB/soA));
		}
	}
}
