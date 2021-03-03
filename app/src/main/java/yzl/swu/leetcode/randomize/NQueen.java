package yzl.swu.leetcode.randomize;

import java.util.Random;

public class NQueen {
    static int n = 15;
    //x[i]即代表放在 i行 x[i]列
    static int[] x;
    //记录在i行时 可放的列数
    static int[] y;
    public static void main(String[] args) {
        long start = System.nanoTime();
        nQueen2();
        System.out.println("拉斯维加斯+回溯----耗时："+(System.nanoTime()-start));
        long start2 = System.nanoTime();
        nQueen1();
        System.out.println("仅拉斯维加斯----耗时："+(System.nanoTime()-start2));
    }

    //仅拉斯维加斯算法
    static void nQueen1(){
        boolean result;
        int count = 0;
        while (!(result=nQueenLV())) count++;
        System.out.println(result+" 随机的次数："+count);
    }

    //拉斯维加斯+回溯      前n项由拉斯维加斯算法生成，后面部分使用递归
    //可能无法算出正确结果  正确性受stopVegas影响，越大正确率越低
    static void nQueen2(){
        x = new int[n];
        y = new int[n];
        int stopVegas = 5;
        if (n > 15)
            stopVegas = n-15;
        boolean found = false;
        while (!nQueenLV2(stopVegas)) ;
        if (backTrack(stopVegas)){
            for (int i=0; i<n; i++)
                System.out.print(y[i]+" ");
            found = true;
        }
        System.out.println("\n"+found);
    }

    //判断该位置的合法性
    static boolean place(int k){
        for (int j=0; j<k; j++){
            if (Math.abs(k-j) == Math.abs(x[k]-x[j]) || x[k] == x[j])
                return false;
        }
        return true;
    }

    //拉斯维加斯算法
    static boolean nQueenLV(){
        x = new int[n];
        y = new int[n];
        Random random = new Random();
        //下一个放置的皇后编号
        int k = 1;
        int count = 1;
        while (k < n && count > 0){
            count = 0;
            for (int i=0; i< n; i++){
                x[k] = i;
                if (place(k))
                    y[count++] = i;
            }

            if (count>0)
                //随机选择可放置的位置
                x[k++] = y[random.nextInt(count)];
        }

        return count>0;
    }


    //递归回溯
    static boolean backTrack(int t){
        if (t >= n) {
            for (int i = 0; i < n; i++)
                y[i] = x[i];
            return true;
        }

        for (int i=0; i<n; i++){
            x[t] = i;
            if (place(t) && backTrack(t+1))
                return true;
        }
        return false;
    }

    //拉斯维加斯算法  随机生成前stop的合法项
    static boolean nQueenLV2(int stop){
        Random random = new Random();
        //下一个放置的皇后编号
        int k = 0;
        int count = 1;
        while (k < stop && count > 0){
            count = 0;
            for (int i=0; i< n; i++){
                x[k] = i;
                if (place(k))
                    y[count++] = i;
            }

            if (count>0)
                //随机选择可放置的位置
                x[k++] = y[random.nextInt(count)];
        }
        return count>0;
    }
}
