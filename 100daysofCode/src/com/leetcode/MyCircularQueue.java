package com.leetcode;

class MyCircularQueue {
    
    Node[] nodeArray;
    Node tail;
    int size;
    int capacity;
    public MyCircularQueue(int k) {
        nodeArray = new Node[k];
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            size++;
            return true;
        }
        if (size == capacity) {
            return false;
        }                
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (tail != null) {
            tail.next = tail.next.next;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (tail != null) {
            return tail.next.data;
        }
        return -1;
    }
    
    public int Rear() {
        if (tail != null) {
            return tail.data;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if (tail == null) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }
    
    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
    	MyCircularQueue myCircularQueue = new MyCircularQueue(3);
    	myCircularQueue.enQueue(1); // return True
    	myCircularQueue.enQueue(2); // return True
    	myCircularQueue.enQueue(3); // return True
    	myCircularQueue.enQueue(4); // return False
    	myCircularQueue.Rear();     // return 3
    	myCircularQueue.isFull();   // return True
    	myCircularQueue.deQueue();  // return True
    	myCircularQueue.enQueue(4); // return True
    	myCircularQueue.Rear();     // return 4   

	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
