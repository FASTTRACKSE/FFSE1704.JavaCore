package quanlycanbo.entity;

public class NhanVien extends CanBo {
		private String phongBan;
		private int soNgayCong;
		private String chucVu;
	public NhanVien(String hoTen, double heSoLuong,String phongBan,
			int soNgayCong,String chucVu) {
		super(hoTen, heSoLuong);
		this.phongBan=phongBan;
		this.soNgayCong=soNgayCong;
		this.chucVu=chucVu;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double tinhLuong() {
		
		double tinhLuong=0;
		if("Trưởng phòng".equals(getChucVu())) {
			return (this.heSoLuong * 730) + (300) + (this.soNgayCong * 30);
		}else if("Phó phòng".equals(getChucVu())) {
			return (this.heSoLuong * 730) +(500) + (this.soNgayCong * 30);
		}else if("Nhân viên".equals(getChucVu())) {
			return (this.heSoLuong * 730) + (1000) + (this.soNgayCong * 30);
		}
		
		return tinhLuong;

	}

}
