#include <iostream>
#include "binarytree.cpp" //Several functions and implementation of binary tree written by me

int main()
{
    struct node* node0 = newNode(3);
    struct node* node1 = newNode(1);
    struct node* node2 = newNode(4);
    struct node* node3 = newNode(6);
    struct node* node4 = newNode(9);
    struct node* node5 = newNode(2);
    struct node* node6 = newNode(5);
    struct node* node7 = newNode(7);
    insert(node0,node1);
    insert(node0,node2);
    insert(node0,node3);
    insert(node0,node4);
    insert(node0,node5);
    insert(node0,node6);
    insert(node0,node7);
    /*
            Should be       3
                          /   \
                        1      4
                             /   \
                            2     6
                                 / \ 
                                5   9
                                   /
                                  7
    */
    cout << "All nodes in tree: " << endl;
    printNodes(node0); //prints all node data in order
    node0 = NULL; //delete root
    cout << "After Deletion\nLeft Tree: " << endl;
    printNodes(node1);
    cout << "Right tree: " << endl;
    printNodes(node2);
    //PrintNodes function throws an exception if root is null
    cout << "Trying to print nodes from previously deleted root..." << endl;
    try {
        printNodes(node0);
    }
    catch(...) {
        cout << "Root not found.";
    }
}