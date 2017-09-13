/*****************
Nicolas Mitchell
CECS 220-01
5/16/17
Assignment 01
Problem 04
*****************/
import java.util.Scanner;

public class problem_04{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the length of one side of a square: ");
		int sideLength = scan.nextInt();
		int perimeter = 4 * sideLength;
		int area = sideLength * sideLength;
		System.out.println("Area = " + area + "\tPerimeter = " + perimeter);
	}
}