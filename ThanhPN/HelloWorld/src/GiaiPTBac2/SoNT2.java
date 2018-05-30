/***************************************
 * Tìm số nguyên tố
 * Phạm Ngọc Thành
 * 29/5/2018
 */
package GiaiPTBac2;

import java.util.Scanner;

public class SoNT2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;					
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so N: ");
		n = scanner.nextInt();
		int i = 2;
		while (i < n && (n % i  != 0)) {
		
		i++;
		}
		 //if (n > 0) {
		//	int dem = 0;
			//for (int i = 1; i <= n; i++) {
			//	if (n % i == 0) {//5:1 = 5 , 5:5 =1 
			//		dem += 1; //
		//	}
		//	}
			if (i == n) {
			System.out.println(n + " La so nguyen to");
			}else {
			System.out.println(n + " Khong la so nguyen to");
		}

	}
	}
