package codemaster.hinhhoc2d.business;

public class HinhTamGiac extends Hinh2D {
	private double canhA;
	private double canhB;
	private double canhC;

	/**
	 * @return the canhA
	 */
	public double getCanhA() {
		return canhA;
	}

	/**
	 * @param canhA
	 *            the canhA to set
	 */
	public void setCanhA(double canhA) {
		this.canhA = canhA;
	}

	/**
	 * @return the canhB
	 */
	public double getCanhB() {
		return canhB;
	}

	/**
	 * @param canhB
	 *            the canhB to set
	 */
	public void setCanhB(double canhB) {
		this.canhB = canhB;
	}

	/**
	 * @return the canhC
	 */
	public double getCanhC() {
		return canhC;
	}

	/**
	 * @param canhC
	 *            the canhC to set
	 */
	public void setCanhC(double canhC) {
		this.canhC = canhC;
	}

	public HinhTamGiac() {
		//
	}

	public HinhTamGiac(int id, String loai, double canhA, double canhB, double canhC) {
		super(id, loai);
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}

	@Override
	public double tinhChuVi() {
		return (canhA + canhB + canhC);
	}

	@Override
	public double tinhDienTich() {
		double p = (canhA + canhB + canhC) / 2;
		return Math.sqrt((p) * (p - canhA) * (p - canhB) * (p - canhC));
	}

	@Override
	public String toString() {
		return super.toString() + "\nCanh A:\t" + canhA + "\nCanh B:\t" + canhB + "\nCanh C:\t" + canhC +
				"\nChu vi:\t" + tinhChuVi() + "\nDien tich:\t" + tinhDienTich();
	}

	@Override
	public String getInfo() {
		return super.getInfo() + canhA + "\t" + canhB + "\t" + canhC + "\t" + tinhChuVi() + "\t" + tinhDienTich();
	}
	

}
