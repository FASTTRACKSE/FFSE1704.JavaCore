package fasttrackse.asm5plus.main;

public class NhanVien extends GiangVien {
	private String phongBan;
	private int chucVu;
	public String getPhongBan() {
		return phongBan;
	}
	public NhanVien(String tenNv, String khoaNV, int songayCong, int hesoLuong, int trinhDo, int phuCap, int soTiet,
			int heLuong, String phongBan, int chucVu) {
		super(tenNv, khoaNV, songayCong, hesoLuong, trinhDo, phuCap);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
	}
	public NhanVien(String tenNv, String khoaNV, int songayCong, int hesoLuong, int trinhDo, int phuCap) {
		super(tenNv, khoaNV, songayCong, hesoLuong, trinhDo, phuCap);
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getChucVu() {
		return chucVu;
	}
	public void setChucVu(int chucVu) {
		this.chucVu = chucVu;
	}
	public double luongNV() {
		return  getHesoLuong()*730+getPhuCap()+getSongayCong()*45;
	}
}
