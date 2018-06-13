package fasttrack.sinhvien.entity;

public class SinhVienJavaCapToc extends SinhVien {

	private double LP4;
	private double LP5;

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double lP4, double lP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		LP4 = lP4;
		LP5 = lP5;
	}

	public double getLP4() {
		return LP4;
	}

	public void setLP4(double lP4) {
		LP4 = lP4;
	}

	public double getLP5() {
		return LP5;
	}

	public void setLP5(double lP5) {
		LP5 = lP5;
	}

	@Override
	public double tinhDTB() {
		
		return (LP4 + LP5) / 2;
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
	
	public String toString(){
		return this.getHoSV()+ "\t   "  + this.getTenSV() +"\t    " + this.getNamSinh() +"\t    " + this.getDiaChi()+"\t    "  +  this.LP4 + "\t   " + this.LP5 + "\t  " + tinhDTB() ;
	}

	
	

}
