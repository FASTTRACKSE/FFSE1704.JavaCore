/********************************
 * Prog: Tìm số nguyên tố
 * Author: Cao Lê Thành
 * Date: 29-May-2018
 */

package fasttrackse.bai1.pratice;

import java.util.Scanner;

public class BaiToanSoNguyenTo {

	public static void main(String[] args) {
		// Phần khai báo
		int N;
		Scanner myInput = new Scanner(System.in);
		
		// Phần thân chương trình
		
		// -- Nhập số từ bàn phím
		System.out.print("Mời bạn nhập số: ");
		N = myInput.nextInt();
		
		// -- Xác định có phải số nguyên tố hay không
		int i = 2;
		
		while (i < N && (N % i != 0)) {
			i++;
		}
		
		if (i == N) {
			System.out.print("Số " + N + " là Số Nguyên Tố");
		}
		else {
			System.out.print("Số " + N + " không phải là Số Nguyên Tố");
		}
		
		myInput.close();
	}

}
