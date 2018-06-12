package javacore.qlsvffse.entity;

public abstract class SinhVien {
		private String hoTen;
		private int namSinh;
		private String diaChi;
		public abstract double tinhDiemTb();
		public SinhVien(String hoTen,int namSinh,String diaChi) {
			this.hoTen=hoTen;
			this.namSinh=namSinh;
			this.diaChi=diaChi;
		}
		public String getHoTen() {
			return hoTen;
		}
		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}
		public int getNamSinh() {
			return namSinh;
		}
		public void setNamSinh(int namSinh) {
			this.namSinh = namSinh;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String XepLoai() {
			String xepLoai = "";
			if(tinhDiemTb()>= 0 || tinhDiemTb() <= 10 ) {
				if(tinhDiemTb()<5) {
					xepLoai="Yếu";
				}else if(tinhDiemTb()<6.5) {
					xepLoai = "Trung Bình";
				}else if(tinhDiemTb()<8.5) {
					xepLoai= "Khá";
				}else {
					xepLoai="Giỏi";
				}
			}else {
				xepLoai = "Điểm Không Hợp Lệ!!!";
			}
			return xepLoai;
		}
}
