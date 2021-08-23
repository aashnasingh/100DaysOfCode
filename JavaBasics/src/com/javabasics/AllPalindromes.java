package com.javabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPalindromes {
	
	List<String> answer = new ArrayList<>();
	Map<String, Boolean> ansMap = new HashMap<>();
	SpecialReverseString specialReverseString = new SpecialReverseString();
	private void allPossiblePalindromes(String input) {
		if (input.length() <= 1) {
			return;
		}
		if (ansMap.containsKey(input)) {
			return;
		}
		if (input.equals(specialReverseString.reverseString(input))) {
			answer.add(input);
		}		
		else {
			allPossiblePalindromes(input.substring(0, input.length() - 1));
			allPossiblePalindromes(input.substring(1, input.length()));
			ansMap.put(input, true);
			ansMap.put(specialReverseString.reverseString(input), true);
		}
				
	}

	public static void main(String[] args) {
		AllPalindromes allPalindromes = new AllPalindromes();
		allPalindromes.allPossiblePalindromes("geeks");
		allPalindromes.answer.addAll(Arrays.asList("geeks".split("")));
		System.out.println(allPalindromes.answer);

	}

}
