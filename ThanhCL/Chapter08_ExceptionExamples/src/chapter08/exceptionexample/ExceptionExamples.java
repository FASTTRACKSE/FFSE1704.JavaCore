package chapter08.exceptionexample;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

public class ExceptionExamples {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int a = 0;
		int b = 0;

		//b = Console.getInt("Nhap b= ");
		while (true) {
			try {
				b = Console.getInt2("Nhap b= ");
				break;
			}
			catch (Exception e) {
				System.out.println("Nhap sai kieu");
			}
			finally {
				System.out.println("Ket thuc xu ly loi");
			}
		}


		System.out.println("(a,b) = (" + a + ", " + b + ")");

		System.out.println("Bye!");

		input.close();
	}

}
