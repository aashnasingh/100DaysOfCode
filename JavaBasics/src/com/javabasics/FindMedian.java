package com.javabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMedian {

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		if (a.isEmpty() && b.isEmpty()) return -1;

		int i = 0, j = 0, k = 0;
		List<Integer> c = new ArrayList<>();
		while ( i < a.size() && j < b.size()) {
			if (a.get(i) <= b.get(j)) {
				c.add(k++, a.get(i));
				i++;
			}
			else {
				c.add(k++, b.get(j));
				j++;
			}
			
		}
		
		while (i < a.size()) {
			c.add(k++, a.get(i));
			i++;
		}
		while (j < b.size()) {
			c.add(k++, b.get(j));
			j++;
		}
		int n = c.size();
		int half = n/2;
		if (n % 2 == 0) {
			
			return (c.get(half - 1) + c.get(half))/2;
		}
		return c.get(half - 1);
	}
	


	public static void main(String[] args) {
		Integer[] arrayA = new Integer[] {-50, -41, -40, -19, 5, 21, 28};
		Integer[] arrayB = new Integer[] {-50, -21, -10};
		List<Integer> a = Arrays.asList(arrayA);
		List<Integer> b = new ArrayList<>( Arrays.asList(arrayB));
		FindMedian findMedian = new FindMedian();
		double median = findMedian.findMedianSortedArrays(a, b);
		System.out.println(median);
		double pow = Math.pow(4, 1/2);
		int ans = (int)Math.floor(pow);
		

	}

}
