package fasttrack.quancanbo.entity;

public abstract class CanBo {

	private String hoTen;
	private int phuCap;
	private double heSo;

	public abstract double tinhLuong();
	
	public CanBo() {
		super();
	}

	public CanBo(String hoTen, int phuCap, double heSo) {
		super();
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.heSo = heSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public double getHeSo() {
		return heSo;
	}

	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
	
}
