/************************
 *Prog: QUẢN LÝ TIỀN ĐIỆN
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 4/06/2018
 **********************/
package quanlytiendien.main;

/**
 * @author Support
 *
 */
import java.util.Scanner;

import quanlytiendien.entity.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập số lượng khách hàng : ");
		int N = nhap.nextInt();
		BienLai[] bienlai = new BienLai[N];
		KhachHang[] khachhang = new KhachHang[N];
		for (int i = 0; i < N; i++) {

			System.out.print("Nhập mã khách hàng: ");
			nhap.nextLine();
			String maKhachHang = nhap.nextLine();

			System.out.print("Nhập tên khách hàng: ");
			String hoTenKhachHang = nhap.nextLine();

			System.out.print("Nhập địa chỉ: ");
			String diaChi = nhap.nextLine();

			System.out.print("Mã số công tơ: ");
			int maSoCongTo = nhap.nextInt();

			System.out.print("Nhập kỳ tiêu thụ: ");
			nhap.nextLine();
			String kyTieuThu = nhap.nextLine();

			System.out.print("Nhập chỉ số cũ: ");
			int chiSoCu = nhap.nextInt();

			System.out.print("Nhập chỉ số mới: ");
			int chiSoMoi = nhap.nextInt();

			System.out.println("********************************");
			khachhang[i] = new KhachHang(maKhachHang, hoTenKhachHang, diaChi, maSoCongTo);
			bienlai[i] = new BienLai(kyTieuThu, chiSoCu, chiSoMoi);

		}
		
		//IN DANH SÁCH KHÁCH HÀNG
		System.out.println("\t \t \t\tDANH SÁCH KHÁCH HÀNG");
		System.out.println("\t \t \t *********************************");
		// System.out.printf("\n" + "%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s
		// %-15s", "STT", "Mã Khách Hàng", "Tên Khách Hàng",
		// "Địa chỉ", "mã Số Công Tơ", "Kỳ Tiêu Thụ", "Chỉ Số Cũ", "Chỉ Số Mới", "Thành
		// Tiền (VNĐ)");
		// System.out.println("\n---------------------------------------------------------------------------------------------");

		for (int i = 0; i < khachhang.length; i++) {

			// System.out.printf("\t\t"+(i + 1)+"\t\t" + khachhang[i].getMaKhachHang() +
			// "\t\t" + khachhang[i].getHoTenKhachHang() + "\t\t" + khachhang[i].getDiaChi()
			// + "\t\t" + khachhang[i].getMaSoCongTo()
			// + "\t\t " + bienlai[i].getKyTieuThu() + "\t\t" + bienlai[i].getChiSoCu() +
			// "\t\t"+ bienlai[i].getChiSoMoi() + "\t\t"+ bienlai[i].soTienPhaiTra() +
			// "\t\t");
			System.out.println("********************************");
			System.out.println("Khách hàng thứ " + (i + 1) + ": " + khachhang[i].toString() + "Kỳ tiêu thụ: "
					+ bienlai[i].getKyTieuThu() + "\n ***** Chỉ số cũ: " + bienlai[i].getChiSoCu()
					+ "\n ***** Chỉ số mới: " + bienlai[i].getChiSoMoi() + "\n ***** Thành tiền: "
					+ bienlai[i].soTienPhaiTra() + " VNĐ");

		}
	}

}