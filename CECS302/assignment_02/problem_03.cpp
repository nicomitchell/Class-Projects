/******************
Nicolas Mitchell
CECS 302
Assignment 02
9/25/17
******************/
#include <iostream>
#include <cmath>

int minimumSubsequenceSum(int*,int);
int maximumSubsequenceProduct(int*,int);
using namespace std;
int main() {
    int numbers[] = {-1,-4,7,-2,10,3,-4,-2};
    cout << "Numbers : ";
    int i;
    for (i = 0; i < 8; i++) {
        cout << numbers[i] << " ";
    }
    cout << endl;
    cout << "Minimum subsequence sum: " << minimumSubsequenceSum(numbers,8) << endl;
    cout << "Max Subsequence Product: " << maximumSubsequenceProduct(numbers,8) << endl;

}

int minimumSubsequenceSum(int* nums, int size) {
    int current_sum = 0, min_sum = nums[0];
    for (int i = 0; i < size; i++) {
        current_sum += nums[i];
        if (current_sum < min_sum) {
            min_sum = current_sum;
        } else if (current_sum > 0) {
            current_sum = 0;
        }
    }
    return min_sum;
}

int maximumSubsequenceProduct(int* nums, int size) {
    int current_prod = 1, max_prod = nums[0];
    for (int i = 0; i < size; i++) {
        current_prod *= nums[i];
        if (current_prod > max_prod) {
            max_prod = current_prod;
        } else if (abs(current_prod) < 1) {
            current_prod = 1;
        }
    }
    return max_prod;
}