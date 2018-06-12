package javacore.hinhhoc.entity;

public class HinhTron extends HinhHoc2D {
	private int banKinh;
	final private double P=3.14;
	public HinhTron(int banKinh) {
		// TODO Auto-generated constructor stub
		this.banKinh=banKinh;
	}
	public int getBanKinh() {
		return banKinh;
	}
	@Override
	public double ChuVi() {
		// TODO Auto-generated method stub

		return (banKinh*2*P);
	}
	@Override
	public double DienTich() {
		// TODO Auto-generated method stub
		return (Math.sqrt(banKinh)*P);
	}

}
