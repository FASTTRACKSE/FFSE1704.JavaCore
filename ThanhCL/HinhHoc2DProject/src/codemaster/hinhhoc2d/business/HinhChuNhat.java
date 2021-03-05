package codemaster.hinhhoc2d.business;

public class HinhChuNhat extends Hinh2D {
	private double chieuDai;
	private double chieuRong;

	/**
	 * @return the chieuDai
	 */
	public double getChieuDai() {
		return chieuDai;
	}

	/**
	 * @param chieuDai
	 *            the chieuDai to set
	 */
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	/**
	 * @return the chieuRong
	 */
	public double getChieuRong() {
		return chieuRong;
	}

	/**
	 * @param chieuRong
	 *            the chieuRong to set
	 */
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat() {
		//
	}

	public HinhChuNhat(int id, String loai, double chieuDai, double chieuRong) {
		super(id, loai);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public double tinhChuVi() {
		return (chieuDai + chieuRong) * 2;
	}

	@Override
	public double tinhDienTich() {
		return chieuDai * chieuRong;
	}

	@Override
	public String toString() {
		return super.toString() + "\nChieu Dai:\t" + chieuDai + "\nChieu Rong:\t" + chieuRong +
				"\nChu vi:\t" + tinhChuVi() + "\nDien tich:\t" + tinhDienTich();
	}

	@Override
	public String getInfo() {
		return super.getInfo() + chieuDai + "\t" + chieuRong + "\t" + tinhChuVi() + "\t" + tinhDienTich();
	}
	
}
