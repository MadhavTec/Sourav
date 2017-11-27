/**
 * @author TresmDisk
 *
 */

package com.techolution.problmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *  This class for solve Find winner problem.
 *  
 *  Note: I did not concentrate much on modularizing and Error handling and other corner test cases as its assignment
 *        and we have time constraint.
 */


public class FindTheWinner {
	
	// Reading inputs from keyboard/console.
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			int andreaArrayLenght = Integer.parseInt(reader.readLine());
			int andreaArray[] = new int[andreaArrayLenght];
			for (int i = 0; i < andreaArrayLenght; i++) {
				andreaArray[i] = Integer.parseInt(reader.readLine());
			}

			int mariaArrayLenght = Integer.parseInt(reader.readLine());
			int mariaArray[] = new int[mariaArrayLenght];
			for (int i = 0; i < mariaArrayLenght; i++) {
				mariaArray[i] = Integer.parseInt(reader.readLine());
			}

			String gameType = reader.readLine();

			String winner = winner(andreaArray, mariaArray, gameType);
			System.out.println(winner);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Logic for find winner based on given conditions.
	private static String winner(int[] andrea, int[] maria, String gameType) {
		int startIndex = -1;
		int andreaScore = 0;
		int mariaScore = 0;
		try {
			if (gameType.equals("Even"))
				startIndex = 0;
			else if (gameType.equals("Odd"))
				startIndex = 1;
			else
				throw new Exception("Invalid input");

			for (int i = startIndex; i < andrea.length; i = i + 2) {

				andreaScore = andreaScore + (andrea[i] - maria[i]);
				mariaScore = mariaScore + (maria[i] - andrea[i]);
			}

			if (andreaScore < mariaScore)
				return "Maria";
			else if (andreaScore > mariaScore)
				return "Andrea";
			else
				return "Tie";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
