/******************** 
Nicolas Mitchell
CECS 220-01
7/11/2017
Assignment 05
Problem 02
********************/

import java.lang.Comparable;
public class Sorting
{

	public static void main(String[] args)
	{
		Comparable[] numbers = {6,23,14,2,9,77,46};
		selectionSort(numbers);
		System.out.println("Selection sort: ");
		for (int i = 0;i < numbers.length;i++)
		{
			System.out.println(numbers[i]);
		}
		System.out.println("Insertion sort: ");
		Comparable[] numbers2 = {8,13,15,66,786,42,19};
		insertionSort(numbers2);
		for (int i = 0;i < numbers2.length;i++)
		{
			System.out.println(numbers2[i]);
		}
		
	}
	public static void selectionSort(Comparable[] list)
	{
		int max;
		Comparable temp;
		for (int index = 0; index < list.length - 1; index++)
		{
			max = index;
			for (int scan = index + 1; scan < list.length; scan++)
				if (list[scan].compareTo(list[max]) > 0)
				{
					max = scan;
				}
			temp = list[max];
			list[max] = list[index];
			list[index] = temp;
		}
	}
	public static void insertionSort(Comparable[] list)
	{
		for (int index = 1; index < list.length; index++)
		{
			Comparable key = list[index];
			int pos = index;
			while (pos > 0 && key.compareTo(list[pos - 1]) > 0)
			{
				list[pos] = list[pos - 1];
				pos--;
			}
			list[pos] = key;
		}
	}
}
