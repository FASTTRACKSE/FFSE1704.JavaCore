package fasttrackse.qlsv.entity;

public class DiemMonHoc {
	private MonHoc monHoc;
	private double diemThi;
	
	public DiemMonHoc() {
		//
	}
	
	public DiemMonHoc(MonHoc monHoc, double diem) {
		this.monHoc = monHoc;
		this.diemThi = diem;		
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public double getDiemThi() {
		return diemThi;
	}
	
	public void setDiemThi(double diemThi) {
		this.diemThi = diemThi;
	}
}
