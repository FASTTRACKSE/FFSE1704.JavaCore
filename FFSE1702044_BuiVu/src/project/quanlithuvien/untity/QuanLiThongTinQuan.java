package project.quanlithuvien.untity;

public class QuanLiThongTinQuan {
	
	private String tenQuan,id;

	public QuanLiThongTinQuan(String id, String tenQuan) {
		this.id = id;
		this.tenQuan = tenQuan;
	}


	public QuanLiThongTinQuan() {
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
