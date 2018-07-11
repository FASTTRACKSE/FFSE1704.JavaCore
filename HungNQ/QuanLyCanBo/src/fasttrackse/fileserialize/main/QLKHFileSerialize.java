package fasttrackse.fileserialize.main;

import java.util.ArrayList;
import java.util.Scanner;

import fasttrackse.filesample.entity.KhachHang;
import fasttrackse.filesample.util.SerializeFileFactory;

public class QLKHFileSerialize {

	public static void main(String[] args) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		Scanner myInput = new Scanner(System.in);
		int myChoose = 0;

		do {
			System.out.println("Mời bạn chọn chức năng (1-Nhập danh sách, 2- Đọc file, 3- Ghi File, 4- In ds KH");
			myChoose = myInput.nextInt();

			switch (myChoose) {
			case 1:
				// Nhập thông tin từ bàn phím
				myInput.nextLine();
				System.out.print("Mã KH: ");
				String maKH = myInput.nextLine();
				System.out.print("Tên KH: ");
				String tenKH = myInput.nextLine();
				dsKH.add(new KhachHang(maKH, tenKH));
				break;

			case 2:
				// Lấy thông tin khách hàng từ file
				dsKH.clear();
				dsKH = SerializeFileFactory.docFile("danhsachkhachhang.txt");
				break;
			case 3:
				// Lưu thông tin khách hàng ra file
				SerializeFileFactory.luuFile(dsKH, "danhsachkhachhang.txt");

				break;

			case 4:
				// In danh sách khách hàng ra màn hình
				for (KhachHang o : dsKH) {
					System.out.println(o.toString());
				}
				break;
			}
		} while (myChoose != 0);

		myInput.close();

	}

}