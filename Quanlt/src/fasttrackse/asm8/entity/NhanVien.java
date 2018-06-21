package fasttrackse.asm8.entity;

public class NhanVien extends CanBo {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public NhanVien(String tenCB, int phuCap, int heSoLuong, String phongBan, int soNgayCong, String chucVu) {
		super(tenCB, phuCap, heSoLuong);
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
	@Override
	public double luongNV() {
		// TODO Auto-generated method stub
		return heSoLuong*730+phuCap+soNgayCong*30;
	}

}
