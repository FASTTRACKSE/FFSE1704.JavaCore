package fasttrackse.javacore.entity;

public class QuanLiPhuong1 {
	public QuanLiPhuong1(String id, String tenPhuong) {
		this.id = id;
		this.tenPhuong = tenPhuong;
	}
	public QuanLiPhuong1(QuanLiPhuong1 item) {
		// TODO Auto-generated constructor stub
	}
	private String id,tenPhuong;

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
