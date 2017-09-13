/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 03
********************/
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class problem_03
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the length of side one: ");
		double a = scan.nextDouble();
		System.out.print("Enter the length of side two: ");
		double b = scan.nextDouble();
		System.out.print("Enter the lenth of side three: ");
		double c = scan.nextDouble();
		Triangle triangle = new Triangle(a,b,c);
		triangle.display();

	}
}

class Triangle
{
	double side1,side2,side3,area,perimeter;
	Triangle(double s1, double s2, double s3)
	{
		side1 = s1;
		side2 = s2;
		side3 = s3;
		perimeter = side1 + side2 + side3;
		double s = 1.0/2.0 * (perimeter);
		area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public void display()
	{
		DecimalFormat fmt = new DecimalFormat("0.###");
		System.out.println("\nTriangle side lengths: " + fmt.format(side1) + ", " + fmt.format(side2) + ", " + fmt.format(side3) + ".");
		System.out.println("Triangle Perimeter = " + fmt.format(perimeter));
		System.out.println("Triangle Area = " + fmt.format(area));
	}
}