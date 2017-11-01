/******************************
    Nicolas Mitchell
    CECS 302
    10/31/17
    Assignment 04
    Problem 01
******************************/
#include <iostream>
#include <vector>
#include <stdexcept>


typedef struct poly_number {
    double coeff;
    double exponent;
    poly_number(double c = 0, double e = 0) {
        coeff = c;
        exponent = e;
    }
    void print() {
        if (coeff != 1) {
            if (exponent > 1) {
                std::cout << coeff << "x^" << exponent;
            } else if (exponent == 1){
                std::cout << coeff << "x";
            } else {
                std::cout << coeff;
            }
        } else {
            if (exponent > 1) {
                std::cout << "x^" << exponent;
            } else if (exponent == 1) {
                std::cout << "x";
            } else {
                std::cout << coeff;
            }
        }
    }
} polyval;

polyval merge(polyval& obj1, polyval& obj2) {
    if(obj1.exponent == obj2.exponent) {
        obj1.coeff += obj2.coeff;
        obj2.coeff = 0;
        return obj1;
    } else {
        throw std::invalid_argument("Incompatible exponents.");
    }
}

class Polynomial {
    std::vector <polyval> values;
public:
    Polynomial(std::vector<polyval>& vals) {
        values = vals;
    }
    Polynomial() {
        values = std::vector<polyval>();
    }
    void clean() {
        for(std::vector<polyval>::iterator itr = values.begin();itr < values.end(); itr++) {
            //std::cout << "Iterating over " << itr->coeff << "x^" << itr->exponent << std::endl;
            if (itr->coeff == 0) {
                //std::cout << "erasing " << itr->coeff << "x^" << itr->exponent << std::endl;
                values.erase(itr);
                itr--; //goes back one since everything past that point is moved down one index
            }
        }
    }
    polyval& value_at(int index) {
        return values[index];
    }
    int get_size() {
        return values.size();
    }
    void add(polyval n) {
        values.push_back(n);
    }
    void add(double c, double e) {
        add(polyval(c,e));
    }
    void print_values() {
        values[0].print();
        for (int i = 1; i < values.size();i++) {
            std::cout << " + ";
            values[i].print();
        }
        std::cout << std::endl;
    }
    void sort() {
        for (int i = 0; i < values.size();i++) {
            for(int j = 0;j < values.size();j++) {
                if (i < j) {
                    if (values[i].exponent < values[j].exponent) {
                        std::swap(values[i],values[j]);
                    }
                } else {
                    if (values[i].exponent > values[j].exponent) {
                        std::swap(values[i],values[j]);
                    }
                }
            }
        }
    }
    void erase(int i) {
        values.erase(values.begin() + i);
    }
    Polynomial multiply(Polynomial p2) {
        std::vector<polyval> new_vec = std::vector<polyval>();
        for (int i = 0; i < get_size();i++) {
            for (int j = 0; j < p2.get_size();j++) {
                polyval tmp;
                tmp.coeff = value_at(i).coeff * p2.value_at(j).coeff;
                tmp.exponent = value_at(i).exponent + p2.value_at(j).exponent;
                new_vec.push_back(tmp);
            }
        }
        for(int i = 0; i < new_vec.size();i++) {
            for (int j = i + 1; j < new_vec.size();j++) {
                if (new_vec[i].exponent == new_vec[j].exponent) {
                    try {
                        merge(new_vec[i],new_vec[j]);
                    } catch(const std::invalid_argument& exc) {
                        std::cout << exc.what() << std::endl;
                    }
                }
            }
        }
        Polynomial new_polynomial = Polynomial(new_vec);
        new_polynomial.clean();
        new_polynomial.sort();
        return new_polynomial;
    }
    Polynomial multiply_by_sorting(Polynomial p2) {
        std::vector<polyval> new_vec = std::vector<polyval>();
        for (int i = 0; i < get_size();i++) {
            for (int j = 0; j < p2.get_size();j++) {
                polyval tmp;
                tmp.coeff = value_at(i).coeff * p2.value_at(j).coeff;
                tmp.exponent = value_at(i).exponent + p2.value_at(j).exponent;
                new_vec.push_back(tmp);
            }
        }
        Polynomial new_polynomial = Polynomial(new_vec);
        new_polynomial.sort();
        for (int i = 1; i < new_polynomial.get_size();i++) {
            if (new_polynomial.value_at(i).exponent == new_polynomial.value_at(i-1).exponent) {
                merge(new_polynomial.value_at(i-1),new_polynomial.value_at(i));
                new_polynomial.erase(i);
                i--;
            }
        }
        return new_polynomial;
    }
};
int main() {
    using namespace std;
    polyval num1(4,2);
    polyval num2(2,3);
    Polynomial a;
    a.add(4,4);
    a.add(6,3);
    a.add(1,2);
    a.add(2,1);
    a.add(3,0);
    cout << "Polynomial A:\t";
    a.print_values();
    Polynomial b;
    b.add(2,3);
    b.add(3,2);
    b.add(1,1);
    b.add(4,0);
    cout << "Polynomial B:\t";
    b.print_values();
    Polynomial c = a.multiply(b);
    Polynomial d = a.multiply_by_sorting(b);
    c.print_values();
    d.print_values();
}