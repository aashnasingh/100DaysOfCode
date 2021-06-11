package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aashnasingh
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 */
public class ContainsDuplicatesII {
	
	    public boolean containsNearbyDuplicate(int[] nums, int k) {
	        
	        Map<Integer, Integer> duplicateMap = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < nums.length; i++) {
	            
	            if (duplicateMap.containsKey(nums[i]) && i - duplicateMap.get(nums[i]) <= k) {
	                return true;
	            }
	            else {
	               duplicateMap.put(nums[i], i); 
	            }
	            
	        }
	        return false;
	    }
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1};
		ContainsDuplicatesII containsDuplicatesII = new ContainsDuplicatesII();
		boolean result = containsDuplicatesII.containsNearbyDuplicate(nums, 3);
		System.out.println(result);
	}

}
