/**
 * 
 */
package SoNguyenTo;

import java.util.Scanner;

/**
 * @author Admin
 *
 */
public class SoNguyenTo {

	private static final int i = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		Scanner myInput = new Scanner(System.in);
		System.out.println("N có phải là số nguyên tố không ?");
		System.out.print("Nhập số N: ");
		n = myInput.nextInt();
		int dem=0;
		if (n>0) {
			for (int i=1; i<=n; i++){
					if (n%i==0) dem +=1;
				}
		}
		if (dem == 2) {
				System.out.print(n+" la so nguyen to");
			}else {
				System.out.print(n+" khong la so nguyen to");
				}
			}
		}
	
	



