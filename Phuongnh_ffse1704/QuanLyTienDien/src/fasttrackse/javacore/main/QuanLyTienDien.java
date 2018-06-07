package fasttrackse.javacore.main;
import fasttrackse.javacore.entity.*;

import java.util.ArrayList;
import java.util.Scanner;
public class QuanLyTienDien {
	public static void main(String[] args) {
		int N;
	Scanner myInput = new Scanner(System.in);
	System.out.print("Nhập thông tin khách hàng ");
	 N=myInput.nextInt();
	 ArrayList<KhachHang> arrKhachhang =new ArrayList<KhachHang>();
	 
	 for (int i=0;i<N;i++) {
		  myInput.nextLine();
		  
		 System.out.print("Nhập mã khách hàng ");
			int maKhachHang = myInput.nextInt();
			
			System.out.print("Nhập tên khách hàng ");
			 myInput.nextLine();
			String tenKhachHang = myInput.nextLine();
			
			System.out.print("Nhập địa chỉ khách Hàng ");
			String diaChi = myInput.nextLine();
			
			System.out.print("Nhập mã công tơ");
			String maCongTo = myInput.nextLine();
			
			KhachHang khachhang = new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo);
			
			ArrayList<BienLai> arrBienlai  = new ArrayList<BienLai>();
			
			//Bắt đầu lưu biên lai
			System.out.print("nhập số biên lai");
			int soBienLai  = myInput.nextInt();
			for (int j = 0; j < soBienLai; j++) {
				
				System.out.print("nhập chỉ số mới ");
				int chiSoMoi  = myInput.nextInt();
				
				System.out.print("nhập chỉ số cũ ");
				int chiSoCu = myInput.nextInt();
				
				System.out.print("nhập kỳ tiêu thụ ");
				int kyTieuThu = myInput.nextInt();
				
				BienLai bienLai = new BienLai(chiSoMoi, chiSoCu, kyTieuThu);
				arrBienlai.add(bienLai);
				
			}
			//Kết thúc hàm for
			
			khachhang.setBienlai(arrBienlai);
			arrKhachhang.add(khachhang);
	 }
	 System.out.println("----------------------------------DANH SÁCH KHÁCH HÀNG---------------------------------------"); 
	 System.out.println("MKH "+"\t \t"+ "Tên Khách Hàng"+"\t \t"+"Địa Chỉ"+" \t \t"+"Tiền điện");
	 for (int i = 0; i < arrKhachhang.size(); i++) {
		KhachHang khachhang = arrKhachhang.get(i);
		 System.out.println(khachhang.getmaKhachHang() +"\t \t"
			 + khachhang.gettenKhachHang()+"\t \t    "
			 + khachhang.getdiaChi()+"\t \t");
	 }
	
	

}
}