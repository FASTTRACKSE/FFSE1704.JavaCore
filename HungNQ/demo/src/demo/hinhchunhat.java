package demo;

public class hinhchunhat {
	int cd;
	int cr;

	public hinhchunhat(int cd2, int cr2) {
		super();
		this.cd = cd2;
		this.cr = cr2;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getCr() {
		return cr;
	}
	public void setCr(int cr) {
		this.cr = cr;
	}
	
	public int tinhDienTich() {
		return cd*cr;
	}
	
	public void hienthiDT() {
		System.out.print("Dien tich la: "+ tinhDienTich());
	}
	@Override
	public String toString() {
		return "hinhchunhat [cd=" + cd + ", cr=" + cr + "]";
	}
	
	
}
