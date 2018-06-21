package hinhhoc.main;

import java.util.ArrayList;

import hinhhoc.entity.*;

public class QuanLyHinhHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<HinhHoc> dsHinh = new ArrayList<>();
        dsHinh.add(new HinhTron1(78));
        dsHinh.add(new HinhTron1(100));
        
        dsHinh.add(new HinhChuNhat());
        }
}
   