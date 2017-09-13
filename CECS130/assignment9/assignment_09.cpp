/*********************
Nicolas Mitchell
CECS 130-01
4/20/17
Assignment 09
*********************/

#include <iostream>
#include <cmath>
using namespace std;

class vector
{
	float x;
	float y;
	float z;

public:
	vector();
	~vector();

	void setComponents(float xComp,float yComp,float zComp);
	void add_v(vector v);
	void display() const;
	vector operator+(const vector& v)
	{
		vector newV;
		newV.x = x + v.x;
		newV.y = y + v.y;
		newV.z = z + v.z;
		return newV;
	}
	float getLength()
	{
		double l;
		l = x*x+y*y+z*z;
		l = sqrt(l);
		return l;
	};
	bool operator==(vector &v)
	{
		if (getLength()==v.getLength())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
};

vector::vector()
{
	x = 0;
	y = 0;
	z = 0;
}

vector::~vector()
{}
void vector::setComponents(float xComp, float yComp, float zComp)
{
	x = xComp;
	y = yComp;
	z = zComp;
}
void vector::add_v(vector v)
{
	x += v.x;
	y += v.y;
	z += v.z;
}

void vector::display() const
{
	cout << "(" << x << ", " << y << ", " << z << ")\n";
}
int main()
{
	vector vector1 = vector();
	vector1.setComponents(5.1,8.8,-4.0);

	cout << "Vector 1: ";
	vector1.display();
	cout << "Length: " << vector1.getLength()<< "\n" << endl;
	
	vector vector2 = vector();
	vector2.setComponents(-4.3,-10.0,5.6);
	
	cout << "Vector 2: ";
	vector2.display();
	cout << "Length: " << vector2.getLength() << "\n" << endl;

	vector vector3 = vector1+vector2;
	
	cout << "Vector 3: ";
	vector3.display();
	cout << "Length: " << vector3.getLength() << "\n" << endl;
	
	vector1 = vector3;
	cout << "Vector one new length: " << vector1.getLength() << "\n" << endl;
	
	if (vector1 == vector3)
	{
		cout << "Vectors one and three have equal length." << endl;
	}
	else
	{
		cout << "Vectors one and three do NOT have equal length!" << endl;
	}
}
