package fasttrackse.qlsv.entity;

import java.util.ArrayList;

public class SinhVien {
	private String hoSinhVien;
	private String tenSinhVien;
	private int namSinh;
	ArrayList<DiemMonHoc> diemThi = new ArrayList<DiemMonHoc>();
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String hoSinhVien, String tenSinhVien, int namSinh) {
		this.hoSinhVien = hoSinhVien;
		this.tenSinhVien = hoSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
	}
	
	public SinhVien(String hoSinhVien, String tenSinhVien, int namSinh, ArrayList<DiemMonHoc> diemThi) {
		this.hoSinhVien = hoSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemThi = diemThi;
	}

	public String getHoSinhVien() {
		return hoSinhVien;
	}

	public void setHoSinhVien(String hoSinhVien) {
		this.hoSinhVien = hoSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public ArrayList<DiemMonHoc> getDiemThi() {
		return this.diemThi;
	}
	
	public void setDiemThi(ArrayList<DiemMonHoc> diemThi) {
		this.diemThi = diemThi;
	}
	
	public double tinhDiemTrungBinhMon() {
		double tongDiem = 0;
		
		for (DiemMonHoc x : this.diemThi) {
			tongDiem += x.getDiemThi();
		}
		
		return tongDiem / this.diemThi.size();
	}

	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + " - " + this.namSinh;
	}
}