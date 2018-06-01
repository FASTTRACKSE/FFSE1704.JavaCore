package fasttrackse.javacore.assignment;
import  java.util.Scanner;
public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Giải phương trình bậc 2: ax2 + bx = c");
		Scanner ptbac2 = new Scanner(System.in);
		Double a,b,c;
		// Nhập tham số a, b, c.
		System.out.println("Mời nhập tham số a: ");
		a = ptbac2.nextDouble();
		System.out.println("Mời nhập tham số b: ");
		b = ptbac2.nextDouble();
		System.out.println("Mời nhập tham số c: ");
		c = ptbac2.nextDouble();
		//giải phường trình
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phương trình có vô số nghiệm.");
				}
				else {
					System.out.println("Phường trình vô nghiệm");
				}
			}
			else if(c==0) {
				System.out.println("phương trình vô nghiệm");
			}
			else{
				System.out.format("Phường trình có 1 nghiệm: %.3f" , (-c/b));
			}
		}
		else {
			Object math;
			//đi tìm delta
			Double Delta = Math.pow(b,2)-4*a*c;
			if(Delta<0) {
				System.out.println("Phương trình vô nghiệm");
			}
			else if(Delta==0) {
				System.out.println("phương trình có nghiệp kép x1 = x2 = " +(-b/(2*a)));
			}
			else {
				System.out.println("phương trình có 2 nghiệm x1,x2.");
				Double x1;
				Double x2;
				x1=(-b+Math.sqrt(Delta)/(2*a));
				x2=(-b-Math.sqrt(Delta)/(2*a));
				System.out.println("Nghiệm x1= " +x1);
				System.out.println("Nghiệm x2= " +x2);
			}
		}
		
	}

}
