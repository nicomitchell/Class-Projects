
/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 05
********************/
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.lang.Math;

public class StarPanel extends JPanel
{
	int x, y, width;
	public StarPanel(int ix, int iy, int iwidth)
	{
		setBackground(new Color(0, 0, 60));
		setPreferredSize(new Dimension(1000, 1000));
		x = ix;
		y = iy;
		width = iwidth;
	}
	public void draw(Graphics page)
	{
		//Draws the lines that create the star
		double outerRadius = width/2;							//ALL MATH
		double innerRadius = outerRadius * .382;
		int xTop,yTop;
		xTop = x + (int)Math.round(outerRadius);
		yTop = y + (int)Math.round(outerRadius);
		double firstLineLength = (outerRadius - innerRadius)/Math.sin(72);	//length of first line
		int yComp1 = (int)Math.round(firstLineLength * Math.sin(72));
		int xComp1 = (int)Math.round(firstLineLength * Math.cos(72));
		int xPoint1 = xTop + xComp1;
		int yPoint1 = yTop + yComp1;
		//Does the actual drawing of individual lines
		page.setColor(Color.yellow);
		page.drawLine(xTop,yTop,xPoint1,yPoint1);

	}
}