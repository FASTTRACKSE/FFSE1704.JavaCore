package fasttrackse.hinh2d.entity;

public class HinhTron extends HinhHoc2D {
	private double banKinh;
	final private double PI = 3.14;

	public HinhTron(double banKinh) {
		this.banKinh = banKinh;

	}

	@Override
	public double tinhChuVi() {

		return banKinh * 2 * PI;
	}

	@Override
	public double tinhDienTich() {

		return banKinh * banKinh * PI;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

}
