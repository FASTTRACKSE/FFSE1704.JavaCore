/************************
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 25/06/2018
 **********************/

package fasttrackse.quanlycanbo.entity;

import java.io.Serializable;

public class NhanVien extends CanBo implements Serializable{
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	private double heSoLuong;

	public NhanVien(String tenCanBo, String phongBan, String chucVu, int soNgayCong, double heSoLuong) {
		super(tenCanBo);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.heSoLuong = heSoLuong;

	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public double tinhLuong() {
		double luong = 0;

		if ("Trưởng phòng".equals(getChucVu())) {
			luong = (this.heSoLuong * 730) + 2000 + (this.soNgayCong * 30);
		} else {
			if ("Phó phòng".equals(getChucVu())) {
				luong = (this.heSoLuong * 730) + 1000 + (this.soNgayCong * 30);
			} else {
				if ("Nhân viên".equals(getChucVu())) {
					luong = (this.heSoLuong * 730) + 500 + (this.soNgayCong * 30);
				}
			}
		}

		return luong;
	}

}