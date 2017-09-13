/******************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 03
******************/

import java.util.Scanner;
public class StringReader
{
	static String userString; 
	static int aCount,eCount,iCount,oCount,uCount,consonantCount;

	StringReader(String inputString)
	{
		userString = inputString;
		aCount = 0;
		eCount = 0;
		iCount = 0;
		oCount = 0;
		uCount = 0;
		consonantCount = 0;
		char[] charArray = userString.toCharArray(); //changes the string to a char array
		for(int counter = 0; counter < userString.length();counter++) //counts the amount of each vowel
		{
			if (charArray[counter] == 'a')
			{
				aCount++;
			}
			else if (charArray[counter] == 'e')
			{
				eCount++;
			}
			else if (charArray[counter] == 'i')
			{
				iCount++;
			}
			else if (charArray[counter] == 'o')
			{
				oCount++;
			}
			else if (charArray[counter] == 'u')
			{
				uCount++;
			}
			else
			{
				consonantCount++;
			}
		}
	}
	public static String getString()
	{
		return userString;
	}
	public static int getCount(char userChar) 
	{											//character used as argument is what count will be returned, 'a' will return the aCount, etc.
		if (userChar == 'a')
		{
			return aCount;
		}
		else if (userChar == 'e')
		{
			return eCount;
		}
		else if (userChar == 'i')
		{
			return iCount;
		}
		else if (userChar == 'o')
		{
			return oCount;
		}
		else if (userChar == 'u')
		{
			return uCount;
		}
		else //if user enters anything but a vowel
		{
			return consonantCount;
		}
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter a String: "); //user enters the string so I could test more strings
		String userString = scan.nextLine();
		StringReader myString = new StringReader(userString);
		System.out.println("String: " + myString.getString()); 			//prints the string and all of the counts
		System.out.println("Count of:\na: " + myString.getCount('a') + "\te: " + myString.getCount('e') + "\ti: " + myString.getCount('i'));
		System.out.println("o: " + myString.getCount('o') + "\tu: " + myString.getCount('u') + "\tOther: " + myString.getCount('s'));
	}
}