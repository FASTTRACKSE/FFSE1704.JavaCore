package qlcb.entity;

import qlcb.entity.CanBo;

public class GiangVien  {
	int ID;
	private String hoTen;
	private Double heSoLuong;
	private String khoa;
	private String trinhDo;
	private int soTietDay;

	

	public GiangVien(int ID,String hoTen, double heSoLuong, String khoa, String trinhDo, int soTietDay) {
		this.hoTen= hoTen;
		this.heSoLuong=heSoLuong;
		this.ID = ID;
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;

	}
	public GiangVien(String hoTen, double heSoLuong, String khoa, String trinhDo, int soTietDay) {
		this.hoTen= hoTen;
		this.heSoLuong=heSoLuong;
		
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;

	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public Double getHeSoLuong() {
		return heSoLuong;
	}



	public void setHeSoLuong(Double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}



	public GiangVien() {
		
		// TODO Auto-generated constructor stub
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}

	public double tinhLuong() {

		double tinhLuong = 0;
		if ("Cử nhân".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (2000) + (this.soTietDay * 45);
		} else if ("Thạc sĩ".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (1000) + (this.soTietDay * 45);
		} else if ("Tiến sĩ".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (500) + (this.soTietDay * 45);
		}

		return tinhLuong;

	}
}
