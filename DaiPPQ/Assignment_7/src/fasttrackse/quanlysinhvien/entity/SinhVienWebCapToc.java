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
public class SinhVienWebCapToc extends SinhVien {
	
	private double diemLP2;
	private double diemLP3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP2, double diemLP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	public double getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(double diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public double getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(double diemLP3) {
		this.diemLP3 = diemLP3;
	}

	@Override
	public double tinhDTB() {
		return (this.diemLP2 + this.diemLP3)/2;
	}
}