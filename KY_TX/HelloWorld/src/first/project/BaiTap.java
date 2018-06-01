/*
 * Assiment3
 * Prog: Mảng.
 * Outhor: Trần Xuân Kỳ.
 * Date:30/May/2018.
 * Mail:FFSE1701005@st.fasttrack.edu.vn 
 * */
package first.project;

import java.util.Scanner;

public class BaiTap {
	/*
	 * int n; Scanner nhap = new Scanner(System.in); n=nhap.nextInt(); int[] mang =
	 * new int[n];
	 */
	static int i,j,n,ldb;
	static int mang[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. Giải phương trình bậc nhất");
		System.out.println("2. Giải phương trình bậc hai");
		System.out.println("3. Nhập mảng");
		System.out.println("4. Sắp xếp mảng tăng dần");
		System.out.println("5. Kết thúc");
		while (true) {
			System.out.print("Mời bạn nhập: ");
			Scanner nhap = new Scanner(System.in);
			int so = nhap.nextInt();
			switch (so) {
			case 1:
				phuongtrinhbacnhat();
				break;
			case 2:
				phuongtrinhbachai();
				break;
			case 3:
				nhapmang();
				break;
			case 4:
				sapxepmang();
				break;
			case 5:
				return;
			}
		}
	}

	public static void phuongtrinhbacnhat() {
		int thamsoa, thamsob, x;
		double nghiemX;
		Scanner myInput = new Scanner(System.in);
		System.out.println("Giait phương trình bật nhất");
		System.out.println("nhập vào số a:");
		thamsoa = myInput.nextInt();
		System.out.println("nhập vào số b:");
		thamsob = myInput.nextInt();
		if (thamsoa == 0) {
			if (thamsob == 0) {
				System.out.println("phương trình " + thamsoa + "x + " + thamsob + " = 0 vô số nghiệm");
			} else {
				System.out.println("phương trình " + thamsoa + "x + " + thamsob + " = 0 vô nghiệm");
			}
		} else {
			x = -thamsob / thamsoa;
			System.out.println("phươn trình có nghiệm " + "x = " + -thamsob + "/" + thamsoa + "=" + x);
		}
	}

	public static void phuongtrinhbachai() {
		int a, b, c;
		System.out.println("Giải phương trình bậc hai một ẩn");
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhập vào số a:");
		a = myInput.nextInt();
		System.out.println("nhập vào số b:");
		b = myInput.nextInt();
		System.out.println("nhập vào số c:");
		c = myInput.nextInt();
		System.out.println("phương trình có dạng " + a + "x*x + " + b + "x " + " + " + c + " = 0 ");
		int delta = b * b - 4 * a * c;
		System.out.println("delta = b*b-4*a*c" + " = " + (b * b - 4 * a * c));
		if (delta > 0) {
			System.out.println("phương trình có hai nghiệm phân biệt ");
			System.out.println("X1= " + (-b + Math.sqrt(delta)) / (2 * a));
			System.out.println("X2= " + (-b - Math.sqrt(delta)) / (2 * a));
		}
		if (delta == 0) {
			System.out.println("phương trình có nghiệm kép X1 = X2 = " + (-b / (2 * a)));
		}
		if (delta < 0) {
			System.out.println("phương trình vô nghiệm");
		}

	}

	public static void nhapmang() {
		int i,j,max, min, locationMax, locationMin, ldb;
		System.out.println("Nhập mảng");
		System.out.print("Nhập số phần tử mảng: ");
		Scanner nhap = new Scanner(System.in);
		n = nhap.nextInt();
		mang = new int[n];
		for (i = 0, j = 1; i < n; i++, j++) {
			System.out.print("Nhập giấ trị phần tử thứ " + j + " : ");
			mang[i] = nhap.nextInt();
			// System.out.println();

		}
		max = mang[0];
		min = mang[0];
		locationMax = 0;
		locationMin = 0;
		for (i = 0; i < n; i++) {
			if (max < mang[i]) {
				max = mang[i];
				locationMax = i;
			}
			if (min > mang[i]) {
				min = mang[i];
				locationMin = i;
			}
		}
		System.out.println("Danh sách mảng:");
		for (i = 0; i < n; i++)
			System.out.print(mang[i] + " ");
		System.out.println();
	}

	public static void sapxepmang() {
		//int i,j;
		for (i = 0; i < n - 1; i++) {
			for (j = n - 1; j >= 1; j--) {
				// nếu phần tử đứng sau nhỏ hơn phần tử đứng trước
				// thì đổi chỗ 2 phần tử đó cho nhau
				// với cách sắp xếp này thì trong lần duyệt đầu tiên
				// phần tử nhỏ nhất sẽ được chuyển lên trên cùng.
				if (mang[j] < mang[j - 1]) {
					ldb = mang[j];
					mang[j] = mang[j - 1];
					mang[j - 1] = ldb;
				}
			}
		}

		System.out.println("Sắp xếp mảng theo chiều tăng dần");
		for (i = 0; i < n; i++) {
			System.out.print(mang[i] + "\t");
		}
		for (i = 0; i < n - 1; i++) {
			for (j = n - 1; j >= 1; j--) {
				// nếu phần tử đứng sau lớn hơn phần tử đứng trước
				// thì đổi chỗ 2 phần tử đó cho nhau
				// với cách sắp xếp này thì trong lần duyệt đầu tiên
				// phần tử lớn nhất sẽ được chuyển lên trên cùng.
				if (mang[j] > mang[j - 1]) {
					ldb = mang[j];
					mang[j] = mang[j - 1];
					mang[j - 1] = ldb;
				}
			}
		}
		System.out.println();

		System.out.println("Sắp xếp mảng theo chiều giảm dần");
		for (i = 0; i < n; i++) {
			System.out.print(mang[i] + "\t");
		}

	}

}
