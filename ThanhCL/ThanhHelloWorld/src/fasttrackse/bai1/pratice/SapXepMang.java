package fasttrackse.bai1.pratice;

import java.util.Scanner;

public class SapXepMang {

	public static void main(String[] args) {
		// Khai báo biến trong chương trình
		Scanner myInput = new Scanner(System.in);
		int[] mangSoNguyen;	// Mảng cần sắp xếp
		int N;				// Độ dài mảng cần nhập 
		
		// Thân chương trình
		
		//1. Nhập độ dài mảng
		System.out.print("Nhập độ dài mảng: ");
		N = myInput.nextInt();
		
		// Khởi tạo mảng gồm N phần tử
		mangSoNguyen = new int[N];
		
		// Tạo vòng lặp để nhập số từ bàn phím
		for(int i = 0; i < N; i++) {
			System.out.print("Nhập số thứ " + (i+1) + ": ");
			mangSoNguyen[i] = myInput.nextInt();
		}
		
		// Sắp xếp mảng
		for (int i = 0; i < N - 1; i++) {
			for (int j = i+1; j < N; j++) {
				int temp;
				if (mangSoNguyen[i] > mangSoNguyen[j]) {
					// Đổi chỗ 2 phần tử i <--> j
					temp = mangSoNguyen[i];
					mangSoNguyen[i] = mangSoNguyen[j];
					mangSoNguyen[j] = temp; 
				}
			}
		}
		
		// In kết quả ra màn hình
		System.out.println("Danh sách mảng đã sắp xếp:");
		
		for(int i = 0; i < N; i++) {
			System.out.print("Phần tử thứ " + (i+1) + ": ");
			System.out.println(mangSoNguyen[i]);
		}

	}

}
