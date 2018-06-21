package ffse.quanlisinhvien.enity;

public class SinhVienJavaCapToc extends SinhVien {
	private int LP4;
	private int LP5;
	public SinhVienJavaCapToc(String hoTen, int namSinh, String diaChi,int lP4,int lP5) {
		super(hoTen, namSinh, diaChi);
		LP4 = lP4;
		LP5 = lP5;
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


	@Override
	public double tinhDiemTb() {
		return (LP4+LP5)/2;
	}


}
