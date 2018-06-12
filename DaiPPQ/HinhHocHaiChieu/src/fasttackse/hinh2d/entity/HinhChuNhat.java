/**
 * 
 */
package fasttackse.hinh2d.entity;

/**
 * @author Support
 *
 */
public class HinhChuNhat extends Hinh2D {
	private double chieuDai;
	private double chieuRong;

	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public double getDienTich() {

		return this.chieuDai * this.chieuRong;
	}

	@Override
	public double getChuVi() {

		return (this.chieuDai + this.chieuRong) * 2;
	}

}