/**
 * @author davidpokuri
 *
 */

package com.techolution.problmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * This class for solving relationship between two circles based on given dimensions problem.
 * 
 * Note: I did not concentrate much on modularizing and Error handling and other corner test cases as its assignment
 * and we have time constraint.
 */

public class TwoCircles {

	// Here is the main business logic
	private static String checkCirclesRelation(String dimensions[]) {

		int x0 = Integer.parseInt(dimensions[0]);
		int y0 = Integer.parseInt(dimensions[1]);
		int r0 = Integer.parseInt(dimensions[2]);

		int x1 = Integer.parseInt(dimensions[3]);
		int y1 = Integer.parseInt(dimensions[4]);
		int r1 = Integer.parseInt(dimensions[5]);

		double distance = Math.sqrt(Math.pow(Math.abs(x0 - x1), 2) + Math.pow(Math.abs(y0 - y1), 2));

		if ((distance == Math.abs(r0 + r1)) || (distance == Math.abs(r0 - r1))) {
			return "Touching";
		} else if (distance < (r0 + r1)) {
			return "Intersecting";
		} else if (x0 == x1 && y0 == y1) {
			return "Concentric";
		} else if (((x0 < x0) && (y0 < y1) && (r0 < r1)) || ((x0 > x0) && (y0 > y1) && (r0 > r1))) {
			return "Disjoint‐Inside";
		} else {
			return "Disjoint‐Outside";
		}

	}
	
	//Reading inputs from console and formatting according to requirements
	//Displying outputs too

	public static void main(String[] args) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(reader.readLine());
			String result[] = new String[n];
			for (int i = 0; i < n; i++) {
				String arr[] = reader.readLine().split(" ");
				result[i] = checkCirclesRelation(arr);
			}

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
