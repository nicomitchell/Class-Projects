/******************** 
Nicolas Mitchell
CECS 220-01
7/11/2017
Assignment 05
Problem 01
********************/

public class Speakers
{
    public static void main(String[] args)
    {
        Speaker s1 = new Preacher("Bob");
        s1.speak();
        s1.announce("I love God like Kanye loves Kanye.");
        s1 = new Senator("Bernie Sanders", "Vermont", 'D');
        s1.speak();
        s1.announce("The top 1% of 1% controls 99% of the wealth in the United States!");
        s1 = new Attorney("Bob Loblaw");
        s1.speak();
        s1.announce("Objection!");
    }

}
interface Speaker
{
 public void speak();
 public void announce (String str);
}

class Preacher implements Speaker
{
    String name;
    Preacher(String n)
    {
        name = n;
    }
    public void speak()
    {
        System.out.println("Father " + name + " begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println("Father " + name + " makes an announcement:\n\t\"" + str + "\"");
    }
}

class Senator implements Speaker
{
    String name;
    String state;
    char party;
    Senator(String n, String s, char p)
    {
        name = n;
        state= s;
        party = p;
    }
    public void speak()
    {
        System.out.println("Senator " + name + " (" + party + "-" + state + ") begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println("Senator " + name + " (" + party + "-" + state + ") makes an announcement: ");
        System.out.println("\t\"" + str + "\"");
    }
}

class Attorney implements Speaker
{
    String name;
    Attorney(String n)
    {
        name = n;
    }
    public void speak()
    {
        System.out.println(name + ", Attorney at Law, begins speaking.");
    }
    public void announce(String str)
    {
        System.out.println(name + ", Attorney at Law, makes an announcement:\n\t\"" + str + "\"");
    }
}