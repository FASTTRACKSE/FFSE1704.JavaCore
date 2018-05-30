package ffse.khoa.bai4;

import java.util.Scanner;

public class Timsonguyento {

	public static void main(String[] args) {
		 
		 int a, dem=0;
		 Scanner Songuyento = new Scanner(System.in);
		 System.out.println("Nhap so nguyen to : ");
		a = Songuyento.nextInt();
		for(int i=1; i<=a; i++) {
			if (a%i==0) {
				dem = dem+1;
			}
		}
		if (dem > 2) {
			System.out.println(a+ "Khong la so nguyen to");
		} else {
			System.out.println(a+ "La So nguyen to");
		}

	


		
		
	} 
}

