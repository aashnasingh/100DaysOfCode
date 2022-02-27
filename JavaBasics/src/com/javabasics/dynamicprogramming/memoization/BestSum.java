package com.javabasics.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
	
	public List<Integer> bestSumRec(int targetSum, int[] nums) {
		List<Integer> sumCombinations = new ArrayList<>();
		List<Integer> shortestCombinations = null;
		if(targetSum == 0) {
			return new ArrayList<>();
		}
		if (targetSum < 0) {
			return null;
		} 
		
		for (int i = 0; i < nums.length; i++) {
			int tSum = targetSum - nums[i];
			sumCombinations = bestSumRec(tSum, nums);
			if (sumCombinations != null) {
				sumCombinations.add(nums[i]);
				if (shortestCombinations == null || shortestCombinations.size() > sumCombinations.size()) {
					shortestCombinations = sumCombinations;
				}
			}
		}
		return shortestCombinations;
		
	}
	
	Map<Integer, List<Integer>> sumMap = new HashMap<>();
	public List<Integer> bestSumDP(int targetSum, int[] nums) {		
		List<Integer> sumCombinationsDP = new ArrayList<>();	
		List<Integer> shortestCombinationsDP = null;
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
			sumCombinationsDP = bestSumDP(tSum, nums);
			if (sumCombinationsDP != null) {
				sumCombinationsDP.add(nums[i]);
				if (shortestCombinationsDP == null || shortestCombinationsDP.size() > sumCombinationsDP.size()) {
					shortestCombinationsDP = sumCombinationsDP;
				}
				sumMap.put(targetSum, shortestCombinationsDP);
			}
		}
		 
		sumMap.put(targetSum, shortestCombinationsDP);
		return shortestCombinationsDP;
	}

	public static void main(String[] args) {
		
		BestSum bestSum = new BestSum();
		int[] nums = new int[] {7, 14};
		List<Integer> ans = bestSum.bestSumRec(8, new int[] {2,3,5});
		List<Integer> ways = bestSum.bestSumDP(7, new int[] {5, 3, 4, 7});
		System.out.println(ans);
		System.out.println(ways);
	}

}
