package com.javabasics.linkedlist;

public class DoublyLinkedList {
	
	DoublyNode head;
	
	public void insertAtHead(int data) {
		DoublyNode newNodeToadd = new DoublyNode(data);
		if (head == null) {
			 head = newNodeToadd;
		}
		else {
			
			newNodeToadd.setNextNode(head);
			System.out.println("newNodeToadd.setNextNode: "+ newNodeToadd.getNextNode().data);
			head.setPrevNode(newNodeToadd);
			System.out.println("head.setPrevNode: "+ head.getPrevNode().data);
			head = newNodeToadd;
			System.out.println("head: "+ head.data);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertAtHead(50);
		dll.insertAtHead(47);
		dll.insertAtHead(36);
		dll.insertAtHead(27);
		dll.insertAtHead(17);
		dll.insertAtHead(7);
		DoublyNode current = dll.head;
		while (current != null) {
			System.out.println("Data: "+ current.data);
			current = current.getNextNode();
		}
		
	}
	
	

}

class DoublyNode {
	
	int data;
	DoublyNode next;
	DoublyNode prev;
	
	DoublyNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public DoublyNode getNextNode() {
		return next;
	
	}
	
	public void setNextNode(DoublyNode next) {
		this.next = next;
	}
	
	public DoublyNode getPrevNode() {
		return prev;
	
	}
	
	public void setPrevNode(DoublyNode prev) {
		this.prev = prev;
	}
}
