package Bai2;
import java.util.Scanner;
public class Giaiptbac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		System.out.println("Giải phương trình bậc hai");
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhập tham số a: ");
		a = myInput.nextInt();
		System.out.print("nhập tham số b: ");
		b = myInput.nextInt();
		System.out.print("nhập tham số c: ");
		c = myInput.nextInt();
		System.out.println("Phương trình có nghiệm " +a+"x*x+ "+b+" x+ "+c+" =0 ");
		int delta=b*b-4*a*c;
		System.out.println("delta = b*b-4*a*c "+ " = " +(b*b-4*a*c));
		if(delta>0) {
			System.out.println("Phương trình có 2 nghiệm phân biệt");
			System.out.println("x1="+(-b+Math.sqrt(delta))/(2*a));
			System.out.println("x2="+(-b-Math.sqrt(delta))/(2*a));
		}
		if(delta==0) {
			System.out.println("phương trình có nghiệp kép x1=x2="+(-b/(2*a)));
		}
		if(delta<0) {
			System.out.println("Phương trình vô nghiệm ");
		}
	}	

}
