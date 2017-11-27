/**
 * @author davidpokuri
 *
 */

package com.techolution.problmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * This class for Psychometric Testing problem.
 * 
 * Note: I did not concentrate much on modularizing and Error handling and other corner test cases as its assignment
 * and we have time constraint.
 */
public class PsychometricTesting {

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int query = lowerLimits.length;
		int[] results = new int[query];
		for (int i = 0; i < query; i++) {
			int count = 0;
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] >= lowerLimits[i] && scores[j] <= upperLimits[i]) {
					count++;
				}
			}
			results[i] = count;
		}
		return results;
	}

	public static void main(String[] args) {

		// Here I have used to BufferedReader to read input from user/console
		BufferedReader reader;
		int scores[] = null;
		int lowerLimitsLength = 0;
		int upperLimitsLength = 0;
		int lowerLimts[] = null;
		int upperLimits[] = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			if (reader != null) {
				String temp = reader.readLine();
				int n = Integer.parseInt(temp);
				if (!(1 <= n && n <= Math.pow(10, 5))) {
					throw new Exception("N is out of the given range");
				}
				scores = new int[n];

				// Here we can check the 1 ≤ scoresj ≤ pow(10,9)
				for (int i = 0; i < n; i++) {
					scores[i] = Integer.parseInt(reader.readLine());
				}

				temp = reader.readLine();
				lowerLimitsLength = Integer.parseInt(temp);
				lowerLimts = new int[lowerLimitsLength];

				// Here we can check 1 ≤ q ≤ pow(10,5) and 1 ≤ lowerLimitsi ≤
				// upperLimitsi ≤ pow(10,9)
				for (int i = 0; i < lowerLimitsLength; i++) {
					lowerLimts[i] = Integer.parseInt(reader.readLine());
				}

				temp = reader.readLine();
				upperLimitsLength = Integer.parseInt(temp);
				upperLimits = new int[upperLimitsLength];
				for (int i = 0; i < upperLimitsLength; i++) {
					upperLimits[i] = Integer.parseInt(reader.readLine());
				}

			}

			if (lowerLimitsLength != upperLimitsLength) {
				throw new Exception("There is a mismatch between no of lower limts and no of upper limits");
			}
			int results[] = jobOffers(scores, lowerLimts, upperLimits);
			for (int i = 0; i < results.length; i++) {
				System.out.println(results[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
