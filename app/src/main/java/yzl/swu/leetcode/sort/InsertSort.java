package yzl.swu.leetcode.sort;

public class InsertSort {

    //基本有序时效率较高
    public static void main(String[] args) {
        sort(SortUtils.arr);
        SortUtils.arrPrint(SortUtils.arr);
    }

    static void sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i; j>0; j--){
                if (arr[j] < arr[j-1]) swap(arr,j,j-1);
            }
        }
    }


//    static void sort2(int[] arr){
//        for (int i=1;i<arr.length;i++){
//            int temp = arr[i];
//            for (int j=i;j>0;j--){
//                if(arr[j] > temp) arr[j+1] = arr[j];
//                else arr[j]
//            }
//        }
//    }

    static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
