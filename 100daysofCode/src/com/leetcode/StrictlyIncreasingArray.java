package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrictlyIncreasingArray {
	
	public boolean canBeIncreasing(Integer[] nums) {
        
        int count = 0;
        int i = 0;
        while(i < nums.length - 1) {
            
            if (nums[i] >= nums[i + 1]) {
                
//                for (int j = i; j < nums.length - 1; j ++) {
//                    nums[j] = nums[j+1];
//                }
            	List<Integer> tempList = new ArrayList<Integer>(Arrays.asList(nums));
                tempList.remove(i);
                nums = tempList.toArray(new Integer[0]);
                count++;
                if (i != 0) {
                    if (nums[i - 1] >= nums[i]) {
                        return false;
                    }
                }
                
            }
            else {
                i++;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

	public static void main(String[] args) {
		StrictlyIncreasingArray strictlyIncreasingArray = new StrictlyIncreasingArray();
		Integer[] arr = new Integer[]{1,2,3};
		boolean canBeIncreasin = strictlyIncreasingArray.canBeIncreasing(arr);
		System.out.println(canBeIncreasin);

	}

}
