package fasttrackse.javacore.entity;

public class QuanLiTheLoaiSach {
	public QuanLiTheLoaiSach(String id, String theLoaiSach) {
		this.id = id;
		this.TheLoaiSach = theLoaiSach;
	}
	private String id,TheLoaiSach;
	public QuanLiTheLoaiSach(QuanLiTheLoaiSach item) {
		// TODO Auto-generated constructor stub
	}
	

 public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTheLoaiSach() {
		return TheLoaiSach;
	}
	public void setTheLoaiSach(String theLoaiSach) {
		TheLoaiSach = theLoaiSach;
	}
	public String toString() {
		return TheLoaiSach;
	}
}

