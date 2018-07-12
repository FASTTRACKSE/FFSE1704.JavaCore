package entyti;

public class SinhVien {

	protected String masinhvien;
	protected String tensinhvien;
	protected String tuoi;
	protected String lop;

	public SinhVien(String masinhvien, String tensinhvien, String tuoi, String lop) {
		super();
		this.masinhvien = masinhvien;
		this.tensinhvien = tensinhvien;
		this.tuoi = tuoi;
		this.lop = lop;
	}

	public SinhVien(String masinhvien2, String tensinhvien2, String tuoisinhvien) {
		// TODO Auto-generated constructor stub
	}

	public String getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}

	public String getTensinhvien() {
		return tensinhvien;
	}

	public void setTensinhvien(String tensinhvien) {
		this.tensinhvien = tensinhvien;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}





}