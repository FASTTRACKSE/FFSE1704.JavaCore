package ffse1703012.entity;

public class PhanMon {
	private String maLop, maMon;
	public PhanMon() {
		 //
	 }
	 
	public PhanMon(String maLop, String maMon) {
		 this.maLop = maLop;
		 this.maMon = maMon;
	 }

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	@Override
	public String toString() {
		return this.maMon;
	}
}
