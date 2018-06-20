package fasttrackse.hinhhoc.entity;

public class HinhVuong extends HinhHoc2D {
	private double canh;
	public HinhVuong(double canh) {
		this.canh = canh;
	}
	public double getCanh() {
		return canh;
	}
	public void setCanh(double canh) {
		this.canh = canh;
	}
	public HinhVuong() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return canh*4;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return canh*canh;
	}

}
