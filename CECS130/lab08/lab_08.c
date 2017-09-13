#include <stdio.h>
#include <stdlib.h>


struct Test
{
    int tnum;
    float tscore;
};

int main()
{
    int amount, i;
	int rc = 0;
    struct Test *myTests;
    
    printf("How many tests have you had?\n");
    scanf("%d", &amount);

     myTests = (struct Test*) malloc(amount * sizeof(struct Test));
     if (myTests != NULL)
     {
         for (i = 0; i < amount; i++)
         {
             printf("\nEnter test number:");
             scanf("%d",&myTests[i].tnum);

             printf("Enter test score:");
             scanf("%f",&myTests[i].tscore);
         }
         for (i=0;i<amount;i++)
         {
             printf("\nTest Number %d:\t %.2f",myTests[i].tnum,myTests[i].tscore);
         }
         float sum = 0, average;
         for (i=0;i<amount;i++)
         {
             sum += myTests[i].tscore;
         }
         average = sum / amount;
         printf("\nYour average test score is %.2f.",average);
     }
     else
     {
     	printf("\nMemory allocation failed.");
		rc = -1;
     }
     return rc;
}
