package bai5.main;

import java.util.Scanner;
import bai5.entity.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhập số lượng khách hàng : ");
		N = nhap.nextInt();
		KhachHang[] khachhang=new KhachHang[N];
		BienLai[] bienlai= new BienLai[N];
		for(int i=0;i<khachhang.length;i++) {
			System.out.print("Nhập mã khách hàng");
			nhap.nextLine();
			String maKhachHang=nhap.nextLine();
			
			System.out.print("Nhập tên khách hàng");
			String tenKhachHang=nhap.nextLine();
			
			System.out.print("Nhập địa khách hàng");
			String diaChi=nhap.nextLine();
			
			System.out.print("Nhập mã công tơ");
			int maCongTo=nhap.nextInt();
			
			System.out.print("Nhập kỳ tiêu thụ");
			String kyTieuThu=nhap.nextLine();
			nhap.nextLine();
			
			System.out.print("Nhập chỉ số cũ");
			int chiSoCu=nhap.nextInt();
			
			System.out.print("Nhập chỉ số mới");
			int chiSoMoi=nhap.nextInt();
			khachhang[i]= new KhachHang(maKhachHang,tenKhachHang,diaChi,maCongTo);
			bienlai[i]=new BienLai(kyTieuThu,chiSoCu,chiSoMoi);
		}
		System.out.println("\t \t \t\tDANH SÁCH KHÁCH HÀNG");
		System.out.println("\t \t \t *********************************");
		for(int i=0;i<khachhang.length;i++) {
			System.out.print("Khách hàng thứ:"+(i+1)+":"+khachhang[i].toString()+"Kỳ tiêu thụ:"+bienlai[i].getkyTieuThu()+"chỉ số cũ:"+bienlai[i].getchiSoCu()+"Chỉ số mới:"+bienlai[i].getchiSoMoi()+"số tiền phải trả:"+bienlai[i].sotienphaitra()+" VNĐ");
		}
	}

}
