package entyti;

public class SinhVien {
	private String tensinhvien;
	
	private int tuoisinhvien;
	
	public SinhVien(String tensinhvien, int tuoisinhvien) {
		this.tensinhvien = tensinhvien;
	
		this.setTuoiSinhVien(tuoisinhvien);
	}
	
	public String getSinhVien() {
		return tensinhvien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tensinhvien = tenSinhVien;
	}


	public int getTuoiSinhVien() {
		return tuoisinhvien;
	}

	public void setTuoiSinhVien(int tuoiSinhVien) {
		this.tuoisinhvien = tuoiSinhVien;
	}
}
