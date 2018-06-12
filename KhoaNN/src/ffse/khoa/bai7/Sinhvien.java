package ffse.khoa.bai7;



public class Sinhvien {
	
	private String tenSinhVien;
	private int namSinh;
	private String gioiTinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;	
	
	public Sinhvien() {
		//
	}
	
	public Sinhvien(String tenSinhVien, int namSinh) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		
	}
	public Sinhvien(String tenSinhVien, int namSinh, String gioiTinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
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
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh=gioiTinh;
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
		return Math.round((diemLP1 + diemLP2 + diemLP3)/ 3);
	}

	public String toString() {
		return  this.tenSinhVien + " - " + " Năm Sinh : " + this.namSinh;
	}

	
	public String xepLoai() {
		if(tinhDiemTrungBinhMon()<5) {
			return "Yếu";
		}else if(tinhDiemTrungBinhMon()<6.5) {
			return "Trung Bình";
		}else if(tinhDiemTrungBinhMon()<7.5) {
			return "Khá";
		}else {
			return "Giỏi";
		}
		
	}

}
