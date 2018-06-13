package BangSinhVien;
import java.util.Scanner;
public class SinhVien {
	String hoTenSV;
	int NamSinhSV;
	int age;

 public void Input() {
	Scanner myInput = new Scanner(System.in);
	System.out.println("nhap ten SV");
	hoTenSV = myInput.nextLine();
	
	System.out.println("nhap năm sinh SV");
	NamSinhSV = myInput.nextInt();
	
	System.out.println("Nhập tuổi của sinh viên");
	age = myInput.nextInt();
}
 public void Output() {
	 System.out.println("Họ tên: " + hoTenSV+"----- " +"Namsinh: "+ NamSinhSV + "Tuổi" + age);
 }
}
