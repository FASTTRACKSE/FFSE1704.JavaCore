/**
 * 
 */
package fasttrackse.bai1.pratice;

import java.util.Scanner;
/**
 * @author QuangDai
 *
 */
public class SoNguyenTo {

	/**
	 *	Nhập 1 số từ bàn phím xem số đó có phải là số nguyên tố
	 *	@author: Phan Phạm Quang Dai
	 *	Date: 29/05/2018
	 */
	public static void main(String[] args) {
		int n;
		int i = 2;
		int dem = 0;
		@SuppressWarnings("resource")
		// Khai báo biến Scanner nhập dữ liệu từ bàn phím
		Scanner myInput = new Scanner(System.in);
		
		// Nhập số nguyên từ bàn phím
		System.out.print("Nhập số nguyên n: ");
		n = myInput.nextInt();
		
		while(i < n/2) {
			if (n % i == 0) {
				dem++;
				break;
			}
			i++;
		}
		
		if (dem == 0) {
			System.out.println("Số nguyên n(" + n + ") là số nguyên tố");
		} else {
			System.out.println("Số nguyên n(" + n + ") không phải là số nguyên tố");
		}
	}
}
