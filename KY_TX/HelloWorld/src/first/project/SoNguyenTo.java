package first.project;

import java.util.Scanner;

public class SoNguyenTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i, dem;
		dem = 0;
		System.out.println("Nhập vào số tự nhiên bất kỳ: ");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		if (n > 0) {
			for (i = 1; i <= n; i++) {
				if (n % i == 0) {
					dem += 1;
					System.out.println(dem);
					/*if(dem>2) {
						break;
					}*/
				}
			}
			if (dem > 2) {
				System.out.println(n + " không phải là số nguyên tố");
			} else {
				System.out.println(n + " là số nguyên tố");
			}
		}
		else {
			System.out.println(n + " không phải là số nguyên tố");
		}
	}

}
