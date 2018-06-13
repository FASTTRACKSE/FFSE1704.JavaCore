/**
 * 
 */
package javacore.fasttrackse.entity;

/**
 * @author GOS ThanhRTCD
 *
 */
public class SinhVienJavaCapToc extends SinhVien {

	private double LP4;
	private double LP5;

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

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double lP4, double lP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		LP4 = lP4;
		LP5 = lP5;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.javacore.entity.SinhVien#tinhDTB()
	 */
	@Override
	public double tinhDTB() {

		return (LP4 + LP5) * 1.0 / 2;
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
