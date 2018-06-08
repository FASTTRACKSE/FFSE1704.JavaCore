package MainSinhVienFFSE;

import SinhVienFFSE.SinhVien;
import java.util.Scanner;


public class QuanLySinhVien {

	public static void main(String[] args) {

		System.out.print("Nhập số lượng sinh viên:");
		Scanner nhap = new Scanner(System.in);
		int n = nhap.nextInt();
		SinhVien[] dsSinhVien = new SinhVien[n];
		for (int i = 0; i < n; i++) {

			
			System.out.print("Nhập tên sinh viên: ");
			nhap.nextLine();
			String hoVaTen = nhap.nextLine();
			System.out.print("Nhập giới tính sinh viên: ");
			String gioiTinh = nhap.nextLine();
			System.out.print("Nhập năm sinh sinh viên: ");
			int namSinh = nhap.nextInt();
			System.out.print("Nhập điểm LP1 sinh viên: ");
			int diemLp1 = nhap.nextInt();
			System.out.print("Nhập điểm LP2 sinh viên: ");
			int diemLp2 = nhap.nextInt();
			System.out.print("Nhập điểm LP3 sinh viên: ");
			int diemLp3 = nhap.nextInt();
			dsSinhVien[i] = new SinhVien(hoVaTen, namSinh, gioiTinh, diemLp1, diemLp2, diemLp3);
		}

		// in ra thông tin sinh viên (điểmLP1,2,3 và xếp loại sinh viên.

		System.out.println("danh sách sinh viên: ");
		System.out.println();
		System.out.printf("\n" + "%3s %10s %14s %14s %14s %14s %14s  %14s %12s", "Stt", "TênSinhViên", "NămSinh",
				"Giới Tính", "ĐiểmLp1", "ĐiểmLp2", "ĐiểmLp3", "ĐiểmTB", "XếpLoai");
		for (int i = 0; i < dsSinhVien.length; i++) {

			
			System.out.println("\n" + (i + 1) + dsSinhVien[i].toString() + dsSinhVien[i].tinhDiemTrungBinh() + "\t"
					+ dsSinhVien[i].xepLoai());

		}
		System.out.println("");
		System.out.println("");
		// in ra danh sách xếp loại sinh viên theo thứ tự tăng dần.

		System.out.println("Sinh viên xếp thứ hạng theo thứ tự tăng dần: ");
		for (int i = 0; i < dsSinhVien.length; i++) {

			System.out.printf("\n" + "%1s %5s %7s %7s %7s", " Stt ", "Nămsinh", " TênSV", "ĐiểmTB", " Xếp Loại");
			System.out.println("");
			System.out.printf(" " + (i + 1) + "\t" + dsSinhVien[i].thongTinhSinhVien()
					+ dsSinhVien[i].tinhDiemTrungBinh() + "\t" + dsSinhVien[i].xepLoai());
		}

	}

}
