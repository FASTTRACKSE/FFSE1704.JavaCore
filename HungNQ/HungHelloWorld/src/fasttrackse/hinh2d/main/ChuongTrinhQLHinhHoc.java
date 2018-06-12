package fasttrackse.hinh2d.main;

import java.util.ArrayList;
import fasttrackse.hinh2d.antity.*;

public class ChuongTrinhQLHinhHoc {

	public static void main(String[] args) {
		ArrayList<HinhHoc2D> dsHinh = new ArrayList<HinhHoc2D>();
		dsHinh.add(new HinhChuNhat(15, 50));
		dsHinh.add(new HinhChuNhat(20, 50));
		dsHinh.add(new HinhChuNhat(35, 50));
		dsHinh.add(new HinhChuNhat(50, 50));

		dsHinh.add(new HinhTron(100));
		dsHinh.add(new HinhTron(150));
		dsHinh.add(new HinhTron(200));

		int i = 0;
		String msg = "";
		for (HinhHoc2D o : dsHinh) {
			if(o instanceof HinhTron) {
				msg = " là hình tròn có bán kính " + ((HinhTron) o).getBanKinh();
			} else if(o instanceof HinhChuNhat) {
				msg = " là hình chữ nhật có chiều dài " + ((HinhChuNhat) o).getChieuDai() + " và chiều rộng " + ((HinhChuNhat) o).getChieuRong();
			}
			System.out.println(
					"Hình thứ " + (++i) + msg + " có chu vi = " + o.tinhChuVi() + " và có diện tích " + o.tinhDienTich());
		}
	}

}
