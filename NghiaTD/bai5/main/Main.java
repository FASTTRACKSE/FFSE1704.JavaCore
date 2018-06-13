package bai5.main;
import bai5.entity.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class Main {
	static int N;
	static ArrayList<KhachHang> dsKhachHang  = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập Thông Tin Khách Hàng|");
			System.out.println("|2.Nhập Biên Lai  Khách Hàng|");
			System.out.println("|3.In Hóa Đơn Tiền điện KH  |");
			System.out.println("|4.DS Tiêu Thụ Theo Chu Kỳ  |");
			System.out.println("|5.Xóa 1 Khách Hàng         |");
			System.out.println("|6.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinKH();
			} else if (N == 2) {
				NhapBienLai();
			} else if (N == 3) {
				InKhachHang();
			} else if (N == 4) {
				InDsTieuThuTheoChuKy();
			} else if (N == 5) {
				XoaMotKhachHang();
			}/*else if (N == 6) {
				XoaBienLaiKH();
			}*/ else {
				System.exit(0);
			}
		}
	}
	public static void NhapThongTinKH() {
		
			System.out.print("Nhập số lượng khách hàng : ");
			
		N = myInput.nextInt();
		for(int i=0;i<N;i++) {
			System.out.print("Nhập khách hàng thứ "+(i+1)+ "\n");
			myInput.nextLine();
			System.out.print("Nhập mã khách hàng");
			String maKH=myInput.nextLine();
			System.out.print("Nhập tên khách hàng");
			myInput.nextLine();
			String tenKH=myInput.nextLine();
			System.out.print("Nhập địa chỉ khách hàng");
			String diaChiKH=myInput.nextLine();
			dsKhachHang.add(new KhachHang(maKH,tenKH,diaChiKH));
			
		}
	}
		public static void NhapBienLai() {
			String M = "";
			System.out.print("Nhập Biên Lai Khách Hàng thứ bao nhiêu? : ");
			M = myInput.nextLine();
			
			for(int j=0;j<dsKhachHang.size();j++) {
				
				if(M.equals(dsKhachHang.get(j).getTenKH())) {
				System.out.print("Nhập thông tin khách hàng"+(j+1)+"\n");
				System.out.print("Nhập mã công tơ");
				String maCongTo=myInput.nextLine();
				System.out.print("Nhập chu kì tháng");
				int chuKiThang=myInput.nextInt();
				System.out.print("Nhập chu kì Năm");
				int chuKiNam=myInput.nextInt();
				System.out.print("Nhập chỉ số đầu kì");
				int csDauKi=myInput.nextInt();
				System.out.print("Nhập chỉ số cuối kì");
				int csCuoiKi=myInput.nextInt();
				dsKhachHang.get(j).addtodsBienLai(new BienLai(maCongTo,chuKiThang,chuKiNam,csDauKi,csCuoiKi) );
				
			}
			}
		}
		public static void InKhachHang() {
			Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
				@Override
				public int compare(KhachHang kh1, KhachHang kh2) {
					return (kh1.getTenKH().compareTo(kh2.getTenKH()));
					
				}
			});
		
		for(KhachHang x : dsKhachHang) {
			System.out.println("Mã KH:"+x.getMaKH()+"Tên KH:"+x.getTenKH()+"\t"+"csDauKy"+"\t"+"csCuoiKy"+"\t"+"Tháng Năm"
		+"\t"+"Tông tiền");
			for(BienLai o : x.getDsBienLai()) {
				System.out.println("t\t\t\t"+ o.getCsDauKy()+ " \t"+ o.getCsCuoiKy()+ "\t " +o.getChuKyThang()+ "/"
						+o.getChuKyNam() + "\t\t" + o.tinhTongTien()+ "VNĐ");
			}
				System.out.println(
						"\n----------------------------------------------------------------------------------------");
			}}
		
		public static void InDsTieuThuTheoChuKy() {
		int c =0;
		System.out.println("Nhập chu kì muốn in");
		c= myInput.nextInt();
		for(KhachHang x : dsKhachHang){
			System.out.println("Mã KH:"+x.getMaKH()+"Tên Kh:"+x.getTenKH()+ "\t"+"chỉ số đầu kì:"+"\t"+"chỉ số cuối kì"
		+ "\t"+"Tổng tiền");
			for(BienLai o : x.getDsBienLai()) {
				if(o.getChuKyThang()==c) {
					System.out.println("t\t\t\t" + o.getCsDauKy()+ "\t" +o.getCsCuoiKy()+ "\t"+ o.getChuKyThang()+"/" +o.getChuKyNam()+"t\t"+
				o.tinhTongTien() + " VNĐ");
					break;
				}
			}
		}
	}
		public static void XoaMotKhachHang() {
			String X;
			System.out.println("Nhập khách hàng cần xóa:");
			myInput.nextLine();
			X=myInput.nextLine();
			for(KhachHang x :dsKhachHang) {
				if(X.equals(x.getTenKH())) {
					dsKhachHang.remove(x);
				}
			}
		}
}
		
		
		
		


