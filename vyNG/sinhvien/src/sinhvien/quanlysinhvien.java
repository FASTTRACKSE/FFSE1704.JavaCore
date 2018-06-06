package sinhvien;

public class quanlysinhvien {
	private String tensinhvien;
	private String gioitinh;
	private int namsinh;
	private int diemlp1;
	private int diemlp2;
	private int diemlp3;
	
	public quanlysinhvien(String tensinhvien, String gioitinh, int namsinh, int diemlp1, int diemlp2, int diemlp3) {
		this.tensinhvien = tensinhvien;
		this.gioitinh = gioitinh;
		this.namsinh = namsinh;
		this.diemlp1 = diemlp1;
		this.diemlp2 = diemlp2;
		this.diemlp3 = diemlp3;
	}
	
	public String getquanlysinhvien() {
		return tensinhvien;	
	}
	
	public void settensinhvien(String téninhvien) {
		this.tensinhvien = tensinhvien;
	}
	
	public String getgioitinh() {
		return gioitinh;
	}
	
	public void setgioitinh() {
		this.gioitinh = gioitinh;
	}
	
	public void setnamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	
	public void setdiemlp1(int diemlp1) {
		this.diemlp1 = diemlp1;
	}
	
	public int getdiemlp2() {
		return diemlp2;
	}
	
	public void setdiemlp2(int diemlp2) {
		this.diemlp2 = diemlp2;
	}
	
	public int getdiemlp3() {
		return diemlp3;
	}
	
	public void setdiemlp3(int diemlp3) {
		this.diemlp3 = diemlp3;
	}
	
	public double diemtrungbinh() {
		return Math.round((diemlp1 + diemlp2 + diemlp3) / 3);
	}
	public String xeploai() {
		
		if(diemtrungbinh() <= 5) {
			return "yếu";
			//System.out.println("yếu");
		}else if (diemtrungbinh() <= 7) {
			return "trung bình";
			//System.out.println("trung bình");
		}else if (diemtrungbinh() <= 8.5) {
			return "khá";
			//System.out.println("khá");
		}else {
			return "giỏi";
			//System.out.println("giỏi");
		}		
	}
	
	public String toString() {
		return "quanlysinhvien: " + this.tensinhvien + "giới tính" + this.gioitinh + "năm sinh" + this.namsinh + "**";
	}


	public static void main(String[] args) {
	}

}
