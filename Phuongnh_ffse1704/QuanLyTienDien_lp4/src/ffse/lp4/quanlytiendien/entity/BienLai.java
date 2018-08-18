package ffse.lp4.quanlytiendien.entity;

public class BienLai extends KhachHang {
		private int ngay; 	
		private int thang; 	
		private int nam; 	
		private int cSMoi; 	
		private int cSCu; 	
		private int TinhTien;
		public BienLai(String maKH, String tenKH, String diaChi, String MaPhuong, String MaQuan, String sDT, String email,
				String maCongTo, int ngay, int thang, int nam, int cSMoi, int cSCu, int tinhTien) {
			super(maKH, tenKH, diaChi, MaPhuong, MaQuan, sDT, email, maCongTo);
			this.ngay = ngay;
			this.thang = thang;
			this.nam = nam;
			this.cSMoi = cSMoi;
			this.cSCu = cSCu;
			TinhTien = tinhTien;
		}
		public int getNgay() {
			return ngay;
		}
		public void setNgay(int ngay) {
			this.ngay = ngay;
		}
		public int getThang() {
			return thang;
		}
		public void setThang(int thang) {
			this.thang = thang;
		}
		public int getNam() {
			return nam;
		}
		public void setNam(int nam) {
			this.nam = nam;
		}
		public int getcSMoi() {
			return cSMoi;
		}
		public void setcSMoi(int cSMoi) {
			this.cSMoi = cSMoi;
		}
		public int getcSCu() {
			return cSCu;
		}
		public void setcSCu(int cSCu) {
			this.cSCu = cSCu;
		}
		public int getTinhTien() {
			return TinhTien;
		}
		public void setTinhTien(int tinhTien) {
			TinhTien = tinhTien;
		} 
		
}