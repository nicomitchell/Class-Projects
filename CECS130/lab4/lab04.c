/***************
Nicolas Mitchell
CECS 130-01
2/7/2017
Lab 03
***************/

#include <stdio.h>

int main()
{
	int i, num, result = 1;
	
	printf("Enter a number: ");
	scanf("%d", &num);
	
	for ( i = 1; i <= num; i++)
		result *= i;
	printf("%d! = %d.\n", num, result);
	printf("That calculation used the for loop.\n\n");
	
	result = 1;
	i = 1;
	while(i<=num){
		result *= i;
		i++;
	}
	printf("%d! = %d.\n", num, result);
	printf("That calculation used the while loop.\n");
	return 0;
	system("pause");
}
