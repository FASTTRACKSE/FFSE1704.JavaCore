package fasttrackse.javacore.entity;

public class QuanLiMaSach {
 
  public QuanLiMaSach(String id, String maSach) {
	
	this.id = id;
	this.maSach = maSach;
}
public String getId() {
	return id;
}
  private String id, maSach;
public void setId(String id) {
	this.id = id;
}
public String getMaSach() {
	return maSach;
}
public void setMaSach(String maSach) {
	this.maSach = maSach;
}
public String toString() {
	return maSach;
}
}
