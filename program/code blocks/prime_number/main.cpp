#include <iostream>

using namespace std;

int num;
int c;

void recall (int num){
    if(num<100){
            moose(c);
        }
    else{
        cout<<"done""\n";
    }
}
void moose(int c){
            if(c<num){
            cout<<num<<"\n";
            moose(c+1);
            }
            else{
            recall (num+1);
            }
}
int main(){
    cin>>num;
    recall(num);
    return 0;
}
