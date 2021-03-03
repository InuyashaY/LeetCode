package yzl.swu.leetcode.branchAndBounds;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//关键点   使用优先队列 当子集树的最优上界小于当前最优价值时，可以不予考虑
public class Knapsack0_1 {
    static class HeapNode{
        int uprofit;    //最优上界
        int profit;     //价值
        int weight;     //已装容量
        int level;      //在树中的第几层
        HeapNode parent;    //上一节点  找到解后，靠此回溯
        boolean LChild;     //是否为左儿子节点，即是否装入背包

        public HeapNode(int uprofit, int profit, int weight, int level, boolean LChild,HeapNode parent) {
            this.uprofit = uprofit;
            this.profit = profit;
            this.weight = weight;
            this.level = level;
            this.LChild = LChild;
            this.parent = parent;
        }
    }


    static PriorityQueue<HeapNode> H;   //优先队列
    static int c;   //背包容量
    static int n;   //物品数量
    static int[] w; //物品重量
    static int[] v; //物品价值
    static int cw;  //当前装包重量
    static int cv;  //当前装包价值
    static int[] bestPath;  //最优解

    public static void main(String[] args) {
        int[] ww = new int[]{2,2,6,5,4};
        int[] vv = new int[]{6,3,5,4,6};
        int result = knapSack(ww,vv,5,10);
        System.out.println("最大价值为："+result+"\n"+"装入质量分别为：");
        for (int i=0; i<n; i++){
            System.out.print(bestPath[i]+" ");
        }
    }

    //初始化参数
    static int knapSack(int[] weights,int[] values,int num, int contain){
        w = weights;
        v = values;
        n = num;
        c = contain;
        cw = cv = 0;
        bestPath = new int[n];
        //按单位价值排序
        for (int i=0; i<n; i++){
            float temp;
            int index = i;
            for (int j=i+1; j<n; j++){
                temp = (float)v[index]/w[index];
                if ((float)v[j]/w[j]>temp) index = j;
            }
            int temp2 = w[i];
            w[i] = w[index];
            w[index] = temp2;
            temp2 = v[i];
            v[i] = v[index];
            v[index] = temp2;
        }

        int bestP = maxKnapSack();

        return bestP;
    }

    //计算价值上界
    static int bound(int i){
        int cLeft = c - cw;
        int p = cv;
        //以单位价值递减装填剩余容量
        while (i < n && w[i] <= cLeft){
            cLeft -= w[i];
            p += v[i];
            i++;
        }
        if (i < n) p += v[i]/w[i]*cLeft;
        return p;
    }


    static int maxKnapSack(){
        //定义优先队列
        H = new PriorityQueue<>(1000, new Comparator<HeapNode>() {
            @Override
            public int compare(HeapNode o1, HeapNode o2) {
                return o2.uprofit-o1.uprofit;
            }
        });
        int i = 0;
        bestPath = new int[n];
        cw = cv = 0;
        int bestV = 0;
        int upV = bound(0);
        HeapNode N = null;
        while (i != n){
            int tempW = cw + w[i];
            //检查左儿子
            if (tempW <= c) {
                if (cv+v[i] > bestV) bestV = cv + v[i];
                H.add(new HeapNode(upV, cv + v[i], cw + w[i], i + 1, true,N));
            }

            upV = bound(i+1);
            //检查右儿子节点
            if (upV >= bestV)
                H.add(new HeapNode(upV, cv, cw, i + 1, false,N));
            N = H.poll();
            cw = N.weight;
            cv = N.profit;
            upV = N.uprofit;
            i = N.level;
        }

        //构造当前最优解
        for (int j=n-1; j>=0; j--){
            bestPath[j] = N.LChild?w[j]:0;
            N = N.parent;
        }

        return cv;
    }


}
