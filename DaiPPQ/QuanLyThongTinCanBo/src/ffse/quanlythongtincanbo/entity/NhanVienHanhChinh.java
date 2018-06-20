/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.entity;


public class NhanVienHanhChinh extends NhanVien {
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	
	public NhanVienHanhChinh(String ten, String phongBan, String chucVu, int phuCap, int soNgayCong, double heSoLuong) {
		super(ten, phuCap, heSoLuong);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
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

	@Override
	public double tinhLuong() {
		double luong = getHeSoLuong()*750 + getPhuCap() + getSoNgayCong()*30;
		return luong;
	}
}
