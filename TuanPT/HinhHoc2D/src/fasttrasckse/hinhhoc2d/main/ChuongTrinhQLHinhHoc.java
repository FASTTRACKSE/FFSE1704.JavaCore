package fasttrasckse.hinhhoc2d.main;

import fasttrackse.hinh2d.entity.*;
import java.util.ArrayList;

public class ChuongTrinhQLHinhHoc {
	public static void main(String[] args) {
		ArrayList<HinhHoc2D> dsHinh = new ArrayList<HinhHoc2D>();
		
		// Nhập dữ liệu
		dsHinh.add(new HinhTron(100));
		dsHinh.add(new HinhTron(150));
		
		dsHinh.add(new HinhChuNhat(10, 20));
		dsHinh.add(new HinhChuNhat(20, 50));
		dsHinh.add(new HinhChuNhat(30, 80));
		
		int i = 0;
		String msg ="";
		for (HinhHoc2D o : dsHinh) {
			if (o instanceof HinhTron) {
				msg = "Hình tròn Bán kính " + ((HinhTron)o).getBanKinh();
			}else if (o instanceof HinhChuNhat) {
				msg = "Hình chữ nhật Chiều dài " + ((HinhChuNhat)o).getChieuDai() + " , Chiều rộng " + ((HinhChuNhat)o).getChieuRong();
			}
			System.out.println("Hình thứ " + (++i) + ":" + msg + " Chu vi =" + o.tinhChuVi() + " - DienTich = " + o.tinhDienTich());
		}
	}

}
