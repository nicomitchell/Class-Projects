#include <stdio.h>

int main()
{
	float num=0,avg=0,cnt=0;
	do
	{
		printf("enter a number: ");
		scanf("%f", &num);
		if (num != 999)
		{
			avg += num;
			cnt++;
		}
	}while(num != 999);
	
	avg /= cnt;
	printf("There are %.0f grades.\t The average is %.2f\n", cnt, avg);
	return 0;
	system("pause");
}
