package com.javabasics.linkedlist;

import java.util.LinkedList;

/**
 * @author aashnasingh
 * 
 * Implement hash map
 * @param <K>
 * @param <V>
 *
 */
public class MyHashMap<K, V> {
	
	private static int SIZE = 5; //initiallyi 2^4
	
	private Entry<K, V> table[];
	
	
	public MyHashMap() {
		table = new Entry[SIZE];
	}
	
	public void put(K key, V value) {
		int hashcode = key.hashCode() % SIZE; //get hashcode(basically a random number and mod by size would give an int position for the array
		LinkedList getEntry1 =new LinkedList();
		Entry<K, V> getEntry = table[hashcode];
		if (getEntry == null) {
			table[hashcode] = new Entry(key, value);
			return;
		}
		
		if (getEntry.getKey() == key) {
            getEntry.setValue(value);
            return;
        }
		while (getEntry.next != null) {
			if (getEntry.getKey() == key) {
				getEntry.setValue(value);
				return;
			}
			getEntry = getEntry.next;
		}

		getEntry.next = new Entry(key, value);

	}
	
	public V get(K key) {
		
		int hashcode = key.hashCode() % SIZE;
		
		Entry<K, V> getEntry = table[hashcode];
		
		while (getEntry != null) {
			if (getEntry.getKey() == key) {
				return getEntry.getValue();
			}
			getEntry = getEntry.next;
		}
		
		return null;
	}
	
	 public Entry remove(K key) {
		 
		int hashcode = key.hashCode() % SIZE;
		 
		Entry<K, V> getEntry = table[hashcode];
		if (getEntry != null) {
			if (getEntry.getKey() == key) {
				this.table[hashcode] = getEntry.next;
				getEntry.next = null;
				return getEntry;
			}
			Entry<K, V> prev = getEntry;
			getEntry = getEntry.next;
			while (getEntry != null) {
				if (getEntry.getKey() == key) {
					prev.next = getEntry.next;
					getEntry.next = null;
					return getEntry;
				}
				prev = getEntry;
				getEntry = getEntry.next;
				
			}	
		}
		return null;
		 
	 }
	 
	 void printAll() {
		 for (int i = 0; i < table.length; i++) {
			 System.out.println("Index :" + i + " - " + table[i]);
		 }
	 }
	 
	 
	 public static void main( String[] args) {
		 MyHashMap myHashMap = new MyHashMap();
		 myHashMap.put(1, 2);
		 myHashMap.put(2, "Hello");
		 myHashMap.put("Array", "LL");
		 myHashMap.printAll();
		 int value = (int) myHashMap.get(1);
		 System.out.println(value);
		 Entry getEntry = myHashMap.remove("Array");
		 myHashMap.printAll();
	 }

}

//LinkedList
class Entry<K, V> {		
	K key;
	V value;
	Entry<K, V> next;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	 @Override
	 public String toString() {
		Entry<K, V> temp = this;
		StringBuilder sb = new StringBuilder();
		while(temp != null ) {
			sb.append(temp.getKey() + " : " + temp.getValue() + " -> ");
			temp = temp.next;
		}
		return sb.toString();
	 }
}
