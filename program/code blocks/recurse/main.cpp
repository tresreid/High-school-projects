
#include <iostream>

using namespace std;

void recurse ( int count )
{
    if( count<100){
  cout<< count <<"\n";
  recurse ( count + 1 );
    }
else {
  cout<< "counting complete";
  return;
}
}

int main()
{
  recurse ( 1);
}

