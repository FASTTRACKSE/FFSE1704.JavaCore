/************************
 *Prog: QUẢN LÝ SINH VIÊN
 *@AUTHOR: Phan Phạm Quang Dai
 *Date: 31/05/2018
 **********************/
package Assignment_4.scr.ffse.qlsv.entity;

/**
 * @author Support
 *
 */
public class SinhVien {
	private String tenSinhVien;
	private String gioiTinh;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;

	public SinhVien(String tenSinhVien, String gioiTinh, int namSinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	public String getSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh() {
		this.gioiTinh = gioiTinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(int diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public int getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(int diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public int getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(int diemLP3) {
		this.diemLP3 = diemLP3;
	}

	public double tinhDiemTrungBinhMon() {
		return  Math.round((diemLP1 + diemLP2 + diemLP3) / 3);
		
	}

	public String xepLoai() {
		String ketQua;
		if (tinhDiemTrungBinhMon() <= 5) {
			ketQua="Yếu";
			//System.out.println("Yếu");
			
		} else if (tinhDiemTrungBinhMon() <= 7) {
			ketQua="Trung bình";
			//System.out.println("Trung Bình");
			
		} else if (tinhDiemTrungBinhMon() <= 8.5) {
			ketQua="khá";
			//System.out.println("Khá");
			
		} else {
			ketQua="Giỏi";
			//System.out.println("Giỏi");
			
		}
		return ketQua;

	}

	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + " *****  Giới Tính: " + this.gioiTinh + " ****** Năm Sinh "
				+ this.namSinh + " ***** ";
	}

}