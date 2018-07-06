package ffse.quanlihinhhoc.main;

import java.util.ArrayList;


import ffse.quanlihinhhoc.entyti.*;

public class QuanLiHinhHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<HinhHoc2D> dsHinhHoc = new ArrayList<HinhHoc2D>();
		 dsHinhHoc.add(new HinhChuNhat(10,9));
		 int i=1;
		 for(HinhHoc2D x : dsHinhHoc) {
			 System.out.println("Hình Có Chu Vi " + x.TinhChuVi() + " Và Diện Tích " + x.TinhDienTich());
		 }
	}

}
