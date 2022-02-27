package com.javabasics.recursion;

public class Factorial {
	
	public int factorialRecusion (int num) {

		return num >= 1 ? num * factorialRecusion(num-1) : 1;
		
	}

	public static void main(String[] args) {
		
		Factorial factorial = new Factorial();
		int num = factorial.factorialRecusion(5);
		System.out.println(num);
	}

}
