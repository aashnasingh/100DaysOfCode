package com.javabasics;

public class LinkedListRecursive {
	
	NodeRd head;
	
	public <T> void append(T data) {
		NodeRd newNodeToAdd = new NodeRd(data); 
		if (head == null) {
			head = newNodeToAdd;
			return;
		}

		NodeRd current = head;
		appendRec(newNodeToAdd, current);
		
		
	}

	private <T> void appendRec(NodeRd newNodeToAdd, NodeRd current) {
		
		if (current.getNext() == null) {
			current.setNext(newNodeToAdd);
			return;
		}
		appendRec(newNodeToAdd, current.getNext());
		
	}
	
	<T> NodeRd deleteVal(NodeRd head, T data) {
		
		if (head == null) {
			return head;
		}
		if (head.getData() == data) {
			head = head.getNext();
			this.head = head;
			return head;
		}

		deleteValRec(head, null, data);
		
		return head;
	}
	
	private <T> void deleteValRec(NodeRd current, NodeRd prev, T data) {
		if (current == null) {
			return;
		}
		
		if (current.getData() == data) {
			prev.setNext(current.getNext());
			return;
		}
		
		
		deleteValRec(current.getNext(), current, data);
	}

	public void printAll() {
		NodeRd current = head;
		printRec(current, 0);
	}

	private void printRec(NodeRd current, int index) {
		
		if (current == null) {
			return;
		}
		
		System.out.println("Element at index " + index + " : " + current.getData());
		printRec(current.getNext(), ++index);
		
	}
	
	public <T> boolean contains(T data) {
		NodeRd current = head;		
		return containsRec(current, data);
	}

	private <T> boolean containsRec(NodeRd current, T data) {
		
		if (current == null) {
			return false;
		}
		if (current.getData() == data) {
			return true;
		}
		return containsRec(current.getNext(), data);		
	}
	
	public int add() {
		
		return addRec(head);
		
	}

	private int addRec(NodeRd current) {
		if (current == null) {
			return 0;
		}
		int curValue = 0;
		if (current.getData() instanceof Integer) {
			curValue = (int)current.getData();
		}
		return curValue + addRec(current.getNext());
	}
	
	public <T> void insertAtIndex(int index, T data) {
		NodeRd newNodeToAdd = new NodeRd(data);
		if (head == null) {
			head = newNodeToAdd;
			return;
		}
		insertAtIndexRec(index, 0, newNodeToAdd, head);
	}

	private void insertAtIndexRec(int index, int currIndex, NodeRd newNodeToAdd, NodeRd current) {
		
		if (currIndex == index - 1) {
			newNodeToAdd.setNext(current.getNext());
			current.setNext(newNodeToAdd);
			return;
		}
		insertAtIndexRec(index, ++currIndex, newNodeToAdd, current.getNext());
	}
	
	public NodeRd reverseLL(NodeRd head) {
		
		if (head == null) {
			return head;
		}
		NodeRd current = head;
		NodeRd prev = null;
		
		NodeRd newHead = reverseRec(current, prev);
		
		return newHead;
		
	}
	
	private NodeRd reverseRec(NodeRd current, NodeRd prev) {
		
		if (current == null) {
			return prev;
		}
		
		NodeRd next = current.getNext();
		current.setNext(prev);
		prev = current;
		current = next; 
		
		return reverseRec(current, prev);
	}

	public void printByHead(NodeRd head) {
		int index = 0;
		NodeRd current = head;
		
		printByHeadRec(current, index);
	}

	private void printByHeadRec(NodeRd current, int index) {
		
		if (current == null) {
			return;
		}
		
		System.out.println("Element at index " + index + " : " + current.getData());
		printByHeadRec(current.getNext(), ++index);
		
		
	}
	
	private NodeRd addOne(NodeRd head) {
		
		int carry = calculateCarryRec(head);
		
		return head;
	}

	private int calculateCarryRec(NodeRd head2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		LinkedListRecursive linkedListRecursive = new LinkedListRecursive();
		linkedListRecursive.append("Start");
		linkedListRecursive.deleteVal(linkedListRecursive.head, "Start");
		linkedListRecursive.append(3);
		linkedListRecursive.append(5);
		linkedListRecursive.append(6);
		linkedListRecursive.append("End");
		linkedListRecursive.insertAtIndex(2, 4);
		linkedListRecursive.deleteVal(linkedListRecursive.head, 6);
		linkedListRecursive.printAll();
		int sum = linkedListRecursive.add();
		System.out.println("Sum is : " + sum);
		boolean contains = linkedListRecursive.contains(5);
		System.out.println("Is 5 present in the Linked List : " + contains);
		NodeRd newHead = linkedListRecursive.reverseLL(linkedListRecursive.head);
		linkedListRecursive.printByHead(newHead);
	}

}
