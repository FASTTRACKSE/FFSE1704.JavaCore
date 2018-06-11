package fasttrackse.javacore.qlsv;

public class SinhVien {
	private String tenSinhVien;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	private String xepLoai;
	private String gioiTinh;

	public SinhVien(String tenSinhVien, String gioiTinh, int namSinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		this.gioiTinh = gioiTinh;

	}

	public String getgioiTinh() {
		return gioiTinh;
	}

	public void setgioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
		return   this.tenSinhVien+"             " +this.namSinh ;
	}

	public String xepLoai(){
	 String ketQua;

		if (tinhDiemTrungBinhMon() < 5) {
			ketQua = "Yếu";

		} else if (tinhDiemTrungBinhMon() <= 7) {
			ketQua= "Trung bình";

		} else if (tinhDiemTrungBinhMon() <8.5) {
			ketQua= "khá";

		} else {
			ketQua = "Giỏi";

		}
		return ketQua;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

}
