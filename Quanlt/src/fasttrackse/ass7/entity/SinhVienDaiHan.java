package fasttrackse.ass7.entity;

public class SinhVienDaiHan extends SinhVien {
	private int lp0;
	private int lp1;
	private int lp2;
	private int lp3;
	private int lp4;
	private int lp5;
	private int lp6;
	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh, String diaChi, int lp0, int lp1, int lp2, int lp3, int lp4, int lp5, int lp6) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.lp0= lp0;
		this.lp1=lp1;
		this.lp2=lp2;
		this.lp3=lp3;
		this.lp4=lp4;
		this.lp5=lp5;
		this.lp6=lp6;
	}


	public int getLp0() {
		return lp0;
	}

	public void setLp0(int lp0) {
		this.lp0 = lp0;
	}

	public int getLp1() {
		return lp1;
	}

	public void setLp1(int lp1) {
		this.lp1 = lp1;
	}

	public int getLp2() {
		return lp2;
	}

	public void setLp2(int lp2) {
		this.lp2 = lp2;
	}

	public int getLp3() {
		return lp3;
	}

	public void setLp3(int lp3) {
		this.lp3 = lp3;
	}

	public int getLp4() {
		return lp4;
	}

	public void setLp4(int lp4) {
		this.lp4 = lp4;
	}

	public int getLp5() {
		return lp5;
	}

	public void setLp5(int lp5) {
		this.lp5 = lp5;
	}

	public int getLp6() {
		return lp6;
	}

	public void setLp6(int lp6) {
		this.lp6 = lp6;
	}

	@Override
	public double tinhTB() {
		return (lp0+lp1+lp2+lp3+lp4+lp5+lp6)/7;
	}
	public String hocLuc() {
		if (tinhTB() <= 5) {
			return "Yếu";
			
		} else if (tinhTB()<6.5) {
			return "Trung bình";
			
		} else if (tinhTB()<8.5) {
			return "Khá";
			
		} else {
			return "Giỏi";
			
		}
		
	}
}
