package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graphs {
	
	Map<String, List<String>> adjacencyList = new HashMap<>();
	
	Graphs() {}
	
	Graphs(Map<String, List<String>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	private void addEdges(List<List<String>> edges) {
		for (List<String> edge : edges) {
			String source = edge.get(0);
			String dest = edge.get(1);
			
			if (dest != null && dest != "") {
				if (adjacencyList.containsKey(source)) {
					adjacencyList.get(source).add(dest);
				}
				else {
					List<String> list = new ArrayList<String>();
					list.add(dest);
					adjacencyList.put(source, list);
				}
			}
			else {
				List<String> list = new ArrayList<String>();
				adjacencyList.put(source, list);			
			}

		}
	}
	
	private void dfsPrint(String source) {
		
		Stack<String> stack = new Stack<>();
		stack.push(source);
		while (stack.size() > 0) {
			String curr = stack.pop();
			System.out.println(curr);
			List<String> listOfEdges = adjacencyList.get(curr);
			if (listOfEdges != null && !listOfEdges.isEmpty()) {
				for (String edge : listOfEdges) {
					stack.push(edge);
				}
			}
		}	
		
	}
	
	Set<String> visited = new HashSet<>();
	private boolean hasPath(String source, String dest) {
		
		if (source == dest) return true;
		
		List<String> currList = adjacencyList.get(source);
		if (currList != null && !currList.isEmpty()) {
			for (String curr : currList) {
				if (!visited.contains(curr)) {
					visited.add(curr);
					hasPath(curr, dest);
				}	
			}
		}
		
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		Graphs graphs = new Graphs();
		List<List<String>> edges = new ArrayList<>();
		edges.add(new ArrayList<>(Arrays.asList("0", "8")));
		edges.add(new ArrayList<>(Arrays.asList("0", "1")));
		edges.add(new ArrayList<>(Arrays.asList("0", "5")));
		edges.add(new ArrayList<>(Arrays.asList("1", "0")));
		edges.add(new ArrayList<>(Arrays.asList("5", "0")));
		edges.add(new ArrayList<>(Arrays.asList("5", "8")));
		edges.add(new ArrayList<>(Arrays.asList("8", "0")));
		edges.add(new ArrayList<>(Arrays.asList("8", "5")));
		edges.add(new ArrayList<>(Arrays.asList("2", "3")));
		edges.add(new ArrayList<>(Arrays.asList("2", "4")));
		edges.add(new ArrayList<>(Arrays.asList("3", "2")));
		edges.add(new ArrayList<>(Arrays.asList("3", "4")));
		edges.add(new ArrayList<>(Arrays.asList("4", "3")));
		edges.add(new ArrayList<>(Arrays.asList("4", "2")));
		graphs.addEdges(edges);
		System.out.println(graphs.adjacencyList);
		//graphs.dfsPrint("0");
		
	}

}
