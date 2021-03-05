package codemaster.hinhhoc2d.database;

import codemaster.hinhhoc2d.business.Hinh2D;
import codemaster.hinhhoc2d.business.HinhChuNhat;
import codemaster.hinhhoc2d.business.HinhTamGiac;
import codemaster.hinhhoc2d.business.HinhTron;

public class HinhHocDB {
	private static Hinh2D[] dsHinh = new Hinh2D[100];
	private static int count=0;
	
	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	public static void khoiTaoHinh() {
		dsHinh[0] = new HinhChuNhat(1, "HCN", 20, 10);
		dsHinh[1] = new HinhChuNhat(2, "HCN", 6, 4);
		dsHinh[2] = new HinhChuNhat(3, "HCN", 2, 2);
		dsHinh[3] = new HinhTron(4, "HT", 20);
		dsHinh[4] = new HinhTamGiac(5, "HTG", 10, 10, 10);
		count = 5;
	}
	
	public static void themHinh(Hinh2D hinh) {
		dsHinh[count++]=hinh;
	}
	
	public static Hinh2D layHinh(int id) {
		for (Hinh2D hinh:dsHinh) {
			if (hinh.getId() == id) return hinh;
		}
		return null;
	}
	
	public static Hinh2D[] layDanhSachHinh() {
		return dsHinh;
	}
}
