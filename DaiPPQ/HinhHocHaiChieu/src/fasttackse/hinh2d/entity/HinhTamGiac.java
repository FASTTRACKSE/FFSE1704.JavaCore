/**
 * 
 */
package fasttackse.hinh2d.entity;

/**
 * @author Support
 *
 */
public class HinhTamGiac extends Hinh2D {
	private double canhThu1;
	private double canhThu2;
	private double canhThu3;
	private double P = (canhThu1 + canhThu2 + canhThu3) / 2;

	public HinhTamGiac(double canhThu3, double canhThu1, double canhThu2) {
		this.canhThu1 = canhThu1;
		this.canhThu2 = canhThu2;
		this.canhThu3 = canhThu3;
	}

	public double getCanhThu1() {
		return canhThu1;
	}

	public void setCanhThu1(double canhThu1) {
		this.canhThu1 = canhThu1;
	}

	public double getCanhThu2() {
		return canhThu2;
	}

	public void setCanhThu2(double canhThu2){
		this.canhThu2 = canhThu2;
	}

	public double getCanhThu3() {
		return canhThu3;
	}

	public void setCanhThu3(double canhThu3) {
		this.canhThu3 = canhThu3;
	}

	@Override
	public double getDienTich() {

		return Math.sqrt(this.P*(this.P - this.canhThu1)*(this.P - this.canhThu2)*(this.P - this.canhThu3));
	}

	@Override
	public double getChuVi() {

		return this.canhThu1 + this.canhThu2 + this.canhThu3;
	}

}