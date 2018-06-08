package fasttrack.asm5.main;

import fasttrack.asm5.antity.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);

		System.out.println("Mời bạn nhập số lượng sinh vên: ");
		int N = myInput.nextInt();

		BienLai[] dsbienlai = new BienLai[N];
		for (int i = 0; i < dsbienlai.length; i++) {
			System.out.print("Nhập mã khách hàng :");
			myInput.nextLine();
			int maKhachHang = myInput.nextInt();

			System.out.print("Nhập tên khách hàng :");
			myInput.nextLine();
			String tenKhachHang = myInput.nextLine();

			System.out.print("Nhập địa chỉ khách hàng :");
			// nhap.nextLine();
			String diaChi = myInput.nextLine();

			System.out.print("Nhập số công tơ  :");
			int maCongTo = myInput.nextInt();

			System.out.print("Nhập kỳ tiêu thụ :");
			myInput.nextLine();
			int kyTieuThu = myInput.nextInt();

			System.out.print("Nhập chỉ số cũ :");
			// nhap.nextInt();
			int chiSoCu = myInput.nextInt();

			System.out.print("Nhập chỉ số mới :");

			int chiSoMoi = myInput.nextInt();

			dsbienlai[i] = new BienLai(maKhachHang, tenKhachHang, diaChi, maCongTo, chiSoCu, chiSoMoi, kyTieuThu);
		}

		System.out.println("\t\t\t\tThông Tin Khách Hàng");
		System.out.println("\t\t\t   *-----------------------------*");
		System.out.println("");
		System.out.printf("\n" + "%3s %10s %14s %14s %14s %15s %15s  %15s %14s ", "Stt", "Makhachhang", "Tenkhachhang",
				"DiaChi", "SoCongTo", "KyTieuThu", "ChiSoCu", "ChiSoMoi", "TongTien");
		System.out.println("");
		for (int i = 0; i < dsbienlai.length; i++) {
			System.out.printf((i + 1) + dsbienlai[i].toString() + dsbienlai[i].soTienPhaiTra());
		}
	}

}
