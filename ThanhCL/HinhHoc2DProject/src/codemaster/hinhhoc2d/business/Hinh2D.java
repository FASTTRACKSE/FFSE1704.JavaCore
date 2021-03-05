package codemaster.hinhhoc2d.business;

public abstract class Hinh2D {
	private int id;
	private String loai;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the loai
	 */
	public String getLoai() {
		return loai;
	}

	/**
	 * @param loai
	 *            the loai to set
	 */
	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Hinh2D() {
	}

	public Hinh2D(int id, String loai) {
		super();
		this.id = id;
		this.loai = loai;
	}

	@Override
	public String toString() {
		return "id:\t" + id + "\nLoai:\t" + loai;
	}
	
	public String getInfo() {
		return id + "\t" + loai + "\t";
	}
	
	public abstract double tinhChuVi();
	public abstract double tinhDienTich();

}
