package ffse1703012.bai1.practice;
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.println("|	Giải phép cộng	   |");
		System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("Nhập số a: ");
		a= sc.nextInt();
		int b;
		System.out.print("Nhập số b: ");
		b= sc.nextInt();
		int c=a+b;
		System.out.print("Kết quả của "+a+ " + " +b +" = "+c);
		
	}

}
