package bai3;
import java.util.Scanner;
public class KiemTraSoNT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int son;
		int dem=0;
		@SuppressWarnings("resource")
		// Khai báo biến Scanner nhập dữ liệu từ bàn phím
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhập số nguyên a: ");
		son = myInput.nextInt();
		
		for(int i=1 ;i<=son ; i++) {
			if(son%i==0) {
			dem=dem+1;
			
			System.out.println("Số nguyên  (" + son + ") chia hết cho " + i);
			}
		}
		if(dem>2) {
			System.out.println("Số nguyên a (" + son + ") không phải là số nguyên tố");
		}
		else {
			System.out.println("Số nguyên a (" + son + ")  là số nguyên tố");
		}
		
	}

}
