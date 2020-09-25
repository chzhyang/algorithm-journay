package com;

import java.util.Arrays;

public class SelectSort {
    public static int[] selectsort(int[] array){
        if(array==null){
            return null;
        }
        int[] arr = Arrays.copyOf(array,array.length);
        int minIndex = 0;
        for(int i=0; i<arr.length-1; i++){//n-1趟，每趟选出一个最xiao的数，交换一次
            minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //swap
            if(minIndex!=i){
                int t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] =t;
            }

        }
        return arr;
    }
}
