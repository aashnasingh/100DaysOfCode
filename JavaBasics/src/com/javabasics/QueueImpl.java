package com.javabasics;

import java.util.Arrays;

public class QueueImpl {
	
	static int intSize = 9;
	int top = -1;
	int start = 0;
	static Integer[] arr = new Integer[intSize];
	
	public void enqueue(int num) {	
		if (top <= intSize - 1)
			arr[++top] = num;	
	}
	
	public int dequeue() {
		if (top >= 0) {
			top--;
			return arr[start++];
		}
		return -1;
	}
	
	public int peek() {
		if (top >= 0) {
			return arr[start];
		}
		return -1;
	}
	
	public int queueSize() {
		return top+1;
	}
	
	
	public static void main(String[] args) {
		QueueImpl queueImpl = new QueueImpl();
		queueImpl.enqueue(5);
		queueImpl.enqueue(6);
		queueImpl.enqueue(2);
		queueImpl.enqueue(3);
		int peekQueue = queueImpl.peek();
		System.out.println(peekQueue);
		int popQueue = queueImpl.dequeue();
		System.out.println(popQueue);
		popQueue = queueImpl.dequeue();
		System.out.println(popQueue);
		int getQueueSize = queueImpl.queueSize();
		System.out.println(getQueueSize);
		queueImpl.enqueue(4);
		System.out.println(Arrays.toString(arr));

	}

}
