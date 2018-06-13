/**
 * 
 */
package javacore.fasttrackse.entity;

/**
 * @author GOS ThanhRTCD
 *
 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.javacore.entity.SinhVien#tinhDTB()
	 */
	@Override
	public double tinhDTB() {
		// TODO Auto-generated method stub
		return (LP0 + LP1 + LP2 + LP3 + LP4 + LP5 + LP6) * 1.0 / 6;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.javacore.entity.SinhVien#xepLoaiSV()
	 */
	@Override
	public String xepLoaiSV() {
		String ketQuaXepLoai = "";
		if (tinhDTB() > 8.5) {
			ketQuaXepLoai = "Gi?i";
		} else if (tinhDTB() < 8.5) {
			ketQuaXepLoai = "Khá";
		} else if (tinhDTB() < 6.5) {
			ketQuaXepLoai = "Trung Bình";
		} else if (tinhDTB() < 5) {
			ketQuaXepLoai = "Y?u";
		}
		return ketQuaXepLoai;
	}

}
