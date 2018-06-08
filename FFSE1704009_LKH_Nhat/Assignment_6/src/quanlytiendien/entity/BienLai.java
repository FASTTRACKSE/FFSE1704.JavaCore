/************************
 *Prop: QUẢN LÝ TIỀN ĐIỆN
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 4/06/2018
 **********************/
package quanlytiendien.entity;

import java.util.Scanner;

public class BienLai {
	protected String maCongTo;
	protected int ckThang;
	protected int ckNam;
	protected int csDauKy;
	protected int csCuoiKy;
	
	public BienLai(String maCongTo, int ckThang, int ckNam, int csDauKy, int csCuoiKy) {
		this.maCongTo = maCongTo;
		this.ckThang = ckThang;
		this.ckNam = ckNam;
		this.csDauKy = csDauKy;
		this.csCuoiKy = csCuoiKy;	
	}

	/**
	 * @return the maCongTo
	 */
	public String getMaCongTo() {
		return maCongTo;
	}

	/**
	 * @param maCongTo the maCongTo to set
	 */
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	/**
	 * @return the ckThang
	 */
	public int getCkThang() {
		return ckThang;
	}

	/**
	 * @param ckThang the ckThang to set
	 */
	public void setCkThang(int ckThang) {
		this.ckThang = ckThang;
	}

	/**
	 * @return the ckNam
	 */
	public int getCkNam() {
		return ckNam;
	}

	/**
	 * @param ckNam the ckNam to set
	 */
	public void setCkNam(int ckNam) {
		this.ckNam = ckNam;
	}

	/**
	 * @return the csDauKy
	 */
	public int getCsDauKy() {
		return csDauKy;
	}

	/**
	 * @param csDauKy the csDauKy to set
	 */
	public void setCsDauKy(int csDauKy) {
		this.csDauKy = csDauKy;
	}

	/**
	 * @return the csCuoiKy
	 */
	public int getCsCuoiKy() {
		return csCuoiKy;
	}

	/**
	 * @param csCuoiKy the csCuoiKy to set
	 */
	public void setCsCuoiKy(int csCuoiKy) {
		this.csCuoiKy = csCuoiKy;
	}
	
	public long tinhTienTrongKy() {
		return (this.csCuoiKy - this.csDauKy) * 3000;
	}
	
}