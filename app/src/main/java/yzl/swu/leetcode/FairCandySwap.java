package yzl.swu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] a = {1,1};
        int[] b = {2,2};
        fairCandySwap(a,b);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int total = 0;
        int totalA;
        int[] result = new int[2];
        Set<Integer> aSet = new HashSet<>();

        for(int i=0; i<A.length; i++) {
            aSet.add(A[i]);
            total += A[i];
        }
        totalA = total;
        for(int i=0; i<B.length; i++) total+=B[i];
        int x = totalA-total/2;

        for(int i=0; i<B.length; i++) {
            if (aSet.contains(B[i]+x)){
                result[0] = B[i]+x;
                result[1] = B[i];
                return result;
            }
        }
        return result;
    }

    public interface TestInterface{
        void test1();


    }
}
