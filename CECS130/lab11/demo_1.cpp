/****************
Nicolas Mitchell
CECS 130-01
4/11/2017
Lab 11
***************/

#include <iostream>
#include <string>

using namespace std;

class myStrings
{
	friend ostream& operator <<(ostream& , const myStrings&);

private:
	string insideString;
public:
	myStrings();
	myStrings(string);
	myStrings operator+(const myStrings&);
};

myStrings::myStrings()
{
	insideString = "" ;
}
myStrings::myStrings(string newString)
{
	insideString = newString;
}
myStrings myStrings::operator+(const myStrings& rhs)
{
	myStrings newStrings(this->insideString.append(rhs.insideString));
	return newStrings;
}

ostream& operator<<( ostream& ostr,const myStrings& z)
{
	return ostr << z.insideString;
}

int main()
{
	myStrings fName("Nicolas");
	myStrings lName("Mitchell");
	cout << fName << endl;
	cout << lName << endl;
	myStrings fullName = fName + myStrings(" ") + lName;
	cout << fullName << endl;
	return 0;	
}
