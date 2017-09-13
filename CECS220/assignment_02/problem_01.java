/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 01
********************/
import java.util.Scanner;
import java.util.Random;

public class problem_01
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = scan.nextLine();
		if (lastName.length() < 5)//allows for a username to be created even if the last name is less than 5 characters
		{
			for(int i = lastName.length() - 1;i < 6;i++)
			{
				lastName = lastName.concat("0");
			}
		}
		Random randomer = new Random();
		int num = randomer.nextInt(90) + 10;
		char firstLetter = firstName.charAt(0);
		String userName = firstLetter + lastName.substring(0,5) + num;
		System.out.println("Your username is: " + userName);

		String lowerName = userName.toLowerCase();
		System.out.println("Your lowercase username is: " + lowerName);


		String upperName = userName.toUpperCase();
		System.out.println("Your uppercase username is: " + upperName);
		
	}
}