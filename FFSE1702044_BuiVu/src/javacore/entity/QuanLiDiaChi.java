package fasttrackse.javacore.entity;

public class QuanLiDiaChi {
	private String Tinh,id;

	public QuanLiDiaChi(String id, String tinh) {
		
		this.id = id;
		this.Tinh = tinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTinh() {
		return Tinh;
	}

	public void setTinh(String tinh) {
		Tinh = tinh;
	}
	public String toString() {
		return Tinh;
	}
	
}
