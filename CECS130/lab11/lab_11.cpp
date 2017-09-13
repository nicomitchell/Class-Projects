/****************
Nicolas Mitchell
CECS 130-01
4/11/2017
Lab 11
***************/

#include <iostream>

using namespace std;

class Date
{
	friend ostream& operator<<(ostream&, const Date&);
	friend Date operator+(const Date&, int);
private:
	int month;
	int day;
	int year;
public:
	Date();
	Date(int, int, int);
	Date(Date&);
};

Date::Date()
{
	month = 1;
	day = 1;
	year = 2017;
}

Date::Date(int mm, int dd, int yr)
{
	month = mm;
	day = dd;
	year = yr;
}
Date::Date(Date& iDate)
{
	month = iDate.month;
	day = iDate.day;
	year = iDate.year;
}
Date operator+(const Date& curDate, int numberDays)
{
	Date myDate(curDate.month,curDate.day,curDate.year);
	while (numberDays >= 360)
	{
		myDate.year++;
		numberDays -= 360;
	}
	while (numberDays >= 30)
	{
		myDate.month++;
		numberDays -= 30;
	}
	myDate.day += numberDays;

	if (myDate.day > 30)
	{
		myDate.month++;
		myDate.day -= 30;
	}
	if (myDate.month > 12)
	{
		myDate.year++;
		myDate.month -= 12;
	}
	return myDate;
}

ostream& operator<<(ostream& ostr,const Date& myDate)
{
	return ostr << myDate.year << "/" << myDate.month << "/" << myDate.day;
}

int main()
{
	Date dateOne;
	Date dateTwo(4,11,2017);
	cout << "Date One: " << dateOne << endl;
	cout << "Date Two: " << dateTwo << endl;
	Date newDate(dateTwo);
	cout << "Cloned date: " << newDate << endl;
}
