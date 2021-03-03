package yzl.swu.leetcode.backtrace;

import java.util.Queue;
/**
 * n后问题
 *
 * */
public class Queen {
    static int n;
    static int x[];
    static long sum;
    public static void main(String[] args) {
//        nQueen(9);
        nQueen(10);
    }

    //递归
    static void nQueen(int count){
        n = count;
        sum = 0;
        int[] p = new int[n+1];
        for (int i=0; i<= n; i++){
            p[i] = 0;
        }
        x = p;
//        backTrack(1);
        backTrack2();
        System.out.println("共 "+sum +" 种摆法");
    }

    //约束
    static boolean place(int k){
        for (int j=1; j<k; j++){
            if (Math.abs(k-j)==Math.abs(x[j]-x[k]) || x[j] == x[k])
                return false;
        }
        return true;
    }

    //递归遍历
    static void backTrack(int t){
        if (t > n) sum++;
        else{
            for (int i=1; i<=n; i++){
                x[t] = i;
                if (place(t))
                    backTrack(t+1);
            }
        }
    }

    //迭代代替递归
    static void backTrack2(){
        x[1] = 0;
        int k=1;
        while (k > 0){
            x[k] += 1;
            while (x[k]<=n && !place(k))
                x[k] += 1;
            if (x[k] <= n){
                if (k == n)
                    sum++;
                else {
                    k++;
                    x[k] = 0;
                }
            }else {
                k--;
            }
        }
    }
}
