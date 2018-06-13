package ffse.hinh2d.entity;

public class HinhTron extends HinhHoc {

	private double pI = 3.14;
	public double banKinh;
	public double duongKinh;
 
	
	public HinhTron(double pI, double banKinh, double duongKinh) {
		super();
		pI = pI;
		this.banKinh = banKinh;
		this.duongKinh = duongKinh;
	}
	
	@Override
	public double tinhChuVi() {
		return this.duongKinh * this.pI;
		// TODO Auto-generated method stub

	}

	@Override
	public double tinhDienTich() {
		return Math.pow(banKinh,2)*pI;

	}

	public double getPI() {
		return pI;
	}

	public void setPI(double pI) {
		pI = pI;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getDuongKinh() {
		return duongKinh;
	}

	public void setDuongKinh(double duongKinh) {
		this.duongKinh = duongKinh;
	}

}
