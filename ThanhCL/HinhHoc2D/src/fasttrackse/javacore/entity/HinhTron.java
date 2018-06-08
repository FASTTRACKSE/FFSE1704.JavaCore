package fasttrackse.javacore.entity;

public class HinhTron extends Hinh {
	private final double PI = 3.14;
	private double banKinh;

	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public double tinhDienTich() {
		return PI * Math.pow(this.banKinh, 2);
	}

	@Override
	public double tinhChuVi() {
		return 2 * PI * this.banKinh;
	}

}
