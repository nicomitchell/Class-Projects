/******************
Nicolas Mitchell
CECS 130-01
1/31/17
Demo 1
******************/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int i, j, k;
	int oldI, oldJ, oldK;
	
	printf("Enter three values, separated by commas: ");
	scanf("%d,%d,%d", &i, &j, &k);
	
	oldI = i;
	oldJ = j;
	oldK = k;
	
	printf("\ni++\n");
	i++;
	printf("i = %d\n", i);
	i = oldI;
	printf("++i\n");
	++i;
	printf("i = %d\n", i);
	
	i = oldI;
	
	printf("j*=++i\n");
	j *= ++i;
	printf("i = %d, j =%d\n", i, j);
	i = oldI;
	j = oldJ;
	printf("j*=i++\n");
	j *= i++;
	printf("i = %d, j = %d \n", i,j);
	
}
