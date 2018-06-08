package fasttrackse.javacore.entity;

public class BienLai {
	private int chiSoMoi ;
	private int chiSoCu;
	private int kyTieuThu;

	public BienLai() {
		
	}
	
	public BienLai(int chiSoMoi,int chiSoCu, int kyTieuThu){
		this.chiSoMoi=chiSoMoi;
		this.chiSoCu = chiSoCu;
		this.kyTieuThu = kyTieuThu;
		
	}
	// chỉ số cũ
		public int getchiSoCu() {
			return chiSoCu;
		}

		public void setchiSoCu(int chiSoCu) {
			this.chiSoCu = chiSoCu;
		}

		// chỉ số mới
		public int getchiSoMoi() {
			return chiSoMoi;
		}

		public void setchiSoMoi(int chiSoMoi) {
			this.chiSoMoi = chiSoMoi;
		}

		
		public int getKyTieuThu() {
			return kyTieuThu;
		}

		public void setKyTieuThu(int kyTieuThu) {
			this.kyTieuThu = kyTieuThu;
		}

		public double tienCanThanhToan() {
			return (this.chiSoMoi-this.chiSoCu)*1.0* 3000;
		}


	
	 }
  
	 
			 

	


