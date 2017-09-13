/*******************
Nicolas Mitchell
8/30/17
CECS 302
Assignment 01
Problem 02
********************/

#include <iostream>
#include <string>
#include <cstring>

using namespace std;
void permute(const string& str);
void permute(const string& str, int low, int high);

int main()
{
    string str = "abcd";
    permute(str);
}

void permute(const string& str){
    permute(str,0,str.length() - 1);
}

void permute(const string& str, int low, int high){
    char* o = new char[high - low];
    strcpy(o,str.c_str());
    if (low == high){
        cout << o << endl;
    }else{
        for(int i = low; i <= high;i++){
            swap(o[low],o[i]);
            permute(o,low+1,high);
            swap(o[low],o[i]);
        }
    }
    delete (o);
}

int fac(int n){
    if (n>1){
        return n * fac(n-1);
    }else{
        return n;
    }
}