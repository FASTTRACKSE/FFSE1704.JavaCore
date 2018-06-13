package facttrackse.hinh2d.main;

import java.util.ArrayList;

import facttrackse.hinh2d.entity.*;
import facttrackse.hinh2d.entity.HinhTron;

public class ChuongTrinhQuanLyHinhHoc {

	public ChuongTrinhQuanLyHinhHoc() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HinhHoc2d> dsHinh = new ArrayList<HinhHoc2d>();
		dsHinh.add(new HinhTron(10));
		dsHinh.add(new HinhChuNhat(10,20));
		dsHinh.add(new HinhChuNhat(15,20));
		dsHinh.add(new HinhChuNhat(20,20));
		int i = 0;
		for(HinhHoc2d o : dsHinh) {
			// đối tuongj sinh ra từ hình tron
			String msg = "";
			if(o instanceof HinhTron) {
				msg ="Hình tròn bán kính" +((HinhTron) o).getBanKinh();
			}
			else if(o instanceof HinhChuNhat) {
				msg="Hình chữ nhật" + ((HinhChuNhat) o).getChieuDai()+","+((HinhChuNhat) o).getChieuRong()+")";
			}
			System.out.println("hình thứ "+(++i)+msg+":Diện Tích ="+o.tinhChuVi()+"Diện tích"+o.tinhDienTich());
		}
	}

}
