#include <iostream>
#include <cmath>

using namespace std;

double weight( int m);

double normal(int m, int o);

double stat( double s, int m, int o);

double kin( double k, int m, int o);

double rest(int m, int o, double s);
double motion( int m, int o, double k);

int main()
{
    double k;
    double s;
    int m;
    int o;

    cout << "Please enter coefficent of kinetic friction: ";
    cin >> k;
    cin.ignore();
    cout << "Please enter coefficent of static friction: ";
    cin >> s;
    cin.ignore();
    cout << "Please enter mass: ";
    cin >> m;
    cin.ignore();
    cout << "Please enter theta: ";
    cin >> o;
    cin.ignore();
    cout << "The weight of the object is:"<< weight(m) <<"\n";
    cout << "The normal force is:"<< normal(m, o) <<"\n";
    cout << "The force of static friction equals:"<< stat( s, m, o) <<"\n";
    cout << "The force of kinetic friction equals:"<< kin( k, m, o) <<"\n";
    cout << "F when sigmaF=0 at rest is:"<< rest( m, o, s) <<"\n";
    cout << "F when sigmaF=0 while in motion is:"<< motion( m,o,k) <<"\n";
    cin. get();

}
double weight( int m){
    return m*9.8;
}
double normal( int m, int o){
    return m*9.8*cos(o*(3.141592654/180));
}
double stat( double s, int m, int o){
    return s*m*9.8*cos(o*(3.141592654/180));
}
double kin( double k, int m, int o){
    return k*m*9.8*cos(o*(3.141592654/180));
}
double rest( int m, int o, double s){
    return m*9.8*sin(o*(3.141592654/180))-s*9.8*m*cos(o*(3.141592654/180));
}
double motion( int m, int o, double k){
    return m*9.8*sin(o*(3.141592654/180))+k*m*9.8*cos(o*(3.141592654/180));
}



