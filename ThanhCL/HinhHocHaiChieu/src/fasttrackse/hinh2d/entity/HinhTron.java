/**
 * 
 */
package fasttrackse.hinh2d.entity;

/**
 * @author thanhcl
 *
 */
public class HinhTron extends HinhHoc2D {
	private double banKinh;
	final private double PI = 3.14;

	/**
	 * 
	 */
	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	/**
	 * @return the banKinh
	 */
	public double getBanKinh() {
		return banKinh;
	}

	/**
	 * @param banKinh the banKinh to set
	 */
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	/* 
	 * @see fasttrackse.hinh2d.entity.HinhHoc2D#tinhDienTich()
	 */
	@Override
	public double tinhDienTich() {
		return PI * banKinh * banKinh;
	}

	/* 
	 * @see fasttrackse.hinh2d.entity.HinhHoc2D#tinhChuVi()
	 */
	@Override
	public double tinhChuVi() {
		return PI * banKinh * 2;
	}

}
