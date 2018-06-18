/**
 * 
 */
package javacore.fasttrackse.entity;

/**
 * @author GOS ThanhRTCD
 *
 */
public class SinhVienWebCapToc extends SinhVien {
	private double LP2;
	private double LP3;

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

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double lP2, double lP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		LP2 = lP2;
		LP3 = lP3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.javacore.entity.SinhVien#tinhDTB()
	 */
	@Override
	public double tinhDTB() {

		return (LP2 + LP3) * 1.0 / 2;
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
