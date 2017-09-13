/************************
 * Nicolas Mitchell
 * CECS 220-01
 * Assignment 04
 * Problem 01
 ***********************/

import java.util.ArrayList;
import java.util.Scanner;

public class NumberCount
{
	public static void main(String[] args)
	{
		int[] counts = new int[50];
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		Scanner inputScan = new Scanner(System.in);
		Integer inNum = 0;
		System.out.println("Enter numbers 1-50. To exit, enter a number higher than 50.");
		do
		{
			inNum = inputScan.nextInt();
			if (inNum <= 50)
				numberList.add(inNum);
			else
			{
				System.out.println("Integer entered is greater than 50. Exiting...");
				break;
			}
		}while (inNum <= 50);
		for (int i = 0; i < numberList.size();i++)
		{
			counts[numberList.get(i) - 1]++;
		}
		System.out.println("Number:\tCount: ");
		for (int i = 0; i < 50; i++)
		{
			if (counts[i] > 0)
				System.out.println((i + 1) + "\t" + counts[i]);
		}
	}
}


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

/********************
 * Nicolas Mitchell
 * CECS 220-01
 * Assignment 04
 * Problem 03
 *******************/

import java.util.Random;
import java.util.ArrayList;
import java.util.Formatter;
public class HospitalEmployees
{
	public static void main(String[] args)
	{
		Doctor grey = new Doctor("Grey",160000.00,"General Practitioner",5);
		grey.displayInformation();
		Nurse tina = new Nurse("Tina", 80000.00);
		tina.displayInformation();
		Surgeon steve = new Surgeon("Steve", 240000.00, "Neurosurgeon", 3);
		steve.displayInformation();
		Administrator jane = new Administrator("Jane", 300000.00);
		jane.displayInformation();
		Receptionist jean = new Receptionist("Jean", 65000.00);
		jean.displayInformation();
		Janitor rob = new Janitor("Rob", 55000.00);
		rob.displayInformation();

		System.out.println();

		jane.hire(grey);
		jane.hire(tina);
		jane.hire(steve);
		jane.hire(rob);

		jean.logPatient("Jim");
		jean.logPatient("Bill");
		jean.logPatient("Sara");
		jean.assign(grey, "Jim");
		jean.assign(grey, "Bill");
		jean.assign(steve, "Sara");

		grey.diagnose("fever", "Jim");
		grey.diagnose("rash", "Bill");
		steve.diagnose("memory problems", "Sara");

		grey.prescribe("Jim", "Ibuprofen");
		grey.prescribe("Bill", "Tylenol");

		steve.performSurgery("Sara");

		tina.doRounds(3);

		tina.bringMedicine("Jim");
		tina.bringMedicine("Bill");

		System.out.printf("Dr. Grey's paycheck for the past two weeks is $%.2f.\n", jane.getPayCheck(grey));

		rob.cleanFloor(4);
	}
}


class Employee
{
	String name;
	Integer employeeID;
	double salary;

	static ArrayList<Integer> idList = new ArrayList<Integer>();
	Employee(String n, double s)
	{
		name = n;
		salary = s;
		this.generateID();
	}
	public String getName()
	{
		return name;
	}
	public int getID()
	{
		return employeeID;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double s)
	{
		salary = s;
	}
	public void giveRaise(double amount)
	{
		salary += amount;
	}
	public void displayInformation()
	{
		System.out.printf("Employee Name: %s\t\tID: %d\t\tSalary: $%.2f\n\n",name,employeeID,salary);
	}
	public void generateID()
	{
		Random idGen = new Random();
		int tempID = idGen.nextInt(900000) + 100000;
		if (!idList.contains(tempID))
		{
			employeeID = tempID;
			idList.add(tempID);
		}
		else
		{
			this.generateID();
		}
	}
}

class Doctor extends Employee
{
	String doctorType;
	int yearsExperience;
	Doctor(String n, double s, String type, int y)
	{
		super(n,s);
		doctorType = type;
		yearsExperience = y;
		System.out.println("Dr. " + name + " constructed");
	}
	public void performCheckup(String name)
	{
		System.out.println("Doctor " + this.name + " performed a checkup on " + name);
	}
	public String diagnose(String symptom, String patient)
	{
		String diagnosis;
		switch (symptom)
		{
			case "fever":
				diagnosis = "viral infection";
				break;
			case "rash":
				diagnosis = "poison ivy";
				break;
			case "infected wound":
				diagnosis = "bacterial infection";
				break;
			default:
				diagnosis = "unknown";
				System.out.println("Doctor " + name + " was unable to diagnose the cause of " + patient + "\'s problem. Looks like they're going to die.");
		}
		if (diagnosis != "unknown")
		{
			System.out.println("Doctor " + name + " diagnoses " + patient + " with " + diagnosis + ".");
		}
		return diagnosis;
	}
	public String prescribe(String patient, String prescription)
	{
		System.out.println("Doctor " + name + " has prescribed " + prescription + " for " + patient + ".");
		return prescription;
	}
	public void displayInformation()
	{
		System.out.printf("Employee Name: %s\t\tID: %d\t\tSalary: $%.2f\nDoctor Type: %s\tYears Experience: %d\n\n",name,employeeID,salary,doctorType,yearsExperience);
	}
}

