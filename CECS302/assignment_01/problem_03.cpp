/*******************
Nicolas Mitchell
8/30/17
CECS 302
Assignment 01
Problem 03
********************/

#include <iostream>
#include <math.h>

double sum1(double maxdifference)
{
    double sum = 0, lastsum;
    int i = 0;

    sum += 1/pow(4,i);
    std::cout << "i = " << i << std::endl << "Sum: " << sum << std::endl;        
    i++;
    
    while(sum - lastsum > maxdifference)
    {
        lastsum = sum;
        sum += 1/pow(4,i);
        std::cout << "i = " << i << std::endl << "Sum: " << sum << std::endl;
        i++;
    }
    
    return sum;
}

double sum2(double maxdifference)
{
    double sum = 0, lastsum;
    int i = 1;

    sum += i/pow(4,i);
    std::cout << "i = " << i << std::endl << "Sum: " << sum << std::endl;        
    i++;
    while(sum - lastsum > maxdifference)
    {
        lastsum = sum;
        sum += i/pow(4,i);
        std::cout << "i = " << i << std::endl << "Sum: " << sum << std::endl;
        i++;
    }
    return sum;
}

int main()
{
    std::cout.precision(15);
    std::cout << "Sum of 1/4^i" << std::endl;
    double s1 = sum1(0);
    std::cout << "Final sum: " << s1;
    std::cout << "\n---------------------------------------------------\n";
    std::cout << "\nSum of i/4^i" << std::endl;
    double s2 = sum2(0);
    std::cout << "Final sum: " << s2;
}
