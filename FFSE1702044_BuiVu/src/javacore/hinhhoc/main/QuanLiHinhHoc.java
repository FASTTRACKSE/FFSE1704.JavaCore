package javacore.hinhhoc.main;

import java.util.ArrayList;

import javacore.hinhhoc.entity.*;

public class QuanLiHinhHoc {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HinhHoc2D> dsHinhHoc= new ArrayList<HinhHoc2D>();
		dsHinhHoc.add(new HinhVuong(5));
		dsHinhHoc.add(new HinhTron(10));
		String hh = "";
		for(HinhHoc2D x: dsHinhHoc) {
			if(x instanceof HinhVuong) {
				hh="Góc Hình Vuông là " + "("+((HinhVuong)x).getCanhGoc()+")";
			}else if(x instanceof HinhTron) {
				hh="Bán Kinh hình Tròn là: ( " + ((HinhTron)x).getBanKinh()+")";
			}
			System.out.println(hh+"\n Chu Vi "+ x.ChuVi() +"\n Diện Tích "+x.DienTich());
		}
			}

}
