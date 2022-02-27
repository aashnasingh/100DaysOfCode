package com.leetcode.linkedlist;

public class MaxStack {
	
	class StackNode {
		
		public StackNode(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public StackNode getNext() {
			return next;
		}
		public void setNext(StackNode next) {
			this.next = next;
		}
		public StackNode getPrev() {
			return prev;
		}
		public void setPrev(StackNode prev) {
			this.prev = prev;
		}
		int data;
		StackNode next;	
		StackNode prev;	
	}
	
	void push() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
