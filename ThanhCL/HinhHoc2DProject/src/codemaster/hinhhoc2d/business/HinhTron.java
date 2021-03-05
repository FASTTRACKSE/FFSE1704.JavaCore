package codemaster.hinhhoc2d.business;

public class HinhTron extends Hinh2D {
	private double banKinh;
	private final double PI = 3.14;

	/**
	 * @return the banKinh
	 */
	public double getBanKinh() {
		return banKinh;
	}

	/**
	 * @param banKinh the banKinh to set
	 */
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	
	

	public HinhTron(double banKinh) {
		super();
		this.banKinh = banKinh;
	}

	public HinhTron() {
		//
	}

	public HinhTron(int id, String loai, double banKinh) {
		super(id, loai);
		this.banKinh = banKinh;
	}

	@Override
	public double tinhChuVi() {
		return 2*PI*banKinh;
	}

	@Override
	public double tinhDienTich() {
		return PI*banKinh*banKinh;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBan Kinh:\t" + banKinh +
				"\nChu vi:\t" + tinhChuVi() + "\nDien tich:\t" + tinhDienTich();
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + banKinh + "\t" + tinhChuVi() + "\t" + tinhDienTich();
	}
	
}
