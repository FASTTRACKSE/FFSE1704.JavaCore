package LP4.JavaCore;
import java.util.Scanner;

public class TinhTong {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("Nhập vào số a : ");
		int a = nhap.nextInt();
		
		System.out.println("Nhập vào số b : ");
		int b = nhap.nextInt();
		
		 int tong = a + b;
		 
		 System.out.println(" Tổng của sô "+a+ " và số "+b+ " là: "+tong);
	}

}
