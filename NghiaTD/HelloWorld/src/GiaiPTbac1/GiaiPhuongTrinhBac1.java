package GiaiPTbac1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
public class GiaiPhuongTrinhBac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int soa, sob, x;
		double nghiemX;
		Scanner myInput = new Scanner(System.in);
	
		System.out.println("nhập vào số a:");
		soa= myInput.nextInt();
		System.out.println("nhập vào số b:");
		sob= myInput.nextInt();
		if(soa==0) {
		if(sob==0) {
			System.out.println("Phương trình" + soa+"x+"+sob+"=0 vô số nghiệm");
		}
		else
		{	
			System.out.println("\t \t \t\tDANH SÁCH KHÁCH HÀNG");
			System.out.println("Phương trình" + soa+"x+"+sob+"=0 vô nghiệm");

	}
		}
		else {
			x = -sob/soa;
			System.out.println("Phương trình có nghiệm" + "x="+ x );
		}
//		long start =System.currentTimeMillis();
//		
//		long end = System.currentTimeMillis();
		long start = System.nanoTime();
		long end  = System.nanoTime();
		
		System.out.println("thời gian thực thi:"+(end - start)+"giây");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date date = new Date();
		String day =dateFormat.format(date);
		System.out.println(day);
	}
	
	
}
