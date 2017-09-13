/*****************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 01
*****************/
import java.text.NumberFormat;

public class AccountTest
{
	public static void main(String[] args)
	{
		Account newAccount = new Account("Nicolas Mitchell", 0001, 600);
		System.out.println("Nicolas Mitchell's account has " + newAccount.getBalance() + " dollars in it.");
		System.out.println("Trying to deposit -50 dollars: ");
		newAccount.deposit(-50.0);
		System.out.println("Trying to deposit 50 dollars: ");
		newAccount.deposit(50.0);
		System.out.println("Nicolas Mitchell account balance: " + newAccount.getBalance() + " dollars.");
		System.out.println("Withdrawing 350 dollars...");
		newAccount.withdraw(350.0, 3.50);
		System.out.println("Nicolas Mitchell account balance: " + newAccount.getBalance() + " dollars.");
		System.out.println("Attempting to withdraw $400...");
		newAccount.withdraw(400.0, 4.00);		
	}
}
class Account
{
	   private final double RATE = 0.035;  // interest rate of 3.5%

	   private long acctNumber;
	   private double balance;
	   private String name;

	   //-----------------------------------------------------------------
	   //  Sets up the account by defining its owner, account number, and initial balance.
	   //-----------------------------------------------------------------
	   public Account (String owner, long account, double initial)
	   {
	      name = owner;
	      acctNumber = account;
	      balance = initial;
	   }
	   //-----------------------------------------------------------------
	   //  Deposits the specified amount into the account. Returns the new balance.
	   //-----------------------------------------------------------------
	   public double deposit (double amount)
	   {
	   	if (amount > 0)
	   	{
	    	balance = balance + amount;
	    	return balance;
	   	}
	   	else
	   	{
	   		System.out.println("Error: Deposit Amount must be greater than zero.");
	   		return balance;
	   	}
	   }
	   //-----------------------------------------------------------------
	   //  Withdraws the specified amount from the account and applies the fee. Returns the new balance.
	   //-----------------------------------------------------------------
	   public double withdraw (double amount, double fee)
	   {
	   	if(balance - amount - fee > 0)
	   	{
	    	balance = balance - amount - fee;
	    	return balance;
	   	}
	   	else
	   	{
	   		System.out.println("Error: Not enough money in account to withdraw specified amount.");
	   		return balance;
	   	}
	   }
	   //-----------------------------------------------------------------
	   //  Adds interest to the account and returns the new balance.
	   //-----------------------------------------------------------------
	   public double addInterest ()
	   {
	      balance += (balance * RATE);
	      return balance;
	   }
	   //-----------------------------------------------------------------
	   //  Returns the current balance of the account.
	   //-----------------------------------------------------------------
	   public double getBalance ()
	   {
	      return balance;
	   }
	   //-----------------------------------------------------------------
	   //  Returns a one-line description of the account as a string.
	   //-----------------------------------------------------------------
	   public String toString ()
	   {
	      NumberFormat fmt = NumberFormat.getCurrencyInstance();
	      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
	   }
}

/******************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 02
******************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JFrame;

public class StyleOptionsPanelApp
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Style Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StyleOptionsPanel panel = new StyleOptionsPanel();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
public class StyleOptionsPanel extends JPanel
{
	private JLabel	saying;
	private JCheckBox	bold, italic;
	private JTextField size;
	public StyleOptionsPanel()
	{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));

		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);
		size = new JTextField(10); //creates text field with 10 character columns
		size.setBackground(Color.white);

		size.setEditable(true);	//makes the text field editable

		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		size.addActionListener(listener);	//uses ActionListener instead of ItemListener

		add(saying);
		add(bold);
		add(italic);
		add(size);

		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 100));
	}

	private class StyleListener implements ItemListener, ActionListener 	//ActionListener used for textField, ItemListener used for checkboxes
	{
		int style = Font.PLAIN; 	//Variables are declared OUTSIDE the methods rather than inside
		int sizeValue = 32;
		public void itemStateChanged(ItemEvent event)
		{
			style = Font.PLAIN;	//checks anew every time the checkboxes' states change

			if (bold.isSelected())
				style += Font.BOLD;

			if (italic.isSelected())
				style += Font.ITALIC;

			saying.setFont(new Font("Helvetica", style, sizeValue));
		}
		public void actionPerformed(ActionEvent event)
		{
			String sizeContent = size.getText();
			sizeValue = Integer.parseInt(sizeContent);	//transforms String from textField to int
			saying.setFont(new Font("Helvetica", style, sizeValue));
		}
	}
}

/******************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 03
******************/

