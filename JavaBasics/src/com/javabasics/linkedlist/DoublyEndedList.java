package com.javabasics.linkedlist;

public class DoublyEndedList {
	
	private Node head;
	private Node tail;
	
	public void insertAtTail (int data) {
		Node newNodeToAdd = new Node(data);
		
		if(head == null) {
			head = newNodeToAdd;
		}
		if (tail != null) {
			tail.setNextNode(newNodeToAdd);
			tail = newNodeToAdd;
		}
	}
	
	public static void main(String[] args) {
		DoublyEndedList dll = new DoublyEndedList();
		dll.insertAtTail(10);
		dll.insertAtTail(18);
		
	}

}
