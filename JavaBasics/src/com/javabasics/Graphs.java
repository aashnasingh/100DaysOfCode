package com.javabasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graphs<T> {
	
	Map<T, List<T>> adjacencyList = new HashMap<>();
	
	private Graphs() {}
	
	private Graphs(Map<T, List<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	private void addEdge(T source, T vertice) {
		if (vertice != null && vertice != "") {
			if (adjacencyList.containsKey(source)) {
				adjacencyList.get(source).add(vertice);
			}
			else {
				List<T> list = new ArrayList<T>();
				list.add(vertice);
				adjacencyList.put(source, list);
			}
		}
		else {
			List<T> list = new ArrayList<T>();
			adjacencyList.put(source, list);			
		}
	}
	
	private void dfsPrint(T source) {
		Stack<T> stack = new Stack<>();
		stack.push(source);
		while (stack.size() > 0) {
			T curr = stack.pop();
			System.out.println(curr);
			List<T> currList = adjacencyList.get(curr);
			if (currList !=  null && !currList.isEmpty()) {
				for (T v : currList) {
					stack.push(v);
				}
			}			
		}
	}
	
	private void dfsRecPrint(T source) {
		System.out.println(source);
		List<T> currList = adjacencyList.get(source);
		if (currList !=  null && !currList.isEmpty()) {
			for (T v : currList) {
				dfsRecPrint(v);
			}
		}	
	}
	
	private void bfsPrint(T source) {
		Queue<T> q = new LinkedList<>();
		q.add(source);
		while (q.size() > 0) {
			T curr = q.remove();
			System.out.println(curr);
			List<T> currList = adjacencyList.get(curr);
			if (currList !=  null && !currList.isEmpty()) {
				for (T v : currList) {
					q.add(v);
				}
			}
		}
	}
	
	Set<T> visited = new HashSet<>();
	public boolean hasPath(T source, T destination) {
		
		if (source == destination) return true;
		
		List<T> currList = adjacencyList.get(source);
		if (currList !=  null && !currList.isEmpty()) {
			for (T v : currList) {
				if (!visited.contains(v)) {
					visited.add(v);
					boolean has = hasPath(v, destination);
					if (has) return true;
				}				
			}
		}
		
		return false;
	}
	
	int count = 0;
	Set<T> visiteds = new HashSet<T>();
	private int connectedComponents() {
		
		for (T v : adjacencyList.keySet()) {
			if (!visiteds.contains(v)) {
				dfsCountComponents(v);
				count++;
			}			
		}
		return count;
	}
	
	private void dfsCountComponents(T v) {
		if (!visiteds.contains(v)) {
			visiteds.add(v);
			for (T neighbors : adjacencyList.get(v)) {
				dfsCountComponents(neighbors);
			}
		}
	}
	
	Set<T> visitedss = new HashSet<T>();
	private int largestComponents() {
		int largest = Integer.MIN_VALUE;
		for (T v : adjacencyList.keySet()) {
			if (!visitedss.contains(v)) {
				dfsLargestComponent(v);
				largest = Math.max(largest, dfsCount);
				this.dfsCount = 0;
			}			
		}
		return largest;
	}
	
	int dfsCount = 0;
	private void dfsLargestComponent(T v) {		
		if (!visitedss.contains(v)) {
			visitedss.add(v);
			dfsCount++;
			for (T neighbors : adjacencyList.get(v)) {
				dfsCountComponents(neighbors);				
			}
		}
	}

	public static void main(String[] args) {
		Graphs graphs = new Graphs();
		graphs.addEdge("0", "8");
		graphs.addEdge("0", "1");
		graphs.addEdge("0", "5");
		graphs.addEdge("1", "0");
		graphs.addEdge("5", "0");
		graphs.addEdge("5", "8");
		graphs.addEdge("8", "0");
		graphs.addEdge("8", "5");
		graphs.addEdge("2", "3");
		graphs.addEdge("2", "4");
		graphs.addEdge("3", "2");
		graphs.addEdge("3", "4");
		graphs.addEdge("4", "3");
		graphs.addEdge("4", "2");
		//graphs.addEdge("n", "o");
		System.out.println(graphs.adjacencyList);
//		System.out.println("DFS - ");
//		graphs.dfsPrint("i");
//		System.out.println("BFS - ");
//		graphs.bfsPrint("i");
//		System.out.println("DFS Rec - ");
//		graphs.dfsRecPrint("i");		
		boolean ans = graphs.hasPath("k", "o");
		System.out.println("Has Path - " +ans);
		int count = graphs.connectedComponents();
		System.out.println("Connected components - " + count);
		int largest = graphs.largestComponents();
		System.out.println("Largest component - " + largest);
	}

}

