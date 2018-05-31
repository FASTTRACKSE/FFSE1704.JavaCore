package fasttrackse.qlsv.entity;

public class SinhVien {
	private String tenSinhVien;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;	
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String tenSinhVien, int namSinh) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		
	}
	public SinhVien(String tenSinhVien, int namSinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		
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

	public int getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(int diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public int getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(int diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public int getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(int diemLP3) {
		this.diemLP3 = diemLP3;
	}
	
	public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3) * 1.0 / 3;
	}

	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + " - " + this.namSinh;
	}
}