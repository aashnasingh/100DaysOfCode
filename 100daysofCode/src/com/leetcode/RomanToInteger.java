package com.leetcode;

import java.util.HashMap;

public class RomanToInteger {
	
	public static int romanToInt(String s) {
        int sumValue = 0;
        HashMap<Character, Integer> romanValueMapping = new HashMap<Character, Integer>();
        romanValueMapping.put('I',1);
        romanValueMapping.put('V',5);
        romanValueMapping.put('X',10);
        romanValueMapping.put('L',50);
        romanValueMapping.put('C',100);
        romanValueMapping.put('D',500);
        romanValueMapping.put('M',1000);
        int arrayLengthTrack = s.length() - 1;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
			char temp = charAt;
            if (i != arrayLengthTrack) {
                char charAt2 = s.charAt(i+1);
				if ('I' == (charAt)) {
                    if ('V' == (charAt2) || 'X' == (charAt2)) {
                        sumValue = sumValue - 1;
                        flag = true;
                    }
                }
                else if ('X' == (charAt)) {
                    if ('L' == (charAt2) || 'C' == (charAt2)) {
                        sumValue -= 10;
                        flag = true;
                    }
                } 
                else if ('C' == (charAt)) {
                    if ('D' == (charAt2) || 'M' == (charAt2)) {
                        sumValue -= 100;
                        flag = true;
                    }
                } 
				if (flag == true) {
					flag = false;
					
				}
				else if (flag == false){
					sumValue += romanValueMapping.get(temp);
				}
                
            }
            else {
            	sumValue += romanValueMapping.get(temp);
            }
            
            
        }
        return sumValue;
    }
	
	public static void main(String[] args) {

		int ans = romanToInt("MCMXCIV");
		
		System.out.println(ans);

	}

}
