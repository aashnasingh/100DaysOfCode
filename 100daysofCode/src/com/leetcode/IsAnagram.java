package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
	
	 public boolean isAnagram(String s, String t) {
	        Map<Character, Integer> countMap = new HashMap<>();
	        if (s.length() != t.length()) {
	            return false;
	        }
	        for (int i = 0; i < s.length(); i++) {
	            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
	            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
	        }
	        for (char c: countMap.keySet()) {
	            if (countMap.get(c) != 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		IsAnagram IsAnagram = new IsAnagram();
		boolean ans = IsAnagram.isAnagram("anagram", "nagaram");
		System.out.println(ans);
	}

}
