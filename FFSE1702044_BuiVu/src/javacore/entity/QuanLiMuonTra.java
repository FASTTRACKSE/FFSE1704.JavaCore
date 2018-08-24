package fasttrackse.javacore.entity;

public class QuanLiMuonTra {
	

	private String MaGD,NgayMuon,MaTV,TrangThai,MaSach;
	public QuanLiMuonTra(String maGD, String ngayMuon, String maTV, String trangThai, String maSach) {
		super();
		MaGD = maGD;
		NgayMuon = ngayMuon;
		MaTV = maTV;
		TrangThai = trangThai;
		MaSach = maSach;
	}
	public String getMaGD() {
		return MaGD;
	}

	public void setMaGD(String maGD) {
		MaGD = maGD;
	}

	public String getNgayMuon() {
		return NgayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		NgayMuon = ngayMuon;
	}

	public String getMaTV() {
		return MaTV;
	}

	public void setMaTV(String maTV) {
		MaTV = maTV;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	
}
