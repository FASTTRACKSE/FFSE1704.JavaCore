package SinhVienFFSE;

public class SinhVien {
	private String hoVaTen;
	private int namSinh;
	private String gioiTinh;
	private int diemLp1;
	private int diemLp2;
	private int diemLp3;
	private String ketQua;

	public SinhVien(String hoVaTen, int namSinh, String gioiTinh, int diemLp1, int diemLp2, int diemLp3) {
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diemLp1 = diemLp1;
		this.diemLp2 = diemLp2;
		this.diemLp3 = diemLp3;
	}

	public SinhVien(String tenSinhVien, int namSinh) {
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;

	}

	public void setHoVaTen() {
		this.hoVaTen = hoVaTen;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setgioiTinh() {
		this.gioiTinh = gioiTinh;
	}

	public String getgioiTinh() {
		return gioiTinh;
	}

	public void setnamSinh() {
		this.namSinh = namSinh;
	}

	public int getnamSinh() {
		return namSinh;
	}

	public void setdiemLp1() {
		this.diemLp1 = diemLp1;
	}

	public int getdiemLp1() {
		return diemLp1;
	}

	public void setdiemLp2() {
		this.diemLp2 = diemLp2;
	}

	public int getdiemLp2() {
		return diemLp2;

	}

	public void setdiemLp3() {
		this.diemLp3 = diemLp3;
	}

	public int getdiemLp3() {
		return diemLp3;
	}

	public double tinhDiemTrungBinh() {
		return (diemLp1 + diemLp2 + diemLp3) * 1.0 / 3;
	}
	public String thongTinhSinhVien() {
		return  this.hoVaTen+"\t"+this.namSinh+"\t";
	}

	public String toString() {
		return "\t" + this.hoVaTen + "\t\t" + this.namSinh + "\t\t" + this.gioiTinh + "\t\t" + this.diemLp1
				+ "\t\t" + this.diemLp2 + "\t\t" + this.diemLp3 + "\t    1";
	}
   
	public String xepLoai() {
		String ketQua;
		
		if (tinhDiemTrungBinh() <= 5) {
			ketQua="Yếu";
			//System.out.println("Yếu");
			
		} else if (tinhDiemTrungBinh() <= 7) {
			ketQua="Trung bình";
			//System.out.println("Trung Bình");
			
		} else if (tinhDiemTrungBinh() <= 8.5) {
			ketQua="khá";
			//System.out.println("Khá");
			
		} else {
			ketQua="Giỏi";
			//System.out.println("Giỏi");
			
		}
		return ketQua;

	}

	
}
