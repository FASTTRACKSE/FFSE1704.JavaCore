package quanly;

import java.util.ArrayList;

import java.util.Scanner;

import biênlai.BiênLai;

public class QuanLy {

	public static void main(String[] args) {
		int n;
		BiênLai bienlai;
		Scanner scanner = new Scanner(System.in);
		ArrayList<BiênLai> arrBiênLai = new ArrayList<>();
		
		System.out.println("nhập số hộ gia đinh : ");
		n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			bienlai = new BiênLai();
			System.out.println("nhập thông tin biên lai của hộ gia đình thứ" + (i+1) + ": ");
			bienlai.nhapbienlai();
			arrBiênLai.add(bienlai);
		}
		
		System.out.println("thông tin biên lai của các hộ gia đinh: ");
		for(int i = 0; i < arrBiênLai.size(); i++) {
			System.out.println("thông tin biên lai gia đình thứ " + (i + 1)  + ": ");
			arrBiênLai.get(i).hienthibienlai();
		}
	}

}
