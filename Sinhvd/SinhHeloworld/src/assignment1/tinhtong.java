package assignment1;
import java.util.Scanner;
public class tinhtong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int soA, sob, tonghaiso;
Scanner myInput = new Scanner(System.in); 
System.out.println("nhap số a");
soA = myInput.nextInt();
System.out.println("nhap số b");
sob = myInput.nextInt();
tonghaiso= soA + sob ;	
	System.out.println("tổng hai số " + soA +  " + " + sob + " là " + tonghaiso);
	}
}
