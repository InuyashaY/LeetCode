package yzl.swu.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
//虚拟汽车加油
public class VisualCar {
    public static void main(String[] args) {
        int[] pot = {1,2,3,4,5,1,6,6};
        System.out.printf("最少加 "+greedy(pot,7)+ "次油");

    }

    static int greedy(int[] x,int n){
        int sum=0; //加油次数
        int k=x.length;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0,s=0;i<k;i++){
            if (x[i] > n){
                System.out.println("No Solution");
                return -1;
            }
            s += x[i];
            if (s>n){
                sum++;
                s = x[i];
                result.add(i);  //记录加油站
            }

        }
        System.out.printf("最优加油路径为：第");
        for (Integer i: result) {
            System.out.printf(" "+i+"、");
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer i : map.keySet()){

        }
        System.out.println("个加油站");
        return sum;
    }
}
