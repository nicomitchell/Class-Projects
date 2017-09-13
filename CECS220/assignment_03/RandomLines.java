/****************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 04
****************/
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
public class RandomLines
{
	
	public static void main(String [] args)
	{
		LinePanel lines = new LinePanel(100,100);
		JFrame lineFrame = new JFrame("Lines");
		lineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lineFrame.getContentPane().add(lines);
		lineFrame.pack();
		lineFrame.setVisible(true);
	}
}

class LinePanel extends JPanel
{
	int x0 , y0;
	LinePanel(int x,int y)
	{
		x0 = x;
		y0 = y;
		setPreferredSize(new Dimension(1000, 1000));
	}
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for ( int i=0; i < 20; i++) //creates 20 lines
		{
			int x1 = x0;
			int y1 = y0 + (30 * i); //moves y coordinate down based on how many times the loop has run
			Random lengthGen = new Random();
			int lineLength = lengthGen.nextInt(600) + 200; //length of each line is randomly generated between 200 and 800 px
			int x2 = x1 + lineLength;
			page.drawLine(x1,y1,x2,y1);
		}
	}
}