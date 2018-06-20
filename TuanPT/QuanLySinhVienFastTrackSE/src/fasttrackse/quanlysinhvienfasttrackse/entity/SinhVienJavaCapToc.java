package fasttrackse.quanlysinhvienfasttrackse.entity;

public abstract class SinhVienJavaCapToc extends SinhVien {
	private int diemLP4;
	private int diemLP5;
	
	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, int diemLP4, int diemLP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
	}
	

	public int getDiemLP4() {
		return diemLP4;
	}


	public void setDiemLP4(int diemLP4) {
		this.diemLP4 = diemLP4;
	}


	public int getDiemLP5() {
		return diemLP5;
	}


	public void setDiemLP5(int diemLP5) {
		this.diemLP5 = diemLP5;
	}


	@Override
	public double tinhDTB() {
		return (diemLP4 + diemLP5)/2;

	}

}
