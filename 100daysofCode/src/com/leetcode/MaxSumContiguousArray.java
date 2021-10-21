package com.leetcode;

import java.util.List;

/**
 * @author aashnasingh
 * 
 * Find the contiguous subarray within an array, A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous subarray.
Constraints:

1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:

Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6.
 *
 */
public class MaxSumContiguousArray {
	
	private int maxSubArray(int[] a) {
		
		int sum = a[0];
		int ans = a[0];
		
		for (int i = 1; i < a.length; i++) {
			
			sum = Math.max(a[i], sum + a[i]);
			ans = Math.max(ans, sum);		
		}
		
		return ans;
	}

	public static void main(String[] args) {
		MaxSumContiguousArray MaxSumContiguousArray = new MaxSumContiguousArray();
		int[] a = new int[] {5,4,-1,7,8};
		int ans = MaxSumContiguousArray.maxSubArray(a);
		System.out.println(ans);
	}

}
