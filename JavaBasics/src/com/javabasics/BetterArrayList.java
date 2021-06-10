package com.javabasics;

import java.util.ArrayList;

public class BetterArrayList extends ArrayList{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 335098427607738842L;

	public Object pop(ArrayList arr) {
		int lastIndex = arr.size() - 1;
		return arr.subList(0, lastIndex);
		
		
	}
	
	public void printList(ArrayList arr) {
		for (Object o : arr) {
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		BetterArrayList barr = new BetterArrayList();
		barr.add("aashna");
		barr.add(4);
		barr.add(1);
		barr.add(5);
		barr.add(3);
		barr.printList(barr);
		System.out.println(barr.pop(barr));
	}

}
