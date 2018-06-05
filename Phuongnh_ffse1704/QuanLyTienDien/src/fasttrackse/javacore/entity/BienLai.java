package fasttrackse.javacore.entity;

public class BienLai   {
	private int chiSoMoi ;
	private int chiSoCu;

	
	public BienLai(int chiSoMoi,int chiSoCu){
		this.chiSoMoi=chiSoMoi;
		this.chiSoCu = chiSoCu;
		
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

		
		public double tienCanThanhToan() {
			return (chiSoMoi-chiSoCu)*1.0* 3000;
		}


	
	 }
  
	 
			 

	


