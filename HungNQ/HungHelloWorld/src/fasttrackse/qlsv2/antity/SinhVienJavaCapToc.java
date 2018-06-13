package fasttrackse.qlsv2.antity;

public class SinhVienJavaCapToc extends SinhVien {
	private int lp4;
	private int lp5;

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, int lp4, int lp5) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.lp4 = lp4;
		this.lp5 = lp5;
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

	@Override
	public double tinhTB() {
		return (lp4 + lp5) / 2;
	}

	public String hocLuc() {
		if (tinhTB() <= 5) {
			return "Yếu";

		} else if (tinhTB() < 6.5) {
			return "Trung bình";

		} else if (tinhTB() < 8.5) {
			return "Khá";

		} else {
			return "Giỏi";

		}
	}
}
