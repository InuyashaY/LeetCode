package yzl.swu.leetcode.sort;

public class SelectionSort {
    public static void main(String[] args) {
        SortUtils.arrPrint(SortUtils.arr);
        System.out.println();
        selectionSort(SortUtils.arr);
        SortUtils.arrPrint(SortUtils.arr);
    }

    public static void selectionSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++){
                minIndex = arr[minIndex] > arr[j]? j:minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


}
