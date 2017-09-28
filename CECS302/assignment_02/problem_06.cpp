/**********************
 * Nicolas Mitchell
 * CECS 302
 * Assignment 02
 * Problem 06
 * *******************/
#include <iostream> 

using namespace std;

struct node {
    int data;
    struct node* next;
} typedef Node;

Node* newNode(int d) {
    Node* n = new Node();
    n->data = d;
    n->next = NULL;
}
void printInReverse(Node* head) {
    Node* cur = head;
    Node* next = NULL;
    Node* prev = NULL;
    while (cur != NULL) {
        next = cur->next;
        cur->next = prev;
        prev = cur;
        cur = next;
    }
    Node* nodeitr = prev;
    while(nodeitr != NULL) {
        cout << nodeitr->data << " ";
        nodeitr = nodeitr->next;
    }
}

int main() {
    Node* head = newNode(11);
    Node* n1 = newNode(9);
    Node* n2 = newNode(7);
    Node* n3 = newNode(4);
    Node* n4 = newNode(1);
    head->next = n1;
    n1->next = n2;
    n2->next  = n3;
    n3->next = n4;

    cout << "List in order: " << endl;
    Node* tmp = head;
    while (tmp != NULL) {
        cout << tmp->data << " ";
        tmp = tmp->next;
    }
    cout << "\nList reversed: " << endl;
    printInReverse(head);
}