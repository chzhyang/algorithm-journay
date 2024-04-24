#include <iostream>
using namespace std;
#include<bits/stdc++.h>
static int MAXN = 100001;
int* help = new int[MAXN];
long solution(long *arr, int l, int r);
long merge(long* arr, int l, int m, int r);
int main() {
    int n;
    cin>>n;
    auto* arr=new long[n];
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }
    cout<<solution(arr, 0, n-1);
    return 0;
}
// 归并分治法
long solution(long *arr, int l, int r){
    if(l==r) return 0;
    int m = (l+r)/2;
    //左侧结果+右侧结果+跨左右的结果
    return solution(arr, l, m)+solution(arr, m+1,r)+merge(arr, l, m, r);
}
long merge(long *arr, int l, int m, int r){
    //统计跨左右的结果
    long ret = 0;
    for(int j=m+1, i=l, sum=0; j<=r; j++){
        while(i<=m && arr[i]<=arr[j]){
            sum += arr[i++];
        }
        ret += sum;
    }
    //正常merge和排序，以加速跨左右的结果计算
    // 左右两侧有序merge的结果先放入help数组，再整体替换回原数组
    int i = l; //help的指针
    int a = l; //左侧指针
    int b = m+1;//右侧指针
    while(a<=m && b<=r){
        help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
    }
    //左右两侧只有一侧可能没走完，剩余的直接纳入help
    while(a<=m){
        help[i++]=arr[a++];
    }
    while(b<=r){
        help[i++]=arr[b++];
    }
    for(i=l; i<=r; i++){
        arr[i] = help[i];
    }
    return ret;
}
