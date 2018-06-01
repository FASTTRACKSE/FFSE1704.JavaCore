package ffse1703012.bai1.practice;
import java.util.Scanner;
public class sinhvien {
	public String tensv;
	public String date;
	public static Scanner sc =  new Scanner (System.in);
	public void input() {
		
		System.out.print("Nhập họ tên Sinh viên: ");
		this.tensv = sc.nextLine();
		System.out.print("Nhập ngày sinh: ");
		this.date = sc.nextLine();
	}
	
	public void output() {
		System.out.println("Tên sinh viên là: "+this.tensv);
		System.out.println("Ngày sinh của sinh viên là: "+this.date);
	}

}
