package fasttrackse.bai3.study;

public class sinhVien {
	private String tenSinhVien;
	private String gioiTinh;
	private int tuoi;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;

	public sinhVien(String tenSinhVien, String gioiTinh, int tuoi, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	public String getSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh() {
		this.gioiTinh = gioiTinh;
	}

	public void settuoi(int tuoi) {
		this.tuoi = tuoi;
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
		return  Math.round((diemLP1 + diemLP2 + diemLP3) / 3);
		
	}

	public String xepLoai() {
		
		if (tinhDiemTrungBinhMon() <= 5) {
			return "Yếu";
			
		} else if (tinhDiemTrungBinhMon() <= 7 && tinhDiemTrungBinhMon()>5) {
			return "Trung bình";
			
		} else if (tinhDiemTrungBinhMon() <= 8.5 && tinhDiemTrungBinhMon()>7) {
			return "Khá";
			
		} else {
			return "Giỏi";
			
		}
		

	}

	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + " \nGiới Tính: " + this.gioiTinh + "\nNăm Sinh "
				+ this.tuoi;
	}

}
