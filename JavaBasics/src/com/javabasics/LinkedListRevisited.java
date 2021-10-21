package com.javabasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void retainMdeleteN(NodeRd head, int m, int n) {
		 if (head == null) {
			 return;
		 }
		 if (n == 0) {
			 return;
		 }
		 if (m == 0) {
			 this.head = null;
		 }
		 NodeRd current = head;
		 NodeRd prev = null;
		 int reM = m;
		 int reN = n;
		 while (current != null) {
			 if (reM == 0 && reN != 0) {
				 prev.setNext(current.getNext());
				 current = prev.getNext();
				 reN--;
				 continue;
			 }
			 else {
				 if (reN == 0) {
					 reM = m;
					 reN = n;
				 }
				 prev = current;
				 current = current.getNext();
				 reM--;
				 
			 }
			 
		 }
		 
	}
	
	public <T> void removeDuplicates(NodeRd head) {
		
		if (head == null) {
			return;
		}
		
		List<T> listCount = new ArrayList<>();
		NodeRd current = head;
		NodeRd prev = null;
		
		while (current != null) {
			
			if (listCount.contains(current.getData())) {
				prev.setNext(current.getNext());
				current = current.getNext();
				continue;
			}
			listCount.add((T) current.getData());
			prev = current;
			current = current.getNext();
		}
	}
	
	public void addOne(NodeRd head) {
		
		if (head == null) {
			return;
		}
		
		NodeRd current = head;
		NodeRd prev = null;
		addOneRec(current, prev, 0);
	}
	
	private void addOneRec(NodeRd current, NodeRd prev, int index) {
		
		if (current == null) {
			return;
		}
		if (index != 0 && (int) current.getData() == 9) {
			prev.setData((int) prev.getData() + 1);
			current.setData(0);
		}
		if (current.getNext() == null) {
			current.setData((int) current.getData() + 1);
		}
		if (index == 0 && (int) current.getData() == 9) {
			NodeRd newNode = new NodeRd(1);
			newNode.setNext(current);
			current = newNode;
		}	
		
		addOneRec(current.getNext(), current, ++index);
	}
	
	
    public NodeRd swapPairs(NodeRd A) {

        if (A == null) return A;
        NodeRd prev = null;
        NodeRd current = A;
        boolean flag = false;
        while(current != null) {
            if (flag) {
                prev.next = current.next;
                current.next = prev;
                
            }
            else {
            	prev = current;
                current = current.next;
            }
 
            flag = !flag;
        }
        char a = 'a';

        return A;
        
        
    }
	


	public static void main(String[] args) {
		LinkedListRevisited llr = new LinkedListRevisited();
		llr.append(1);
		llr.append(2);
		llr.append(3);
		llr.append(4);
		NodeRd newHead =llr.swapPairs(llr.head);
//		NodeRd newHead = llr.reverseLL(llr.head);
//		llr.addOne(llr.head);
//		llr.insert(3);
//		llr.deleteValSecMethod(llr.head, 3);
//		llr.insert("Start");
//		llr.append("End");
//		llr.append(6);
//		llr.append(6);		
//		llr.append(7);	
//		llr.append(8);	
//		llr.append(6);	
//		llr.append(10);	
//		llr.append("End");
//		llr.insertAtIndex(4, 2);
//		llr.deleteVal(llr.head, "End");
//		llr.printAll();	
//		int sum = llr.add();
//		System.out.println("Sum is : " + sum);
//		boolean contains = llr.contains("Start");
//		System.out.println("Is Start present in the Linked List : " + contains);
//		NodeRd newHead = llr.reverseLL(llr.head);
//		llr.removeDuplicates(newHead);
//		llr.printByHead(newHead);	
//		llr.retainMdeleteN(newHead, 2, 2);
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
