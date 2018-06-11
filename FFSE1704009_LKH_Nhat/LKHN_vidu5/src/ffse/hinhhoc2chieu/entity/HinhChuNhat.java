/**
 * 
 */
package ffse.hinhhoc2chieu.entity;

/**
 * @author Support
 *
 */
public class HinhChuNhat extends HinhHoc2Chieu {
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

	public HinhChuNhat(double chieuDai,double chieuRong) {
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

}
