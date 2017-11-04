#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
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
bool str_contains(string s, char c) {
    for(int i = 0; i < s.length();i++) {
        if (c == s[i]) {
            return true;
        }
    }
    return false;
}
bool check_for_shuffled(string wrong, string right) {
    int occurrences = 0;
    for (int i = 0; i < wrong.length() - 1; i++) {
        if (wrong[i] == right[i + 1] && right[i] == wrong[i + 1]) {
            occurrences++;
        }
    }
    if (occurrences == 1) {
        return true;
    }
    return false;
}
bool check_for_removal(string wrong, string right) {
    int occurrences = 0;
    string::iterator i,j;
    i = wrong.begin();
    j = right.begin();
    while(i != wrong.end() && j != right.end()) {
        if (*i != *j) {
            occurrences++;
            i++;
        }
        i++;
        j++;
    }
    if (i++ != wrong.end()) {
        occurrences++;
    }
    if (occurrences == 1) {
        return true;
    }
    return false;
}
bool check_for_add(string wrong, string right) {
    int occurrences = 0;
    string::iterator i,j;
    i = wrong.begin();
    j = right.begin();
    while(i != wrong.end() && j != right.end()) {
        if (*i != *j) {
            occurrences++;
            j++;
        }
        i++;
        j++;
    }
    if (j++ != right.end()) {
        occurrences++;
    }
    if (occurrences == 1) {
        return true;
    }
    return false;
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
        nodes = vector<node*>(128);
        for (int i = 0;i < 128;i++) {
            nodes[i] = NULL;
        }
    }
    hash_table(node* n) {
        nodes = vector<node*>(128);
        for (int i = 0;i < 128;i++) {
            nodes[i] = NULL;
        }
        insert(n);
    }
    void insert(node* n) {
        int index = hash(n);
        //cout << n->text << " inserted at " << index << endl;
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
    bool contains(string text) {
        int index = hash(text[0]);
        node* tmp = nodes[index];
        while (tmp != NULL) {
            if (text == tmp->text) {
                return true;
            }
            tmp = tmp->next;
        }
        return false;
    }
    void print_all() {
        node* tmp;
        for (int i = 0; i < 128; i++) {
            tmp = nodes[i];
            while(tmp != NULL) {
                cout << tmp->text << endl;
                tmp = tmp->next;
            }
        }
    }
    vector<string> find_closest_match(string s) {
        vector<string> matches;
        int characters_shared;
        int index = hash(s[0]);
        node* tmp = nodes[index];
        while(tmp != NULL) {
            characters_shared = 0;
            for (int i = 0; i < tmp->text.length();i++) {
                if (str_contains(s,tmp->text[i])) {
                    characters_shared++;
                }
            }
            if (characters_shared == s.length() ||
                characters_shared == s.length() - 1) {
                if (s.length() == tmp->text.length()) { 
                    if (check_for_shuffled(s,tmp->text)) {
                        matches.push_back(tmp->text);
                    }
                } else if (s.length() - tmp->text.length() == 1) {
                    if (check_for_removal(s,tmp->text)) {
                        matches.push_back(tmp->text);
                    }
                } else if (tmp->text.length() - s.length() == 1) {
                    if (check_for_add(s,tmp->text)) {
                        matches.push_back(tmp->text);
                    }
                }
            }
            tmp = tmp->next;
        }
        return matches;
    }
};

hash_table get_dictionary(char* file_name) {
    ifstream f;
    hash_table dict;
    f.open(file_name);
    if (!f) {
        throw ("No file found.");
    } else {
        string tmp;
        while(f >> tmp) {
            dict.insert(tmp);
        }
    }
    return dict;
}

int main() {
    typedef hash_node node;
    typedef hash_table table;
    table dict, dict_personal;
    cout << "Do you have a personal dictionary?\n1)Yes\n2)No" << endl;
    int choice;
    cin >> choice;
    if (choice == 1) {
        cout << "\nWhat is the name of the file you want to use? ";
        char file_name[100];
        cin >> file_name;   
        try {
            dict_personal = get_dictionary(file_name);
        } catch (...) {
            cout << "File could not be found.";
        }
    }

    dict = get_dictionary("words_list.txt");
    cout << "\nImported dictionary." << endl;
    
    char file_name[100];
    cout << "What is the name of the file you're checking? "; 
    cin >> file_name;
    vector<string> text;
    try {
        text = get_text(file_name);
    } catch(...) {
        cout << "file could not be found. using default text file." << endl;
        text = get_text("test.txt");
    }
    cout << "\n\nYour text file: " << endl;
    for(int i = 0; i < text.size();i++) {
        cout << text[i] << " ";    
    }
    cout << endl << endl;
    for(int i = 0; i < text.size();i++) {
        if (!dict.contains(text[i]) && !dict_personal.contains(text[i])) {
            cout << "Misspelled word - Line " << i << ":\t" << text[i] << endl;
            vector<string> potential_replacements = dict.find_closest_match(text[i]);
            vector<string> personal_potential_replacements = dict_personal.find_closest_match(text[i]);
            cout << "Potential replacements: " << endl;
            cout << potential_replacements[0];
            for (int i = 1; i < potential_replacements.size();i++) {
                cout << ",\t" << potential_replacements[i];
            }
            for (int i = 0; i < personal_potential_replacements.size();i++) {
                cout << ",\t" << personal_potential_replacements[i];
            }
            cout << endl << endl;
        }
    }
    cout << "All mistakes found." << endl;
}