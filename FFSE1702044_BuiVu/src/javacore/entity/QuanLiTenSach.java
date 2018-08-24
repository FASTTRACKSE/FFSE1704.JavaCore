package fasttrackse.javacore.entity;

public class QuanLiTenSach {
	
 public QuanLiTenSach(String id, String tenSach) {
		super();
		this.id = id;
		TenSach = tenSach;
	}

private String id,TenSach;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTenSach() {
	return TenSach;
}

public void setTenSach(String tenSach) {
	TenSach = tenSach;
}
 
}
