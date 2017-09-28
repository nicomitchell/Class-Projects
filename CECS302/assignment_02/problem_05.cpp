#include <algorithm>
#include <iostream>



template <typename Object>
class Vector {

public:
    explicit Vector( int initSize = 0 ) : theSize{ initSize },
    theCapacity{ initSize + SPARE_CAPACITY }
    { objects = new Object[ theCapacity ]; }

    Vector( const Vector & rhs ) : theSize{ rhs.theSize },
    theCapacity{ rhs.theCapacity }, objects{ NULL }
    {
        objects = new Object[ theCapacity ];
        for( int k = 0; k < theSize; ++k )
        objects[ k ] = rhs.objects[ k ];
    }

    Vector & operator= ( const Vector & rhs )
    {
        Vector copy = rhs;
        std::swap( *this, copy );
        return *this;
    }

    ~Vector( )
    { delete [ ] objects; }

    Vector<Object>( Vector& rhs ) : theSize{ rhs.theSize },
    theCapacity{ rhs.theCapacity }, objects{ rhs.objects }
    {
        rhs.objects = NULL;
        rhs.theSize = 0;
        rhs.theCapacity = 0;
    }

    Vector & operator= ( Vector& rhs )
    {
        std::swap( theSize, rhs.theSize );
        std::swap( theCapacity, rhs.theCapacity );
        std::swap( objects, rhs.objects );

        return *this;
    }
    void resize( int newSize )
    {
        if( newSize > theCapacity )
        reserve( newSize * 2 );
        theSize = newSize;
    }
    
    void reserve( int newCapacity )
    {
        if( newCapacity < theSize )
        return;
    
        Object *newArray = new Object[ newCapacity ];
        for( int k = 0; k < theSize; ++k )
            newArray[ k ] = objects[k];
    
            theCapacity = newCapacity;
            std::swap( objects, newArray );
            delete [ ] newArray;
    }
    Object & operator[]( int index )
    {
        if (index < 0 || index > theCapacity) {
            throw "Index is out of bounds!";
        } else {
        return objects[ index ]; 
        }
    }
    
    const Object & operator[]( int index ) const
    { 
        if (index < 0 || index > theSize) {
        throw "Index is out of bounds!";
        } else {
            return objects[ index ]; 
        }
    }
    
    bool empty( ) const
    { return size( ) == 0; }
    
    int size( ) const
    { return theSize; }
   
    int capacity( ) const
    { return theCapacity; }
    
    void push_back( const Object & x )
    {
        if( theSize == theCapacity )
            reserve( 2 * theCapacity + 1 );
            objects[ theSize++ ] = x;
    }
    void pop_back( )
    {
        --theSize;
    }
    
    const Object & back ( ) const
    {
        return objects[ theSize - 1 ];
    }
    
    typedef Object * iterator;
    typedef const Object * const_iterator;
    
    iterator begin( )
    { return &objects[ 0 ]; }
    
    const_iterator begin( ) const
    { return &objects[ 0 ]; }
    
    iterator end( )
    { return &objects[ size( ) ]; }
    
    const_iterator end( ) const
    { return &objects[ size( ) ]; }
    
    static const int SPARE_CAPACITY = 16;
    
private:
    int theSize;
    int theCapacity;
    Object * objects;
};


int main()
{
    using namespace std;

    Vector<int> vec;
    vec.push_back(1);
    vec.push_back(4);
    vec.push_back(16);
    vec.push_back(22);
    vec.push_back(11);
    vec.push_back(7);
    cout << "Size: " << vec.size();
    for(int i = 0; i < vec.size();i++) {
        cout << vec [ i ] << endl;
    }
    int index;    
    try {
        while(1) {
            cout << "What index would you like to check?" << endl;
            cin >> index;
            cout << "Item at " << index << " is " << vec[ index ] << endl;
        }
    } catch (...) {
        cout << "Index out of bounds. Exiting program." << endl;
    }
}