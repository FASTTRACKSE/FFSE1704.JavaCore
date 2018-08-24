package javaswing.tablesql.untity;

public class SinhVien {

	String ID;
	String HoSV;
	String TenSV;
	String GenderSV;
	String NamSinhSV;
	String ClassSV;

	public SinhVien(String iD, String hoSV, String tenSV, String genderSV, String namSinhSV, String classSV) {
		super();
		ID = iD;
		HoSV = hoSV;
		TenSV = tenSV;
		GenderSV = genderSV;
		NamSinhSV = namSinhSV;
		ClassSV = classSV;
	}

	public SinhVien(String hoSV, String tenSV, String genderSV, String namSinhSV, String classSV) {
		super();

		HoSV = hoSV;
		TenSV = tenSV;
		GenderSV = genderSV;
		NamSinhSV = namSinhSV;
		ClassSV = classSV;
	}

	public SinhVien(String iD, String hoSV, String tenSV, String namSinhSV) {
		ID = iD;
		HoSV = hoSV;
		TenSV = tenSV;
		NamSinhSV = namSinhSV;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHoSV() {
		return HoSV;
	}

	public void setHoSV(String hoSV) {
		HoSV = hoSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public String getGenderSV() {
		return GenderSV;
	}

	public void setGenderSV(String genderSV) {
		GenderSV = genderSV;
	}

	public String getNamSinhSV() {
		return NamSinhSV;
	}

	public void setNamSinhSV(String namSinhSV) {
		NamSinhSV = namSinhSV;
	}

	public String getClassSV() {
		return ClassSV;
	}

	public void setClassSV(String classSV) {
		ClassSV = classSV;
	}

}
