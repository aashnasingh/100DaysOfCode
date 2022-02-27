package com.javabasics.arrays;

public class StackImpl {
	
	static int intSize = 9;
	int top = -1;
	Integer[] arr = new Integer[intSize];
	
	public void push(int num) {		
		top++;
		arr[top] = num;
		
	}
	
	public int pop() {
		if (top > -1) {
			return arr[top--];
		}
		return -1;
	}
	
	public int peek() {
		if (top > -1) {
			return arr[top];
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		StackImpl stackImpl = new StackImpl();
		stackImpl.push(5);
		stackImpl.push(6);
		stackImpl.push(2);
		stackImpl.push(3);
		int peekStack = stackImpl.peek();
		System.out.println(peekStack);
		int popStack = stackImpl.pop();
		System.out.println(popStack);
		popStack = stackImpl.pop();
		System.out.println(popStack);
		

	}

}
