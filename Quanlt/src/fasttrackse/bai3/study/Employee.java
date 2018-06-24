package fasttrackse.bai3.study;

import java.util.Scanner;

public class Employee {
	private String ten;
	private int tuoi;
	private String lop;
	public void nhapTen() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập tên: ");
		this.ten = sc.nextLine();
		
	}
	public void nhapTuoi() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập tuổi: ");
		this.tuoi = sc.nextInt();
	}
	public void nhapLop() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập lớp: ");
		this.lop = sc.nextLine();
	}
	public void in() {
		System.out.println("\n Tên: "+this.ten);
		System.out.println("\n Tuổi: "+this.tuoi);
		System.out.println("\n Lớp: "+this.lop);
	}
}
