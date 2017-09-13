/*******************
Nicolas Mitchell
8/30/17
CECS 302
Assignment 01
Problem 04
********************/

#include <iostream>

using namespace std;


template <class T>
class Collection{
    private:
        T *objList;
        int arrSize;
    public:
        Collection(T *objArr, int size){
            objList = objArr;
            arrSize = size;
        }void display(){
            if (isEmpty()){
                std::cout << "The collection is empty." << std::endl;
            }
            else{
                std::cout << "Array Size:\t" << arrSize << std::endl;
                for (int i = 0; i < arrSize; i++){
                    std::cout << objList[i] << std::endl;
                }
            }
        }bool isEmpty(){
            if (arrSize == 0){
                return true;
            }else{
                return false;
            }
        }void makeEmpty(){
            if (isEmpty()){
                return;
            }else{
                T* newArray = new T[0];
                objList = newArray;
                arrSize = 0;
            }
        }bool contains(T item){
            for (int  i = 0; i < arrSize; i++){
                if (objList[i] == item){
                    return true;
                }
            }
            return false;
        }void insert(int index, T item){
            if (isEmpty()){
                T *newArr = &item;
                objList = newArr;
                arrSize = 1;
            }else{
                arrSize++;
                T* newArr = new T[arrSize];
                for (int i = 0; i < arrSize; i++){
                    if (i < index){
                        newArr[i] = objList[i];
                    }else if (i == index){
                        newArr[i] = item;
                    }else{
                        newArr[i] = objList[i - 1];
                    }
                }
                objList = newArr;
            }
        }void remove(int index){
            if (!isEmpty()){
                arrSize--;
                T* newArr = new T[arrSize];
                for (int i = 0; i < arrSize;i++){
                    if (i < index){
                        newArr[i] = objList[i];
                    }else if (i >= index){
                        newArr[i] = objList[i + 1];
                    }
                }
                objList = newArr;
            }
        }
};

int main(){
    using namespace std;
    int nums[] = {1,6,45,23,11,9,66,133,14};
    Collection<int> col(nums,9);
    col.display();
    cout << "Should be true:\t\t\tcontains(23): \t\t" << col.contains(23) << endl;
    cout << "Should be false:\t\tcontains(1234): \t" << col.contains(1234) <<endl;
    cout << "Inserting 999 at index 4:" << endl;
    col.insert(4,999);
    col.display();
    cout << "Now removing index 4 from the array..." << endl;
    col.remove(4);
    col.display();
    cout << "Is collection empty?\tisEmpty(): \t\t\t" << col.isEmpty() << endl;
    cout << "Making empty...." << endl;
    col.makeEmpty();
    cout << "How about now?\t\t\tisEmpty(): \t\t\t" << col.isEmpty() << endl;
    col.display();
}
