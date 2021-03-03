package yzl.swu.leetcode.backtrace;

import java.util.PriorityQueue;
/**
 * 0-1背包问题
 * 回溯法求解
 * */
public class Knapsack0_1 {
    static int n;
    static int[] v;
    static int[] w;
    static int c; //背包容量
    static int curW; //当前容量
    static int curV; //当前价值
    static int bestV; //当前最优价值
    static int[] wPath;
    static int[] bestPath;
    public static void main(String[] args) {
        knapsack();
    }

    static void knapsack(){
        n = 4;
        c = 7;
        v = new int[]{9, 10, 7, 4};
        w = new int[]{3,5,2,1};
        wPath = new int[n];
        bestPath = new int[n];
        curW = 0;
        curV = 0;
        bestV = 0;
        //按单位价值排序
        for (int i=0; i<n; i++){
            float temp;
            int index = i;
            for (int j=i+1; j<n; j++){
                temp = v[i]/w[i];
                if (v[j]/w[j]>temp) index = j;
            }
            int temp2 = w[i];
            w[i] = w[index];
            w[index] = temp2;
            temp2 = v[i];
            v[i] = v[index];
            v[index] = temp2;
        }
        //从根节点开始遍历
        backTrack(0);

        System.out.println("最优价值："+bestV);
        System.out.print("依次装入重量如下的物品：");
        for (int i=0; i<n; i++){
            System.out.print(" "+bestPath[i]);
        }

    }

    static void backTrack(int i){
        if (i >= n){
            //到达叶子节点
            if (curV>=bestV) bestV = curV;
            for (int k=0; k<n; k++){
                bestPath[k] = wPath[k];
            }

            return;
        }

        if (curW+w[i] <= c){
            //进入左子树
            curW+=w[i];
            curV+=v[i];
            wPath[i] = w[i];
            backTrack(i+1);
            //搜素完左子树后  回退容量，考虑右子树
            curW-=w[i];
            curV-=v[i];
            wPath[i] = 0;
        }
        //右子树可能包含最优解
        if (bound(i+1) > bestV) backTrack(i+1);
    }

    //剪枝  计算后续节点的价值上界
    static int bound(int i){
        int cLeft = c-curW;
        int mValue = curV;
        while (i<n && w[i]<=cLeft){
            cLeft -= w[i];
            mValue += v[i++];
        }
        if (i<n) mValue+=cLeft*v[i]/w[i];
        return mValue;
    }
}
