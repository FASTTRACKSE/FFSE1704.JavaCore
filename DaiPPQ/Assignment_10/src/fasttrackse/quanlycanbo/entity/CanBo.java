/************************
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 25/06/2018
 **********************/
package fasttrackse.quanlycanbo.entity;

import java.io.Serializable;

public abstract class CanBo implements Serializable{
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