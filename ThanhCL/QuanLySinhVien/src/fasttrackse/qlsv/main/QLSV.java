package fasttrackse.qlsv.main;

import java.util.Scanner;

import fasttrackse.qlsv.entity.SinhVien;

public class QLSV {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
//		System.out.print("Nhap ten sinh vien: ");
//		String ten = myInput.nextLine();
//		System.out.print("Nhap nam sinh sinh vien: ");
//		int namsinh = myInput.nextInt();
//		SinhVien sv1 = new SinhVien(ten, namsinh);
		
		// Nhập thông tin sinh viên 1 qua hàm dựng
		SinhVien sv1 = new SinhVien("Nguyễn Văn Anh", 1997, 9, 8, 8);
		
		// Nhập thông tin sinh viên 2 qua phương thức setters
		SinhVien sv2 = new SinhVien();
		sv2.setTenSinhVien("Bùi Thị Bình");
		sv2.setNamSinh(1999);
		sv2.setDiemLP1(9);
		sv2.setDiemLP2(9);
		sv2.setDiemLP3(10);
		
		// In thông tin sinh viên 1
		System.out.println(sv1.toString());
		System.out.println(sv1.tinhDiemTrungBinhMon());

		// In thông tin sinh viên 2
		System.out.println(sv2.toString() + " DTB:" + Math.round(sv2.tinhDiemTrungBinhMon()));

	}

}
