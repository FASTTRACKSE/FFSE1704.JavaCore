package ffse.quanlysinhvien.entity;

import java.util.Comparator;

public abstract class SinhVien{
	private String hoSV;
	private String tenSV;
	private int namSinh;
	private String diaChi;

	// ArrayList<SinhVienDaiHan> dsSVDaiHan;
	public SinhVien(String hoSV, String tenSV, int namSinh, String diaChi) {
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}

	public String getHoSV() {
		return hoSV;
	}

	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public abstract double tinhDTB();


	
	

}
