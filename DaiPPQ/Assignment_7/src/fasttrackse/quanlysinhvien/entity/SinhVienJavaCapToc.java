/**
 *	Prog: QUẢN LÝ SINH VIÊN
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 11/06/2018
 */
package fasttrackse.quanlysinhvien.entity;

/**
 * @author QuangDai
 *
 */
public class SinhVienJavaCapToc extends SinhVien {
	
	private double diemLP4;
	private double diemLP5;

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP4, double diemLP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
	}

	public double getDiemLP4() {
		return diemLP4;
	}

	public void setDiemLP4(double diemLP4) {
		this.diemLP4 = diemLP4;
	}

	public double getDiemLP5() {
		return diemLP5;
	}

	public void setDiemLP5(double diemLP5) {
		this.diemLP5 = diemLP5;
	}

	@Override
	public double tinhDTB() {
		return (this.diemLP4 + this.diemLP5)/2;
	}
}