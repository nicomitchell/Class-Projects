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
		toDoList.add(task2.getPriority() - 1, task2);
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
	{
		priority = pri;
	}
	public int getPriority()
	{
		return priority;
	}
}

interface Priority
{
	void setPriority(int pri);
	int getPriority();
}