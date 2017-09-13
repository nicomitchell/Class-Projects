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
