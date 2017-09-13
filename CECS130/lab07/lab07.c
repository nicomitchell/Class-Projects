/****************
Nicolas Mitchell
CECS 130-01
2/28/17
Lab 07
****************/

#include <stdio.h>
#include <string.h>

struct city
{
	char name[20];
	int population;
	double surfacearea;
};

int main()
{
	struct city cities[3];
	
	strcpy(cities[0].name,"Paradis");
	cities[0].population = 200000;
	cities[0].surfacearea = 75000.00;
	
	strcpy(cities[1].name,"Springfield");
	cities[1].population = 230000;
	cities[1].surfacearea = 82000.00;
	
	strcpy(cities[2].name,"Paradis");
	cities[2].population = 134000;
	cities[2].surfacearea = 42000.00;
	int i;
	double popDensity;
	for (i=0;i<3;i++)
	{
		popDensity = (cities[i].population)/(cities[i].surfacearea);
		printf("%s \t %.2f\t people per square mile.\n",cities[i].name,popDensity);
	}
}

