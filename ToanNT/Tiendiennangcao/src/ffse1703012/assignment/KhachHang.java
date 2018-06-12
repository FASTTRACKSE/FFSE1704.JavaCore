package ffse1703012.assignment;

import java.util.ArrayList;

public class KhachHang implements Comparable<KhachHang> {
	protected String maKH;
	protected String tenKH;
	public String diaChiKH;
	ArrayList<BienLai> dsBienLai;

	public KhachHang(String maKH, String tenKH, String diaChiKH) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiKH = diaChiKH;
		dsBienLai = new ArrayList<BienLai>();
	}

	public String getKhachHang() {
		return tenKH;
	}

	public void setKhachHang(String tenKhachHang) {
		this.tenKH = tenKH;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}


	public String getMaKH() {
		return maKH;
	}


	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}


	public String getDiaChiKH() {
		return diaChiKH;
	}

	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}


	public ArrayList<BienLai> getDsBienLai() {
		return dsBienLai;
	}


	public void setDsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}

	public void addToDsBienLai(BienLai bienLai) {
		this.dsBienLai.add(bienLai);
	}

	@Override
	public int compareTo(KhachHang x) {
		if (this.diaChiKH.compareTo(x.diaChiKH) == 0) {
			return this.tenKH.compareTo(x.tenKH);
		} else {
			return this.diaChiKH.compareTo(x.diaChiKH);
		}
	}

}
