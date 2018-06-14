package fasttrackse.hinh2d.entity;

public class HinhTron extends HinhHoc2D {
	private double  banKinh;
	final private double  PI=3.14;

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}



	public HinhTron(double banKinh) {
		// TODO Auto-generated constructor stub
		this.banKinh = banKinh;
	}

	@Override
	public double tinhDienTich() {
		// TODO Auto-generated method stub
		return PI*banKinh*banKinh;
	}

	@Override
	public double tinhChuVi() {
		// TODO Auto-generated method stub
		return PI* banKinh*2;
	}

}
