package codemaster.hinhhoc2d.ui;

import codemaster.hinhhoc2d.business.Hinh2D;
import codemaster.hinhhoc2d.business.HinhTron;
import codemaster.hinhhoc2d.database.HinhHocDB;

public class HinhHocApp {

	public static void main(String[] args) {
		HinhHocDB.khoiTaoHinh();
		
		Hinh2D hinh = HinhHocDB.layHinh(3);
		if (hinh != null) {
			System.out.println(hinh.toString());
		} else {
			System.out.println("Khong ton tai hinh id = 3");
		}
		
		Hinh2D hinhMoi = new HinhTron(6, "HT", 30);
		HinhHocDB.themHinh(hinhMoi);
		
		System.out.println("--------------------------------");
		System.out.println("DANH SACH CAC HINH 2D TRONG CSDL");
		System.out.println("--------------------------------");
		for (int i=0; i<HinhHocDB.getCount(); i++) {
			System.out.println(HinhHocDB.layDanhSachHinh()[i].getInfo());
		}
	}
}
