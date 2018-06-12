package fasttrackse.hinh2d.entity;

public class HinhChuNhat extends HinhHoc2D {
	private double chieuDai; 
	private double chieuRong;
	

	public HinhChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public double tinhDienTich() {
		return this.chieuDai * this.chieuRong;
	}

	@Override
	public double tinhChuVi() {
		return (this.chieuDai + this.chieuRong) * 2;
	}

	/**
	 * @return the chieuDai
	 */
	public double getChieuDai() {
		return chieuDai;
	}

	/**
	 * @param chieuDai the chieuDai to set
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
	 * @param chieuRong the chieuRong to set
	 */
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

}
