/******************
Nicolas Mitchell
CECS 302
10/3/17
Assignment 03
Problem 02
******************/
#include <iostream>
#include "binarytree.cpp"

typedef struct node Node;
using namespace std;

int numberOfNodes(Node* n) {
    if (n == NULL) {
        return 0;
    }
    else {
        return 1 + numberOfNodes(n->left) + numberOfNodes(n->right);
    }
}

int numberOfLeaves(Node* n) {
    if (n == NULL) {
        return 0;
    } else if (n->left == NULL && n->right == NULL) {
        return 1;
    } else {
        return numberOfLeaves(n->left) + numberOfLeaves(n->right);
    }
}

int numberOfFullNodes(Node* n) {
    if (n == NULL) {
        return 0;
    }
    if (n->left == NULL) {
        return numberOfFullNodes(n->right);
    } 
    if (n->right == NULL) {
        return numberOfFullNodes(n->left);
    } else if (n->left != NULL) {
        return 1 + numberOfFullNodes(n->left) + numberOfFullNodes(n->right);
    }
}
int main() {
    Node* n0 = newNode(7);
    Node* n1 = newNode(6);
    Node* n2 = newNode(19);
    Node* n3 = newNode(23);
    Node* n4 = newNode(3);
    Node* n5 = newNode(4);
    Node* n6 = newNode(44);
    Node* n7 = newNode(1);
    /*
    * Should be                 7 (FULL)
    *                       6       19
    *       (FULL)       3              23
    *        (LEAF)   1    4 (LEAF)        44 (LEAF)
    *
    * So 2 full nodes, 3 leaves, 8 nodes
    */
    insert(n0,n1);
    insert(n0,n2);
    insert(n0,n3);    
    insert(n0,n4);
    insert(n0,n5);
    insert(n0,n6);
    insert(n0,n7);
    cout << "Nodes: " << endl;
    printNodes(n0);
    cout << "Number of Nodes: " << numberOfNodes(n0) << endl; 
    cout << "Number of Leaves: " << numberOfLeaves(n0) << endl;
    cout << "Number of Full nodes: " << numberOfFullNodes(n0);
}