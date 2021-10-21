package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aashnasingh
 * 
 * You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4] 

A = 3, B = 4
 *
 */
public class RepeatedMissingNumbers {
	
	private List<Integer> findRepeatedMissing(int[] nums) {
		
		List<Integer> ans = new ArrayList<>();
		int sum = 0;
		int n = nums.length;
		for (int num : nums) {
			
			if (nums[Math.abs(num) - 1] < 0) {
				ans.add(Math.abs(num));
			}
			else {
				sum = sum + Math.abs(num);
			}
			nums[Math.abs(num) - 1] *= -1;
		}
		
		int missingNumber = (n*(n+1))/2 - sum;
		ans.add(missingNumber);
		return ans;
	}

	public static void main(String[] args) {
		RepeatedMissingNumbers repeatedMissingNumbers = new RepeatedMissingNumbers();
		int[] nums = new int[] {9,6,4,2,3,5,7,1, 4};
		List<Integer> ans = repeatedMissingNumbers.findRepeatedMissing(nums);
		System.out.println(ans);
	}

}
