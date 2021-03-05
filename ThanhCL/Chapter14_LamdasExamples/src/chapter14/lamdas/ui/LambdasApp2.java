package chapter14.lamdas.ui;

import java.util.ArrayList;

import chapter14.lamdas.business.FilterNumber;

public class LambdasApp2 {
	
	public static int sumArray(ArrayList<Integer> nums, FilterNumber filterNumber) {
		int sum = 0;
		for (int n : nums) {
			if (filterNumber.filterNumber(n))
				sum += n;
		}
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(4);
		nums.add(6);
		nums.add(7);
		nums.add(9);
		nums.add(10);
		
		System.out.println("Tong all = " + sumArray(nums, n -> true));
		System.out.println("Tong so le = " + sumArray(nums, n -> n%2 != 0));
		
		
	}

}
