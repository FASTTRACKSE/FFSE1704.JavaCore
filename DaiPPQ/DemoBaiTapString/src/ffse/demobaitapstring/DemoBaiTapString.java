/**
 *	Prog: Demo bài tập sử lý chuổi
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 25/06/2018
 */
package ffse.demobaitapstring;

/**
 * @author QuangDai
 *
 */
public class DemoBaiTapString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println("Bài 1");
		String str = "      Phạm    Trung    Hải    ";
		System.out.println("Chuổi ban đầu: " + str);
        str = str.trim();
        str = str.replaceAll("\\s+","_");
        System.out.println("Chuổi sau sử lý: " + str);
        

        
        System.err.println("Bài 2");
        
        String str1 = "  phan   trung   hai  ";
        System.out.println("Chuổi ban đầu: " + str1);
        
        str1 = str1.trim();
        str1 = str1.replaceAll("\\s+"," ");
	    String[] temp;
	    String delimeter = " ";
	    temp = str1.split(delimeter);
	    
	    for(int i = 0; i < temp.length ; i++){
	    	System.out.println(temp[i]);
	    }
	}

}
