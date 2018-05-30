/***************************************
 * Tìm số nguyên tố
 * Phạm Ngọc Thành
 * 29/5/2018
 */
package GiaiPTBac2;

import java.util.Scanner;

public class SoNT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// phần khai báo
		int n;
		Scanner scanner = new Scanner(System.in);
		
		
		// phần thân chương trình
		// -- nhập số từ bàn phím
		System.out.println("Nhap so N: ");
		n = scanner.nextInt();
		
		
		// xác định số nguyên tố hay không
		
		
		if (n > 0) {
			int dem = 0;
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {//5:1 = 5 , 5:5 =1 
					dem += 1; //
			}
			}
			if (dem == 2) {
			System.out.println(n + " La so nguyen to");
			}else {
			System.out.println(n + " Khong la so nguyen to");
		}

	}
	}
}
