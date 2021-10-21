package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author aashnasingh
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 *
 */
public class MergeOverlappingIntervals {
	
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> mergedLL = new LinkedList<>();
        
        for (int[] interval : intervals) {
            
            if (mergedLL.isEmpty() || mergedLL.getLast()[1] < interval[0]) {
                mergedLL.add(interval);
            }
            else {
                mergedLL.getLast()[1] = Math.max(mergedLL.getLast()[1], interval[1]);
            }
        }
        
        return mergedLL.toArray(new int[mergedLL.size()][]);
    }

	public static void main(String[] args) {
		MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
		
		int[][] intervals = new int[4][2];
		intervals[0] = new int[] {1, 3};
		intervals[1] = new int[] {2,6};
		intervals[2] = new int[] {8,10};
		intervals[3] = new int[] {15,18};
		int[][] merged = mergeOverlappingIntervals.merge(intervals);
		System.out.println(Arrays.toString(merged[0]));
		System.out.println(Arrays.toString(merged[1]));
		System.out.println(Arrays.toString(merged[2]));

	}

}
