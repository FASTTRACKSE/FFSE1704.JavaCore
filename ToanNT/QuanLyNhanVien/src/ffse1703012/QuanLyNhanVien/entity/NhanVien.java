package ffse1703012.QuanLyNhanVien.entity;
import java.io.Serializable;
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String hoTen;
	private double heSoLuong;
	public int phuCap;

	public NhanVien(String hoTen, double heSoLuong, int phuCap) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}

	public NhanVien() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public long tinhLuong() {
		return 0;
	}

	public void nhap() {
		
		
	}


	
	
}