import java.util.Scanner;
public class StringReader
{
	static String userString; 
	static int aCount,eCount,iCount,oCount,uCount,consonantCount;

	StringReader(String inputString)
	{
		userString = inputString;
		aCount = 0;
		eCount = 0;
		iCount = 0;
		oCount = 0;
		uCount = 0;
		consonantCount = 0;
		char[] charArray = userString.toCharArray(); //changes the string to a char array
		for(int counter = 0; counter < userString.length();counter++) //counts the amount of each vowel
		{
			if (charArray[counter] == 'a')
			{
				aCount++;
			}
			else if (charArray[counter] == 'e')
			{
				eCount++;
			}
			else if (charArray[counter] == 'i')
			{
				iCount++;
			}
			else if (charArray[counter] == 'o')
			{
				oCount++;
			}
			else if (charArray[counter] == 'u')
			{
				uCount++;
			}
			else
			{
				consonantCount++;
			}
		}
	}
	public static String getString()
	{
		return userString;
	}
	public static int getCount(char userChar) 
	{											//character used as argument is what count will be returned, 'a' will return the aCount, etc.
		if (userChar == 'a')
		{
			return aCount;
		}
		else if (userChar == 'e')
		{
			return eCount;
		}
		else if (userChar == 'i')
		{
			return iCount;
		}
		else if (userChar == 'o')
		{
			return oCount;
		}
		else if (userChar == 'u')
		{
			return uCount;
		}
		else //if user enters anything but a vowel
		{
			return consonantCount;
		}
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter a String: "); //user enters the string so I could test more strings
		String userString = scan.nextLine();
		StringReader myString = new StringReader(userString);
		System.out.println("String: " + myString.getString()); 			//prints the string and all of the counts
		System.out.println("Count of:\na: " + myString.getCount('a') + "\te: " + myString.getCount('e') + "\ti: " + myString.getCount('i'));
		System.out.println("o: " + myString.getCount('o') + "\tu: " + myString.getCount('u') + "\tOther: " + myString.getCount('s'));
	}
}

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

/*****************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 05
*****************/
import java.util.ArrayList;
public class CourseDriver
{
	public static void main(String[] args)
	{

		Course course1 = new Course("CECS 220");
		Student student1 = new Student("Nicolas", "Mitchell");
		student1.setTestScore(1,85);
		student1.setTestScore(2, 92);
		student1.setTestScore(3, 96.8);
		course1.addStudent(student1);
		Student student2 = new Student("John", "Smith");
		student2.setTestScore(1,78.5);
		student2.setTestScore(2, 81);
		student2.setTestScore(3,91);
		course1.addStudent(student2);
		Student student3 = new Student("Jane", "Doe");
		student3.setTestScore(1,62);
		student3.setTestScore(2,54.5);
		student3.setTestScore(3,68.9);
		course1.addStudent(student3);
		double c1average = course1.average();
		course1.roll();
		System.out.println("The average for the course is: " + c1average);
	}
}

class Course
{
	ArrayList<Student> studentList;
	String courseName;
	Course(String name)
	{
		courseName = name;
		studentList = new ArrayList<Student>(); //initializes empty ArrayList
	}
	public void addStudent(Student student)
	{
		studentList.add(student);
	}
	public double average()
	{
		int count = 0;
		double sum = 0;
		for (int i = 0; i < studentList.size(); i++)
		{
			Student temp = studentList.get(i);
			sum += temp.average();
			count++;
		}
		double average = sum / count;
		return average;
	}
	public void roll()
	{
		for (int i = 0; i < studentList.size(); i++)
		{
			System.out.print(studentList.get(i).toString());
			System.out.println("");
		}
	}
}

