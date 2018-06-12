package ffse1703012.assignment;

public class BienLai {
	protected String maCongTo;
	protected int ckThang;
	protected int ckNam;
	protected int csDauKy;
	protected int csCuoiKy;
	public int setCkNam;
	public int setCsDauKy;
	public int setCsCuoiKy;
	
	public BienLai(String maCongTo, int ckThang, int ckNam, int csDauKy, int csCuoiKy) {
		this.maCongTo = maCongTo;
		this.ckThang = ckThang;
		this.ckNam = ckNam;
		this.csDauKy = csDauKy;
		this.csCuoiKy = csCuoiKy;	
	}

	public BienLai() {
	}

	
	public String getMaCongTo() {
		return maCongTo;
	}

	
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	
	public int getCkThang() {
		return ckThang;
	}

	public void setCkThang(int ckThang) {
		this.ckThang = ckThang;
	}


	public int getCkNam() {
		return ckNam;
	}


	public void setCkNam(int ckNam) {
		this.ckNam = ckNam;
	}

	
	public int getCsDauKy() {
		return csDauKy;
	}

	
	public void setCsDauKy(int csDauKy) {
		this.csDauKy = csDauKy;
	}


	public int getCsCuoiKy() {
		return csCuoiKy;
	}

	
	public void setCsCuoiKy(int csCuoiKy) {
		this.csCuoiKy = csCuoiKy;
	}
	public long tinhTienTrongKy() {
		return (this.csCuoiKy - this.csDauKy) * 3000;
	}
	

}
