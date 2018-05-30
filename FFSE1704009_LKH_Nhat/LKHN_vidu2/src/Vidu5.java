/**
 * 
 */

/**
 * @author Support
 *
 */
import java.util.Scanner;

public class Vidu5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		Scanner myInput = new Scanner(System.in);

		System.out.println("*************************");
		System.out.println("| KIEM TRA SO NGUYEN TO |");
		System.out.println("*************************");

		System.out.println("Nhập số cần kiểm tra: ");
		n = myInput.nextInt();
		
//cách 1:		
		int dem = 0;
		int i = 2;
		while (i < n &&(n%i!=0)) {
			
			i++;

		}
		;
		if (i == n) {
			System.out.println("số " + n + " là số nguyên tố");
		} else {
			System.out.println("số " + n + " không phải số nguyên tố");
		}

		
//cách 2:		
//		while (n < 1) {
//			System.out.println("n phải lớn hơn hoặc bằng 1: ");
//			n = myInput.nextInt();
//		}
//
//		int dem = 0;
//		for (int i = 1; i <= n; i++) {
//			if (n % i == 0) {
//				dem++;
//			}
//		}
//		if (dem == 2) {
//			System.out.println("Số " + n + " là số nguyên tố");
//		} else {
//			if(dem == 1) {
//				System.out.println("Số 1 là số đặc biệt");
//				}else {
//			System.out.println("Số " + n + " không phải số nguyên tố");
//			}
//		}
		

	}
}
