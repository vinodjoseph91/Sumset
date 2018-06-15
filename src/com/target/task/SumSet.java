package com.target.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumSet {
	/*
	 * Recursive Function to find all possible values which sum up to the result
	 */

	static void checkSum(ArrayList<Integer> values, int result, ArrayList<Integer> subItems) {
		int s = calcSum(subItems);
		if (s == result) {
			System.out.println(Arrays.toString(subItems.toArray()) + "=" + result);
		}
		if (s >= result)
			return;
		for (int i = 0; i < values.size(); i++) {
			int n = values.get(i);
			ArrayList<Integer> partialValues = loadPartialValues(i + 1, values);
			ArrayList<Integer> valuesToCheckSum = new ArrayList<Integer>(subItems);
			valuesToCheckSum.add(n);
			checkSum(partialValues, result, valuesToCheckSum);
		}
	}

	/* Method to calculate the sum of partial items */
	static int calcSum(ArrayList<Integer> list) {
		int s = 0;
		for (int x : list) {
			s += x;
		}
		return s;
	}

	/* Method to create the next set of partial items for each iteration */
	static ArrayList<Integer> loadPartialValues(int index, ArrayList<Integer> list) {
		ArrayList<Integer> partialValues = new ArrayList<Integer>();
		for (int i = index; i < list.size(); i++) {
			partialValues.add(list.get(i));
		}
		return partialValues;
	}

	/*
	 * Method which invokes the recursive function by creating a temporary partial
	 * Array
	 */
	static void getCombinations(ArrayList<Integer> values, int res) {
		checkSum(values, res, new ArrayList<Integer>());
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array.");
		int noOfItems = sc.nextInt();
		System.out.println("Enter " + noOfItems + " items.");
		Integer[] numbers = new Integer[noOfItems];
		for (int i = 0; i < noOfItems; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println("Enter the sum to check for :");
		int res = sc.nextInt();
		sc.close();

		/*
		 * Below code can be used to directly set the input values without reading from
		 * console
		 */
		// Integer[] numbers = { 1, 2, 3 ,4};
		// int res = 4;
		getCombinations(new ArrayList<Integer>(Arrays.asList(numbers)), res);
	}

}
