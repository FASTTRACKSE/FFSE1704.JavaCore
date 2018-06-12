package LP4.JavaCore;

import java.util.Scanner;

public class SinhVien {
	public String fullname;
	public int birthday;
	public String country;

	public void ThongTinhSinhVien() {

		Scanner nhap = new Scanner(System.in);
		System.out.println(" Xin mời nhập Full Name : ");
		this.fullname = nhap.nextLine();

		System.out.println(" Xin mời nhập Birthday : ");
		this.birthday = nhap.nextInt();

		System.out.println(" Xin mời nhập country : ");
		nhap.nextLine();
		this.country = nhap.nextLine();
		
	}

	public void output() {

		System.out.println("+-------------------------+");
		System.out.println("|Full name : " + fullname);
		System.out.println("|Năm sinh : " + birthday);
		System.out.println("|Quốc tịch : " + country);
		System.out.println("+-------------------------+");
	}

}
