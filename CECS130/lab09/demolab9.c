#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//DEMO 1
/*
int main()
{
    FILE *outFile;
    char *fileName = "myIncome.txt";

    outFile = fopen(fileName, "w");

    if (outFile == NULL)
    {
        printf("File %s could not be opened.",fileName);
    }
    else
    {
        printf("File %s opened successfully", fileName);
        fputs("January Income = $2000",outFile);
        fputs("\n",outFile);
        fputs("February Income = $4000",outFile);
        fclose(outFile);
    }
    return 0;
}
*/

//DEMO 2

int main()
{
    char* fName = "myIncome.txt";
    FILE* pFile;
    char tempBuf[81];

    pFile = fopen(fName,"r");
    
    if (pFile == NULL)
    {
        fprintf(stderr, "File %s could not be opened.",fName);
    }
    else
    {
        fprintf(stdout, "File %s opened successfully\n",fName);
        while (!feof(pFile))
        {
            fgets(tempBuf,80,pFile);
            printf("I read: %s\n",tempBuf);
        }
        fclose(pFile);
    }
    return 0;
}

