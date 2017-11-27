/**
 * @author davidpokuri
 *
 */

package com.techolution.problmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * This class for solve Largest Subset sum problem
 * 
 * Note: I did not concentrate much on modularizing and Error handling and other corner test cases as its assignment
 * and we have time constraint.
 * 
 */

public class LargestSubsetSum {

	static int getMaximumSumWithLCMN(int n) {
		int sum = 0;
		int limit = (int) Math.sqrt(n);

		for (int i = 1; i <= limit; i++) {
			if (n % i == 0) {
				if (i == (n / i))
					sum += i;
				else
					sum += (i + n / i);
			}
		}
		return sum;
	}

	static long[] maxSubsetSum(int[] k) {
		long resultArray[] = new long[k.length]; 
		for(int i =0; i < k.length; i++){
			resultArray[i] = getMaximumSumWithLCMN(k[i]);
		}
		return resultArray;
	}

	// Here Reading inputs from console and preparing in required format.
	// For displaying output purpose
	public static void main(String[] args) {
		BufferedReader reader = null;
		int arr[] = null;

		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(reader.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(reader.readLine());
				arr[i] = temp;
			}
			
			long[] finalResults = maxSubsetSum(arr);
			for(int i= 0; i< finalResults.length; i++){
				System.out.println(finalResults[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
