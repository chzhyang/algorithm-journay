package com;

import java.util.Stack;

public class QuickSort {
    //递归快排
    public static void quicksort1(int[] arr,int start,int end){
        if(arr==null||start>=end){
            return;
        }
        int index = partition(arr,start,end);
        //递归
        quicksort1(arr, start,index-1);
        quicksort1(arr,index+1,end);
    }
    //一趟快排，挖坑填数
    public static int partition(int[] arr, int start, int end){
        if(start==end){
            return start;
        }
        int pivot = arr[start];
        while(start<end){
            //从右往左找
            while(start<end && arr[end]>=pivot){
                end--;
            }
            arr[start] = arr[end];
            //从左往右
            while(start<end && arr[start]<= pivot){
                start++;
            }
            arr[end] = arr[start];
            //pivot放在中间
            arr[start] = pivot;

        }
        return start;
    }
    //非递归快排，栈存区间
    public static void quicksort2(int[] arr,int start,int end){
        if(arr==null){
            return;
        }
        Stack<Integer> st = new Stack<>();
        st.push(start);
        st.push(end);
        while(!st.isEmpty()){
            int right = st.pop();
            int left = st.pop();
            int index = partition(arr,left,right);
            if(index-1 > left){
                st.push(left);
                st.push(index-1);
            }
            if(index+1 < right){
                st.push(index+1);
                st.push(right);
            }
        }
    }
}
