package com.javabasics.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aashnasingh
 * 
 * return number of ways can strings in wordBank concatenate to form target
 * 
 * Brute Force -
 * Time - O(n^m * line 28(can maximum be of m)) = O(n^m *m)
 * Space - O(m*m)
 * 
 * Memo -
 * Time - O(n*m* ine 28(can maximum be of m)) = O(n*m*m) = O(n*m^2)
 * Space - O(m*m)
 * 
 */
public class CountConstruct {

	Map<String, Integer> booleanMap = new HashMap<>();
	
	public int countConstructRec(String target, String[] wordBank) {
		int count = 0;
		if (target.isBlank()) {
			return 1;
		}
		
		for (int i = 0; i < wordBank.length; i++) {
			if (target.indexOf(wordBank[i]) == 0) {
				String suffix = target.substring(wordBank[i].length());
				int ans = countConstructRec(suffix, wordBank);
				if (ans == 1) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int countConstructMemo(String target, String[] wordBank) {

		int count = 0;
		if (target.isBlank()) {
			return 1;
		}
		
		if (booleanMap.containsKey(target)) {
			return booleanMap.get(target);
		}
		
		for (int i = 0; i < wordBank.length; i++) {
			if (target.indexOf(wordBank[i]) == 0) {
				String suffix = target.substring(wordBank[i].length());
				int ans = countConstructRec(suffix, wordBank);
				if (ans == 1) {
					booleanMap.put(target, ++count);
				}
			}
		}
		booleanMap.put(target, count);
		return count;
	}
	
	
	public static void main(String[] args) {
		
		CountConstruct countConstruct = new CountConstruct();
		String[] wordBank = new String[] {"purp", "p", "ur", "le", "purpl"  };
		int ans = countConstruct
				.countConstructRec("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"});
		System.out.println(ans);
		int ways = countConstruct
				.countConstructMemo("purple", wordBank);
		System.out.println(ways);
		
	}

}
