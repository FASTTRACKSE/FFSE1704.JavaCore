package MainQuanLyTienDien;

import java.util.Scanner;

import QuanLyTienDien.*;

public class QuanLyTienDien {

	public static void main(String[] args) {
		System.out.println("\t\t+-----------------------------------+");
		System.out.println("\t\t******** SỞ ĐIỆN LỰC ĐÀ NẴNG ********");
		System.out.println("\t\t+-----------------------------------+");
		System.out.println("");

		Scanner nhap = new Scanner(System.in);
		System.out.print("  *Nhập số lượng khách hàng :");
		int n = nhap.nextInt();

		BienLai[] dsbienlai = new BienLai[n];
		for (int i = 0; i < dsbienlai.length; i++) {
			System.out.print("Nhập mã khách hàng :");
			nhap.nextLine();
			int maKhachHang = nhap.nextInt();

			System.out.print("Nhập tên khách hàng :");
			nhap.nextLine();
			String tenKhachHang = nhap.nextLine();

			System.out.print("Nhập địa chỉ khách hàng :");
			// nhap.nextLine();
			String diaChi = nhap.nextLine();

			System.out.print("Nhập số công tơ  :");
			int maCongTo = nhap.nextInt();

			System.out.print("Nhập kỳ tiêu thụ :");
			nhap.nextLine();
			String kyTieuThu = nhap.nextLine();

			System.out.print("Nhập chỉ số cũ :");
			// nhap.nextInt();
			int soCu = nhap.nextInt();

			System.out.print("Nhập chỉ số mới :");

			int soMoi = nhap.nextInt();

			dsbienlai[i] = new BienLai(maKhachHang, tenKhachHang, diaChi, maCongTo, kyTieuThu, soCu, soMoi);
		}

		System.out.println("\t\t\t\tThông Tin Khách Hàng");
		System.out.println("\t\t\t   *-----------------------------*");
		System.out.println("");
		System.out.printf("\n" + "%3s %10s %14s %14s %14s %15s %15s  %15s %14s ", "Stt", "Makhachhang", "Tenkhachhang",
				"DiaChi", "SoCongTo", "KyTieuThu", "ChiSoCu", "ChiSoMoi","TongTien");
		System.out.println("");
		for (int i = 0; i < dsbienlai.length; i++) {
			System.out.printf((i + 1) + dsbienlai[i].toString() + dsbienlai[i].soTienPhaiTra());
		}
	} 

}
