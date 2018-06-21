package fasttrackse.qltt.main;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

import fasttrackse.qltt.entity.*;

public class QuanLyThongTin {
	
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("***********************");
			System.out.println("*    1.Nhập GV,NV     *");
			System.out.println("*    2.In ds GV,NV    *");
			System.out.println("*      3.Kết Thúc     *");
			System.out.println("***********************");

			System.out.println("Mời bạn chọn chương trình: ");
			int soNguoiDungChon = myInput.nextInt();
			if (soNguoiDungChon == 1) {
				Nhap();
			} else if (soNguoiDungChon == 2) {
				System.out.println("Nhân Viên");
			} else if (soNguoiDungChon == 3) {
				KetThuc();
			}
		}
	}
	public static void Nhap() {
		//GiangVien x = new GiangVien(null, null, null, null, null)
		int N;
		System.out.print("Nhập Số Lượng Cán Bộ Muốn Nhập");
		N = myInput.nextInt();
		for(int i=0;i<N;i++) {
			System.out.print("Nhập Loại Cán Bộ");
			int K = myInput.nextInt();
			try{
				if(K==1) {

					System.out.print("Mời Bạn Nhập Giảng Viên");

					System.out.print("Nhập Tên GV");
					
					String tenCB=myInput.nextLine();
					
					
				}
			}
			catch(Exception e){
				System.out.println("Chỉ nhập từ 1 hoặc 2, nhập lại nhé bạn hiền!");
			}
		}
	}
	public static void KetThuc() {
		myInput.close();
		System.out.println("Cảm ơn bạn đã sử dụng chương trình!!!");
		System.exit(0);
	}
}
