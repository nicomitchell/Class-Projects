public class DoWhileDemo
{
	public static void main(String [] args)
	{
		String copyFromMe = "my name is johny smithy";
		char c;
		int i=0;
		do
		{
			System.out.print(c = copyFromMe.charAt(i));
			i++;
		}
		while ( c != 'y');
		System.out.println("\n");
	}
}