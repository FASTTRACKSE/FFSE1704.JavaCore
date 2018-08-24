package javacore.cacthuvienchuoi.xulichuoi;

public class XuLiChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tenChuoi= "  Phạm     Trung  Hải";
		while(tenChuoi.indexOf("  ",1) > 0) {
			tenChuoi= tenChuoi.replaceAll("  "," ");
		}
		System.out.println(tenChuoi.trim());
		tenChuoi= tenChuoi.toLowerCase();
				
		System.out.println(tenChuoi.trim());
		
		
	}

}
