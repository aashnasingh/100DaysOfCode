package com.javabasics;

public class SpecialReverseString {
	
	public String reverseString(String input) {
		if ("".equals(input)) return input;
		char[] inputArr = input.toCharArray();
		int left = 0; int right = inputArr.length - 1;
		
		while (left < right) {
			if (!Character.isAlphabetic(inputArr[left])) left++;
			else if (!Character.isAlphabetic(inputArr[right])) right--;
			else {
				char temp = inputArr[left];
				inputArr[left++] = inputArr[right];
				inputArr[right--] = temp;
			}			
		}
		
		return String.valueOf(inputArr);
	}

	public static void main(String[] args) {
		SpecialReverseString specialReverseString = new SpecialReverseString();
		String output = specialReverseString.reverseString("a,b$c");
		System.out.println(output);
	}

}
