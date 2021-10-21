package com.leetcode;

import java.util.Arrays;

/**
 * @author aashnasingh
 * 
 * You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.
Example:
If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:
[
    [3, 1],
    [4, 2]
]
 *
 */

public class RotateMatrix {
	
	private int[][] solution(int[][] a) {
		int n = a.length;
		
		//transpose
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = a[j][i];
				a[j][i] = a[i][j];
				a[i][j] = temp;
			}
		}
		
		//reflect
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				int temp = a[i][n - 1 - j];
				a[i][n - 1 - j] = a[i][j];
				a[i][j] = temp;
			}
		}
		
		return a;
		
	}

	public static void main(String[] args) {
		
		RotateMatrix rotateMatrix = new RotateMatrix();
		int n = 5;
		int k = 1;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = k++;
			}
		}
		a = rotateMatrix.solution(a);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
	}

}
