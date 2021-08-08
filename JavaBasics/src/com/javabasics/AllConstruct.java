package com.javabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {
	
	Map<String, Integer> booleanMap = new HashMap<>();
	
	Map<String, List<List<String>>> allWaysMap = new HashMap<>();
	public List<List<String>> allConstructRec(String target, String[] wordBank) {
		
		if (target.isBlank()) {
			return new ArrayList<>(Arrays.asList(new ArrayList<>()));
		}
		List<List<String>> allWaysList = new ArrayList<>();
		for (int i = 0; i < wordBank.length; i++) {
			String wordCombo = wordBank[i];
			if (target.indexOf(wordCombo) == 0) {
				String suffix = target.substring(wordCombo.length());				
				List<List<String>> combinationsList = allConstructRec(suffix, wordBank);
				combinationsList.stream().forEach(way -> way.add(0, wordCombo));
				allWaysList.addAll(combinationsList);
			}
		}

		return allWaysList;
	}
	
	public List<ArrayList<String>> allConstructMemo(String target, String[] wordBank) {

		List<ArrayList<String>> allWaysList = null;
		
		return allWaysList;
	}
	
	
	public static void main(String[] args) {
		
		AllConstruct allConstruct = new AllConstruct();
		String[] wordBank = new String[] {"purp", "p", "ur", "le", "purpl"  };
		int[] wordBanks = new int[] {2,5,3,4,1};
		int[] wordBankss = Arrays.copyOfRange(wordBanks, 0, wordBanks.length - 1);
		System.out.println(Arrays.toString(wordBankss));
		List<List<String>> ans = allConstruct
				.allConstructRec("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"});
		System.out.println(ans);
		List<ArrayList<String>> ways = allConstruct
				.allConstructMemo("purple", wordBank);
		System.out.println(ways);
	}

}
