/*********************
 * Nicolas Mitchell
 * CECS 302
 * 9/25/17
 * Assignment 2
 * Problem 04
 ********************/

 #include <iostream>
 #include <list>
 #include <iterator>

 using namespace std;
 
 list<int> findListOverlap(list<int>,list<int>);
 
 int main() {
     list<int> nums1,nums2;
     nums1.push_back(4);
     nums1.push_back(16);
     nums1.push_back(20);
     nums1.push_back(21);
     nums1.push_back(28);
     nums1.push_back(33);
     nums1.push_back(42);
     nums1.push_back(53);
     nums1.push_back(87);
     nums2.push_back(5);
     nums2.push_back(7);
     nums2.push_back(12);
     nums2.push_back(16);
     nums2.push_back(21);
     nums2.push_back(32);
     nums2.push_back(33);
     list <int> over = findListOverlap(nums1,nums2);
     cout << "List 1: ";
     list<int>::iterator itr;
     for (itr = nums1.begin();itr != nums1.end();++itr) {
         cout << *itr << " ";
     }
     cout <<"\nList 2: ";
     for (itr = nums2.begin();itr != nums2.end();++itr) {
         cout << *itr << " ";
     }
     cout << endl;
     itr = over.begin();
     for (itr;itr != over.end();++itr) {
         cout << *itr << endl;
     }
 }

 list<int> findListOverlap(list<int> l1, list<int> l2) {
    list<int> smaller, bigger, overlap; 
    if (l1.size() > l2.size()) {
         smaller = l1;
         bigger = l2;
     } else {
         smaller = l2;
         bigger = l1;
     }
      list<int>::iterator bigitr = bigger.begin();
      list<int>::iterator smallitr = smaller.begin();
      for (smallitr; smallitr != smaller.end(); ++smallitr) {
          bigitr = bigger.begin();
          for(bigitr; bigitr != bigger.end(); ++bigitr) {
              if (*smallitr == *bigitr) {
                 overlap.push_back(*smallitr);
                 break;
              }
          }
      }
     return overlap;
 }