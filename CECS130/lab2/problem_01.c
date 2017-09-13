/******************/
/*Nicolas Mitchell*/
/****CECS 130-01***/
/*****1/24/2017****/
/******Lab 02******/
/****Problem 01****/
/******************/

#include <stdio.h>

int main()
{
	int miles, yards;
	printf("Please enter the distance in miles: ");
	scanf("%d", &miles);
	
	yards = 1760 * miles;
	printf("Miles = %d \t Yards = %d", miles,yards);
	
	return 0;
	system("pause");
}
