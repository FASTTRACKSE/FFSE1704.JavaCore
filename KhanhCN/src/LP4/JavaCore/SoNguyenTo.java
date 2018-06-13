/***********************
 Prog : Tìm sồ nguyên tố 
 Outhor : Cao Ng�?c Khánh
 Date : 29-May-2018
 
*/


package LP4.JavaCore;

import java.util.Scanner;

public class SoNguyenTo {

	public static void main(String[] args) {
		//Phần khai báo 
		int dem = 0;
		Scanner nhap = new Scanner(System.in);
		
		//Phần thân chương trình
		System.out.println("Hãy nhập  một số nguyên bất kỳ : ");
		int so = nhap.nextInt();
		
		
		if (so > 1) {
			for (int i = 1; i <= so; i++) {
				if (so % i == 0) {  
					dem += 1;
				}
			}
			if (dem == 2) {
				System.out.println(" Số " + so + " là số  nguyên tố");
			} else {
				System.out.println(" Số " + so + " không phải là số nguyên tố");
			}
		} else {
			System.out.println(" Số " + so + " không phải là số nguyên tố");
		}

	}
}
