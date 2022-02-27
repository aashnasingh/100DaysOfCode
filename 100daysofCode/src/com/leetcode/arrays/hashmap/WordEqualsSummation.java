
package com.leetcode.arrays.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aashnasingh
 * 
 *Input: firstWord = "acb", secondWord = "cba", targetWord = "cdb"
 *Output: true
 *Explanation:
 *The numerical value of firstWord is "acb" -> "021" -> 21.
 *The numerical value of secondWord is "cba" -> "210" -> 210.
 *The numerical value of targetWord is "cdb" -> "231" -> 231.
 *We return true because 21 + 210 == 231.
 *
 */
public class WordEqualsSummation {
public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        Map<String, String> alphabetMap = new HashMap<String, String>();
        alphabetMap.put("a", "0");
        alphabetMap.put("b", "1");
        alphabetMap.put("c", "2");
        alphabetMap.put("d", "3");
        alphabetMap.put("e", "4");
        alphabetMap.put("f", "5");
        alphabetMap.put("g", "6");
        alphabetMap.put("h", "7");
        alphabetMap.put("i", "8");
        alphabetMap.put("j", "9");
        String firstStr = "0";
        String secondStr = "0";
        String thirdStr = "0";
        
        int possibleLength = firstWord.length() >= secondWord.length() ? firstWord.length() : secondWord.length();
        int lengthLoop = possibleLength >= targetWord.length() ? possibleLength : targetWord.length();
        
        char[] tempFirst = firstWord.toCharArray();
        char[] tempSecond = secondWord.toCharArray();
        char[] tempThird = targetWord.toCharArray();
        int firstCounter = firstWord.length();
        int secondCounter = secondWord.length();
        int thirdCounter = targetWord.length();
        
        for (int i = 0; i < lengthLoop; i++) {
            
            if (firstCounter != 0) {
                char key = tempFirst[i];
				firstStr= firstStr.concat(alphabetMap.get(Character.toString(key)));
                firstCounter--;
            }
            if (secondCounter != 0) {
            	
            	secondStr = secondStr.concat(alphabetMap.get(Character.toString(tempSecond[i])));
                secondCounter--;
            }
            if (thirdCounter != 0) {
            	thirdStr = thirdStr.concat(alphabetMap.get(Character.toString(tempThird[i])));
                thirdCounter--;
            }
        }
        System.out.println(firstStr + "-" +secondStr + "-" +thirdStr);
        if (Integer.parseInt(firstStr) + Integer.parseInt(secondStr) != Integer.parseInt(thirdStr)) {
            return false;
        }
        return true; 
    }

	public static void main(String[] args) {
		WordEqualsSummation WordEqualsSummation = new WordEqualsSummation();
		boolean result = WordEqualsSummation.isSumEqual("acb", "cba", "cdb");
		System.out.println(result);
	}

}
