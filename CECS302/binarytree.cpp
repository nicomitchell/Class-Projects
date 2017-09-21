#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;
struct node{
    int data;
    node* left;
    node* right;
};

struct node* newNode(int data){
    struct node* node = new struct node;
    node->data = data;
    node->left = node->right = NULL;
}

void insert(struct node* root,struct node* node_for_insertion){
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

bool contains(struct node* root, int data) {
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

void printNodes(struct node* root){
    if (root != NULL) {
        if (root->left != NULL){
            printNodes(root->left);
        }
        cout << root->data << endl;
        if (root->right != NULL){
            printNodes(root->right);
        }
    }
}

int size(struct node* n) {
    if (n == NULL) {
        return 0;
    }
    int sum = 1;   
    sum += size(n->left) + size(n->right);
    // if (n->left != NULL) {
    //     sum += size(n->left);
    // }
    // if (n->right != NULL) {
    //     sum += size(n->right);
    // }
    return sum;
}

int maxDepth(struct node* n) {
    if (n == NULL) {
        return 0;
    }
    int leftDepth = 1;
    int rightDepth = 1;
    if (n->left != NULL) {
        leftDepth += maxDepth(n->left);
    } if (n->right != NULL) {
        rightDepth += maxDepth(n->right);
    } if (leftDepth >= rightDepth) {
        return leftDepth;
    } else {
        return rightDepth;
    }
}

int minValue(struct node* n) {
    while (n->left != NULL) {
        n = n->left;
    }
    return n->data;
}

int maxValue(struct node* n) {
    while (n->right != NULL) {
        n = n->right;
    }
    return n->data;
}
void printPostOrder(struct node* n) {
    if (n != NULL) {
        if (n->left != NULL) {
            printPostOrder(n->left);
        } if (n->right != NULL) {
            printPostOrder(n->right);
        }
        cout << n->data << endl;
    }
}


int main() {
    struct node* node0 = newNode(62);
    struct node* node1 = newNode(8);
    struct node* node2 = newNode(14);
    struct node* node3 = newNode(29);
    struct node* node4 = newNode(3);
    struct node* node5 = newNode(77);
    struct node* node6 = newNode(53);
    struct node* node7 = newNode(64);
    insert(node0,node1);
    insert(node0,node2);
    insert(node0,node3);
    insert(node0,node4);
    insert(node0,node5);
    insert(node0,node6);
    insert(node0,node7);
    printNodes(node0);
    cout << "Number of nodes: " << size(node0) << endl;
    cout << "Depth: " << maxDepth(node0) << endl;
    cout << "Minimum value: " << minValue(node0) << "\tMaximum Value: " << maxValue(node0) << endl;
    cout << "Postorder: " << endl;
    printPostOrder(node0);
}
