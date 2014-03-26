#include <iostream>

using namespace std;

void recall (int num){

    if ( num == 1 ){
        cout<< "1""\n";
        cout<< "done";
        return;
    }
    else if ( num%2 == 0 ){
        cout<< num <<"\n";
         recall(num/2);

    }
    else {
        cout<< num <<"\n";
        recall( num + 1 );
    }
}

int main()
{
    int num;
    cin>> num;
    cin.ignore();
    recall (num);
}
