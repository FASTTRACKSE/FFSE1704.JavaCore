package ffse.hinh2d.entity;

public class HinhChuNhat extends HinhHoc {

	private double chieuDai;
	private double chieuRong;

	public HinhChuNhat() {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public double tinhDienTich() {
		return this.chieuDai * this.chieuRong;

	}

	@Override
	public double tinhChuVi() {
		return this.chieuDai + this.chieuRong * 2;

	}

	public double getChieudai() {
		return chieuDai;
	}

	public void setChieudai(double chieudai) {
		this.chieuDai = chieudai;
	}

	public double getChieurong() {
		return chieuRong;
	}

	public void setChieurong(double chieurong) {
		this.chieuRong = chieurong;
	}

}
