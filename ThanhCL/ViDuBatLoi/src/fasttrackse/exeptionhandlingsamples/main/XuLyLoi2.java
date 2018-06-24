package fasttrackse.exeptionhandlingsamples.main;

import java.util.Scanner;

public class XuLyLoi2 {

	public static void main(String[] args) {
		int a, b, n, choose = 1;
		boolean choosenOK, inputOK;
		int[] arrInt = new int[10];
		int x = 0;
		String tenCB;
		Scanner myInput = new Scanner(System.in);

		do {
			try {
				inputOK = true;
				System.out.print("Nhập tên cán bộ: ");
				tenCB = myInput.nextLine();

				if (tenCB.length() < 1 || tenCB.length() > 40) {
					// bẵn lỗi
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Lõi nhập tên cán bộ - Độ dài tên phải từ 1 - 40 ký tự. Hãy nhập lại!!!");
				inputOK = false;
			}
		} while (!inputOK);

		System.out.println("Chương trình kết thúc");

		myInput.close();

	}

}
