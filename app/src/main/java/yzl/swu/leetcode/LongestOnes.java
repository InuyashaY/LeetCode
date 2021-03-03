package yzl.swu.leetcode;

import java.util.ArrayList;

/**
 * 1004. 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * */
public class LongestOnes {

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        longestOnes(A,2);
    }

    static int n;
    static int result = 0;
    public static int longestOnes(int[] A, int K) {
        n = A.length;
        ArrayList<Integer> record = new ArrayList();
        for(int i=0; i<n; i++){
            if(A[i] == 0) record.add(i);
        }

        if(record.size() <= K) return n;

        backTrack(record,K);

        return result;
    }

    public static void backTrack(ArrayList<Integer> record, int K){
        if(K <= 0) {
            if(record.get(0) > 0) result = (result>record.get(0)?result:record.get(0));
            for(int i=1; i<record.size(); i++){
                int size = record.get(i)-record.get(i-1)-1;
                if(size>result) result = size;
            }
            int lastIndex = record.get(record.size()-1);
            if(lastIndex < n-1) result = (result>n-lastIndex-1?result:n-lastIndex-1);
            return;
        }
        ArrayList<Integer> tempRecord = new ArrayList(record);
        for(int i=0;i<record.size();i++){
            Integer temp = tempRecord.get(i);
            tempRecord.remove(temp);
            backTrack(tempRecord,K-1);
            tempRecord.add(i,temp);
        }
    }
}
