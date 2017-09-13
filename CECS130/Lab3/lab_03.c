/*****************
Nicolas Mitchell
CECS 130-01
Lab 03
*****************/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x, y, quadrant;
	printf("Enter x and y values, separated by a comma: ");
	scanf("%d,%d", &x,&y);
	
	printf("\nYour point is (%d,%d).\n", x,y);
	if (x >= 0)
	{
		if (y >= 0)
		{
			quadrant = 1;
		}
		else 
		{
			quadrant = 4;
		}
	}
	else
	{
		if (y >= 0)
		{
			quadrant = 2;
		}
		else
		{
			quadrant = 3;
		}
	}
	printf("Your point (%d,%d) is in Quadrant %d.\n", x,y,quadrant);
	system("pause");
}
