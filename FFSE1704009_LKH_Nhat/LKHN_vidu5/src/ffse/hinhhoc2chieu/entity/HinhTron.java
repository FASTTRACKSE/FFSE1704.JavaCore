package ffse.hinhhoc2chieu.entity;

public class HinhTron extends HinhHoc2Chieu {
private double banKinh;
final private double PI = 3.14;
	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public double tinhDienTich() {

		return this.PI * (this.banKinh*this.banKinh);
	}

	@Override
	public double tinhChuVi() {

		return (2 * this.banKinh)* this.PI;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getPI() {
		return PI;
	}

}
