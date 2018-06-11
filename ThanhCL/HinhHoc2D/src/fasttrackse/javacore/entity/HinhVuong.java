package fasttrackse.javacore.entity;

public class HinhVuong extends Hinh {
	double canh;
	
	public HinhVuong(double canh) {
		this.canh = canh;
	}
	
	public double getCanh() {
		return canh;
	}

	public void setCanh(double canh) {
		this.canh = canh;
	}

	@Override
	public double tinhDienTich() {
		return canh*canh;
	}

	@Override
	public double tinhChuVi() {
		return canh*4;
	}

}
