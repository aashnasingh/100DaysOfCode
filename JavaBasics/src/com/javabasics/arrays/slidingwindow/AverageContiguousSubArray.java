package com.javabasics.arrays.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aashnasingh
 *
 *  Find the average of all contiguous sub arrays of size K.
 *  *
 *  * Input : [1, 2, 3, 4, 5], 3
 *  * Output : [2, 3, 4]
 */
public class AverageContiguousSubArray {

    /**
     *
     * @param arr
     * @param k
     * @return
     */
    private List<Integer> getSubArrayAvg(int[] arr, int k) {

        List<Integer> averageList = new ArrayList<>();
        int intermediateSum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {

//            intermediateSum = intermediateSum + arr[i];
//            if (i >= k -1) {
//                averageList.add(intermediateSum / k);
//                intermediateSum = intermediateSum - arr[i - k + 1];
//            }
            // i < len not working for 8
            if (i >= k) {
                averageList.add(intermediateSum / k);
                intermediateSum = intermediateSum - arr[i - k];
            }
            intermediateSum = intermediateSum + arr[i];
        }
        return averageList;
    }

    public static void main(String[] args) {

        AverageContiguousSubArray averageContiguousSubArray = new AverageContiguousSubArray();
        int[] inputArr = new int[] {1, 2, 3, 4, 5, 6, 3, 56, 27};
        List<Integer> averageList = averageContiguousSubArray.getSubArrayAvg(inputArr, 4);
        System.out.println(averageList);
    }

}
