package codemaster.customexception.ui;

import java.util.Scanner;

import codemaster.customexception.business.MyException;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choose = "y";
		while (choose.equalsIgnoreCase("Y")) {
			try {
				System.out.print("Nhập năm sinh: ");
				int ns = Integer.parseInt(sc.nextLine());

				if (ns < 0) {
					throw new MyException(2);
				} else if (ns > 2019) {
					throw new MyException(3);
				}

			} catch (NumberFormatException e) {
				System.err.println(new MyException(e.toString(), 1));
				System.out.println();
				continue;
			} catch (MyException e) {
				System.err.println(e.toString());
				System.out.println();
				continue;
			}
			System.out.print("Continue? (y/n): ");
			choose = sc.nextLine();
		}
	}

}
