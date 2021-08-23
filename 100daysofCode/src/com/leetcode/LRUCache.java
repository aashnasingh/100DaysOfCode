package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	class Node {
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		public Node() {

		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		int key;
		int value;
		Node next;
		Node prev;
		
		@Override
		public String toString() {
			Node node = this;
			StringBuilder sb = new StringBuilder();
			while (node != null) {
				sb.append(node.getKey() + " : " + node.getValue() + " -> ");
				node = node.getNext();
			}			
			return sb.toString();
		}
	}
	
	Map<Integer, Node> lruMap = new HashMap<Integer, Node>();
    private int capacity;
    private Node head;
    private Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		
		head = new Node();
		head.setPrev(null);
		
		tail = new Node();
		tail.setNext(null);
		
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	private int get(int key) {
		
		if (lruMap.containsKey(key)) {
			Node node = lruMap.get(key);
			remove(node);
			addNode(node);
			return node.getValue();
		}
		
		return -1;		
	}

	private void put(int key, int value) {
		
		if (lruMap.containsKey(key)) {
			Node node = lruMap.get(key);
			node.value = value;
			remove(node);
			addNode(node);
			return;
		}
		
		Node node = new Node(key, value);
		lruMap.put(key, node);
		if (lruMap.size() > capacity) {
			lruMap.remove(tail.getPrev().getKey());
			remove(tail.getPrev());
		}
		addNode(node);		
	}
	
	private void addNode(Node node) {
		
		node.setNext(head.getNext());
		node.getNext().setPrev(node);
		node.setPrev(head);
		head.setNext(node);	
	}
	
	private void remove(Node node) {
		
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.lruMap);
		lRUCache.get(1);    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.lruMap);
		lRUCache.get(2);    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.lruMap);
		lRUCache.get(1);    // return -1 (not found)
		lRUCache.get(3);    // return 3
		lRUCache.get(4);    // return 4
		System.out.println(lRUCache.lruMap);
	}	

}
