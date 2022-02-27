package com.javabasics.dynamicprogramming.memoization;

import java.util.*;

public class FibMemoization {
	
	Long sum = 0L;
	Map<Integer, Long> valueMap = new HashMap<>();
	public Long fibonnaciRec (int num) {
		
		if (num < 3) {
			return 1L;
		}
		if (valueMap.containsKey(num)) {
			return valueMap.get(num);
		}
		sum = fibonnaciRec(num - 1) + fibonnaciRec(num - 2);
		valueMap.put(num, sum);
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		FibMemoization fibonnaciSeq = new FibMemoization();
		Long num = fibonnaciSeq.fibonnaciRec(5);
		System.out.println(num);
	}

}
