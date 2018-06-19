/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.entity;


public class NhanVienHanhChinh extends NhanVien {

	private String tenNV;
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	private double heSoLuong;
	
	public NhanVienHanhChinh(String tenNV, String phongBan, String chucVu, int soNgayCong, double heSoLuong2) {
		this.tenNV = tenNV;
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.heSoLuong = heSoLuong2;
		
	}
	
	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
		
		if("Trưởng phòng".equals(getChucVu())) {
			luong = (this.heSoLuong * 730) + 2000 + (this.soNgayCong * 30);
		}else {
			if("Phó phòng".equals(getChucVu())) {
				luong = (this.heSoLuong * 730) + 1000 + (this.soNgayCong * 30);
			}else {
				if("Nhân Viên".equals(getChucVu())) {
					luong = (this.heSoLuong * 730) + 500 + (this.soNgayCong * 30);
				}
			}
		}
		
		return luong;
	}
}
