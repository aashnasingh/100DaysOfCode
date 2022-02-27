package com.javabasics.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
	Map<String, Boolean> booleanMap = new HashMap<>();
	public boolean canConstructRec(String target, String[] wordBank) {
		
		if (target.isBlank()) {
			return true;
		}
		
		for (int i = 0; i < wordBank.length; i++) {
			if (target.indexOf(wordBank[i]) == 0) {
				String newTarget = target.substring(wordBank[i].length());
 				boolean ans = canConstructRec(newTarget, wordBank);
				if (ans) {
					return ans;
				}
			}
		}
		
		return false;
	}
	
	public boolean canConstructMemo(String target, String[] wordBank) {

		if (target.isBlank()) {
			return true;
		}
		
		if (booleanMap.containsKey(target)) {
			return booleanMap.get(target);
		}
		
		for (int i = 0; i < wordBank.length; i++) {
 			if (target.indexOf(wordBank[i]) == 0) {
				String newTarget = target.substring(wordBank[i].length());
				boolean ans = canConstructMemo(newTarget, wordBank);
				if (ans) {
					booleanMap.put(target, ans);
					return ans;
				}
			}
		}
		booleanMap.put(target, false);
		return false;
	}
	
	
	public static void main(String[] args) {
		
		CanConstruct canConstruct = new CanConstruct();
		String[] wordBank = new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
		boolean ans = canConstruct
				.canConstructRec("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"});
		System.out.println(ans);
		boolean ways = canConstruct
				.canConstructMemo("skateboard", wordBank);
		System.out.println(ways);
		
	}

}
