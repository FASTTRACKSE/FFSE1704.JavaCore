package ffse.quanlithongtin.enity;

public abstract class ThongTin {
	private String hoTen;

	public ThongTin() {
	}

	public ThongTin(String hoTen) {
		this.hoTen = hoTen;
	}

	public String gethoTen() {
		return hoTen;
	}

	public void sethoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public abstract double tinhLuong();

}
