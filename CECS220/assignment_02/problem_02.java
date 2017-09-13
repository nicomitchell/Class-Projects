/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 02
********************/
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class problem_02
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the radius of your sphere: ");
		float r = scan.nextFloat();
		Sphere ball = new Sphere(r);
		ball.display();
	}
}

class Sphere
{
	double radius,volume,surfaceArea;
	Sphere(float r)
	{
		radius = r;
		volume = (4.0/3.0) * Math.PI * Math.pow(r,3.0);
		surfaceArea = 4 * Math.PI * Math.pow(r,2.0);
	}
	public void display()
	{
		DecimalFormat fmt = new DecimalFormat("0.####");
		System.out.println("Radius = " + fmt.format(radius));
		System.out.println("Volume = " + fmt.format(volume));
		System.out.println("Surface Area = " + fmt.format(surfaceArea));
	}
}