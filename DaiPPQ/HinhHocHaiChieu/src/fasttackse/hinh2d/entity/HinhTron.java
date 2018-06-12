/**
 * 
 */
package fasttackse.hinh2d.entity;

public class HinhTron extends Hinh2D {
private double banKinh;
final private double PI = 3.14;
	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public double getDienTich() {

		return this.PI * (this.banKinh*this.banKinh);
	}

	@Override
	public double getChuVi() {

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
