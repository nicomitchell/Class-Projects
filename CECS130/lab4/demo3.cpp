#include <stdio.h>

int main()
{
	int c;
		
	printf("Enter a string to exit...\n");
	
	while ((c = getchar())!='\n')
	{
		switch(c)
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				c = toupper(c);
				break;
			default:
				c = tolower(c);
		}
		putchar(c);
	}
	printf("\n");
}
