import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
/*****************
 Nicolas Mitchell
 CECS 220-01
 7/13/17
 Assignment 05
 Problem 03
 ****************/
class StringReader
{
    static StringTooLongException exc = new StringTooLongException();
    static ArrayList<String> stringList = new ArrayList<String>();
    public static void main(String[] args) throws StringTooLongException
    {
        Scanner scan = new Scanner(System.in);
        String inputString;
        System.out.println("Enter strings. When you are finished, enter \"DONE\"");
        try
        {
            inputString = scan.nextLine();
            while (!inputString.equals("DONE"))
            {
                if (inputString.length() > 20)
                {
                    throw exc;
                }
                else
                {
                    stringList.add(inputString);
                }
                inputString = scan.nextLine();
            }
            scan.close();
        }
        catch (StringTooLongException exc)
        {
            System.out.println(exc.getMessage());
            System.exit(1);
        }
        finally
        {
            System.out.println("\nHere are all the strings you entered: ");
            for (int i = 0; i < stringList.size();i++)
            {
                System.out.println(stringList.get(i));
            }
        }
    }
}

class StringTooLongException extends Exception
{
    public StringTooLongException()
    {
        super("The String entered is more than 20 characters! Terminating program.");
    }
}