package fasttrackse.bai2.assignment;

import java.util.*;

public class Assignment3 {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = sc.nextInt(); // khởi tạo mảng
		int arr[] = new int[n];
		String vtmin = " ";
		String vtmax = " ";
		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + i + ": ");
			arr[i] = sc.nextInt();
		}
		// 1 In ra danh sách mảng:
		System.out.println("\n Danh sách mảng "); // In mảng
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		// 2 In ra giá trị lớn nhất và giá trị nhỏ nhất:
		int min = arr[0]; // giá trị đầu tiên trong mảng là nhỏ nhất
		int max = arr[0];
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] < min) { // nếu có giá trị < min thì gán min cho số đó
				min = arr[k];
			}
			if (arr[k] > max) {
				max = arr[k];
			}
		}
		System.out.println("\n------------------");
		System.out.println("Giá trị nhỏ nhất là: " + min);
		System.out.println("Giá trị lớn nhất là: " + max);
		// 3 In ra vị trí lớn nhất và vị trí nhỏ nhất:
		for (int l = 0; l < arr.length; l++) {
			if (arr[l] == min) {
				vtmin = "Vị trí phần tử chứa giá trị nhỏ nhất: Phần tử thứ " + l; // nếu có giá trị = min thì gán min
																					// cho vị trí đó
			}
			if (arr[l] == max) {
				vtmax = "Vị trí phần tử chứa giá trị lớn nhất: Phần tử thứ " + l;
			}
		}
		System.out.println("------------------");
		System.out.println(vtmin);
		System.out.println(vtmax);

	}

}
