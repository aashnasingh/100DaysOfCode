package com.leetcode;

/**
 * @author aashnasingh
 * 
 * Input: salary = [4000,3000,1000,2000]
 * Output: 2500.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
 * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
 * salary[i] is unique
 *
 */
public class AverageSalary {
	
	 public double average(int[] salary) {
	        
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        int sum = 0;
	        
	        for (int i = 0; i < salary.length; i++) {
	            
	            if (salary[i] < min) {
	                min = salary[i];
	            }
	            if (salary[i] > max) {
	                max = salary[i];
	            }
	            sum += salary[i];   
	        }
	        sum = sum - (min + max);
	        return new Double(sum)/(salary.length - 2);
	    }
	 
	 public static void main(String[] args) {
		AverageSalary AverageSalary = new AverageSalary();
		int[] arr = new int[]{14000,3000,1000,2000};
		double avg = AverageSalary.average(arr);
		System.out.println(avg);

	}

}
