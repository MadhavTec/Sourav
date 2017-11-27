/**
 * @author davidpokuri
 *
 */
package com.techolution.problmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * This calss for solving In the future problem.
 * 
 * Note: I did not concentrate much on modularizing and Error handling and other corner test cases as its assignment
 * and we have time constraint.
 */
public class InTheFuture {

	// Reading inputs from console using BufferedReader and preparing inputs
	// according to requirements
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			int a = Integer.parseInt(reader.readLine());
			int k = Integer.parseInt(reader.readLine());
			int p = Integer.parseInt(reader.readLine());

			int minNum = minNum(a, k, p);
			System.out.println(minNum);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Actual business logic to find min numbers of days required.
	private static int minNum(int a, int k, int p) {

		int asha = a + p;
		int kelly = k;
		int noofDays = 1;

		if (asha < kelly) {
			return 1;
		} else if (asha == kelly) {
			return 2;
		} else {
			while (true) {
				if (asha < kelly) {
					return noofDays;
				} else if (asha == kelly)
					return noofDays + 1;
				else {
					asha = asha + a;
					kelly = kelly + k;
					noofDays++;
				}
			}
		}
	}
}
