/******************** 
Nicolas Mitchell
CECS 220-01
7/11/2017
Assignment 05
Problem 01
********************/

public class Speakers
{
    public static void main(String[] args)
    {
        Speaker s1 = new Preacher("Bob");
        s1.speak();
        s1.announce("I love God like Kanye loves Kanye.");
        s1 = new Senator("Bernie Sanders", "Vermont", 'D');
        s1.speak();
        s1.announce("The top 1% of 1% controls 99% of the wealth in the United States!");
        s1 = new Attorney("Bob Loblaw");
        s1.speak();
        s1.announce("Objection!");
    }

}
interface Speaker
{
 public void speak();
 public void announce (String str);
}

class Preacher implements Speaker
{
    String name;
    Preacher(String n)
    {
        name = n;
    }
    public void speak()
    {
        System.out.println("Father " + name + " begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println("Father " + name + " makes an announcement:\n\t\"" + str + "\"");
    }
}

class Senator implements Speaker
{
    String name;
    String state;
    char party;
    Senator(String n, String s, char p)
    {
        name = n;
        state= s;
        party = p;
    }
    public void speak()
    {
        System.out.println("Senator " + name + " (" + party + "-" + state + ") begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println("Senator " + name + " (" + party + "-" + state + ") makes an announcement: ");
        System.out.println("\t\"" + str + "\"");
    }
}

class Attorney implements Speaker
{
    String name;
    Attorney(String n)
    {
        name = n;
    }
    public void speak()
    {
        System.out.println(name + ", Attorney at Law, begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println(name + ", Attorney at Law, makes an announcement:\n\t\"" + str + "\"");
    }
}

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


import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
/*****************
 Nicolas Mitchell
 CECS 220-01
 7/13/17
 Assignment 05
 Problem 03
 ****************/
class StringReader
{
    static StringTooLongException exc = new StringTooLongException();
    static ArrayList<String> stringList = new ArrayList<String>();
    public static void main(String[] args) throws StringTooLongException
    {
        Scanner scan = new Scanner(System.in);
        String inputString;
        System.out.println("Enter strings. When you are finished, enter \"DONE\"");
        try
        {
            inputString = scan.nextLine();
            while (!inputString.equals("DONE"))
            {
                if (inputString.length() > 20)
                {
                    throw exc;
                }
                else
                {
                    stringList.add(inputString);
                }
                inputString = scan.nextLine();
            }
            scan.close();
        }
        catch (StringTooLongException exc)
        {
            System.out.println(exc.getMessage());
            System.exit(1);
        }
        finally
        {
            System.out.println("\nHere are all the strings you entered: ");
            for (int i = 0; i < stringList.size();i++)
            {
                System.out.println(stringList.get(i));
            }
        }
    }
}

class StringTooLongException extends Exception
{
    public StringTooLongException()
    {
        super("The String entered is more than 20 characters! Terminating program.");
    }
}

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
/*****************
 Nicolas Mitchell
 CECS 220-01
 7/13/17
 Assignment 05
 Problem 04
 ****************/
class StringReader2
{
    static StringTooLongException exc = new StringTooLongException();
    static ArrayList<String> stringList = new ArrayList<String>();
    public static void main(String[] args) throws StringTooLongException
    {
        Scanner scan = new Scanner(System.in);
        String inputString;
        System.out.println("Enter strings. When you are finished, enter \"DONE\"");
        inputString = scan.nextLine();
        while (!inputString.equals("DONE"))
        {
            try
            {
                if (inputString.length() > 20)
                {
                    throw exc;
                }
                else
                {
                    stringList.add(inputString);
                }
                inputString = scan.nextLine();
            }
            catch (StringTooLongException exc)
            {
                System.out.println(exc.getMessage());
                inputString = scan.nextLine();
                continue;
            }
            finally
            {
                if (inputString.equals("DONE"))
                {
                    System.out.println("\nHere are all the strings you entered: ");
                    for (int i = 0; i < stringList.size();i++)
                    {
                        System.out.println(stringList.get(i));
                    }
                    scan.close();
                }
            }
        }
    }
}

class StringTooLongException extends Exception
{
    public StringTooLongException()
    {
        super("The String entered is more than 20 characters!");
    }
}