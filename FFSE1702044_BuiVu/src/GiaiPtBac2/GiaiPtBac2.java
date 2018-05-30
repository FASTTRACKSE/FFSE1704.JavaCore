package GiaiPtBac2;

import java.util.Scanner;
public class GiaiPtBac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Giải Phương Trình Bậc 2 ");
		Scanner GiaiPtBac2 = new Scanner(System.in);
		int a,b,c;
		double x1,x2;
		// Nhập a , b, c
		System.out.println("Nhập Số a : ");
		a = GiaiPtBac2.nextInt();
		System.out.println("Nhập Số b : ");
		b= GiaiPtBac2.nextInt();
		System.out.println("Nhập Số c : ");
		c= GiaiPtBac2.nextInt();
		// Kiểm Tra các số đã nhập
		if(a==0) {
			if(b==0) {
				System.out.println("PT vô nghiệm");
			}else {
				System.out.println("PT có 1 nghiệm x= "+ (-b/2*a));
			}
			return;
		}
		float detal = (b*b)-(4*a*c);
		
		//Kiểm tra delta
		if(detal < 0) {
			System.out.println("PT vô Nghiệm");
			
		}else if(detal == 0) {
			x1=(-b/2*a);
			System.out.println("PT có nghiệm kép x1=x2= " + x1);
		}else {
			x1= (-b + Math.sqrt(detal)/(2*a));
			x2= (-b - Math.sqrt(detal)/(2*a));
			System.out.println("PT có Nghiệm x1= "+ x1 +"  PT có Nghiệm x2= "+ x2);
		}
		
	}

}