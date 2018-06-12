package LP4.JavaCore;
import java.util.Scanner;

import LP4.JavaCore.SinhVien;

public class mainSinhVien {

	public static void main(String[] args) {
		
		int n ; 
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập số lương sinh viên : ");
		n = nhap.nextInt();
		SinhVien[] danhsach = new SinhVien[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập phần tử thứ " + i + " của mảng :");
			danhsach[i] = new SinhVien();
			danhsach[i].ThongTinhSinhVien();
			

		}
		for (int j = 0; j < n; j++) {
			
			System.out.println("Thông tin sinh viên thứ "+(j+1));
			danhsach[j].output();
			

		}
		
		
		



	}

}
