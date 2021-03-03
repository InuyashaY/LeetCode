package yzl.swu.leetcode.greedy;

public class knapsack {
    public static void main(String[] args) {
        float[] weights = {10f,20f,30f};
        float[] values = {60f,100f,120f};
        float result = knapsack(weights.length,50,values,weights);
        System.out.println("the max value is "+result);
    }

    //n-物品数量    M-最大容量  v-价值数组  w-重量数组
    static float knapsack(int n,int M,float[] v,float[] w){
        //按性价比排序
        for(int i=0;i<n;i++){
            int maxIndex = i;
            for (int j=i;j<n;j++){
                if(v[j]/w[j] > v[maxIndex]/w[maxIndex])
                    maxIndex = j;
            }
            float temp = w[i];
            w[i] = w[maxIndex];
            w[maxIndex] = temp;
            temp = v[i];
            v[i] = v[maxIndex];
            v[maxIndex] = temp;
        }

        int maxValue = 0;
        for (int i=0;M>0;i++){
            if (M>w[i]){
                M-=w[i];
                maxValue+=v[i];
            }else {
                maxValue+=v[i]/w[i]*M;
                M = 0;
            }
        }

        return maxValue;
    }
}
