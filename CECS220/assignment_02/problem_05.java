/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 05
********************/
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.lang.Math;
import java.util.ArrayList;

public class problem_05
{
	public static void main(String[] args)
	{
		JFrame starFrame = new JFrame("Stars");
		starFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//StarPanel panel = new StarPanel(150,150,100);
		Random starGen = new Random();
		StarPanel panel = new StarPanel();
		for (int i=0; i < 100; i++)
		{
			int xPoint, yPoint, width;
			xPoint = starGen.nextInt(900) + 10;
			yPoint = starGen.nextInt(900) + 10;
			width = starGen.nextInt(100) + 10;
			Star star =  new Star(xPoint,yPoint,width);
			StarPanel.addStar(star);
		}

		starFrame.getContentPane().add(panel);
		starFrame.pack();
		starFrame.setVisible(true);

	}
}

class Star
{
	int x, y, width;
	Star(int xCo,int yCo,int w)
	{
		x= xCo;
		y = yCo;
		width = w;
	}
}
class StarPanel extends JPanel
{
	static ArrayList<Star> starList;
	StarPanel()
	{
		starList = new ArrayList<Star>();
		setBackground(new Color(21,5,128));
		setPreferredSize(new Dimension(1000, 1000));
	}
	public static void addStar(Star newStar)
	{
		starList.add(newStar);
	}
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		//Draws the lines that create the star
		for(int i = 0; i<starList.size();i++)
		{
			int x = starList.get(i).x;
			int y = starList.get(i).y;
			int width = starList.get(i).width;
			double outerRadius = width/2.0;							//ALL MATH
			double innerRadius = outerRadius * .382;
			int xTop,yTop; //initial points
			xTop = x + (int)Math.round(outerRadius);
			yTop = y;
			double firstLineLength = (outerRadius - innerRadius)/Math.sin(1.25664);	//length of first line
			int yComp1 = (int)Math.round(firstLineLength * Math.sin(1.25664));
			int xComp1 = (int)Math.round(firstLineLength * Math.cos(1.25664));
			int xPoint1 = xTop + xComp1;
			int yPoint1 = yTop + yComp1;
			int xPoint2 = xTop - xComp1;
			int yPoint2 = yTop + yComp1;
			int xOuterPoint1 = xTop + (int)Math.round(outerRadius/2);
			int xOuterPoint2 = xTop - (int)Math.round(outerRadius/2);
			int yInPoint = yPoint1 + (int)Math.round(outerRadius/3);
			int yBottomPoint = yInPoint + (int)Math.round(outerRadius/2);
			int xBottomPoint1 = xOuterPoint1 - (int)Math.round(innerRadius/3);
			int xBottomPoint2 = xOuterPoint2  + (int)Math.round(innerRadius/3);
			int xFinal = xTop;
			int yFinal = yTop + (int)Math.round(outerRadius + innerRadius/3);
		//Does the actual drawing of individual lines
			page.setColor(Color.yellow);
			page.drawLine(xTop,yTop,xPoint1,yPoint1);
			page.drawLine(xTop,yTop,xPoint2,yPoint2);
			page.drawLine(xPoint1, yPoint1, xOuterPoint1, yPoint1);
			page.drawLine(xPoint2, yPoint2, xOuterPoint2, yPoint2);
			page.drawLine(xOuterPoint1, yPoint1, xPoint1, yInPoint);
			page.drawLine(xOuterPoint2, yPoint1, xPoint2, yInPoint);
			page.drawLine(xPoint1, yInPoint, xBottomPoint1, yBottomPoint);
			page.drawLine(xPoint2, yInPoint, xBottomPoint2, yBottomPoint);
			page.drawLine(xBottomPoint1,yBottomPoint,xFinal,yFinal);
			page.drawLine(xBottomPoint2,yBottomPoint,xFinal,yFinal);
	}

	}
}