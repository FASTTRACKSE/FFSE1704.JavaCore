package quanlysinhvien.java;

public class SinhVienDaiHan extends SinhVien {

	private double diemLP0;
	private double diemLP1;
	private double diemLP2;
	private double diemLP3;
	private double diemLP4;
	private double diemLP5;
	private double diemLP6;

	public SinhVienDaiHan(String hoSinhVien, String tenSinhVien, int namSinh, String diaChi, double diemLP0,
			double diemLP1, double diemLP2, double diemLP3, double diemLP4, double diemLP5, double diemLP6) {
		super(hoSinhVien, tenSinhVien, namSinh, diaChi);
		this.diemLP0 = diemLP0;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
		this.diemLP6 = diemLP6;

	}

	public double getDiemLP0() {
		return diemLP0;
	}

	public void setDiemLP0(double diemLP0) {
		this.diemLP0 = diemLP0;
	}

	public double getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(double diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public double getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(double diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public double getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(double diemLP3) {
		this.diemLP3 = diemLP3;
	}

	public double getDiemLP4() {
		return diemLP4;
	}

	public void setDiemLP4(double diemLP4) {
		this.diemLP4 = diemLP4;
	}

	public double getDiemLP5() {
		return diemLP5;
	}

	public void setDiemLP5(double diemLP5) {
		this.diemLP5 = diemLP5;
	}

	public double getDiemLP6() {
		return diemLP6;
	}

	public void setDiemLP6(double diemLP6) {
		this.diemLP6 = diemLP6;
	}

	@Override
	public double tinhDiemTrungBinh() {

		return (this.diemLP0 +this.diemLP1 + this.diemLP2 + this.diemLP3 +this.diemLP4 +this.diemLP5+ this.diemLP6)/7;
	}

	@Override
	public String xepLoai() {
		String ketqua;
		if (tinhDiemTrungBinh() <= 5) {
			ketqua = "yếu";
		} else if (tinhDiemTrungBinh() <= 6.5) {
			ketqua = "trung bình";
		} else if (tinhDiemTrungBinh() <= 8.5) {
			ketqua = "khá";

		} else {
			ketqua = "giỏi";
		}
		return ketqua;
	}
}
