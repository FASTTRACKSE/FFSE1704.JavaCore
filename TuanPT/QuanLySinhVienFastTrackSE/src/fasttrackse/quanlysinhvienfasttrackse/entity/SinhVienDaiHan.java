package fasttrackse.quanlysinhvienfasttrackse.entity;

public abstract class SinhVienDaiHan extends SinhVien {
	private int diemLP0;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	private int diemLP4;
	private int diemLP5;
	private int diemLP6;

	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh, String diaChi, int diemLP0, int diemLP1, int diemLP2,
			int diemLP3, int diemLP4, int diemLP5, int diemLP6) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP0 = diemLP0;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
		this.diemLP6 = diemLP6;
	}
	

	public int getDiemLP0() {
		return diemLP0;
	}


	public void setDiemLP0(int diemLP0) {
		this.diemLP0 = diemLP0;
	}


	public int getDiemLP1() {
		return diemLP1;
	}


	public void setDiemLP1(int diemLP1) {
		this.diemLP1 = diemLP1;
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


	public int getDiemLP6() {
		return diemLP6;
	}


	public void setDiemLP6(int diemLP6) {
		this.diemLP6 = diemLP6;
	}




	@Override
	public double tinhDTB() {
		return (diemLP0 + diemLP1 + diemLP2 + diemLP3 + diemLP4 + diemLP5 + diemLP6)/7;
	}

}
