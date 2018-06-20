package fasttrackse.hinhhoc.main;

import java.util.*;

import fasttrackse.hinhhoc.entity.*;

public class HinhHoc {

	public static void main(String[] args) {
		ArrayList<HinhHoc2D> dsHinh = new ArrayList<>();
		dsHinh.add(new HinhChuNhat(10,20));
		dsHinh.add(new HinhVuong(9));
		int i=1;
		String a = " ";
		for(HinhHoc2D x : dsHinh) {
			if(x instanceof HinhVuong) {
				a="Hình vuông có cạnh"+((HinhVuong)x).getCanh();
			}else if(x instanceof HinhChuNhat) {
				a="Hình chữ nhật có chiều dài: "+((HinhChuNhat)x).getChieuDai()+" và chiều rộng: "+((HinhChuNhat)x).getChieuRong();
			}
			System.out.println("Hình: "+a+" "+(i++)+" \nDiện tích: "+x.dienTich()+" \nChu Vi: "+x.chuVi());
		}
	}

}
