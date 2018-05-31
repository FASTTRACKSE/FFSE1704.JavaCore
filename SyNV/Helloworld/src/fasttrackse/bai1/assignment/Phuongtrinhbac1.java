package fasttrackse.bai1.assignment;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Phuongtrinhbac1 {

	private static Scanner scanner;

	public static void main(String[] args) {

		int soA, soB;
		 
		 Scanner sc = new Scanner(System.in);
		 
		 	System.out.println("----------------------------");
		 	System.out.println("|Giải phương trình bậc nhất|");
		 	System.out.println("----------------------------");
			System.out.println("Nhập số a: ");
			soA= sc.nextInt();
			System.out.println("Nhập số b: ");
			soB= sc.nextInt();
		if(soA == 0) {
			if(soB ==0) {
				System.out.println("Phương trình vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm!");
			}
		}else {
			System.out.println("Phương trình có nghiệm X = " + (-soB/soA));
		}
		System.out.println("Nhấn Enter để chọn chức năng khác");

}}
