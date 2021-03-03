package yzl.swu.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,5,9};
        sort(arr,0,6);
        //merge(arr,0,4,6);
        SortUtils.arrPrint(arr);
    }

    public static void sort(int[] arr,int start,int end){
        //左右相等，递归出口
        if (start == end) return;
        //计算中间
        int mid = start + (end-start)/2;
        //左边排序
        sort(arr,start,mid);
        //右边排序
        sort(arr,mid+1,end);
        //合并到数组
        merge(arr,start,mid+1,end);

        List<List<Integer>> list = new ArrayList<>();
        
        Collections.reverse(list);

    }

    static void merge(int[] arr,int left,int right,int end){
        int[] temp = new int[end-left+1];
        int leftIndex = left;
        int rightIndex = right;
        int tempIndex = 0;
        while(leftIndex < rightIndex && rightIndex < end){
            if (arr[leftIndex] <= arr[rightIndex]){
                temp[tempIndex++] = arr[leftIndex++];
            }else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }
        while (leftIndex < right) temp[tempIndex++] = arr[leftIndex++];
        while (rightIndex <= end) temp[tempIndex++] = arr[rightIndex++];

        for (int i=left,j=0;i<=end;i++,j++) arr[i] = temp[j];
    }
}
