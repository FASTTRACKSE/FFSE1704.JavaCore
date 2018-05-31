//**Le Trong Quan**
//**quanltofficial@gmail.com**
//**fb.me/quanltofficial**
package fasttrackse.bai2.assignment;

import java.util.*;

public class Assignmentt4 {

	public static void giaipt1() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Nhap so a: ");
		int a = sc1.nextInt();
		System.out.println("Nhap so b:");
		int b = sc1.nextInt();
		int c;
		if (a == 0) {
			if (b == 0) {
				System.out.println("* Phương trình " + a + "x+" + b + "=0 có vô số nghiệm");
			} else {
				System.out.println("* Phương trình " + a + "x+" + b + "=0 có vô nghiệm");
			}

		} else {
			c = -b / a;
			System.out.println("* Phương trình " + a + "x+" + b + "=0 có nghiệm " + c);
		}
	}

	public static void giaipt2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("* Chương trình giải phương trình bậc 2 có dạng ax2 + bx + c = 0 (a ≠ 0)");
		System.out.println("Nhập số a: ");
		float a = sc2.nextFloat();
		System.out.println("Nhập số b: ");
		float b = sc2.nextFloat();
		System.out.println("Nhập số c: ");
		float c = sc2.nextFloat();
		float denta = b * b - 4 * a * c;
		float nghiemx1;
		float nghiemx2;
		if (denta == 0) {
			nghiemx1 = (-b) / (2 * a);
			System.out.println("* Phương trình trên có nghiệm kép : x1=x2= " + nghiemx1);
		} else if (denta > 0) {
			nghiemx1 = (float) ((-b + Math.sqrt(denta)) / (2 * a));
			nghiemx2 = (float) ((-b - Math.sqrt(denta)) / (2 * a));
			System.out.println("* Phương trình trên có nghiệm : x1= " + nghiemx1);
			System.out.println("* Phương trình trên có nghiệm : x2= " + nghiemx2);
		} else {
			System.out.println("* Phương trình trên vô nghiệm ");
		}
	}

	static int n;
	static int arr[];

	public static void nhapmang() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = sc.nextInt(); // khởi tạo mảng
		arr = new int[n];
		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + i + ": ");
			arr[i] = sc.nextInt();
		}
		System.out.println("*******************");
		System.out.println("\n* Nhập mảng thành công, chọn option 4 để xem mảng ");

		// 2 In ra giá trị lớn nhất và giá trị nhỏ nhất:
	}

	public static void sapxep() {
		int min = arr[0]; // giá trị đầu tiên trong mảng là nhỏ nhất
		int max = arr[0];
		String vtmin = " ";
		String vtmax = " ";
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] < min) { // nếu có giá trị < min thì gán min cho số đó
				min = arr[k];
			}
			if (arr[k] > max) {
				max = arr[k];
			}
		}
		System.out.println("\n*******************");
		System.out.println("\n* Danh sách mảng: "); // In mảng
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("\n* Giá trị nhỏ nhất là: " + min);
		System.out.println("* Giá trị lớn nhất là: " + max);
		for (int l = 0; l < arr.length; l++) {
			if (arr[l] == min) {
				vtmin = "* Vị trí phần tử chứa giá trị nhỏ nhất: Phần tử thứ " + l; // nếu có giá trị = min thì gán min
																					// cho vị trí đó
			}
			if (arr[l] == max) {
				vtmax = "* Vị trí phần tử chứa giá trị lớn nhất: Phần tử thứ " + l;
			}
		}
		System.out.println("------------------");
		System.out.println(vtmin);
		System.out.println(vtmax);
		Arrays.sort(arr);
		System.out.println("* Mảng sắp theo thứ tự tăng dần");
		for (int q = 0; q < arr.length; q++) {
			System.out.println(arr[q] + " ");
		}
		System.out.println("* Mảng sắp theo thứ tự giảm dần");
		Integer[] arrnew = new Integer[arr.length];
		for (int h = 0; h < arr.length; h++) {
			arrnew[h] = new Integer(arr[h]);
		}
		Arrays.sort(arrnew, Collections.reverseOrder());
		for (int g = 0; g < arr.length; g++) {
			System.out.println(arrnew[g] + " ");
		}
	}

	public static void back() {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>");
		System.out.println("Ấn Enter để quay lại Menu chính");
		sc.nextLine();
	}

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("-------------------------------");
			System.out.println("Nhập lựa chọn tương ứng với số: ");
			System.out.println("1. Giải phương trình bậc nhất");
			System.out.println("2. Giải phương trình bậc hai");
			System.out.println("3. Nhập hàm");
			System.out.println("4. Hiện thị mảng, giá trị nhỏ nhất lớn nhất và sắp xếp ở option 3");
			System.out.println("5. Kết thúc");
			System.out.println("\n***************");
			System.out.print("Mời bạn chọn 1 mục: ");
			int a;
			a = input.nextInt();
			switch (a) {
			case 1:
				giaipt1();
				back();
				break;

			case 2:
				giaipt2();
				back();
				break;
			case 3:
				nhapmang();
				back();
				break;
			case 4:
				sapxep();
				back();
				break;
			case 5:
				System.out.println("Chương trình kết thúc. Thank you \nCode by Quanlt");
				System.exit(0);

			}
		}

	}
}
