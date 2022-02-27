package com.javabasics.sorting;

import java.util.Arrays;

public class BubbleSortAlgorithm {
	
	public int[] bubbleSort(int[] arr) {
		
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - 2 - i; j++) {
				
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
		
	}

	public static void main(String[] args) {
		BubbleSortAlgorithm BubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] arr = new int[]{12, 8, 7, 5, 2};
		arr = BubbleSortAlgorithm.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
