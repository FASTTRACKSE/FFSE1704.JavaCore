/************************
 *Prop: QUẢN LÝ TIỀN ĐIỆN
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 4/06/2018
 **********************/
package quanlytiendien.entity;

import java.util.ArrayList;

public class KhachHang implements Comparable<KhachHang> {
	protected String maKH;
	protected String tenKH;
	public String diaChiKH;
	ArrayList<BienLai> dsBienLai;

	public KhachHang(String maKH, String tenKH, String diaChiKH) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiKH = diaChiKH;
		dsBienLai = new ArrayList<BienLai>();
	}

	public String getKhachHang() {
		return tenKH;
	}

	public void setKhachHang(String tenKhachHang) {
		this.tenKH = tenKH;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return maKH;
	}

	/**
	 * @param maKH
	 *            the maKH to set
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}

	/**
	 * @param tenKH
	 *            the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	/**
	 * @return the diaChiKH
	 */
	public String getDiaChiKH() {
		return diaChiKH;
	}

	/**
	 * @param diaChiKH
	 *            the diaChiKH to set
	 */
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}

	/**
	 * @return the dsBienLai
	 */
	public ArrayList<BienLai> getDsBienLai() {
		return dsBienLai;
	}

	/**
	 * @param dsBienLai
	 *            the dsBienLai to set
	 */
	public void setDsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}

	public void addToDsBienLai(BienLai bienLai) {
		this.dsBienLai.add(bienLai);
	}

	@Override
	public int compareTo(KhachHang x) {
		if (this.diaChiKH.compareTo(x.diaChiKH) == 0) {
			return this.tenKH.compareTo(x.tenKH);
		} else {
			return this.diaChiKH.compareTo(x.diaChiKH);
		}
	}

}
