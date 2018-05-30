package first.project;

import java.util.Scanner;

public class Snt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,dem;
		dem=0;
		i=0;
		System.out.println("nhập số n bất kỳ: ");
		Scanner nhap = new Scanner(System.in);
		n = nhap.nextInt();
		while(i<=n) {
			i++;
			if(n%i==0) {
				dem+=1;
				if(dem>2) {
					System.out.println(n + "không phải số nguyên tố");
					break;
					
				}
			}
		}
	}

}
