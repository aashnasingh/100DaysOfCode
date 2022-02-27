package com.javabasics.arrays;

import java.util.Arrays;

public class AddOne {
	
	private int[] addOneToNumber(int[] arr) {
		
		int carry = 0;
		int n = arr.length - 1;
		
		arr[n] = arr[n] + 1;
		
		for (int i = n; i >= 0; i--) {
			
			if (carry > 0) {

				arr[i] = arr[i] + carry;
				
			}
			
			carry = arr[i] /10;
			arr[i] = arr[i] % 10;	
			
		}

		if ( carry > 0) {
			arr = Arrays.copyOfRange(arr, 0, arr.length + 1);
			arr[0] = carry;
		}

		
		return arr;
	}

	public static void main(String[] args) {
		AddOne addOne = new AddOne();
		int[] arr = new int[] {9, 9};
		arr = addOne.addOneToNumber(arr);
		System.out.println(Arrays.toString(arr));
	}

}
