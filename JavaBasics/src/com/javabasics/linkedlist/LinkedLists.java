package com.javabasics.linkedlist;

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
	
	public int lengthLinkedList() {
		int counter = 0;
		
		Node current = head;
		
		while (current != null) {
			counter++;
			current = current.getNextNode();
		}
		
		return counter;
		
	}
	
	public void deleteHeadNode() {

		head = head.getNextNode();
	}
	
	public void iterateLL(Node current) {
		int index = 0;
		
		while (current != null) {
			System.out.println("Index: " + index + ", Data: "+ current.data);
			//current = current.next;
			index++;
			current = current.getNextNode();
		}
	}
	
	public int searchData(int data) {
		boolean flag = false;
		Node current = head;
		int index = 0;
		while (current !=  null) {
			if (current.getData() == data) {
				flag = true;
				break;
			}
			current = current.getNextNode();
			index++;
		}
		if(flag) {
			return index;
		}
		return -1;
	}
	
	public void insertInSortedList(int data) {
		Node newNodeToAdd = new Node(data);
		Node current = head;
		if (head == null) {
			head = newNodeToAdd;
		}
		else {
			if (head.data > data) {
				newNodeToAdd.setNextNode(head);
				head = newNodeToAdd;
			}
			else {
				while (current.getNextNode() != null) {
					
					if (data < current.getNextNode().data) {
						newNodeToAdd.setNextNode(current.getNextNode());
						current.setNextNode(newNodeToAdd);
						
						current = newNodeToAdd;
						break;
						
					}
					
					current = current.getNextNode();
					
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		LinkedLists ls = new LinkedLists();
		int lengthLL = 0;
		ls.add(54);
		ls.add(43);
		ls.add(34);
		ls.add(23);
		ls.add(20);
		ls.add(18);
		ls.add(10);
		ls.insertInSortedList(29);
		Node current = ls.head;
		ls.iterateLL(current);
		lengthLL = ls.lengthLinkedList();
		System.out.println("Length" +lengthLL);
		ls.deleteHeadNode();
		current = ls.head;
		ls.iterateLL(current);
		lengthLL = ls.lengthLinkedList();
		System.out.println("Length" +lengthLL);
		int searchIndex = ls.searchData(10);
		if (searchIndex == -1) {
			System.out.println("Data does not exist in linked list");
		}
		else {
			System.out.println("Index of searched Data: " + searchIndex);
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


