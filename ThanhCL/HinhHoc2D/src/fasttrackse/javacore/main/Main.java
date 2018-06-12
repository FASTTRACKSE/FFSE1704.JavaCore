package fasttrackse.javacore.main;

import fasttrackse.javacore.entity.*;

public class Main {

	public static void main(String[] args) {
		Hinh hinh1 = new HinhVuong(10);
		Hinh hinh2 = new HinhChuNhat(20, 30);
		Hinh hinh3 = new HinhTron(15);
		
		Hinh[] dsHinh = {hinh1, hinh2, hinh3};
		
		int stt = 0;
		for (Hinh x : dsHinh) {
			System.out.print(++stt);
			if (x instanceof HinhVuong) {
				System.out.print("/ HÌNH VUÔNG ");
				System.out.println("(" + ((HinhVuong) x).getCanh() + ")");
			} else if (x instanceof HinhChuNhat) {
				System.out.print("/ HÌNH CHỮ NHẬT ");
				System.out.println("(" + ((HinhChuNhat) x).getChieuDai()+ "," + ((HinhChuNhat) x).getChieuRong()+ ")");
			} else if (x instanceof HinhTron) {
				System.out.print("/ HÌNH TRÒN ");
				System.out.println("( R = " + ((HinhTron) x).getBanKinh() + ")");
			}
			System.out.printf("Chu vi = %-5.1f - Diện tích = %-10.1f\n\n", x.tinhChuVi(), x.tinhDienTich());
		}
	}

}
