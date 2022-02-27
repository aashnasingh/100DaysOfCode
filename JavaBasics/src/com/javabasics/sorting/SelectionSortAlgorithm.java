package com.javabasics.sorting;

import java.util.Arrays;

public class SelectionSortAlgorithm {
	
	public int[] selectionSort(int[] arr) {
		
		int minIndex = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			}
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		SelectionSortAlgorithm SelectionSortAlgorithm = new SelectionSortAlgorithm();
		int[] arr = new int[]{12, 8, 7, 5, 2};
		arr = SelectionSortAlgorithm.selectionSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
