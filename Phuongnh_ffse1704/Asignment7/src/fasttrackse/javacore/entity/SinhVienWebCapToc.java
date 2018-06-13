package fasttrackse.javacore.entity;

public class SinhVienWebCapToc extends SinhVien {
	private double diemLP2;
	private double diemLP3;

	public SinhVienWebCapToc(String hoDemSV, String tenSV, String diaChiSV, int namSinhSV, double diemLP2,
			double diemLP3) {
		super(hoDemSV, tenSV, diaChiSV, namSinhSV);
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	@Override
	public double tinhDTB() {

		return ((this.diemLP2 + this.diemLP3) / 2) * 1.0;
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

	// xếp loại sv
	public String xepLoaiSV() {
		String ketQua;

		if (tinhDTB() < 5) {

			ketQua = "Yếu";

		} else if (tinhDTB() < 6.5) {

			ketQua = "Trung Bình";

		} else if (tinhDTB() < 8.5) {

			ketQua = "Khá";

		} else {

			ketQua = "Giỏi";
		}

		return ketQua;
	}

	
	

}
