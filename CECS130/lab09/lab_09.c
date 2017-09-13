/****************
Nicolas Mitchell
CECS 130-01
3/28/17
Lab 09
****************/

#include <stdio.h>
#include <stdlib.h>

void loadMyIncome(char*);

int main()
{
    char* fName = "myIncome.txt";
    loadMyIncome(fName);
    return 0;
}

void loadMyIncome(char* fName)
{
    FILE *fp;
    fp = fopen(fName,"r");
    char readLine[81];
    if (fp == NULL)
    {
        fprintf(stderr, "The file %s could not be opened.",fName);
    }
    else
    {
        fprintf(stdout, "The file %s was opened successfully.\n",fName);
        while (!feof(fp))
        {
            fscanf(fp,"%s",readLine);
            printf("I read: %s\n",readLine);
        }
    }
}
