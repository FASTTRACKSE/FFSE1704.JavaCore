package fasttrackse.hinhhoc.entity;

public class HinhChuNhat extends HinhHoc2D {
	private double chieuDai;
	private double chieuRong;
	public HinhChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		
	}
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return chieuDai+chieuRong;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return chieuDai*chieuRong;
	}

}
