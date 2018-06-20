package ffse1703012.assignment;

public class SinhVienJavaCapToc extends SinhVien{
	private double diemLP4;
	private double diemLP5;
	
	public SinhVienJavaCapToc(String hoSV, String tenSV, int ngaySinh, String diaChi, double diemLP4, double diemLP5) {
		super(hoSV, tenSV, ngaySinh, diaChi);
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

	public double tinhDTB() {
		return((this.diemLP4 + this.diemLP5) / 2);
	}
}
