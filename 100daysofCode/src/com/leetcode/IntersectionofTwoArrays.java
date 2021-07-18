package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoArrays {
	
	public int[] intersect(int[] nums1, int[] nums2) {
	        
	        Map<Integer, Integer> countMap = new HashMap<>();
	        int loopLen = 0;
	        int largerArr = 0;
	        if (nums1.length > nums2.length) {
	            loopLen = nums1.length;
	            largerArr = 1;
	        }
	        else {
	            loopLen = nums2.length;
	            largerArr = 2;
	        }
	        ArrayList<Integer> al = new ArrayList<>();
	       
	        for (int i = 0; i < loopLen; i++) {
	            if (largerArr == 1) {
	                countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
	                if (i < nums2.length) {
	                    countMap.put(nums2[i], countMap.getOrDefault(nums2[i], 0) + 1);
	                }
	            }
	            else {
	                countMap.put(nums2[i], countMap.getOrDefault(nums2[i], 0) + 1);
	                if (i < nums1.length) {
	                    countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
	                }
	            }
	            
	        }
	        
	        int position = 0;
	        for (int num : countMap.keySet()) {
	            int j = 0;
	            if (countMap.get(num) % 2 == 0) {
	                int q = countMap.get(num)/2;
	                while(j < q) {
	                    int[] ans;
						//ans[j+position] = num;
	                    j++;
	                } 
	                position = (j - 1)+ q;
	            }
	        }
	        int[] ans = new int[al.size()];
	        int k = 0;
	        for (int i : al) ans[k++] = i;
	        return ans;
	    }
	
	public static void main(String[] args) {
		IntersectionofTwoArrays IntersectionofTwoArrays = new IntersectionofTwoArrays();
		int[] arr = new int[]{1,2,2,1};
		int[] arr2 = new int[]{2,2};
		int[] ans = IntersectionofTwoArrays.intersect(arr, arr2);
		System.out.println(Arrays.toString(ans));
	
	}

}
