package com.javabasics;


/**
 * @author aashnasingh
 * 
 * step = feet
 * Frog can take 1 step or two steps
 * have to cross n feet river where there are (n-1) stones with distance of 1 feet 
 * eg - 11 feet river with 10 stones 1 feet apart
 * Find number of ways.
 * 2 feet - 2 ways -> 1-1/2
 * 3 feet - 3 ways -> 1- 2 feet left + 2 - 1 feet left = 2 + 1 = 3
 *
 */
public class FrogLeap {
	int ans = 0;
	public int frogLeapRec(int num) {
		
		if (num >= 3) {
			ans = frogLeapRec(num - 1) + frogLeapRec(num - 2);
		}
		else if (num == 2) {
			ans = 2;
		}
		else if (num == 1) {
			ans = 1;
		}
		else {
			ans = 0;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		FrogLeap frogLeap = new FrogLeap();
		int ans = frogLeap.frogLeapRec(7);
		System.out.println(ans);
	}

}
