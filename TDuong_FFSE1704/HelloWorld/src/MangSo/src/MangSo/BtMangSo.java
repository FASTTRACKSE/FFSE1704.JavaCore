package MangSo;

import java.util.Scanner;

public class BtMangSo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        // khởi tạo mảng ar
        int[] ar = new int[n];
        	System.out.print("Nhap cac phan tu cua mang: \n");
        	for (int i=0; i<n;i++) {
        		System.out.print("a["+i+"]= ");
        		ar[i] = scanner.nextInt();
        	}
        System.out.print("Cac phan tu cua mang: ");
        show(ar);
    }

	private static void show(int[] ar) {
		for (int i=0; i< ar.length; i++) {
			System.out.print(ar[i] +" " );
			
		}
	}

}
