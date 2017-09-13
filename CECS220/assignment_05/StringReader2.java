import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
/*****************
 Nicolas Mitchell
 CECS 220-01
 7/13/17
 Assignment 05
 Problem 04
 ****************/
class StringReader2
{
    static StringTooLongException exc = new StringTooLongException();
    static ArrayList<String> stringList = new ArrayList<String>();
    public static void main(String[] args) throws StringTooLongException
    {
        Scanner scan = new Scanner(System.in);
        String inputString;
        System.out.println("Enter strings. When you are finished, enter \"DONE\"");
        inputString = scan.nextLine();
        while (!inputString.equals("DONE"))
        {
            try
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
            catch (StringTooLongException exc)
            {
                System.out.println(exc.getMessage());
                inputString = scan.nextLine();
                continue;
            }
            finally
            {
                if (inputString.equals("DONE"))
                {
                    System.out.println("\nHere are all the strings you entered: ");
                    for (int i = 0; i < stringList.size();i++)
                    {
                        System.out.println(stringList.get(i));
                    }
                    scan.close();
                }
            }
        }
    }
}

class StringTooLongException extends Exception
{
    public StringTooLongException()
    {
        super("The String entered is more than 20 characters!");
    }
}