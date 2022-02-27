package com.leetcode.graphs;

/**
 * @author aashnasingh
 * 
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]


Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]



Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]



Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 *
 */
public class SetMatrixZero {
	
	public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for (int i = 0; i < rowSize; i++) {
            
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int j = 0; j < colSize; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (isCol) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
