package demo;

public class hinh3DNhat extends hinhchunhat {
	int cc;
	public hinh3DNhat(int cd2, int cr2,int cc) {
		super(cd2, cr2);
		this.cc=cc;
		// TODO Auto-generated constructor stub
	}
	public int  tinhTT() {
		return this.tinhDienTich()*this.cc;
	}
}
