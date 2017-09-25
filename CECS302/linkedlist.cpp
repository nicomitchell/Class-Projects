#include <iostream>

using namespace std;

struct node {
    int data;
    struct node* next;
};

typedef struct node Node;

Node* newNode(int i) {
    Node* n = new Node;
    n->data = i;
    n->next = NULL;
}

Node* insert(Node* head, Node* n) {
    if (n->data == head->data) {
        return head;
    } if(n->data < head->data) {
        n->next = head;
        return n;
        //Will not occur on recursion
    }
    if(head->next == NULL) {
        head->next = n;
    } else {
        if (head->next->data < n->data) {
            insert(head->next, n);
        } else {
            n->next = head->next;
            head->next = n;
        }
    }
    return head;
}

void printLinkedList(Node* n) {
    while(n->next != NULL) {
        cout << n->data << endl;
        n = n->next;
    }
    cout << n->data <<endl;
}
//Removes node n from the linked list without access to the head
void remove(Node* n) {
    if (n != NULL) {
        if (n->next == NULL) {
            n = NULL;
        } else {
            n->data = n->next->data;
            n->next = n->next->next;
        }
    }
}

bool contains(Node* head, int i) {
    if (head != NULL) {
        if (head->data == i) {
            return true;
        } else {
            return contains(head->next, i);
        }
    }
    return false;
}
int main() {
    Node* n1 = newNode(4);
    Node* n2 = newNode(5);
    Node* n3 = newNode(2);
    Node* n4 = newNode(3);
    n1 = insert(n1,n2);
    n1 = insert(n1,n3);
    n1 = insert(n1,n4);
    printLinkedList(n1);
    remove(n3);
    printLinkedList(n1);
}