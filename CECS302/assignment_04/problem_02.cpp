#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;
vector<string> get_text(char* f_name) {
    vector<string> words;
    ifstream file_stream;
    file_stream.open(f_name);
    if (!file_stream) {
        throw "No file found";
    } else {
        string temp;
        while (file_stream >> temp) {
            words.push_back(temp);
        }
    }
    file_stream.close();
    return words;
}

struct hash_node {
    char key;
    string text;
    hash_node* next;
    hash_node(string t) {
        key = t[0];
        next = NULL;
        text = t;
    }
    insert(hash_node* n) {
        hash_node* tmp = next;
        if (tmp == NULL) {
            next = n;
        } else {
            while (tmp->next != NULL) {
                tmp = tmp->next;
            }
            tmp->next = n;
        }
    }
};

class hash_table {
    typedef hash_node node;
    vector<node*> nodes;
    int hash(node* n) {
        return (int)(n->key);
    }
    int hash(char key) {
        return (int)key;
    }
public:
    hash_table() {
        nodes = vector<node*>(256);
        for (int i = 0;i < 256;i++) {
            nodes[i] = NULL;
        }
    }
    hash_table(node* n) {
        nodes = vector<node*>(256);
        for (int i = 0;i < 256;i++) {
            nodes[i] = NULL;
        }
        insert(n);
    }
    void insert(node* n) {
        int index = hash(n);
        cout << n->text << " inserted at " << index << endl;
        if (nodes[index] == NULL) {
            nodes[index] = n;
        } else {
            nodes[index]->insert(n);
        }
    }
    void insert(string text) {
        node* tmp = new node(text);
        insert(tmp);
    }
    //returns the first node in the linked list of that key
    node* get(char key) {
        int index = hash(key);

        return nodes[index];
    }
    node* get(string text) {
        node* r_node = get(text[0]);
        if (r_node != NULL) {
            while (r_node->text != text && r_node != NULL) {
                r_node = r_node->next;
            }
        }
        return r_node;
    }
    void print_all() {
        node* tmp;
        for (int i = 0; i < 256; i++) {
            tmp = nodes[i];
            while(tmp != NULL) {
                cout << tmp->text << endl;
                tmp = tmp->next;
            }
        }
    }
};


int main() {
    typedef hash_node node;
    typedef hash_table table;
    // vector<string> dictionary = get_text("test.txt");
    // for (int i = 0; i < dictionary.size();i++) {
    //     cout << dictionary[i] << endl;
    // }
    node* n = new hash_node("6est");
    table t(n);
    t.insert("elevator");
    t.insert("blood");
    t.insert("zest");
    t.insert("test");
    t.insert("table");
    t.insert("body");
    t.insert("tarnation");
    t.print_all();
}