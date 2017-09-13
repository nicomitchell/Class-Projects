/***************
Nicolas Mitchell
CECS 130-01
Lab 05
2/14/2017
***************/

#include <stdio.h>

void adder(void), subtracter(void); //voids so they don't return any value
static int total; //initialized in main() function

int main()
{
	total = 0;
	int i; //i is used in the for loops
	for (i = 1; i <= 4; i++) //runs adder four times
	{
		adder();
		printf("\tThe running total is %d\n", total); //prints the total each time for debugging purposes
	}
	for(i = 1; i <= 4; i++) //runs subtractor four times
	{
		subtracter();
		printf("\tThe running total is %d\n", total);
	}
	return 0; 
}

void adder()
{
	int x;
	printf("\nEnter a value to add: ");
	scanf("%d", &x);
	total += x; //adds to static int total
}

void subtracter()
{
	int y;
	printf("\nEnter a value to subtract: ");
	scanf("%d", &y);
	total -=y; //subtracts from static int total
}
