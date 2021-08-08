package com.javabasics;

public class LinkedListRevisited {
	
	NodeRd head;
	
	public <T> void insert(T data) {
		NodeRd newNodeToAdd = new NodeRd(data);
		if (head != null) {
			newNodeToAdd.setNext(head);
		}
		head = newNodeToAdd;
		
	}
	
	public <T> void append(T data) {
		NodeRd newNodeToAdd = new NodeRd(data);
		if (head == null) {
			head = newNodeToAdd;
		}
		else {
			NodeRd current = head;
			while (current.next != null) {
				current = current.getNext();
			}
			current.setNext(newNodeToAdd);
		}
	}
	
	public <T> void insertAtIndex(T data, int index) {
		NodeRd newNodeToAdd = new NodeRd(data);
		
		if (head == null) {
			head = newNodeToAdd;
		}
		else {
			int currIndex = 0;
			NodeRd current = head;
			while (current != null) {
				if (currIndex == index - 1) {
					newNodeToAdd.setNext(current.getNext());
					current.setNext(newNodeToAdd);
					break;
				}
				currIndex++;
				current = current.getNext();
			}
		}
	}
	
	public <T> NodeRd deleteVal(NodeRd head, T data) {
		
		if (head == null) {
			return head;
		}
		
		if (head.getData() == data) {
			head = head.getNext();
			this.head = head;
			return head.getNext();
		}
		
		NodeRd current = head;
		
		while (current != null) {
			if ( current.getNext().getData() == data) {
				current.setNext(current.getNext().getNext());
				break;
			}
			current = current.getNext();
		}

		return head;
		
	}
	
	public <T> NodeRd deleteValSecMethod(NodeRd head, T data) {
		
		if (head == null) {
			return head;
		}
		
		if (head.getData() == data) {
			head = head.getNext();
			this.head = head;
			return head;
		}
		
		NodeRd prev = null;
		NodeRd current = head;
		
		while (current != null) {			
			if (current.getData() == data) {
				prev.setNext(current.getNext());
				break;
			}
			prev = current;
			current = current.getNext();
		}
		
		return head;
	}
	
	public void printAll() {
		int index = 0;
		NodeRd current = head;
		while (current != null) {
			System.out.println("Element at index " + index + " : " + current.getData());
			current = current.getNext();
			index++;
		}
	}
	
	public <T> boolean contains(T data) {

		NodeRd current = head;
		while (current != null) {
			if (current.getData() == data) {
				return true;
			}
			current = current.getNext();
		}
		
		return false;
	}
	
	public int add() {

		NodeRd current = head;
		int sum = 0;
		while (current != null) {
			if (current.getData() instanceof Integer) {
				sum = sum + (int)current.getData();
			}
			current = current.getNext();
		}		
		return sum;
		
	}
	
	public NodeRd reverseLL(NodeRd head) {
		
		if (head == null) {
			return head;
		}
		NodeRd current = head;
		NodeRd prev = null;
		while (current != null) {	
			NodeRd next = current.getNext();
			current.setNext(prev);
			prev = current;	
			current = next;
		}
		return prev;
		
	}
	
	public void printByHead(NodeRd head) {
		int index = 0;
		NodeRd current = head;
		while (current != null) {
			System.out.println("Element at index " + index + " : " + current.getData());
			current = current.getNext();
			index++;
		}
	}
	
	public static void main(String[] args) {
		LinkedListRevisited llr = new LinkedListRevisited();
		llr.insert(3);
		llr.deleteValSecMethod(llr.head, 3);
		llr.insert("Start");
		llr.append(5);
		llr.append(6);		
		llr.append("End");
		llr.insertAtIndex(4, 2);
		llr.deleteVal(llr.head, "End");
		llr.printAll();	
		int sum = llr.add();
		System.out.println("Sum is : " + sum);
		boolean contains = llr.contains("Start");
		System.out.println("Is Start present in the Linked List : " + contains);
		NodeRd newHead = llr.reverseLL(llr.head);		
		llr.printByHead(newHead);	
	}
	

}

class NodeRd<T> {
	
	T data;
	NodeRd next;
	
	NodeRd(T data) {
		this.data = data;
	}
	
	public NodeRd getNext() {
		return next;
	}

	public void setNext(NodeRd next) {
		this.next = next;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	
	
}
