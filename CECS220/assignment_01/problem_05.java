/*****************
Nicolas Mitchell
CECS 220-01
5/16/17
Assignment 01
Problem 05
*****************/
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JApplet;

public class problem_05 extends JApplet
{
	private static long serialVersionIUD	= 1L;


	public void paint(Graphics page)
	{
		for (int i = 0; i<8; i++)
		{	
			Color testColor = randomColor(page);
			page.setColor(testColor); //sets the color for the balloon on each iteration of the for loop
			generateBalloon(page); //draws a balloon using random coordinates
		}
	}
	public Color randomColor(Graphics page)
	{
		//Generates RGB values to create random colored balloons; returns a color
		Random rand = new Random();
		int r = rand.nextInt(255) + 1;
		int g = rand.nextInt(255) + 1;
		int b = rand.nextInt(255) + 1;

		Color generatedColor = new Color(r,g,b);
		return generatedColor;
	}
	public void generateBalloon(Graphics page)
	{
		Random rand = new Random();
		//Generates coordinates for the ovals
		int c1 = rand.nextInt(800)+1;
		int c2 = rand.nextInt(400)+1;
		page.fillOval(c1,c2,100,140); //generates a second oval on the opposite corner of the first; makes it appear a bit more balanced
		int c3 = 800 - c1;
		int c4 = 800 - c2;
		page.fillOval(c3,c4,120,170);
		//Generates coordinates for the strings
		page.setColor(Color.black);//string color will be black
		page.drawLine(c1+50,c2+140,c1+50,c2+280);//draws line from the bottom center of the ovals
		page.drawLine(c3+60,c4+170,c3+60,c4+340);
	}
}