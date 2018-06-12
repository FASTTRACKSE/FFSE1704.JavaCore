/**********************	
 * prog:tiềm số ngu
 * 
 */
package assignment2;

import java.util.Scanner;

public class TimSoNguyenTo {

	public static void main(String[] args) {
		// phần khai báo
		int n;
		Scanner myInput = new Scanner(System.in);
		// phần thân chương trình
		n = myInput.nextInt();
		System.out.print("nhập số nguyên");
		//xác định có pải là số nguyên tố hay 
		for (int i=1; i<=n; i++) {
			if(n%i ==0) {
				tongUocSo++;
			}
		}
	}
}