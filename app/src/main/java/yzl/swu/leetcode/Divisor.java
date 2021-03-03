package yzl.swu.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

/**
 * 最多约数问题
 * */
//        Scanner scanner = new Scanner(System.in);
//        new File("input.txt");
//        System.out.printf("a=");
//        a = scanner.nextInt();
//        System.out.printf("b=");
//        b = scanner.nextInt();

public class Divisor {


//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//        File file = new File("C:\\Users\\lenovo\\Desktop\\input.txt");
//        BufferedReader reader = null;
//        int a,b;
//
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            String text = null;
//            while ((text = reader.readLine()) != null) {
//                list.add(Integer.parseInt(text));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException e) {
//            }
//        }
//
//
//        a=list.get(0);b=list.get(1);
//        int max = 0;
//        int maxCount = 0;
//        for (int i = a+1; i < b; i++){
//            int count = 0;
//            for (int j = 1; j <= (int)Math.sqrt(i); j++){
//                if (i%j == 0){
//                    count += i/j==j?1:2;
//                }
//            }
//            if (count>maxCount){
//                maxCount = count;
//                max = i;
//            }
//        }
//
//        System.out.println("x ="+max+" maxCount="+maxCount+list.get(1));
//    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("C:\\Users\\lenovo\\Desktop\\input.txt");
        BufferedReader reader = null;
        int a,b;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }


        a=list.get(0);b=list.get(1);
        // 调用算法
        get(a,b);
    }



    static int prime(int n)
    {
        int[] m = new int[n/2+1]; // 默认值是0
        int ncount = 1;
        int k = n;

        for (int i=2; i<=k/2; i++) // 质因子最大值为n/2
        {
            if (n%i == 0)
            {
                m[i]++; // 质因子出现一次
                n /= i; // 减小n的规模
                i--;	// 还原i值
            }
        }

        // 根据每个质因数出现的次数计算n的约数个数
        for (int j=2; j<=k/2; j++)
        {
            if (m[j] > 0)
            {
                ncount *= (m[j]+1);
            }
        }
        return ncount;
    }

    static void get(int a, int b) {
        int maxCount = 0; // 最多约数个数
        int maxNum = a;
        int val = 0;

        for (int i = a; i < b; i++) {
            val = prime(i);
            if (maxCount < val) {
                maxCount = val;
                maxNum = i;
            }
        }

        System.out.println("约数最多的数为："+maxNum + "有："+maxCount + "个");
    }
}
