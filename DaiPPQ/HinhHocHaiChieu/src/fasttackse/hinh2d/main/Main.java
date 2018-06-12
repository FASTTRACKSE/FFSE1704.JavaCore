/**
 * 
 */
package fasttackse.hinh2d.main;

import java.util.ArrayList;
import java.util.Scanner;

import fasttackse.hinh2d.entity.*;

/**
 * @author Support
 *
 */
public class Main {

	static int N;
	static ArrayList<Hinh2D> dsHinh = new ArrayList<Hinh2D>();

	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Tính Hình Chữ Nhật       |");
			System.out.println("|2.Tính Hình Tròn           |");
			System.out.println("|3.Tính Hình Tam Giác       |");
			System.out.println("|4.Tính Hình Bình Hành      |");
			System.out.println("|5.In kết quả               |");
			System.out.println("|6.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				TinhHCN();
			} else if (N == 2) {
				TinhHinhTron();
			} else if (N == 3) {
				TinhHinhTamGiac();
			} else if (N == 4) {
				TinhHinhBinhHanh();
			} else if (N == 5) {
				InKetQua();
			}  else {
				System.exit(0);
			}
		}
	}

	public static void TinhHCN() {
		System.out.print("Nhập Số Lượng Hình muốn tính: ");
		N = myInput.nextInt();
		ArrayList<HinhChuNhat> hinhCN = new ArrayList<HinhChuNhat>();
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin các cạnh của hình thứ " + (i + 1) + "\n");
			myInput.nextLine();

			System.out.print("Nhập chiều dài: ");
			double chieuDai = myInput.nextInt();

			System.out.print("Nhập chiều rộng: ");
			double chieuRong = myInput.nextInt();
			System.out.println("------------------------------------------------------------------");
			//hinhCN.add(new HinhChuNhat(chieuDai, chieuRong));
			dsHinh.add(new HinhChuNhat(chieuDai, chieuRong));
		}

		int i = 0;
		String msg = "";
		for (HinhHoc2Chieu o : dsHinh) {
			if (o instanceof HinhChuNhat) {
				msg = "Hình chữ nhật(" + ((HinhChuNhat) o).getChieuDai() + ", " + ((HinhChuNhat) o).getChieuRong()
						+ ")";
			}
			System.out.println(
					"Hình Chữ nhật Thứ " + (++i) + ": Chu vi: " + o.tinhChuVi() + " - Diện Tích: " + o.tinhDienTich());
		}
		System.out.println("******************************************************");
	}

	public static void TinhHinhTron() {
		System.out.print("Nhập Số Lượng Hình muốn tính: ");
		N = myInput.nextInt();
		ArrayList<HinhTron> hinhTron = new ArrayList<HinhTron>();
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin các cạnh của hình thứ " + (i + 1) + "\n");
			myInput.nextLine();

			System.out.print("Nhập bán kính: ");
			double banKinh = myInput.nextInt();
			System.out.println("------------------------------------------------------------------");
			dsHinh.add(new HinhTron(banKinh));
		}

		int i = 0;
		String msg = "";
		for (HinhHoc2Chieu o : dsHinh) {
			if (o instanceof HinhTron) {
				msg = "Hình chữ nhật(" + ((HinhTron) o).getBanKinh() + ")";
			}
			System.out.println(
					"Hình Chữ nhật Thứ " + (++i) + ": Chu vi: " + o.tinhChuVi() + " - Diện Tích: " + o.tinhDienTich());
		}
		System.out.println("******************************************************");
	}

	public static void TinhHinhTamGiac() {
		System.out.print("Nhập Số Lượng Hình muốn tính: ");
		N = myInput.nextInt();
		ArrayList<HinhTamGiac> hinhTamGiac = new ArrayList<HinhTamGiac>();
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập Thông Tin các cạnh của hình thứ " + (i + 1) + "\n");
			myInput.nextLine();

			System.out.print("Nhập cạnh thứ nhất: ");
			double canhThu1 = myInput.nextInt();

			System.out.print("Nhập cạnh thứ 2: ");
			double canhThu2 = myInput.nextInt();

			System.out.print("Nhập cạnh thứ 3: ");
			double canhThu3 = myInput.nextInt();
			System.out.println("------------------------------------------------------------------");
			dsHinh.add(new HinhTamGiac(canhThu1, canhThu2, canhThu3));
		}
		int i = 0;
		String msg = "";
		for (HinhHoc2Chieu o : dsHinh) {
			if (o instanceof HinhTamGiac) {
				msg = "Hình chữ nhật(" + ((HinhTamGiac) o).getCanhThu1() + ", " + ((HinhTamGiac) o).getCanhThu2() + ", "
						+ ((HinhTamGiac) o).getCanhThu3() + ")";
			}
			System.out.println(
					"Hình Chữ nhật Thứ " + (++i) + ": Chu vi: " + o.tinhChuVi() + " - Diện Tích: " + o.tinhDienTich());
		}
		System.out.println("******************************************************");
	}

	public static void TinhHinhBinhHanh() {

	}

	public static void InKetQua() {

	}
}