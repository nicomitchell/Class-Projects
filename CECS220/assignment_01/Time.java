package assignment_01;

import java.util.Scanner;

public class Time{
	int hours;
	int minutes;
	int seconds;

	Time()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the hours: ");
		int h = scan.nextInt();
		System.out.println("");

		System.out.print("Enter the minutes: ");
		int m = scan.nextInt();
		System.out.println("");

		System.out.print("Enter the seconds: ");
		int s = scan.nextInt();
		System.out.println("");
		hours = h;
		minutes = m;
		seconds = s;
	}
	void displayTime()
	{
		System.out.println(hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.");
	}
	int secondConvert()
	{
		int hoursToSeconds = hours * 60 * 60;
		int minsToSeconds = minutes * 60;
		int newSecondCount = hoursToSeconds + minsToSeconds + seconds;
		return newSecondCount;
	}
}