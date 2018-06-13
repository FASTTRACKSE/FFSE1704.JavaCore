package ffse.quanlisinhvien.enity;



public class SinhVienDaiHan extends SinhVien {
	private int LP0;
	private int LP1;
	private int LP2;
	private int LP3;
	private int LP4;
	private int LP5;
	private int LP6;
	public SinhVienDaiHan(String hoTen, int namSinh, String diaChi, int lP0, int lP1, int lP2, int lP3, int lP4,
			int lP5, int lP6) {
		super(hoTen, namSinh, diaChi);
		LP0 = lP0;
		LP1 = lP1;
		LP2 = lP2;
		LP3 = lP3;
		LP4 = lP4;
		LP5 = lP5;
		LP6 = lP6;
	}

	public int getLP0() {
		return LP0;
	}

	public void setLP0(int lP0) {
		LP0 = lP0;
	}

	public int getLP1() {
		return LP1;
	}

	public void setLP1(int lP1) {
		LP1 = lP1;
	}

	public int getLP2() {
		return LP2;
	}

	public void setLP2(int lP2) {
		LP2 = lP2;
	}

	public int getLP3() {
		return LP3;
	}

	public void setLP3(int lP3) {
		LP3 = lP3;
	}

	public int getLP4() {
		return LP4;
	}

	public void setLP4(int lP4) {
		LP4 = lP4;
	}

	public int getLP5() {
		return LP5;
	}

	public void setLP5(int lP5) {
		LP5 = lP5;
	}

	public int getLP6() {
		return LP6;
	}

	public void setLP6(int lP6) {
		LP6 = lP6;
	}

	@Override
	public double tinhDiemTb() {
		return (LP1+LP2+LP3+LP4+LP5+LP6)/6;
	}

}