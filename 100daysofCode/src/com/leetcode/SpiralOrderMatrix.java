package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author aashnasingh
 * 
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]

 *
 */

public class SpiralOrderMatrix {
	
	int rowSize;
    int colSize;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        rowSize = matrix.length;
        colSize = matrix[0].length;
        int size = rowSize*colSize;
        
        int i = 0, j = 0;
        while (result.size() != size) {            
            result = spiralOrderRes("R", i, j, matrix, result);
            result = spiralOrderRes("D", i, colSize - j - 1, matrix, result);
            result = spiralOrderRes("L", rowSize - i - 1, colSize - j - 1, matrix, result);
            result = spiralOrderRes("U", rowSize - i - 1, j, matrix, result);
            i++; 
            j++;
        }
        return result;
    }
    
    Set<String> visited = new HashSet<>();
    private List<Integer> spiralOrderRes(String direction, int i, int j, int[][] matrix, List<Integer> result) {
      
        while (isValidRange(i, j)) {
            String edge = String.valueOf(i) + "-" + String.valueOf(j);
            if (!visited.contains(edge)) {
                result.add(matrix[i][j]);
                visited.add(edge);
            }
  
            if ("R".equals(direction)) {
                j++;
            }
            else if ("D".equals(direction)) {
                i++;
            }
            else if ("L".equals(direction)) {
                j--;
            }
            else if ("U".equals(direction)) {
                i--;
            }
            
        }
        return result;
    }
    
    boolean isValidRange(int i, int j) {
        return i >= 0 && i < rowSize && j >= 0 && j < colSize;
    }

	public static void main(String[] args) {
		SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();
		int m = 3;
		int n = 3;
		int[][] matrix = new int[m][n];
		matrix[0] = new int[] {1,2,3};
		matrix[1] = new int[] {4,5,6};
		matrix[2] = new int[] {7,8,9};
		List<Integer> result = spiralOrderMatrix.spiralOrder(matrix);
		System.out.println(result);

	}

}
