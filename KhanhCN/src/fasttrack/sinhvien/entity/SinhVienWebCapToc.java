package fasttrack.sinhvien.entity;

public class SinhVienWebCapToc extends SinhVien {

	private double LP2;
	private double LP3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double lP2, double lP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		LP2 = lP2;
		LP3 = lP3;
	}

	public double getLP2() {
		return LP2;
	}

	public void setLP2(double lP2) {
		LP2 = lP2;
	}

	public double getLP3() {
		return LP3;
	}

	public void setLP3(double lP3) {
		LP3 = lP3;
	}

	@Override
	public double tinhDTB() {

		return (LP2 + LP3) / 2;
	}

	@Override
	public String xepLoaiSV() {
		String ketQua = " ";

		if (tinhDTB() > 8.5) {
			ketQua = "GIỎI";
		} else if (tinhDTB() >= 7 && tinhDTB() <= 8.5) {
			ketQua = "KHÁ";
		} else if (tinhDTB() >= 5 && tinhDTB() < 7) {
			ketQua = "TBÌNH";
		} else if (tinhDTB() < 5) {
			ketQua = "YẾU";

		}
		return ketQua;
		
	}

	public String toString() {
		return this.getHoSV() + "\t   " + this.getTenSV() + "\t    " + this.getNamSinh() + "\t  " + this.getDiaChi()
				+ "\t  " + this.LP2 + "\t   " + this.LP3 + "\t   " + tinhDTB();
	}

}
