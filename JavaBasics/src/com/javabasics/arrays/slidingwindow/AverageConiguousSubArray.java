package com.javabasics.arrays.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author aashnasingh
 * 
 * Find the average of all contiguous sub arrays of size K.
 * 
 * Input : [1, 2, 3, 4, 5], 3 
 * Output : [2, 3, 4]
 *
 */
public class AverageConiguousSubArray {
	
	private List<Integer> getSubArrayAverage(int[] arr, int k) {
		
		List<Integer> averageList = new ArrayList<>();								
		int sum = 0;
		int counter = k;
		
		for (int i = 0; i < arr.length + 1 - k; i++) {
			int j = i;
			while (counter-- != 0) {
				sum = sum + arr[j++];
			}
			counter = k;
			averageList.add(sum/counter);
			sum = 0;
			
		}
		
		return averageList;
		
	}

	public static void main(String[] args) {
		
		AverageConiguousSubArray averageConiguousSubArray = new AverageConiguousSubArray();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter value of k : ");
//		int k = sc.nextInt();
		int[] inputArr = new int[] {1, 2, 3, 4, 5, 6, 3, 56, 27};		
		List<Integer> averageList = averageConiguousSubArray.getSubArrayAverage(inputArr, 4);
		System.out.println(averageList);
	}

}
