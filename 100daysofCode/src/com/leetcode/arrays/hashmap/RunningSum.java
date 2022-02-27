package com.leetcode.arrays.hashmap;

import java.util.Arrays;

public class RunningSum {
	
	public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }
	
	public static void main(String[] args) {
		RunningSum RunningSum = new RunningSum();
		int[] nums = new int[] {1,2,3,4};
		nums = RunningSum.runningSum(nums);
		System.out.println(Arrays.toString(nums));
	}

}
