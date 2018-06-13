package fasttrack.sinhvien.entity;

public class SinhVienDaiHan extends SinhVien {
	private double LP0;
	private double LP1;
	private double LP2;
	private double LP3;
	private double LP4;
	private double LP5;
	private double LP6;
	
	
	
	
	
	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh, String diaChi, double lP0, double lP1, double lP2,
			double lP3, double lP4, double lP5, double lP6) {
		super(hoSV, tenSV, namSinh, diaChi);
		LP0 = lP0;
		LP1 = lP1;
		LP2 = lP2;
		LP3 = lP3;
		LP4 = lP4;
		LP5 = lP5;
		LP6 = lP6;
	}

	public double getLP0() {
		return LP0;
	}

	public void setLP0(double lP0) {
		LP0 = lP0;
	}

	public double getLP1() {
		return LP1;
	}

	public void setLP1(double lP1) {
		LP1 = lP1;
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

	public double getLP6() {
		return LP6;
	}

	public void setLP6(double lP6) {
		LP6 = lP6;
	}

	

	@Override
	public double tinhDTB() {
		
		return (LP1+LP2+LP3+LP4+LP5+LP6)/6;
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
		return this.getHoSV()+ "\t   "  + this.getTenSV() +"\t    " + this.getNamSinh() +"\t" + this.getDiaChi() + "\t "  + this.LP0 + "\t " + this.LP1 + "\t   " + this.LP2 + "\t   " + this.LP3
				+ "\t    " + this.LP4 + "\t     " + this.LP5 + "\t" + this.LP6 + "\t  "+ tinhDTB();
	}

}
