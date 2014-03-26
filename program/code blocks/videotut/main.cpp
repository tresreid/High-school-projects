#include <iostream>

using namespace std;

int main(void)
{
    double dnumber1= 0.0;
    double dnumber2= 0.0;
    double dnumber3= 0.0;
    double daverage= 0.0;
    cout<<" Please input 3 numbers"<< endl;
    cin>>dnumber1;
    cin>>dnumber2;
    cin>>dnumber3;

    daverage= (dnumber1+dnumber2+dnumber3)/3;
    cout<<"the average of the numbers are:"<< daverage<<endl<<endl;
    return 0;
}
