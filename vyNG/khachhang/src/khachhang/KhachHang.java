package khachhang;

import java.util.Scanner;

public class KhachHang {
	private String hotenchunha;
	private String sonha;
	private int masocongto;
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(String hotenchunha, String sonha, int masocongto) {
		super();
		this.hotenchunha = hotenchunha;
		this.sonha = sonha;
		this.masocongto = masocongto;
	}
	
	public void nhapthongtinkhachhang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhập thông tin chủ hộ");
		hotenchunha = scanner.nextLine();
		System.out.println("nhập số nhà");
		sonha = scanner.nextLine();
		System.out.println("mã số công tơ");
		masocongto = scanner.nextInt();
	}
	
	public void hienthithongtinkhachhang() {
		System.out.println("tên chủ hộ : " + hotenchunha);
		System.out.println("số nhà : " + sonha);
		System.out.println("mã số công tơ : " + masocongto);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
