package com;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[] arr = {1,8,6,2,10};
		int[] res = SelectSort.selectsort(arr);
		//int[] res=BubbleSort.bubblesort(arr);
		//int[] res = InsertSort.insertsort(arr);

		for(Integer i: res){
			System.out.print(i+" ");
		}
		System.out.println();
//		QuickSort.quicksort1(arr,0,arr.length-1);
//		for(Integer i : arr){
//			System.out.print(i+" ");
//		}
//		System.out.println();
	}


}
