package yzl.swu.leetcode.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        shellSort(SortUtils.arr);
        SortUtils.arrPrint(SortUtils.arr);
    }

    static void shellSort(int[] arr){
        int space = arr.length/2;
        while (space>0){
            for (int i=space; i<arr.length; i++){
                for (int j=i; j>space-1; j-=space){
                    if (arr[j]<arr[j-space]) swap(arr,j,j-space);
                }
            }
            space /= 2;
        }
    }


    static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
