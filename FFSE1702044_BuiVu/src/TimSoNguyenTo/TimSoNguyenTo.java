/************************
 *Tìm Số Nguyên Tố 
 *Bùi Lê Anh Vũ
 *29/05/2018
 **********************/
package TimSoNguyenTo;

import java.util.Scanner;

public class TimSoNguyenTo {

	public static void main(String[] args) {
		// khai báo
		Scanner nhapSoNguyenTo = new Scanner(System.in);
		int n;
		int dem=1;
		System.out.print("Nhập n để kiểm tra số nguyên tố : ");
		n = nhapSoNguyenTo.nextInt();
		//for (int i=1; i <= n; i++) {
			//if(n%i==0) {
			//dem= dem+1;
			//}
		//}
		//if(dem > 2) {
			//System.out.println("Ko phải số nguyên tố");
		//}else {
			//System.out.println("Là số nguyên tố");
		//}
		int i=2;
	while(i<n || n%i!=0  ) {
		dem= dem++;
		System.out.print(dem);
		break;
	}
		if(dem == 2) {
			System.out.println("Ko phải số nguyên tố");
		}else {
			System.out.println("Là số nguyên tố");
		}
	}
}
