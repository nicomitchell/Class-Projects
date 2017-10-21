/****************
 * Nicolas Mitchell
 * CECS 302
 * Assignment 03
 * Problem 03
 * *************/
#include <iostream>

typedef struct node{
    int data;
    int sizeLeft;
    int sizeRight;
    struct node* left;
    struct node* right;

    node(int d) {
        data = d;
        sizeLeft = sizeRight = 0;
        left = right = NULL;
    }
} node;

void insert(struct node* root,struct node* node_for_insertion){
    if (root != NULL){
        if(node_for_insertion->data <= root->data){
            if (root->left == NULL){
                root->left = node_for_insertion;
                root->sizeLeft++;
            } else {
                insert(root->left, node_for_insertion);
                root->sizeLeft++;
            }
        } else{
            if (root->right == NULL) {
                root->right = node_for_insertion;
                root->sizeRight++;
            } else {
                insert(root->right, node_for_insertion);
                root->sizeRight++;                
            }
        }
    }
}
node* findKth(node* root, int k) {
    if (k == root->sizeLeft + 1) {
        return root;
    } else {
        if (k <= root->sizeLeft) {
            return findKth(root->left,k);
        } else {
            return findKth(root->right, k - root->sizeLeft - 1);
        }
    }
}

void printNodes(struct node* root){
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

int main() {
    using namespace std;
    node* h = new node(5);
    node* n1 = new node(1);
    node* n2 = new node(6);
    node* n3 = new node(8);
    node* n4 = new node(19);
    node* n5 = new node(22);
    node* n6 = new node(3);
    node* n7 = new node(2);
    insert(h,n1);
    insert(h,n2);
    insert(h,n3);
    insert(h,n4);
    insert(h,n5);
    insert(h,n6);
    insert(h,n7);
    cout << "All nodes: " << endl;
    printNodes(h);
    int k;
    cout << "Enter k: ";
    cin >> k;
    if (k < 1 || k > h->sizeLeft + h->sizeRight + 1) {
        cout << k << " is an invalid value for k." << endl;
    } else {
        cout << k << " smallest number in tree: " << findKth(h,k)->data;
    }
}