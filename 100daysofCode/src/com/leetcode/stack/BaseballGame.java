package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BaseballGame {
	
	public int calPoints(String[] ops) {
        
        List<Integer> scoreList = new ArrayList<Integer>();
        Stack<Integer> scoreStack = new Stack<>();
        int sum = 0;
//        int pointer = 0;
//        boolean flag = false;
//        for (int i = 0; i < ops.length; i++) {
//            if ("+".equals(ops[i])) {
//
//                scoreList.add(scoreList.get(pointer) + scoreList.get(pointer-1));
//                pointer++;
//            }
//            else if ("D".equals(ops[i])) {
//
//                scoreList.add(2*scoreList.get(pointer));
//                pointer++;
//            }
//            else if ("C".equals(ops[i])) {
//                scoreList.remove(scoreList.get(pointer));
//                flag = true;
//                pointer--;
//            }
//            else {
//            	if (flag) {
//               	 pointer = scoreList.size();
//               }
//               else {
//               	pointer = i;
//               }
//                scoreList.add(Integer.parseInt(ops[i]));
// 
//            }
//        }
        
        for (int i = 0; i < ops.length; i++) {
        	
        	if ("+".equals(ops[i])) {

                int top = scoreStack.pop();
                int newTop = top + scoreStack.peek();
                scoreStack.push(top);
                scoreStack.push(newTop);
            }
            else if ("D".equals(ops[i])) {

            	scoreStack.add(2*scoreStack.peek());

            }
            else if ("C".equals(ops[i])) {
            	scoreStack.pop();
   
            }
            else {
            	
            	scoreStack.push(Integer.parseInt(ops[i]));
 
            }
        	
        }
        
        for (Integer s : scoreStack) {
        	sum += s;
        }
        
//        for (Integer j : scoreList) {
//            sum += j;
//        }
        
        return sum;
    }

	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		String[] arr = new String[]{"5","-2","4","C","D","9","+","+"};
		int sum = baseballGame.calPoints(arr);
		System.out.println(sum);
	
	}

}
