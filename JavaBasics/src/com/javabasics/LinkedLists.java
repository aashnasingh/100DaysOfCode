package com.javabasics;

public class LinkedLists {
	
	 Node head;
	
	public void add(int data) {
 		Node newNodetoAdd = new Node(data);
		if (head == null) {

			head = newNodetoAdd;
		}
		else {
			newNodetoAdd.setNextNode(head);
			//newNodetoAdd.next = head;
			head = newNodetoAdd;
		}
	}
	
	public static void main(String[] args) {
		LinkedLists ls = new LinkedLists();
		ls.add(10);
		ls.add(18);
		Node current = ls.head;
		while (current != null) {
			System.out.println(current.data);
			//current = current.next;
			current = current.getNextNode();
		}
//		System.out.println(ls.head.data);
//		System.out.println(ls.head.next.data);
		
		
	}

}

class Node {
	
	int data;
	Node next;
	
	Node(int d) {
		data = d;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int d) {
		data = d;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public void setNextNode(Node nextNode) {
		next = nextNode;
	}
	
	
}


