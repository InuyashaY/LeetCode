package yzl.swu.leetcode.randomize;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class PrimeTest {
    //是否为合数
    static boolean composite;
    static int testNum = 128;
    public static void main(String[] args) {
        int isComposite=0;  //判定为合数的次数
        int isPrime = 0;    //判定为素数的次数
        for (int i=0; i<10000; i++){
            boolean result  = prime(testNum);
            if (result == false) isComposite++;
            else isPrime++;
        }


        System.out.println("测试数字："+testNum+"\n"+"Composite:"+isComposite+"\n"+"Prime:"+isPrime);
    }



    //判断是否为素数
    static boolean prime(int n){
        int a = new Random().nextInt(n-2)+1;
        composite = false;
        int result = power(a,n-1,n);
        if (composite || result!=1)
            return false;
        else
            return true;
    }

    //递归 进行二次探测
    static int power(int a,int p,int n){

        if (p == 0) return 1;
        //递归计算
        int x = power(a,p/2,n);
        //二次探测
        int result = (x*x)%n;
        if (result == 1  && x != 1  && x != n-1)
            composite = true;
        if (p%2 == 1)
            result = (result*a) % n;
        return result;
    }




}
