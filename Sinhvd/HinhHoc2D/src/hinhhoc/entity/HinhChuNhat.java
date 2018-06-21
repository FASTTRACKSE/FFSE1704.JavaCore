package hinhhoc.entity;

public class HinhChuNhat extends HinhHoc {
	private double chieudai;
	private double chieurong;

	public HinhChuNhat(double chieudai, double chieurong) {
		this.chieudai = chieudai;
		this.chieurong = chieurong;
	}

	public double dientich() {
		return chieudai + chieurong;
	}

	public double chuvi() {

		return this.chieudai + this.chieurong * 2;
	}

	public void getChieudai(double chieudai) {
		this.chieudai = chieudai;
	}

	public void setChieudai(double chieudai) {
		this.chieudai = chieudai;
	}

	public double getChieurong() {
		return chieurong;
	}

	public void setChieurong(double chieurong) {
		this.chieurong = chieurong;
	}
}
