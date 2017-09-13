/************************
 * Nicolas Mitchell
 * CECS 220-01
 * Assignment 04
 * Problem 01
 ***********************/

import java.util.ArrayList;
import java.util.Scanner;

public class NumberCount
{
	public static void main(String[] args)
	{
		int[] counts = new int[50];
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		Scanner inputScan = new Scanner(System.in);
		Integer inNum = 0;
		System.out.println("Enter numbers 1-50. To exit, enter a number higher than 50.");
		do
		{
			inNum = inputScan.nextInt();
			if (inNum <= 50)
				numberList.add(inNum);
			else
			{
				System.out.println("Integer entered is greater than 50. Exiting...");
				break;
			}
		}while (inNum <= 50);
		for (int i = 0; i < numberList.size();i++)
		{
			counts[numberList.get(i) - 1]++;
		}
		System.out.println("Number:\tCount: ");
		for (int i = 0; i < 50; i++)
		{
			if (counts[i] > 0)
				System.out.println((i + 1) + "\t" + counts[i]);
		}
	}
}
