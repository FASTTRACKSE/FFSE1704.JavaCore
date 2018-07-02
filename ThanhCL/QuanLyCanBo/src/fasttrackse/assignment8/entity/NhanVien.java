package fasttrackse.assignment8.entity;

public class NhanVien extends CanBo {
	private String phongBan;	
	private String chucVu;
	private int soNgayCong;
	
	public NhanVien(String tenCB, long phuCap, double hsLuong, String phongBan, String chucVu, int soNgayCong) {
		super(tenCB, phuCap, hsLuong);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	@Override
	public double tinhLuong() {
		return hsLuong * 730 + phuCap + soNgayCong * 30;
	}

	/**
	 * @return the phongBan
	 */
	public String getPhongBan() {
		return phongBan;
	}

	/**
	 * @param phongBan the phongBan to set
	 */
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	/**
	 * @return the chucVu
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @param chucVu the chucVu to set
	 */
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	/**
	 * @return the soNgayCong
	 */
	public int getSoNgayCong() {
		return soNgayCong;
	}

	/**
	 * @param soNgayCong the soNgayCong to set
	 */
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

}
