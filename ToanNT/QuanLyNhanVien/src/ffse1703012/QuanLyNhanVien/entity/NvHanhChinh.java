package ffse1703012.QuanLyNhanVien.entity;

public class NvHanhChinh extends NhanVien {
	private String phongBan;
	private int soNgayCong;
	private String chucVu;
	public NvHanhChinh() {
		super();
	}
	public NvHanhChinh(String hoTen, double heSoLuong, int phuCap) {
		super(hoTen, heSoLuong, phuCap);
		
	}
	public NvHanhChinh(String hoTen, double heSoLuong, int phuCap, String phongBan, int soNgayCong,
			String chucVu) {
		super(hoTen, heSoLuong, phuCap);
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
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
	public long tinhLuong() {
        return (long) (this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoNgayCong() * 45);
    }
	
}
