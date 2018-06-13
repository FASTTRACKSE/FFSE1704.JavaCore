package facttrackse.hinh2d.entity;

public class HinhTron extends HinhHoc2d {
	private double banKinh;
	final private double PI = 3.14;
	
	public HinhTron(double banKinh) {
		this.banKinh=banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public double getPI() {
		return PI;
	}

	@Override
	public double tinhDienTich() {
		// TODO Auto-generated method stub
		
		return PI * banKinh *banKinh;
		
	}

	@Override
	public double tinhChuVi() {
		// TODO Auto-generated method stub
		return PI * banKinh *2;
	}

}
