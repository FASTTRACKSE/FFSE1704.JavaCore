/************************
 *Tìm Số Nguyên Tố 
 *Le Nguyen Thanh Tung
 *29/05/2018
 **********************/
package fasttrackse.baitap.asm;

import java.util.Scanner;

public class SoNguyenTo {

	public static void main(String[] args) {
		
		Scanner nhapSoNguyenTo = new Scanner(System.in);
		int n;
		int dem=1;
		System.out.print("Nhập n để kiểm tra số nguyên tố : ");
		n = nhapSoNguyenTo.nextInt();
		for (int i=1; i <= n; i++) {
			if(n%i==0) {
			dem= dem+1;
			}
		}
		if(dem > 2) {
			System.out.println("Ko phải số nguyên tố");
		}else {
			System.out.println("Là số nguyên tố");
		}

	}
}