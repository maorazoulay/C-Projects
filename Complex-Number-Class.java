#include <iostream>
#include <cmath>
using namespace std;

class Complex {
private:
	double r; //real part
	double i; //imaginary part

public:
	// constructors

	// default constructor
	Complex() {
		r = 0;
		i = 0;
	}

	Complex(double r1) { 
	  r = r1;
	  i = 0;
	}
	
	Complex(double r1, double i1) {
		r = r1;
		i = i1;
	}

	// setters and getters (these should be easy)
	int getR() {
		return r;
	}
	int getI() {
		return i;
	}
	void setR(double r1) {
		r = r1;
	}
	void setI(double i1) {
		i = i1;
	}

	// arithmetic operators

	Complex operator+(Complex c) {
		Complex t;
		t.r = r + c.r;
		t.i = i + c.i;
		return t;
	}
	Complex operator-(Complex c) {
		Complex t;
		t.r = r - c.r;
		t.i = i - c.i;
		return t;
	}
	
	//https://en.wikipedia.org/wiki/Complex_number#Multiplication_and_division
	Complex operator*(Complex c1) {
	  //(a+bi)(c+di) = (ac-bd) + (bc+ad)i
		double a = r, b = i, c = c1.r, d = c1.i;
		
		Complex t;
		t.r = a*c - b*d;
		t.i = b*c + a*d;
		
		return t;
	}
	
	Complex operator/(Complex c1) {
	  //(a+bi)/(c+di) = [(ac+bd)/(c^2+d^2)]+[(bc-ad)/(c^2+d^2)]i
		double a = r, b = i, c = c1.r, d = c1.i;

    Complex t;
		t.r = (a*c+b*d)/(c*c+d*d);
		t.i = (b*c-a*d)/(c*c+d*d);
		
		return t;
	}
	
	//We only need to output for this one
	friend ostream &operator<<(ostream &os, Complex c);
}; // end of Complex Class

ostream &operator<<(ostream &os, Complex c) {
	if (c.i == 0){
	  os << c.r; 
	} else if(c.i > 0){
	  os << c.r << "+" << c.i << "i";
	}	else { //c.i < 0
	  os << c.r << c.i << "i";
	}
	return os;
}

int main() {
  Complex c1(5);
  cout << "Expecting 5\t\t" << c1 << endl;
  Complex c2(10,-12);
  cout << "Expecting 10-12i\t" << c2 << endl;
  
  cout << "Expecting 15-12i\t" << c1+c2 << endl;
  cout << "Expecting -5+12i\t" << c1-c2 << endl;
  
  
	Complex m1(3,2), m2(1,4); //multiplication test
	cout << "Expecting -5+14i\t" << m1*m2 << endl;
	Complex d1(3,2), d2(4,-3); //division test
	cout << "Expecting 0.24+0.68i\t" << d1/d2 << endl;
  
	return 0;
}