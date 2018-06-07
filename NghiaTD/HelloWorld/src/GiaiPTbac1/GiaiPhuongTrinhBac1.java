package GiaiPTbac1;
import java.util.Scanner;
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
			System.out.println("Phương trình" + soa+"x+"+sob+"=0 vô nghiệm");

	}
		}
		else {
			x = -sob/soa;
			System.out.println("Phương trình có nghiệm" + "x="+ x );
		}
	}

}
