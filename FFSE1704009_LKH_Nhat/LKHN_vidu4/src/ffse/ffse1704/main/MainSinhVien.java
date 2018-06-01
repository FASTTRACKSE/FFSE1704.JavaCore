/**
 * 
 */
package ffse.ffse1704.main;

import java.util.Scanner;
import ffse.ffse1704.quanly.QuanLySinhVien;

public class MainSinhVien {
	public static void main(String[] args) {

		Scanner sl = new Scanner(System.in);
		System.out.println("Nhập vào số sinh viên cần thêm dữ liệu: ");
		int n = sl.nextInt();

		// int array[] = new int[n];
		QuanLySinhVien[] dsSinhVien = new QuanLySinhVien[n];
		System.out.println("Nhập thông tin sinh viên: ");
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			System.out.println("Nhập phần thông tin sinh viên thứ " + j + ": ");
			dsSinhVien[i] = new QuanLySinhVien();
			dsSinhVien[i].Input();
		}
		for (int i = 0; i < n; i++) {

			dsSinhVien[i].Output();
		}

		// QuanLySinhVien sv1, sv2, sv3;
		//
		// sv1 = new QuanLySinhVien();
		// sv2 = new QuanLySinhVien();
		// sv3 = new QuanLySinhVien();
		//
		//
		// sv1.Input();
		// sv2.Input();
		// sv3.Input();
		//
		// sv1.Output();
		// sv2.Output();
		// sv3.Output();

	}

}


