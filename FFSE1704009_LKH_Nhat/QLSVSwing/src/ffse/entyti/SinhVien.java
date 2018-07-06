package ffse.entyti;

public class SinhVien {
	private String tenSinhVien;
	private String lopSinhVien;
	private int tuoiSinhVien;
	

	public SinhVien(String tenSinhVien, String lopSinhVien, int tuoiSinhVien) {
		this.tenSinhVien = tenSinhVien;
		this.setLopSinhVien(lopSinhVien);
		this.setTuoiSinhVien(tuoiSinhVien);
		
	}

	public String getSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getLopSinhVien() {
		return lopSinhVien;
	}

	public void setLopSinhVien(String lopSinhVien) {
		this.lopSinhVien = lopSinhVien;
	}

	public int getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(int tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	
}
