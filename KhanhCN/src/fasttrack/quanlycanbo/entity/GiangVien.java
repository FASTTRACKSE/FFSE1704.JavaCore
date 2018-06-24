package fasttrack.quanlycanbo.entity;

public class GiangVien extends CanBo {
	

	private String khoa;
	private String trinhDo;
	private int soTietTrongThang;
	
	public GiangVien(String hoTen, int phuCap, double heSo, String khoa, String trinhDo, int soTietTrongThang) {
		super(hoTen, phuCap, heSo);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietTrongThang = soTietTrongThang;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietTrongThang() {
		return soTietTrongThang;
	}

	public void setSoTietTrongThang(int soTietTrongThang) {
		this.soTietTrongThang = soTietTrongThang;
	}
	

	@Override
	public double tinhLuong() {
		double tienluong = 0;
		tienluong = getHeSo()*730000 + getPhuCap() + getSoTietTrongThang() * 45 ;
		return tienluong;
	}

}
