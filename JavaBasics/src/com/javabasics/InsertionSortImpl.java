package com.javabasics;

import java.util.Arrays;

public class InsertionSortImpl {
	
	public static int[] insertionSortArray(int[] inputArr) {
		
		for (int i = 0; i < inputArr.length; i++) {
			int current = inputArr[i];
			int j = i-1;
			
			while (j >= 0 && inputArr[j] > current) {
				inputArr[j+1] = inputArr[j];
				j--;
			}
			inputArr[j+1] = current;
		}
		
		return inputArr;
		
	}
	
	public static void main(String[] args) {
		int[] inputArr = new int[]{2, 5, 20, 12, 5, 45};
		
		inputArr = insertionSortArray(inputArr);
		
		System.out.println(Arrays.toString(inputArr));
	}

}
