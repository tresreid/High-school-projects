#include <iostream>

using namespace std;

int main()
{
  int x;
  int y;
  int array[11][11]; // Declares an array like a chessboard

  for ( x = 0; x < 11; x++ ) {
    for ( y = 0; y < 11; y++ )
      array[x][y] = x * y; // Set each element to a value
  }
  cout<<"Array Indices:\n";
  for ( x = 0; x < 11;x++ ) {
    for ( y = 0; y < 11; y++ )
      cout<<"["<<x<<"]["<<y<<"]="<< array[x][y] <<" ";
    cout<<"\n";
  }
  cin.get();
}
