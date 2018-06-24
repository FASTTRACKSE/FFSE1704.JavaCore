/************************
 *Prog: QUẢN LÝ CÁN BỘ
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 22/06/2018
 **********************/
package ffse.quanlycanbo.entity;

public abstract class CanBo {
	private String tenCanBo;

	public CanBo() {
	}

	public CanBo(String tenCanBo) {
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
