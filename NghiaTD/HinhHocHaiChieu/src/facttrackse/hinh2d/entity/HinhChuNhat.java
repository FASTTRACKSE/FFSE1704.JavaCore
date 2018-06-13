package facttrackse.hinh2d.entity;

public class HinhChuNhat extends HinhHoc2d {
	private double chieuDai;
	private double chieuRong;
	public HinhChuNhat(double chieuDai,double chieuRong) {
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
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

	@Override
	public double tinhDienTich() {
		// TODO Auto-generated method stub
		return this.chieuDai *this.chieuRong;
		
	}

	@Override
	public double tinhChuVi() {
		// TODO Auto-generated method stub
		return (this.chieuDai +this.chieuRong)*2;
	}

}
