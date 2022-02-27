package com.javabasics;

import java.util.Arrays;

public class QuickSort {
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low - 1;
		
		for (int j = low; j <= high - 1; j++) {
			
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		++i;
		swap(arr, i, high);
		return i;
	}
	
	public int[] quickSort(int[] arr, int low, int high) {
		
		if (low < high) {
			
			int pivot = partition(arr, low, high);
			
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
 			
		return arr;
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] inputArr = new int[]{2, 5, 20, 12, 5, 45};
		inputArr = quickSort.quickSort(inputArr, 0, inputArr.length - 1);
		System.out.println(Arrays.toString(inputArr));

	}

}
