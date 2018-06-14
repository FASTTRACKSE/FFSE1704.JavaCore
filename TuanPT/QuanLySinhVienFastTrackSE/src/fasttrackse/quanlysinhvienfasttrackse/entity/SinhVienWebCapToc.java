package fasttrackse.quanlysinhvienfasttrackse.entity;

public abstract class SinhVienWebCapToc extends SinhVien {
	private int diemLP2;
	private int diemLP3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, int diemLP2, int diemLP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	public int getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(int diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public int getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(int diemLP3) {
		this.diemLP3 = diemLP3;
	}

	@Override
	public double tinhDTB() {
		return (diemLP2 + diemLP3)/2;

	}

}
