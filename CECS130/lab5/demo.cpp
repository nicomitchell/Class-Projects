#include <stdio.h>

void addthem(void);
const int testConst = 11;

int main()
{
	int i;
	printf("\tStatic storage class example\n");
	printf("Enter 5 numbers you would like to sum.");

	for (i=0; i < 5;++i)
	{
		addthem();
	}
	return 0;
}

void addthem()
{
	static int sum;
	int num;
	printf("Enter a number: ");
	scanf("%d", &num);
	sum += num;
	printf("The test const is %d\n", testConst);
	printf("The sum is %d\n", sum);
}
