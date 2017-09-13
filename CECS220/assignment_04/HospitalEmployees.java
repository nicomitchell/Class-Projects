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