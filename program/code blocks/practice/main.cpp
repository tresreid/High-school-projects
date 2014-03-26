#include <iostream>
#include <cmath>

using namespace std;

double weight( int m);

int main()
{

    int m;


    cout << "Please enter the tempurature in celsius: ";
    cin >> m;
    cin.ignore();
    cout << "The tempurature in fahrenheit is:"<< weight(m) <<"\n";

    cin. get();

}
double weight( int m){
    return m*1.8+32;
}
