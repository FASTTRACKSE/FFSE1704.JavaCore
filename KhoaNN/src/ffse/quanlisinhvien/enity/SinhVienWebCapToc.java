package ffse.quanlisinhvien.enity;

public class SinhVienWebCapToc extends SinhVien {
	private int LP2;
	private int LP3;
	public SinhVienWebCapToc(String hoTen, int namSinh, String diaChi, int lP2, int lP3) {
		super(hoTen, namSinh, diaChi);
		LP2 = lP2;
		LP3 = lP3;
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
	@Override
	public double tinhDiemTb() {
		return (LP2+LP3)/2;
	}

}