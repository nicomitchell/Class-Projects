/*******************
Nicolas Mitchell
8/30/17
CECS 302
Assignment 01
Problem 01
********************/
#include <iostream>

int numberOfBinaryOnes(int);

int main()
{
    using namespace std;
    int t = 4;
    int ones = numberOfBinaryOnes(t);
    //cout << "In binary "<< t << ",  there are " << ones << " ones." << endl;
}

int numberOfBinaryOnes(int n)
{
    int numOnes = 0;
    if (n > 0)
    {
        if(n % 2 == 1)
        {
            numOnes = 1 + numberOfBinaryOnes(n / 2);
        }
        else
        {
            numOnes = numberOfBinaryOnes(n / 2);
        }
    }
    std::cout << "In binary "<< n << ",  there are " << numOnes << " ones." << std::endl;    
    return numOnes;
}