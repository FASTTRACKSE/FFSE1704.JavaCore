package nhanvien;

import canbo.CanBo;

public class NhanVien extends CanBo {
	private String phongban;
	private String chucvu;
	private int songaycong;
	private double hetsoluong;
	
	public NhanVien(String tenCanBo, String phongban, String chucvu, int songaycong, double hesoluong) {
		super(tenCanBo);
		// this.tenNV = tenNV;
		this.phongban = phongban;
		this.chucvu = chucvu;
		this.songaycong = songaycong;
		this.hetsoluong = hesoluong;
	}
	
	public String getPhongBan() {
		return phongban;
	}

	public void setPhongBan(String phongBan) {
		this.phongban = phongBan;
	}

	public String getChucVu() {
		return chucvu;
	}

	public void setChucVu(String chucVu) {
		this.chucvu = chucVu;
	}

	public int getSoNgayCong() {
		return songaycong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.songaycong = soNgayCong;
	}

	public double getHeSoLuong() {
		return hetsoluong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.hetsoluong = heSoLuong;
	}
	
	@Override
	public double tinhLuong() {
		double luong = 0;
		
		if("trưởng phòng".equals(getChucVu())) {
			luong = (this.hetsoluong * 730) + 2000 + (this.songaycong * 30);
		}else {
			if("phó phòng".equals(getChucVu())) {
				luong = (this.hetsoluong * 730) + 1000 + (this.songaycong * 30);
			}else {
				if("nhân viên".equals(getChucVu())) {
					luong = (this.hetsoluong * 730) + 500 + (this.songaycong * 30);
				}
			}
		}
		return luong;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
