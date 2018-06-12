package fasttrackse.hinh2d.antity;

public class HinhTron extends HinhHoc2D {
	private double banKinh;
	final private double PI = 3.14;

	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double tinhChuVi() {
		return PI * banKinh * 2;
	}

	@Override
	public double tinhDienTich() {
		return PI * banKinh * banKinh;
	}

}
