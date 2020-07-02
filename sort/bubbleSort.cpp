#include <iostream>
using namespace std;

void swap(int array[], int i, int j){
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
}

void bubbleSort(int array[], int n){
    if(n < 1){
        return;
    }
    for(int i = 0; i<n; i++){
        //冒泡数据交换标志
        bool flag = false;
        for(int j = 0; j<n-i-1; j++){
            if(array[j] > array[j+1]){//swap
                swap(array, j+1, j);
                flag = true;
            }
        }
        //没有交换，提前退出
        if(!flag){
            break;
        }
    }
}

int main(int argc, const char *argv[]){
    int n=0;
    cout<<"input n"<<endl;
    cin>>n;
    int *a = new int[n];
    cout<<"input array"<<endl;
    for(int i = 0; i<n; i++){
        cin>>a[i];
    }
    bubbleSort(a,n);
    cout<<"bubble sort output"<<endl;
    for(int i =0 ; i<n;i++){
        cout << a[i]<<endl;
    }
    //system("pause");
    return 0;
}