class Student
{
	private String	firstName, lastName;
	private Address	homeAddress, schoolAddress;
	private double testScore1,testScore2,testScore3;
	public Student(String first, String last)		
	{											//made this constructor so I wouldn't have to enter new addresses each time
		firstName = first;
		lastName = last;
		homeAddress = new Address("1900 S. 4th Street", "Louisville", "KY", 40208);
		schoolAddress = new Address("1900 S. 4th Street", "Louisville", "KY", 40208);
	}
	public Student(String first, String last, Address home, Address school)
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		testScore1 = 0;		//book challenge says to set all test scores to zero at first and manually set them
		testScore2 = 0;		//using the setTestScore method
		testScore3 = 0;
	}
	public void setTestScore(int testNum, double score)
	{
		switch (testNum)	//decides which test to set
		{
			case 1:
				testScore1 = score;
				break;
			case 2:
				testScore2 = score;
				break;
			case 3:
				testScore3 = score;
				break;
			default:
				break;
		}
	}
	public double getTestScore(int tNum)
	{
		switch (tNum)	//decides which test to set
		{
			case 1:
				return testScore1;
			case 2:
				return testScore2;
			case 3:
				return testScore3;
			default:
				return 0;
		}
	}
	public double average()
	{
		double average = ((testScore1 + testScore2 + testScore3) / 3);
		return average;
	}

	public String toString()
	{
		String result;

		result = firstName + " " + lastName + "\n";
		result += "Home Address:\n" + homeAddress + "\n";
		result += "School Address:\n" + schoolAddress + "\n";
		result += "Test Scores: \n1: " + testScore1 + "\t\t2: " + testScore2 + "\t\t3: " + testScore3 + "\n";

		return result;
	}
}

class Address
{
	private String	streetAddress, city, state;
	private long	zipCode;

	public Address(String street, String town, String st, long zip)
	{
		streetAddress = street;
		city = town;
		state = st;
		zipCode = zip;
	}

	public String toString()
	{
		String result;

		result = streetAddress + "\n";
		result += city + ", " + state + "  " + zipCode;

		return result;
	}
}

/****************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 06
****************/

import java.util.ArrayList;
public class PriorityDriver
{
	public static void main(String[] args)
	{
		Task task1 = new Task("Buy groceries.");
		Task task2 = new Task("Go to the gym.");
		Task task3 = new Task("Study for Physics exam.");
		Task task4 = new Task("Work on programming homework.");
		task1.setPriority(2);
		task2.setPriority(1);
		task3.setPriority(3);
		task4.setPriority(4);
		System.out.println("Task 1: " + task1.getTaskName() + " Priority: " + task1.getPriority() + "\tTask 2: " + task2.getTaskName() + " Priority: " + task2.getPriority());
		System.out.println("Task 3: " + task3.getTaskName() + " Priority: " + task3.getPriority() + "\tTask 4: " + task4.getTaskName() + " Priority: " + task4.getPriority());
		ArrayList<Task> toDoList = new ArrayList<Task>(4);
		toDoList.add(task2.getPriority() - 1, task2);			//Had to do task 2 first since it is at index 0
		toDoList.add(task1.getPriority() - 1, task1);
		toDoList.add(task3.getPriority() - 1, task3);
		toDoList.add(task4.getPriority() - 1, task4);
		System.out.println("\n\nAfter arranging by priority: ");
		for (int i = 0; i < toDoList.size();i++)
		{
			System.out.println("Task " + toDoList.get(i).getPriority() + ": " + toDoList.get(i).getTaskName());
		}
	}
}

class Task implements Priority
{
	String taskName;
	int priority;
	Task(String name)
	{
		taskName = name;
		priority = 0;
	}
	public String getTaskName()
	{
		return taskName;
	}
	public void setPriority(int pri) 
	{									//implements interface methods
		priority = pri;
	}
	public int getPriority()
	{
		return priority;
	}
}

interface Priority
{
	void setPriority(int pri);//implemented in Task class
	int getPriority();
}