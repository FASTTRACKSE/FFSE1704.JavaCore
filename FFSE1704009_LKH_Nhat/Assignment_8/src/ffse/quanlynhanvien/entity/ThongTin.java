package ffse.quanlynhanvien.entity;

public abstract class ThongTin {
	private String tenCanBo;

	public ThongTin(String tenCanBo) {
		this.tenCanBo = tenCanBo;
	}

	public String getTenCanBo() {
		return tenCanBo;
	}

	public void setTenCanBo(String tenCanBo) {
		this.tenCanBo = tenCanBo;
	}

	public abstract double tinhLuong();

}
