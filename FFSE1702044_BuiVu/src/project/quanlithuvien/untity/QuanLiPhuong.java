package project.quanlithuvien.untity;

public class QuanLiPhuong {
	public QuanLiPhuong(String id, String tenPhuong) {
		this.id = id;
		this.tenPhuong = tenPhuong;
	}
	public QuanLiPhuong(QuanLiPhuong item) {
		// TODO Auto-generated constructor stub
	}
	
	private String tenPhuong,id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}
	public String toString() {
		return tenPhuong;
	}
	
}
