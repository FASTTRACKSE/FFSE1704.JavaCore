/************************
 *Prog: QUẢN LÝ CÁN BỘ
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 22/06/2018
 **********************/
package ffse.quanlycanbo.entity;

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
