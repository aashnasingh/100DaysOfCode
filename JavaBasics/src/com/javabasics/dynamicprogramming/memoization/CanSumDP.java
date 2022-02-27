package com.javabasics.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSumDP {
	Map<Integer, Boolean> booleanMap = new HashMap<>();
	public boolean canSumRec(int targetSum, int[] nums) {
		
		if (targetSum == 0) {
			return true;
		}
		
		if (targetSum < 0) {
			return false;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int tSum = targetSum - nums[i];
			boolean ans = canSumRec(tSum, nums);
			if(ans) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean canSumMemo(int targetSum, int[] nums) {
		
		if (targetSum == 0) {
			return true;
		}
		
		if (targetSum < 0) {
			return false;
		}
		
		if (booleanMap.containsKey(targetSum)) {
			return booleanMap.get(targetSum);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int tSum = targetSum - nums[i];
			
			if(canSumRec(tSum, nums)) {
				booleanMap.put(targetSum, true);
				return true;
			}
		}
		booleanMap.put(targetSum, false);
		return false;
	}
	
	
	public static void main(String[] args) {
		
		CanSumDP canSumDP = new CanSumDP();
		int[] nums = new int[] {7, 14};
		boolean ans = canSumDP.canSumRec(7, new int[] {7, 14});
		boolean ways = canSumDP.canSumMemo(300, nums);
		System.out.println(ways);
		System.out.println(ans);
	}

}
