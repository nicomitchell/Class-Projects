/**********************
 * Nicolas Mitchell
 * CECS 302
 * 10/11/17
 * Assignment 03
 * Problem 04
 * *******************/

#include <iostream>

typedef struct node {
    int data;
    struct node* left;
    struct node* right;
    struct node* parent;

    node(int n) {
        data = n;
        left = right = NULL;
        parent = NULL;
    }
}node;

bool operator==(node& a, node& b) {
    return a.data == b.data;
}

class Set_Iterator{
    node* current;
public:
    Set_Iterator(node* c) {
        current = c;
    }
    ~Set_Iterator() {
        delete(current);
    }
    Set_Iterator& operator++() {
        if(current->right != NULL) {
            current = current->right;
            while (current->left != NULL) {
                current = current->left;
            }
        } else {
            node* tmp = current->parent;
            while(tmp != NULL && tmp->right == current) {
                current = tmp;
                tmp = tmp->parent;
            }
            current = tmp;
        }
        return *(this);
    }
    Set_Iterator& operator++( int ) {
        if(current->right != NULL) {
            current = current->right;
            while (current->left != NULL) {
                current = current->left;
            }
        } else {
            node* tmp = current->parent;
            while(tmp != NULL && tmp->right == current) {
                current = tmp;
                tmp = tmp->parent;
            }
            current = tmp;
        }
        return *this;
    }
    Set_Iterator& operator+=(int n) {
        for (int i = 0;i < n; i++) {
            current++;
        }
        return *this;
    }
    node& operator*() {
        return *current;
    }
};

bool operator==(Set_Iterator& a, Set_Iterator& s) {
    return (*a).data == (*s).data;
}
bool operator!=(Set_Iterator& a, Set_Iterator& s) {
    return !(*a == *s);
}
class Set {
private:
    node* root;
    int size;
    node* insert(node* r, node* n) {
        if(r == NULL) {
            r = n;
            return n;
        } if (r->data == n->data) {
            return r;
        } if(n->data > r->data) {
            if (r->right == NULL) {
                r->right = n;
                n->parent = r;
                return n;
            } 
            return insert(r->right, n);
        } else {
            if(r->left == NULL) {
                r->left = n;
                n->parent = r;
                return n;
            }
            return insert(r->left, n);
        }
    }
public:
    Set(node* r) {
        root = r;
        size = 1;
    }
    Set(int d) {
        node* tmp = new node(d);
        root = tmp;
    }
    ~Set() {
        delete(root);
    }
    node* insert(node* n) {
        size++;
        return insert(root,n);
    }
    node* insert(int n) {
        node* tmp = new node(n);
        return insert(tmp);
    }
    void printNodes() {
        printNodes(root);
    }
    void printNodes(node* n) {
        if (n != NULL) {
            printNodes(n->left);
            std::cout << n->data << std::endl;
            printNodes(n->right);
        }
    }
    void remove(node* n);
    Set_Iterator begin() {
        node* tmp = root;
        while (tmp->left != NULL) {
            tmp = tmp->left;
        }
        Set_Iterator itr(tmp);
        return itr;
    }
    Set_Iterator end() {
        node* tmp = root;
        while (tmp->right != NULL) {
            tmp = tmp->right;
        }
        Set_Iterator itr(tmp);
        return itr;
    }
};

int main() {
    Set s(5);
    s.insert(8);
    s.insert(10);
    s.insert(3);
    s.insert(2);
    s.insert(4);
    //s.printNodes();
    Set_Iterator itr = s.begin();
    Set_Iterator itr2 = s.end();
    itr++;itr++;itr++;
    std::cout <<(*itr).data;
    //while (itr!=itr2) {
    //    std::cout <<(*itr).data << std::endl;
    //    ++itr;
    //}
}