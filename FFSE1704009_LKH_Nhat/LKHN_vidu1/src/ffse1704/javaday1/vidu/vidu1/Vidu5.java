package ffse1704.javaday1.vidu.vidu1;

public class Vidu5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String myName = "   phạm   trung   hải   ";
		 String yourName1 = "";
		 String yourName2 = "";
		 String yourName3 = "";
		 
		 System.out.println("Chuỗi Đầu: " + myName);
		 
		 yourName1 = myName.substring(3, 8);
		 yourName2 = myName.substring(10, 16);
		 yourName3 = myName.substring(18);
				
		 System.out.println("chuỗi sau thứ nhất: " + yourName1 + yourName2 + yourName3 );
		 
		 
		 yourName1 = myName.replace("   ", " ");
		 System.out.println(" chuỗi sau thứ 2: " + yourName1);
		 
		 
		 String[] yourName4 = myName.split("   ");
		 System.out.println("chuỗi sau thứ 3: " + yourName4[1] +" " + yourName4[2]+ " " + yourName4[3]);
		 
		 
		 String List = myName.substring(3, 4).toUpperCase();
		 String List2 = myName.substring(10, 11).toUpperCase();
		 String List3 = myName.substring(18, 19).toUpperCase();
		 System.out.println(List3);
		 
		 
	}

}
