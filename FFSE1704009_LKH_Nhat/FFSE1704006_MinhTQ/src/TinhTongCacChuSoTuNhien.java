import java.util.Scanner;

public class TinhTongCacChuSoTuNhien {

	public static void main(String[] args) {

		Scanner nhap = new Scanner(System.in);

		System.out.println("nhập vào số a");
		int a = nhap.nextInt();

		System.out.println("nhập vào số b");
		int b = nhap.nextInt();

		System.out.println("Tổng của a + b là " + a + "+" + b + "=" + (a + b));
	}

}
