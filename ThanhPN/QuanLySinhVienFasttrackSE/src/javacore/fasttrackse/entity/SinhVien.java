/**
 * 
 */
package javacore.fasttrackse.entity;

/**
 * @author GOS ThanhRTCD
 *
 */
public abstract class SinhVien {
	protected String hoSV;
	protected String tenSV;
	protected int namSinh;
	protected String diaChi;

	public SinhVien(String hoSV, String tenSV, int namSinh, String diaChi) {
		super();
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;

	}

	public abstract double tinhDTB();

	public abstract String xepLoaiSV();

	public String getHoSV() {
		return hoSV;
	}

	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
