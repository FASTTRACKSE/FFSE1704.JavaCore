package ffse1704.java_day1.hello_joker;

import java.util.Random;
import java.util.Vector;

public class Hello_Joker {

	public static void main(String[] args) {
		 Random rd = new Random();

	        //random 10 number bettween 100
	        System.out.println("random 10 số  trong 100 số");
	        for (int i = 0; i < 10; i++) {
	            System.out.println("STT " + (i+1) + ":" + rd.nextInt(100));
	        }
	       
	        //random new item difference from previous random item
	        int iNewNumber = 0, iPrevious = -1;
	        for (int i = 0; i < 10; ) {
	            iNewNumber = rd.nextInt(1000);
	            if (iNewNumber != iPrevious){
	                i++;
	                iPrevious = iNewNumber;
	                System.err.println("Item " + (i) + ":" + iNewNumber);
	            }
	        }
	       
	        //random 10 unique number
	        Vector<Integer> v = new Vector<Integer>();
	        int iNew = 0;
	        for (int i = 0; i < 10;  ) {
	            iNew = rd.nextInt(100);
	            if (!v.contains(iNew)){
	                i++;
	                v.add(iNew);
	                System.out.println("=> " + (i) + ":" + iNew);
	            }
	        }
	    }
}
