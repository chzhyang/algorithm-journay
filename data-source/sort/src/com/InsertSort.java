package com;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertsort(int[] array){
        if(array==null){
            return null;
        }
        int[] arr = Arrays.copyOf(array, array.length);
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for(int i=1; i<arr.length; i++){
            int t = arr[i];//待插入数据
            int j = i;//从已排序序列右侧开始,往左比较，找到比 t 小的数，插到他后边
            while(j>0 && t<arr[j-1]){
                arr[j] = arr[j-1];//大于t的右移
                j--;
            }
            if(j!=i){
                arr[j] = t;
            }
        }
        return arr;
    }
}
