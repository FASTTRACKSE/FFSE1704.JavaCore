package fasttrackse.bai3.quanlytiendien.main;
import java.util.*;

import fasttrackse.bai3.quanlytiendien.entity.*;
public class QuanLyTienDien {
	static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số khách hàng: ");
        n=sc.nextInt();
        BienLai[] arr=new BienLai[n];
        for(int i=0; i<arr.length ; i++){
            System.out.println("Nhập mã khác hàng thứ "+(i+1)+" : ");
            int makh= sc.nextInt();
            System.out.println("Nhập tên khách hàng thứ "+(i+1)+" : ");
            sc.nextLine();
            String tenkh= sc.nextLine();
            System.out.println("Nhập địa chỉ khách hàng thứ "+(i+1)+" : ");
            String diachikh= sc.nextLine();
            System.out.println("Nhập mã công tơ khách hàng thứ "+(i+1)+" : ");
            int mact = sc.nextInt();
            System.out.println("Nhập chỉ số cũ khách hàng thứ "+(i+1)+" : ");
            int chisocu=sc.nextInt();
            System.out.println("Nhập chỉ số mới khách hàng thứ "+(i+1)+" : ");
            int chisomoi=sc.nextInt();
            System.out.println("Nhập thời gian ghi số khách hàng thứ "+(i+1)+" : ");
            sc.nextLine();
            String thoigian=sc.nextLine();
            arr[i]= new BienLai(makh, tenkh, diachikh, mact, chisocu, chisomoi, thoigian);
            arr[i].thanhtoan();
            
            }
        
                System.out.println("----------------------HOÁ ĐƠN ĐIỆN--------------------------");
                System.out.printf("\n" + "%-10s %-15s %-10s %-12s %-8s %-8s %-8s %-8s", "Mã KH", "Tên KH", "Địa chỉ",
				"Mã CT", "CSCT_Cu", "CSCT_Moi", "ThoiGian", "TienDien");
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("\n" + "%-29s %-32s %-32s",arr[i].toString(), arr[i].mact(),arr[i].thanhtoan());
        }
    }
}
