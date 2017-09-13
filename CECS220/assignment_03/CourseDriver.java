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
