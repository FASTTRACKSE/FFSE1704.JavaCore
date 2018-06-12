/**
 * 
 */
package quanlytiendien.entity;

/**
 * @author Admin
 *
 */
	import java.util.Scanner;
	 
	public class BienLai {
	    private int chiSoCu;
	    private int chiSoMoi;
	    private int maKhachHang;
	    private double soTienPhaiTra;
	    private KhachHang khachHang;
	     
	    public BienLai() {
	        super();
	    }
	 
	    public BienLai(int chiSoCu, int chiSoMoi, double soTienPhaiTra, KhachHang khachHang) {
	        super();
	        this.chiSoCu = chiSoCu;
	        this.chiSoMoi = chiSoMoi;
	        this.soTienPhaiTra = soTienPhaiTra;
	        this.khachHang = khachHang;
	        this.maKhachHang= maKhachHang;
	    }
	     
	    public void nhapBienLai() {
	        khachHang = new KhachHang();
	        khachHang.nhapThongTinKhachHang();
	         
	        Scanner scanner = new Scanner(System.in);
	        do {
	            System.out.print("Nhập chỉ số cũ: ");
	            chiSoCu = scanner.nextInt();
	            System.out.print("Nhập chỉ số mới: ");
	            chiSoMoi = scanner.nextInt();
	            System.out.println("Nhập Mã Khách Hàng: ");
	            maKhachHang=scanner.nextInt();
	        } while (chiSoCu > chiSoMoi);
	     
	        soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 3000;
	    }
	     
	    public void hienThiBienLai() {
	        khachHang.hienThiThongTinKhachHang();
	        System.out.println("Chỉ số cũ: " + chiSoCu);
	        System.out.println("Chỉ số mới: " + chiSoMoi);
	        System.out.println("Mã Khách Hàng:" +maKhachHang);
	        System.out.println("Số tiền phải trả: " + soTienPhaiTra);
	    }
}