class Surgeon extends Doctor
{
	Surgeon(String n, double s, String type, int y)
	{
		super(n,s,type,y);
	}	
	public boolean performSurgery(String patient)
	{
		double successChance = 0.5 + 0.05 * yearsExperience;
		if (successChance >= 1)
		{
			successChance = 0.99;
		}
		Random chance = new Random();
		//Generates a number between -100 and 0 and adds the success chance percentage value to that number to determine success
		int successful = (chance.nextInt(100) - 100) + (int)(100 * successChance);
		if (successful >= 0)
		{
			System.out.println("Doctor " + name + "\'s surgery was a success! " + patient + " will make a full recovery.");
			return true;
		}
		else
		{
			System.out.println("Doctor " + name + "\'s surgery failed, and " + patient + " died during the operation.");
			return false;
		}
	}
}

class Nurse extends Employee
{
	Nurse(String n, double s)
	{
		super(n,s);
		System.out.println("Nurse " + name + " constructed.");
	}
	public void bringMedicine(String patient)
	{
		System.out.println(name + " has brought " + patient + " their medicine.");
	}
	public void getDoctor(String patient, Doctor doc)
	{
		System.out.println("Doctor " + doc.getName() + " is now treating " + patient + ".");
	}
	public void doRounds(int floor)
	{
		System.out.println(name + " completed her rounds on floor " + floor + ".");
	}
}

class Receptionist extends Employee
{
	static ArrayList<String> patientList = new ArrayList<String>();
	Receptionist(String n, double s)
	{
		super(n,s);
		System.out.println("Receptionist " + name + " constructed.");
	}
	public boolean logPatient(String patient)
	{
		if (patientList.size() < 500)
		{
			patientList.add(patient);
			return true;
		}
		else
		{
			System.out.println("Hospital capacity reached. Patient could not be admitted");
			return false;
		}
	}
	public double billPatient(String patient, double cost)
	{
		if (patientList.contains(patient))
		{
			int index = patientList.indexOf(patient);
			patientList.remove(index);
			System.out.println(patient + " was removed from the system and has been billed " + "$" + cost + ".");
			return cost;
		}
		else
		{
			System.out.println(patient  + " could not be found in the system.");
			return 0.0;
		} 
	}
	public void assign(Employee emp, String patient)
	{
		System.out.println(emp.getName() + " has been assigned to " + patient +".");
	}
}

class Administrator extends Employee
{
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	Administrator(String n, double s)
	{
		super(n, s);
		System.out.println("Administrator " + name + " created.");
	}
	public void hire(Employee emp)
	{
		employeeList.add(emp);
	}
	public double getPayCheck(Employee emp)
	{
		//Biweekly paycheck
		return emp.getSalary()/24;
	}
}

class Janitor extends Employee
{
	Janitor(String n, double s)
	{
		super(n, s);
		System.out.println("Janitor " + name + " constructed.");
	}
	public void cleanFloor(int floor)
	{
		System.out.println(name + " cleaned floor " + floor + ".");
	}
}

/*********************
 * Nicolas Mitchell
 * CECS 220-01
 * Assignment 04
 * Problem 04
 * ******************/

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
import javax.swing.Timer; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingCar
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Moving Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Car car = new Car(0,900);
        MovingCarPanel panel = new MovingCarPanel(car);
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
        setPreferredSize(new Dimension(2000,1000));
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

class MovingCarPanel extends CarPanel
{
    Timer timer;
    MovingCarPanel(Car car)
    {
        super(car);
        timer = new Timer(20, new TimerListener());
        timer.start();
    }
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
    }
    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            for (int i = 0; i < 8; i++)
            {
                xCar[i] += 20;
            }
            for (int i = 0; i < 4; i++)
            {
                xWindow[i] += 20;
            }
            xWheel1 +=20;
            xWheel2 += 20;
            if(xCar[7] >= 2000)
            {
                for (int i = 0;i < 8;i++)
                {
                    xCar[i] -= 2500;
                }
                for (int i = 0;i < 4;i++)
                {
                    xWindow[i] -= 2500;
                }
                xWheel1 -= 2500;
                xWheel2 -= 2500;
            }
            repaint();
        }
    }
}