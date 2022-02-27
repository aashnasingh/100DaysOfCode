package com.leetcode.arrays.hashmap;

import java.util.Arrays;

/**
 * @author aashnasingh
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {
	
	public String largestNumber(int[] nums) {
        
        int n = nums.length;
        
        if (n == 1) return String.valueOf(nums[0]);
        String[] numsStr = new String[n];
        for (int i = 0; i < n; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsStr, (a, b) -> (b+a).compareTo(a+b));
        
        if (numsStr[0].equals("0")) return "0";
        
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans = ans.concat(numsStr[i]);
        }
        
        return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
