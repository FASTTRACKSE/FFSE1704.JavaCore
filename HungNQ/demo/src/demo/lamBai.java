package demo;

public class lamBai {

	public static void main(String[] args) {

	}
	int sum(int... x) {
		int s = 0;
		for(int a :x) {
			s+=a;
		}
		return s;
	}
}
