package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class GreatString {
	
	public String makeGood(String s) {
        
		 Deque<Character> stringStack = new ArrayDeque<Character>();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            
	            if (Character.isUpperCase(c)) {
	                if (!stringStack.isEmpty()) {
	                  if (Character.toLowerCase(c) == stringStack.peek()) {
	                    stringStack.pop();
	                  }  
	                  else {
	                	  stringStack.push(c);
	                  }
	                }
	                else {
	                    stringStack.push(c);
	                }
	            }
	            else if (!stringStack.isEmpty() && Character.isUpperCase(stringStack.peek()) && c == Character.toLowerCase(stringStack.peek())) {
	            	stringStack.pop();
	            }
	            else {
	                stringStack.push(c);
	            }
	        }
	        Iterator<Character> itr = stringStack.descendingIterator();
	 
	        while (itr.hasNext()) {
	            sb.append(itr.next());
	        }

	        return sb.toString();
    }
	
	public static void main(String[] args) {
		GreatString greatString = new GreatString();
		String ans = greatString.makeGood("Hvh");
		System.out.println(ans);
	
	}

}
