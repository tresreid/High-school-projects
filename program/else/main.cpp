#include <iostream>

using namespace std;

int main()
{
  int age;

  cout<<"Please input your age: ";
  cin>> age;
  cin.ignore();
  if ( age < 100 ) {
     cout<<"You are pretty young!\n";
  }
  else if ( age == 100 ) {
     cout<<"You are old\n";
  }
  else {
    cout<<"You are really old\n";
  }
  cin.get();
}

