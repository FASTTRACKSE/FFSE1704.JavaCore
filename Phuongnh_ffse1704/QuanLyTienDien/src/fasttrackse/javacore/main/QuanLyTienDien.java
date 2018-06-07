package fasttrackse.javacore.main;
import fasttrackse.javacore.entity.*;
import java.util.Scanner;
public class QuanLyTienDien {
	public static void main(String[] args) {
		int N;
	Scanner myInput = new Scanner(System.in);
	System.out.print("Nhập thông tin khách hàng ");
	 N=myInput.nextInt();
	 KhachHang[] khachhang = new KhachHang[N];
	 BienLai[] bienlai = new BienLai[N];
	 for (int i=0;i<N;i++) {
		  myInput.nextLine();
		  
		 System.out.print("Nhập mã khách hàng ");
			int makhachhang = myInput.nextInt();
			
			System.out.print("Nhập tên khách hàng ");
			 myInput.nextLine();
			String tenkhachhang = myInput.nextLine();
			
			System.out.print("Nhập địa chỉ khách Hàng ");
			String diachi = myInput.nextLine();
			
			System.out.print("Nhập mã công tơ");
			String macongto = myInput.nextLine();
			
			System.out.print("nhập chỉ số mới ");
			int chisomoi  = myInput.nextInt();
			
			System.out.print("nhập chỉ số cũ ");
			int chisocu = myInput.nextInt();
			
			System.out.print("nhập kỳ tiêu thụ ");
			int kytieuthu = myInput.nextInt();
			
			khachhang[i]=new KhachHang(makhachhang,tenkhachhang,diachi,macongto,kytieuthu);
			bienlai[i] = new BienLai(chisomoi,chisocu); 
		 
	 }
	 System.out.println("----------------------------------DANH SÁCH KHÁCH HÀNG---------------------------------------"); 
	 System.out.println("MKH "+"\t \t"+ "Tên Khách Hàng"+"\t \t"+"Địa Chỉ"+" \t \t"+"Tiền điện");
	 for (int i = 0; i < khachhang.length; i++) {
		
	 System.out.println(khachhang[i].getmaKhachHang() +"\t \t"+khachhang[i].gettenKhachHang()+"\t \t"+khachhang[i].getdiaChi()+"\t \t"+ +bienlai[i].tienCanThanhToan()+"đồng" );
	 }
	
	

}
}