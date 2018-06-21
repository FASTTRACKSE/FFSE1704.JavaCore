/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.entity;

public abstract class NhanVien{
	private String ten;
	private int phuCap;
	private double heSoLuong;
	
	public NhanVien(String ten, int phuCap, double heSoLuong) {
		this.ten = ten;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public int getPhuCap() {
		return phuCap;
	}
	
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	
	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	
	public abstract double tinhLuong();

}
