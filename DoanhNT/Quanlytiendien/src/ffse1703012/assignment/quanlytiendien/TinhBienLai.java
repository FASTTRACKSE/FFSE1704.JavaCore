package ffse1703012.assignment.quanlytiendien;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

import ffse1703012.assignment.quanlytiendien.KhachHang;
import ffse1703012.assignment.quanlytiendien.BienLai;

public class TinhBienLai {
	public static Scanner sc = new Scanner(System.in);
	static ArrayList<KhachHang> arrayKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> arrayBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {
		// Nhập Khách hàng
		System.out.print("Số lượng khách hàng muốn nhập: ");
		int n = sc.nextInt();

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
			arrayKhachHang.add(new KhachHang(hoTenChuNha, maKhachHang, soNha, maSoCongTo));

			// Nhập Biênlai
			System.out.println("Số biên lai muốn nhập: ");
			int tongBienLai = sc.nextInt();
			for (int j = 0; j < tongBienLai; j++) {
				System.out.println("Nhập kỳ tiêu thụ: ");
				sc.nextLine();
				String kyTieuThu = sc.nextLine();

				System.out.print("Nhập số điện cũ: ");
				int chiSoCu = sc.nextInt();

				System.out.print("Nhập số điện mới: ");
				int chiSoMoi = sc.nextInt();
				arrayBienLai.add(new BienLai(arrayKhachHang.get(i).getHoTenChuNha(),
						arrayKhachHang.get(i).getMaKhachHang(), arrayKhachHang.get(i).getSoNha(),
						arrayKhachHang.get(i).getMaSoCongTo(), kyTieuThu, chiSoCu, chiSoMoi));
			}
		}

		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng |");
		for (BienLai x : arrayBienLai) {
			System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s\n", x.getMaKhachHang(),
					x.getHoTenChuNha(), x.getSoNha(), x.getMaSoCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
					x.soTienPhaiTra(), x.getKyTieuThu());
		}
		
	}
}