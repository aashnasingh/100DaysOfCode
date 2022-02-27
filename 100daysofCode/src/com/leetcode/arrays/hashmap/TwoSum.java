package com.leetcode.arrays.hashmap;

import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        int tempAns;
        HashMap<Integer, Integer> combinationMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            tempAns = target - nums[i];
            
            if (combinationMap.containsKey(tempAns)) {
                
                return new int[]{combinationMap.get(tempAns), i};
                
            }
            else {
                combinationMap.put(nums[i], i);
            }
        }
        return null;
    }
	
	public static void main(String[] args) {

		int[] ans = twoSum(new int[]{2,7,11,15}, 9);
		
		System.out.println(ans);

	}

	
}
