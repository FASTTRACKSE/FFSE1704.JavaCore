/**
 * 
 */
package fasttrackse.hinh2d.main;

import java.util.ArrayList;
import fasttrackse.hinh2d.entity.*;

/**
 * @author GOS ThanhRTCD
 *
 */
public class ChuongTrinhTinhHinhHoc {

	/**
	 * 
	 */
	public ChuongTrinhTinhHinhHoc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<HinhHoc2D> dsHinh = new ArrayList<HinhHoc2D>();

		// Nhập Dữ Liệu
		dsHinh.add(new HinhTron(100));
		dsHinh.add(new HinhTron(150));

		dsHinh.add(new HinhChuNhat(10, 15));
		dsHinh.add(new HinhChuNhat(20, 25));
		dsHinh.add(new HinhChuNhat(30, 35));
		dsHinh.add(new HinhChuNhat(40, 45));

		int i = 0;
		String Cloud9 = "";
		for (HinhHoc2D o : dsHinh) {
			if (o instanceof HinhTron) {
				Cloud9 = " Hình tròn Bán Kính " + ((HinhTron) o).getBanKinh(); 
				} 
			else if (o instanceof HinhChuNhat)
				Cloud9 = " Hinh Chữ Nhật " + "(" + ((HinhChuNhat) o).getChieuDai() + " , " + ((HinhChuNhat) o).getChieuRong() + ")";
			System.out.println(
					" Hình Thứ " + (++i) + " : " + Cloud9 + " : Chu Vi = " + o.tinhChuVi() + " - Diện Tích = " + o.tinhDienTich());
		}
	}
}
