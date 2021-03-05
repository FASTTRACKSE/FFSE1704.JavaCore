package chapter08.exceptionexample;

import java.util.Scanner;

public class Console {
	public static Scanner sc = new Scanner(System.in);

	public static int getInt(String prompt) {
		int i = 0;
		while(true) {
			System.out.println(prompt);
			try {
				i = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e) {
				
			}
		}
		return i;
	}

	public static int getInt2(String prompt) throws NumberFormatException {
		System.out.println(prompt);
		int i = Integer.parseInt(sc.nextLine());
		return i;
	}
}
