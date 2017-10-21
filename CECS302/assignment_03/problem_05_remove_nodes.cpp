/********************
 * Nicolas Mitchell
 * CECS 302
 * 10/18/17
 * Assignment 03
 * Problem 05
 * *****************/
#include <iostream>
#include "binarytree.cpp"
using namespace std;

typedef struct node Node;
void removeNode_1(Node* n) {
    if (n->left != NULL) {
        n->data = n->left->data;
        if (n->left->left == NULL) {
            n->left = NULL;
            return;
        }
        removeNode_1(n->left);
        return;
    }
}

int main(){
    Node* n0 = newNode(2);
    Node* n1 = newNode(5);
    Node* n2 = newNode(3);
    Node* n3 = newNode(7);
    Node* n4 = newNode(8);
    Node* n5 = newNode(6);
    insert(n0,n1);
    insert(n0,n2);
    insert(n0,n3);
    insert(n0,n4);
    insert(n0,n5);
    cout << "before removal: " << endl;
    printNodes(n0);
    removeNode_1(n3);
    cout << "after removal: " << endl;
    printNodes(n0);
}