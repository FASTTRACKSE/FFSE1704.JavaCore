package ffse1703012.assignment;

public class SinhVienWebCapToc extends SinhVien {
	private double diemLP2;
	private double diemLP3;
	
	public SinhVienWebCapToc(String hoSV, String tenSV, int ngaySinh, String diaChi, double diemLP2, double diemLP3) {
		super(hoSV, tenSV, ngaySinh, diaChi);
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
	
	public double tinhDTB() {
		return((this.diemLP2 + this.diemLP3) / 2);
	}
}
