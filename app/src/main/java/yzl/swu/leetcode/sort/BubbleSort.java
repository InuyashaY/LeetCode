package yzl.swu.leetcode.sort;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(SortUtils.arr);
        SortUtils.arrPrint(SortUtils.arr);
    }

    static void bubbleSort(int[] arr){
        for (int i=arr.length-1; i > 0; i--){
            for (int j=0;j<i;j++){
                if(arr[j] > arr[j+1]) swap(arr,j,j+1);
            }
        }
    }

    static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
