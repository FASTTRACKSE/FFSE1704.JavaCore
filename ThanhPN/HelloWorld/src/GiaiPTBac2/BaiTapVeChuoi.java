package GiaiPTBac2;

public class BaiTapVeChuoi {

	public static void main(String[] args) {
		String a = "        Pham       ngoc         tHanh";
	
	a = a.trim();
	System.out.println("Loai bo khoang trang: " + a);
		
	
		
     while (a.indexOf("  ")> 0) 
    	 a = a.replaceAll("\\s+", " ");
    	 System.out.println("Cat bo khoang du: " + a);
     
     
 	
		a = a.trim().toLowerCase();
	System.out.println("ve ki tu thuong: " + a);
		
	 String msg;
	String arr[] = msg.split(" ");
     
	}

}
str = chuanHoa(str);
String temp[] = str.split(" ");
str = ""; // ? ^-^
for (int i = 0; i < temp.length; i++) {
    str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
    if (i < temp.length - 1) // ? ^-^
        str += " ";
}
return str;
}