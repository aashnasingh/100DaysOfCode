package com.leetcode.arrays.hashmap;

import java.util.Arrays;

public class ReverseStringInPlace {
	
	private String[] reverseStringArr(String[] word) {
		int left = 0, right = word.length - 1;
		while (left< right) {
			String temp = word[left];
			word[left++] = word[right];
			word[right--] = temp;
		}
 		return word;
	}
	
	public static void main(String[] args) {
		ReverseStringInPlace reverseStringInPlace = new ReverseStringInPlace();
		String[] word = new String[] {"E", "x", "t", "r", "a", "o", "r", "d", "i", "n", "a", "r", "y"};
		String[] reversed = reverseStringInPlace.reverseStringArr(word);
		System.out.println("Reversed String : " + Arrays.toString(reversed) );
		
	}

}
