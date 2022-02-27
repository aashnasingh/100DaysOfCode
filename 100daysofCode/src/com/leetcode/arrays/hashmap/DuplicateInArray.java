package com.leetcode.arrays.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aashnasingh
 * 
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
Sample Input:

[3 4 1 4 1]

Sample Output:

1

If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 *
 */
public class DuplicateInArray {
	
	private List<Integer> findDupe(int[] nums) {
		
		List<Integer> dupes = new ArrayList<>();

        for (int num : nums) { 
            
            if (nums[Math.abs(num) - 1] < 0) dupes.add(Math.abs(num));
            nums[Math.abs(num) - 1] *= -1;

        }
		
		return dupes;
	}

	public static void main(String[] args) {
		
		DuplicateInArray duplicateInArray = new DuplicateInArray();
		int[] a = new int[] {3, 4, 1, 4, 1};
		List<Integer> dupes = duplicateInArray.findDupe(a);
		System.out.println(dupes);
	}

}
