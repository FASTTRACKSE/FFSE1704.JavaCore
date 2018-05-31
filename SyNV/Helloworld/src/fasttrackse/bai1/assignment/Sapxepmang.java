package fasttrackse.bai1.assignment;
import java.util.Scanner;

public class Sapxepmang {
	public static Scanner print = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		do {
			System.out.print("Nhập số phần tử của mảng: ");
			n = print.nextInt();
		} while (n <= 0);
		int bubbleSort;

		int[] array = new int[n];// khai báo mảng
		System.out.println("Nhập phần tử của mảng: \n");// dùng \n để con trỏ xuống dòng tiếp theo
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);// %d: số thập phân, số nguyên
			array[i] = print.nextInt();
		}
		System.out.println("Các phần từ của mảng ban đầu: ");
		show(array);
		int max = array[0];// khởi tạo biến max và min tại vị trí phần tử đầu tiên của mảng
		int min = array[0];
		int pmax = 0;
		int pmin = 0;
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];// nếu max nhỏ hơn phần tử nào trong mảng thì cho max bằng phần tử đó
				pmax = i;
			}
			if (min > array[i]) {
				min = array[i];// nếu min lớn hơn phần tử nào trong mảng thì cho min bằng phần tử đó
				pmin = i;
			}
		}

		System.out.println("Phần tử lớn nhất của mảng là " + max + " và nằm ở vị trí thứ " + pmax);
		System.out.println("Phần tử nhỏ nhất của mảng là " + min + " và nằm ở vị trí thứ " + pmin);
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j >= 1; j--) {
				if (array[j] < array[j - 1]) {
					bubbleSort = array[j];
					array[j] = array[j - 1];
					array[j - 1] = bubbleSort;
				}
			}
		}
		System.out.print("Mảng sau khi sắp sếp: ");
		for (int t = 0; t < n; t++) {
			System.out.print(array[t] + " ");

		}

	}

	private static void show(int[] array) {
		// TODO Auto-generated method stub
		
	}
}
