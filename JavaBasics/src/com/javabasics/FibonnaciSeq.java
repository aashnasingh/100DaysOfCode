package com.javabasics;


/**
 * @author aashnasingh
 * 
 * 1,1,2,3,5,8,13
 *
 */
public class FibonnaciSeq {
	int sum = 0;
	public int fibonnaciRec (int num) {
		return num >= 3 ? sum = fibonnaciRec(num - 1) + fibonnaciRec(num - 2) : 1;
	}
	
	public static void main(String[] args) {
		
		FibonnaciSeq fibonnaciSeq = new FibonnaciSeq();
		int num = fibonnaciSeq.fibonnaciRec(5);
		System.out.println(num);
	}

}
