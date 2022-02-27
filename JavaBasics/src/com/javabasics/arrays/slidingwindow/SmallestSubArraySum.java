package com.javabasics.arrays.slidingwindow;

/**
 *
 * @author aashnasingh
 *
 * Given array of positive integers and a positive integer s, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to s. Return 0 if no such subarray exsits.
 *
 * Input: [1, 3, 2, 2, 4, 5], 6
 * Output: 2
 *
 */
public class SmallestSubArraySum {

    private int smallestSubArraySum(int[] arr, int s) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int possibleLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            possibleLen++;
            while (sum >= s) {
                len = Math.min(len, possibleLen);
                sum = sum - arr[i - --possibleLen];
            }
        }
        return len != Integer.MAX_VALUE ? len : 0;
    }

    public static void main(String[] args) {
        SmallestSubArraySum smallestSubArraySum = new SmallestSubArraySum();
        int[] arr = new int[]{1, 1, 1, 1, 1, 1};
        int answer = smallestSubArraySum.smallestSubArraySum(arr, 7);
        System.out.println(answer);
    }
}
