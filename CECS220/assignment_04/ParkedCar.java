/**********************
 * Nicolas Mitchell
 * CECS 220-01
 * Assignment 04
 * Problem 02
 *********************/

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.lang.Math;
import java.util.ArrayList;

public class ParkedCar
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Car car = new Car(100,900);
        CarPanel panel = new CarPanel(car);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class CarPanel extends JPanel
{
    int[] xCar = new int[8];
    int[] yCar = new int[8];
    int[] xWindow = new int[4];
    int[] yWindow = new int[4];
    int xWheel1, xWheel2;
    int yWheel;
    int wheelDiameter;
    CarPanel(Car car)
    {
        setBackground(new Color(26, 82, 173));
        setPreferredSize(new Dimension(1000,1000));
        xCar = car.getXPoints();
        yCar = car.getYPoints();
        xWindow = car.getXWindow();
        yWindow = car.getYWindow();
        xWheel1 = car.getXWheel1();
        xWheel2 = car.getXWheel2();
        yWheel = car.getYWheel();
        wheelDiameter = car.getWheelDiameter();
    }
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(Color.red);
        page.fillPolygon(xCar,yCar,xCar.length);
        page.setColor(Color.gray);
        page.fillPolygon(xWindow, yWindow, xWindow.length);
        page.setColor(Color.black);
        page.fillOval(xWheel1, yWheel, wheelDiameter, wheelDiameter);
        page.fillOval(xWheel2, yWheel, wheelDiameter, wheelDiameter);
    }
}

class Car
{
    ArrayList<Integer> xCar = new ArrayList<Integer>(), yCar = new ArrayList<Integer>();
    ArrayList<Integer> xWindow = new ArrayList<Integer>(), yWindow = new ArrayList<Integer>();
    int xWheel1,xWheel2,yWheel;
    int wheelDiameter = 200;
    Car(int startX, int startY)
    {
        int x1,x2,x3,x4,x5,x6,x7,x8;
        xCar.add(x1 = startX);
        xCar.add(x2 = startX);
        xCar.add(x3 = startX + 150);
        xCar.add(x4 = x3 + 300);
        xCar.add(x5 = x4 + 150);
        xCar.add(x6 = x5 + 150);
        xCar.add(x7 = x6);
        xCar.add(x8 = startX);
        int y1,y2,y3,y4,y5,y6,y7,y8;
        yCar.add(y1 = startY);
        yCar.add(y2 = startY - 150);
        yCar.add(y3 = y2 - 150);
        yCar.add(y4 = y3);
        yCar.add(y5 = y4 + 150);
        yCar.add(y6 = y5);
        yCar.add(y7 = y1);
        yCar.add(y8 = y1);
        int xwStart = startX + 20;
        xWindow.add(xwStart);
        xWindow.add(xwStart + 150);
        xWindow.add(xwStart + 430);
        xWindow.add(xwStart + 560);
        int ywStart = startY - 150;
        yWindow.add(ywStart);
        yWindow.add(ywStart - 130);
        yWindow.add(ywStart - 130);
        yWindow.add(ywStart);
        xWheel1 = startX + 50;
        xWheel2 = startX + 500;
        yWheel = startY - 100;
    }
    public int[] getXPoints()
    {
        int[] xPoints = new int[8];
        for (int i = 0; i < xCar.size();i++)
        {
            xPoints[i] = xCar.get(i);
        }
        return xPoints;
    }
    public int[] getYPoints()
    {
        int[] yPoints = new int[8];
        for (int i = 0;i < yCar.size();i++)
        {
            yPoints[i] = yCar.get(i);
        }
        return yPoints;
    }
    public int[] getXWindow()
    {
        int[] xwPoints = new int[4];
        for (int i = 0;i < xWindow.size();i++)
        {
            xwPoints[i] = xWindow.get(i);
        }
        return xwPoints;
    }
    public int[] getYWindow()
    {
        int[] ywPoints = new int[4];
        for (int i = 0; i < yWindow.size();i++)
        {
            ywPoints[i] = yWindow.get(i);
        }
        return ywPoints;
    }
    public int getYWheel()
    {
        return yWheel;
    }
    public int getXWheel1()
    {
        return xWheel1;
    }
    public int getXWheel2()
    {
        return xWheel2;
    }
    public int getWheelDiameter()
    {
        return wheelDiameter;
    }

}