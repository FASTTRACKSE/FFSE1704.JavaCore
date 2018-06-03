package fasttrackse.qlsv.entity;

public class SinhVien {
	private String tenSinhVien;
	private int namSinh;
	private String gioiTinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	private double diemTrungBinh;

	public SinhVien(String tenSinhVien, int namSinh, String gioiTinh, int diemLP1, int diemLP2, int diemLP3) {
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

	public int getGioiTinh() {
		return namSinh;
	}

	public void getGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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

	public double tinhDiemTrungBinh() {

		return diemTrungBinh = Math.round((diemLP1 + diemLP2 + diemLP3) * 1.0 / 3);

	}

	// xếp loại
	public String xepLoaiSinhVien() {

		String ketQua = " ";

		if (diemTrungBinh > 8.5) {
			ketQua = "GIỎI";
		} else if (diemTrungBinh >= 7 && diemTrungBinh <= 8.5) {
			ketQua = "KHÁ";
		} else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
			ketQua = "TBÌNH";
		} else if (diemTrungBinh < 5) {
			ketQua = "YẾU";

		}
		return ketQua;

	}

	public String toString() {

		return "\t\t" + this.tenSinhVien + "\t\t" + this.namSinh + "\t  " + this.gioiTinh + "\t   " + this.diemLP1
				+ "\t    " + this.diemLP2 + "\t     " + this.diemLP3 + "\t     ";
	}
}
