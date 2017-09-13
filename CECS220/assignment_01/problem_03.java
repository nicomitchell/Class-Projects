/******************
Nicolas Mitchell
CECS 220-01
5/16/17
Assignment 01
Problem 03
******************/

import java.util.Scanner;

public class problem_03{
	public static void main(String[] args){
		aTime inTime = new aTime();//creates new instance of class time using default constructor
		inTime.displayTime();
		
		int totalSeconds = inTime.secondConvert();
		System.out.println("Total Seconds: " + totalSeconds);
	}
}

class aTime{
	int hours;
	int minutes;
	int seconds;

	aTime(){
	//constructor - creates new instance of object and initializes it using Scanner statements
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
	void displayTime(){ //method displays time in hours minutes seconds format
		System.out.println(hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.");
	}
	int secondConvert(){ //method converts hours and minutes to seconds and returns total seconds
		int hoursToSeconds = hours * 60 * 60;
		int minsToSeconds = minutes * 60;
		int newSecondCount = hoursToSeconds + minsToSeconds + seconds;
		return newSecondCount;
	}
}