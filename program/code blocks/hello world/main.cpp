#include <iostream>

using namespace std;

int thisisanumber(int y, int z);

int main()
{
  int x;
  int y;
  int z;

for(x=0;x<3;x++){
  cout<<"Please enter the first code: ";
  cin>> y;
  cin.ignore();
  cout<<"Please enter the second code: ";
  cin>> z;
  cin.ignore();
  if( thisisanumber( y, z) == 1260){
  cout<<"Access Granted\n";
  }
  else {
  cout<<"Access Denied\n";
  }
}
while(x=3){
  cout<<"Please enter the first code: ";
  cin>> y;
  cin.ignore();
  cout<<"Please enter the second code: ";
  cin>> z;
  cin.ignore();
  cout<<"Sorry you have been locked out\n";
}
  cin.get();
}
int thisisanumber(int y, int z){
    return y*z;
}
