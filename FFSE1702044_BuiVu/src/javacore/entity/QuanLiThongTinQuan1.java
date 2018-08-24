package fasttrackse.javacore.entity;

public class QuanLiThongTinQuan1 {
	private String id,tenQuan;

	public QuanLiThongTinQuan1(String id, String tenQuan) {
		this.id = id;
		this.tenQuan = tenQuan;
	}


	public QuanLiThongTinQuan1() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}
	public String toString() {
		return tenQuan;
	}
}
