package com.javabasics;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
	
	Long ways = 0L;
	Map<String, Long> waysMap = new HashMap<>();
	public Long gridTravellerRec (int m, int n) {
		
		if (m == 0 || n == 0) {
			return 0L;
		}
		if (m == 1 && n == 1) {
			return 1L;
		}
		
		ways = gridTravellerRec(m-1, n) + gridTravellerRec(m, n-1);
		
		return ways;
	}
	
	public Long gridTravellerMemo (int m, int n) {
		
		if (m == 0 || n == 0) {
			return 0L;
		}
		if (m == 1 && n == 1) {
			return 1L;
		}
		String dim = String.valueOf(m).concat("-").concat(String.valueOf(n)).concat("-").concat(String.valueOf(n)).concat("-").concat(String.valueOf(m));
		if (waysMap.containsKey(dim)) {
			return waysMap.get(dim);
		}
		ways = gridTravellerRec(m-1, n) + gridTravellerRec(m, n-1);
		waysMap.put(dim, ways);
		return ways;
	}
	
	
	public static void main(String[] args) {
		
		GridTraveller gridTraveller = new GridTraveller();
		Long ways = gridTraveller.gridTravellerMemo(18 , 18);
		System.out.println(ways);
		Long num = gridTraveller.gridTravellerRec(3, 3);
		System.out.println(num);
	}

}
