/************************
 * Nicolas Mitchell
 * CECS 302
 * Assignment 03
 * Problem 05
 * 10/16/17
 * *********************/

#include <iostream>
#include <cstdlib>
#include <time.h>

typedef struct node {
    int data;
    struct node* left;
    struct node* right;

    node(int d) {
        data = d;
    }
} node;

bool contains(node* root, int data) {
    if (root == NULL) {
        return false;
    }
    else {
        if (root->data == data) {
            return true;
        }
        else if (root->data > data){
            return contains(root->left, data);
        }
        else { 
            return contains(root->right, data);
        }
    }
}

void insert(node* root,node* node_for_insertion){
    if (root != NULL){
        if(node_for_insertion->data <= root->data){
            if (root->left == NULL){
                root->left = node_for_insertion;
            } else {
                insert(root->left, node_for_insertion);
            }
        } else{
            if (root->right == NULL) {
                root->right = node_for_insertion;
            } else {
                insert(root->right, node_for_insertion);
            }
        }
    }
}

node* generateRandomTree(int n) {
    srand(time(NULL));
    int num = rand() % (n) + 1;
    node* root = new node(num);
    for (int i = 1; i < n; i++) {
        num = rand() % n + 1;
        while(contains(root,num)) {
            num = rand() %  n + 1;
        }
        insert(root, new node(num));
    }
    return root;
}


node* generateBalancedTree(int n, int min) {
    
    if (n > min) {
        int num = (min + n) / 2;
        //std::cout << num << std::endl;
        node* r = new node(num);
        r->left = generateBalancedTree(num,min);
        r->right = generateBalancedTree(n, num + 1);
        return r;
    }
    return NULL;
}

node* generateBalancedTree(int n) {
    generateBalancedTree(n+1, 1);
}

node* generateSkewedTree(int n) {
    node* r = new node(1);
    for (int i = 2; i <= n;i++) {
        node* tmp = new node(i);
        insert(r,tmp);
    }
    return r;
}
void printNodes(node* root){
    using namespace std;
    if (root != NULL) {
        if (root->left != NULL){
            printNodes(root->left);
        }
        cout << root->data << endl;
        if (root->right != NULL){
            printNodes(root->right);
        }
    } else {
        throw root;
    }
}

void printPostOrder(struct node* n) {
    if (n != NULL) {
        if (n->left != NULL) {
            printPostOrder(n->left);
        } if (n->right != NULL) {
            printPostOrder(n->right);
        }
        using namespace std;
        cout << n->data << endl;
    }
}

int main() {
    std::cout << "Random Tree: " << std::endl;
    node* n = generateRandomTree(10);
    printNodes(n);

    std::cout << "Postorder: " << std::endl;
    printPostOrder(n);

    std::cout << "\n\n Balanced: " << std::endl;
    node* b = generateBalancedTree(10);
    printNodes(b);
    std:: cout << "\nPostorder: " << std::endl;
    printPostOrder(b);

    std::cout << "\n\nSkewed: " << std::endl;
    node* s = generateSkewedTree(10);
    printNodes(s);
    std::cout << "\nPostorder: " << std::endl;
    printPostOrder(s);
}