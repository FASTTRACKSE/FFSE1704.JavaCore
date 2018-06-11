package biênlai;

import java.util.Scanner;

import khachhang.KhachHang;

public class BiênLai {
	private int chisocu;
	private int chisomoi;
	private double sotienphaitra;
	private KhachHang khachhang;
	
	public BiênLai() {
		super();
	}
	
	public BiênLai(int chisocu, int chisomoi, double sotienphaitra, KhachHang khachhang) {
		super();
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		this.sotienphaitra = sotienphaitra;
		this.khachhang = khachhang;
	}
	
	public void nhapbienlai() {
		khachhang = new KhachHang();
		khachhang.nhapthongtinkhachhang();
         
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập chỉ số cũ: ");
            chisocu = scanner.nextInt();
            System.out.print("Nhập chỉ số mới: ");
            chisomoi = scanner.nextInt();
        } while (chisocu > chisomoi);
     
        sotienphaitra = (double) (chisomoi - chisocu) * 600;
    }
	public void hienthibienlai() {
		khachhang.nhapthongtinkhachhang();
		System.out.println("chỉ số cũ : " + chisocu);
		System.out.println("chỉ số mới : " + chisomoi);
		System.out.println("số tiền phải trả : " + sotienphaitra);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
