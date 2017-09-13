#include <stdio.h>

int main()
{
	int i,num, answer=1;
	printf("Enter a number: ");
	scanf("%d", &num);
	
	for(i = num; i > 0; i--)
		answer *= i;
	printf("%d! = %d\n", num,answer);
	return 0;
}
