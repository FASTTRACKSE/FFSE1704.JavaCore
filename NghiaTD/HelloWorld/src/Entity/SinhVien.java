
/************************
 *Prog: QUẢN LÝ SINH VIÊN
 *@AUTHOR: TRƯƠNG ĐẠI NGHĨA
 *Date: 31/05/2018
 **********************/
package Entity;

/**
 * @author Support
 *
 */
public class SinhVien {
		private String TenSV;
		private String GioiTinh;
		private int namSinh;
		private int diemLP1;
		private int diemLP2;
		private int diemLP3;
		
		public SinhVien(String TenSV,String GioiTinh,int namSinh,int diemLP1,int diemLP2,int diemLP3) {
			this.TenSV = TenSV;
			this.GioiTinh=GioiTinh;
			this.namSinh=namSinh;
			this.diemLP1=diemLP1;
			this.diemLP2=diemLP2;
			this.diemLP3=diemLP3;
			
		}
		public String getSinhvien(){  //xuất
			return TenSV;
		}
		public void setSinhVien(String TenSV) { //nhap
			this.TenSV = TenSV;
		}
		public String getGioiTinh() {
			return GioiTinh;
		}
		public void setGioiTinh() {
			this.GioiTinh=GioiTinh;
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
			return Math.round((diemLP1+diemLP2+diemLP3)/3);
		}
		public String xepLoai() {
			String ketQua="";
			if(tinhDiemTrungBinhMon() >= 8.5) {
				ketQua="Gioi";
			}
			else if(tinhDiemTrungBinhMon() >=7){
				ketQua="Khá";
			}
			else if(tinhDiemTrungBinhMon() >=5){
				ketQua= "Trung Bình";
		}
			else {
				ketQua= "Yếu";
		}
			return ketQua;
		}
		public String Hienthi() {
	return " SinhVien:" +this.TenSV + " **** Giới tính:"+this.GioiTinh+"*** Năm Sinh"+this.namSinh +"**";
		}
		
	}


