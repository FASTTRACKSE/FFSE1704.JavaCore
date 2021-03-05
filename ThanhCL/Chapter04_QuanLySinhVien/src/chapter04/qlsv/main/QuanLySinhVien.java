package chapter04.qlsv.main;

import chapter04.qlsv.business.*;
import java.util.Scanner;

public class QuanLySinhVien {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Nhap du lieu		
		System.out.print("Nhap ho dem sinh vien: ");
		String hoDem = input.nextLine();
		
		System.out.print("Nhap ten sinh vien: ");
		String ten = input.nextLine();
		
		SinhVien sv1 = new SinhVien(hoDem, ten);
		
		System.out.println("Tong sinh vien:" + SinhVien.tongSV);

		SinhVien sv2 = new SinhVien();
		sv2.setHoDem("Nguyen Ngoc");
		sv2.setTen("Lam");
		
		// In du lieu
		System.out.println("THONG TIN SINH VIEN");
		System.out.println("--------------------------");
		System.out.println(sv1.getMaSV() + "\t" + sv1.getHoDem() + " " + sv1.getTen());
		System.out.println(sv2.getMaSV() + "\t" + sv2.getHoDem() + " " + sv2.getTen());
		
		System.out.println("Tong sinh vien:" + SinhVien.tongSV);

		
		changeName(sv1, "Lam"); // sv1 -> 1A
		changeName(sv2, "Tu");  // sv2 -> 2A

		// In du lieu
		System.out.println("THONG TIN SINH VIEN");
		System.out.println("--------------------------");
		System.out.println(sv1.getMaSV() + "\t" + sv1.getHoDem() + " " + sv1.getTen());
		System.out.println(sv2.getMaSV() + "\t" + sv2.getHoDem() + " " + sv2.getTen());
		
		System.out.println("Tong sinh vien:" + SinhVien.tongSV);
		
		double d = 10;
		System.out.print("d = ");
		System.out.println(d);
		
		tinhBinhPhuong(d);
		System.out.print("d = ");
		System.out.println(d);
		
		System.out.println();
		System.out.println("Bye!");

	}
	
	public static void tinhBinhPhuong(double d) {
		d = d*d;
		System.out.print("d = ");
		System.out.println(d);
	}
	
	public static void changeName(SinhVien s, String newName) {
		//s -> 1A
		s.setTen(newName);

		SinhVien s1 = new SinhVien(); // s1 -> 1B
		s1.setHoDem(s.getHoDem());
		s1.setDiemToan(s.getDiemToan());
		s1.setDiemLy(s.getDiemLy());
		s1.setDiemHoa(s.getDiemHoa());
		s1.setTen(newName);
		// s -> 1A
		
		s = s1; // s -> 1B
	}

}
