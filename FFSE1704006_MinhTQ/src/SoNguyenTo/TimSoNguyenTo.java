/**************
 * ỳqbf
 * 
 */
package SoNguyenTo;
import java.util.Scanner;
public class TimSoNguyenTo {
	public static void main(String[] args) {
		int n;
		int dem1 = 0;
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập số n : ");
		n = nhap.nextInt();
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					dem1 += 1;
				}
			}
			if (dem1 == 2) {
				System.out.println(n + "  là số nguyên tố");
			} else  {
				System.out.println(n + " không phải số nguyên tố ");
			}

		} else {
			System.out.println(n + " không phải là số nguyên tố ");
		}
	}
}
