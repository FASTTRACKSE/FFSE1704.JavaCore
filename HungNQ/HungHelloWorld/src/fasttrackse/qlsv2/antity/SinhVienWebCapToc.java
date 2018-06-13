package fasttrackse.qlsv2.antity;

public class SinhVienWebCapToc extends SinhVien {
	private int lp2;
	private int lp3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, int lp2, int lp3) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.lp2 = lp2;
		this.lp3 = lp3;
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

	@Override
	public double tinhTB() {
		return (lp2 + lp3) / 2;
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
