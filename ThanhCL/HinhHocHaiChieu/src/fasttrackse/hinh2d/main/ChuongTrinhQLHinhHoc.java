/**
 * 
 */
package fasttrackse.hinh2d.main;

import java.util.ArrayList;

import fasttrackse.hinh2d.entity.*;

/**
 * @author thanhcl
 *
 */
public class ChuongTrinhQLHinhHoc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<HinhHoc2D> dsHinh = new ArrayList<HinhHoc2D>();

		// Nhập dữ liệu
		dsHinh.add(new HinhTron(100));
		dsHinh.add(new HinhTron(150));

		dsHinh.add(new HinhChuNhat(10, 20));
		dsHinh.add(new HinhChuNhat(20, 50));
		dsHinh.add(new HinhChuNhat(30, 80));

		int i = 0;
		String msg = "";
		for (HinhHoc2D o : dsHinh) {
			if (o instanceof HinhTron) {
				msg = "Hình tròn Bán Kính " + ((HinhTron) o).getBanKinh();
			} else if (o instanceof HinhChuNhat) {
				msg = "Hình chữ nhật (" + ((HinhChuNhat) o).getChieuDai() + ", " + ((HinhChuNhat) o).getChieuRong()
						+ ")";
			}

			System.out.println("Hinh thứ " + (++i) + ": " + msg + " Chu vi = " + o.tinhChuVi() + " - Diện tích = "
					+ o.tinhDienTich());
		}
	}

}
