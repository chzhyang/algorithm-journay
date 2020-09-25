package com;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubblesort(int[] array) {
        if (array == null) {
            return null;
        }
        int[] arr = Arrays.copyOf(array, array.length);
        for(int i=1; i<arr.length;i++){//n-1趟
            boolean flag=true;//若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成
            for(int j=0; j<arr.length-i; j++){//arr[length-i]之后是已排序序列
                if(arr[j] > arr[j+1]){//swap
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    flag=false;
               }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }
}
