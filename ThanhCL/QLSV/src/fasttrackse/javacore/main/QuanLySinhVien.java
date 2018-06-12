package fasttrackse.javacore.main;

import fasttrackse.javacore.entity.SinhVien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		SinhVien sv1, sv2, sv3;
		SinhVien[] dsSinhVien;
		
		sv1 = new SinhVien();
		sv2 = new SinhVien();
		sv3 = new SinhVien();
		
		System.out.println("Nhap thong tin sinh vien 1");
		sv1.Input();

		System.out.println("Nhap thong tin sinh vien 2");
		sv2.Input();
		
		System.out.println("Nhap thong tin sinh vien 3");
		sv3.Input();
		
		sv1.Output();
		sv2.Output();
		sv3.Output();
	}

}
