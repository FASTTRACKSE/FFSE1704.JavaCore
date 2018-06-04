package ffse1703012.assignment.quanlytiendien;

import java.util.Scanner;
import ffse1703012.assignment.quanlytiendien.KhachHang;
import ffse1703012.assignment.quanlytiendien.BienLai;

public class TinhBienLai {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Số lượng khách hàng muốn nhập: ");
		int n = sc.nextInt();
		BienLai[] bienlai = new BienLai[n];
		KhachHang[] khachhang = new KhachHang[n];
		for (int i = 0; i < n; i++) {

			System.out.print("Nhập mã khách hàng: ");
			sc.nextLine();
			String maKhachHang = sc.nextLine();

			System.out.print("Nhập tên khách hàng: ");
			String hoTenChuNha = sc.nextLine();

			System.out.print("Địa chỉ khách hàng: ");
			String soNha = sc.nextLine();

			System.out.print("Mã số công tơ: ");
			int maSoCongTo = sc.nextInt();

			System.out.print("Nhập kỳ tiêu thụ: ");
			sc.nextLine();
			String kyTieuThu = sc.nextLine();

			System.out.print("Nhập số điện cũ: ");
			int chiSoCu = sc.nextInt();

			System.out.print("Nhập số điện mới: ");
			int chiSoMoi = sc.nextInt();

			System.out.println("********************************");
			khachhang[i] = new KhachHang(hoTenChuNha, maKhachHang, soNha, maSoCongTo);
			bienlai[i] = new BienLai(kyTieuThu, chiSoCu, chiSoMoi);

		}

		// IN DANH SÁCH KHÁCH HÀNG
		System.out.println("	HÓA ĐƠN TIỀN ĐIỆN CỦA KHÁCH HÀNG");
		System.out.println("	*********************************");

		for (int i = 0; i < khachhang.length; i++) {
			System.out.println("+*************************************+");
			System.out.println("|Khách hàng thứ " + (i + 1) + ": ");
			System.out.println("|Họ tên Khách hàng: " + khachhang[i].getHoTenChuNha());
			System.out.println("|Mã khách hàng: " + khachhang[i].getMaKhachHang());
			System.out.println("|Địa Chỉ: " + khachhang[i].getSoNha());
			System.out.println("|Mã số Công tơ: " + khachhang[i].getMaSoCongTo());
			System.out.println("|Kỳ tiêu thụ: " + bienlai[i].getKyTieuThu());
			System.out.println("|Số điện cũ: " + bienlai[i].getChiSoCu());
			System.out.println("|Số điện mới: " + bienlai[i].getChiSoMoi());
			System.out.println("|Thành tiền: " + bienlai[i].soTienPhaiTra() + " VNĐ");
			System.out.println("+*************************************+");
			System.out.println("								");

			// + );

		}
	}

}