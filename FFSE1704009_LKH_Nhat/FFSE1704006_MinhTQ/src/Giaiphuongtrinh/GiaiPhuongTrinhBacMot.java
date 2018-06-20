package Giaiphuongtrinh;

import java.util.Scanner;

public class GiaiPhuongTrinhBacMot {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		
	    System.out.println("Nhập vào số a");
	    int a = nhap.nextInt();
	    
	    System.out.println("Nhập vào số b");
		int b = nhap.nextInt();
		
		
		if(a==0){
			if(b==0) {
				//a=0,b=0;
				System.out.println("Phương trình"+ a +"x +"+ b +"= 0 có vô số nghiệm");
			}else {
				//a=o,b#0;
				System.out.println("phương trình"+ a +"x +"+ b +"= 0 vô nghiệm" );
			}
		}else {
			//a!=0 phương trình có một nghiệm là x=- b/a
		int	nghiemX = -b/a;
			System.out.println("phương trình"+ a +"x + "+ b +" = 0 có nghiệm x = "+ nghiemX);
		}
	}

}
