package com.javabasics.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
	
	List<Integer> sumCombinations = new ArrayList<>();
	Map<Integer, List<Integer>> sumMap = new HashMap<>();
	public List<Integer> howSumRec(int targetSum, int[] nums) {
		
		if(targetSum == 0) {
			return new ArrayList<>();
		}
		if (targetSum < 0) {
			return null;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int tSum = targetSum - nums[i];
			sumCombinations = howSumRec(tSum, nums);
			if (sumCombinations != null) {
				sumCombinations.add(nums[i]);
				return sumCombinations;
			}
		}
		return null;
		
	}
	
	List<Integer> sumCombinationsDP = new ArrayList<>();
	public List<Integer> howSumDP(int targetSum, int[] nums) {		
		
		if(targetSum == 0) {
			return new ArrayList<>();
		}
		if (targetSum < 0) {
			return null;
		}
		
		if (sumMap.containsKey(targetSum)) {
			return sumMap.get(targetSum);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int tSum = targetSum - nums[i];
			sumCombinationsDP = howSumRec(tSum, nums);
			if (sumCombinationsDP != null) {
				sumCombinationsDP.add(nums[i]);
				sumMap.put(targetSum, sumCombinationsDP);
				return sumCombinationsDP;
			}
		}
		sumMap.put(targetSum, null);
		return null;
	}

	public static void main(String[] args) {
		
		HowSum howSum = new HowSum();
		int[] nums = new int[] {7, 14};
		List<Integer> ans = howSum.howSumRec(7, new int[] {5, 3, 4, 7});
		List<Integer> ways = howSum.howSumDP(300, nums);
		System.out.println(ans);
		System.out.println(ways);
	}

}
