
package MangSo;

import java.util.Scanner;

public class MinMax {
	public static Scanner scanner = new Scanner(System.in);
	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Nhap so phan tu mang: ");
		int n = scanner.nextInt();
		int[] ar = new int[n];
		System.out.print("Nhap cac phan tu mang: ");
		for(int i=0; i<n;i++) {
			System.out.print("a["+i+"]= ");
			ar[i] = scanner.nextInt();
		}
		int min = ar[0];
		int max = ar[0];
		for(int i=0; i< ar.length; i++) {
			if (ar[i]<min) {
				min = ar[i];
			}
			if (ar[i]>max) {
				max = ar[i];
			}
		}
		System.out.println("Max cua mang: "+max);
		System.out.print("Min cua mang: "+min);
	}
}
