package com.javabasics;

class MyHashMapInt {

	EntryInt[] bucket;
    private static int SIZE = 7;
    /** Initialize your data structure here. */
    public MyHashMapInt() {        
        bucket = new EntryInt[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = Math.abs(key % SIZE);

        if (bucket[hashCode] == null) {
            bucket[hashCode] = new EntryInt(key, value);
            return;
        }
        EntryInt getEntry = bucket[hashCode];
        
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
        getEntry.next = new EntryInt(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = Math.abs(key % SIZE);
        
        EntryInt getEntry = bucket[hashCode];
        
        if (getEntry != null) {
            while (getEntry != null) {
                if (getEntry.getKey() == key) {
                    return getEntry.getValue();
                }
                getEntry = getEntry.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = Math.abs(key % SIZE);
        
        EntryInt getEntry = bucket[hashCode];
        
        if (getEntry != null) {
            if (getEntry.getKey() == key) {
                this.bucket[hashCode] = getEntry.next;
                return;
            }
            EntryInt prev = getEntry;
            getEntry = getEntry.next;
            while (getEntry != null) {
                if (getEntry.getKey() == key) {
                    prev.next = getEntry.next;
                    return;
                }
                getEntry = getEntry.next;
            }
        }
    }
    
    void printAll() {
		 for (int i = 0; i < bucket.length; i++) {
			 System.out.println("Index :" + i + " - " + bucket[i]);
		 }
	 }
    
    public static void main( String[] args) {
    	MyHashMapInt myHashMap = new MyHashMapInt();
    	myHashMap.put(1, 1); // The map is now [[1,1]]
    	myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    	myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    	myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    	myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    	myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    	myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    	myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    	myHashMap.printAll();
    }
}

 class EntryInt {
    private int key;
    private int value;
    EntryInt next;
    
    public EntryInt(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
	 public String toString() {
		EntryInt temp = this;
		StringBuilder sb = new StringBuilder();
		while(temp != null ) {
			sb.append(temp.getKey() + " : " + temp.getValue() + " -> ");
			temp = temp.next;
		}
		return sb.toString();
	 }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */