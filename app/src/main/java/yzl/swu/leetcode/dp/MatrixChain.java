package yzl.swu.leetcode.dp;
/**
 * 矩阵连乘问题
 *
 * */
public class MatrixChain {

    public static void main(String[] args) {
        //输入即为30*35 35*15 15*5 5*10 10*20 20*25 这六个矩阵
        int[] p = {30,35,15,5,10,20,25};
        matrixChain(p,p.length-1);
    }

    //计算最优值
    static void matrixChain(int[] p,int n){
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1];

        for (int r=2;r<=n;r++){
            for (int i=1;i<=n-r+1;i++){ //自底向上
                int j = i+r-1;
                m[i][j] = m[i+1][j] + p[i-1]*p[i]*p[j];
                s[i][j] = i;
                for (int k=i+1;k<j;k++){
                    int temp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (temp < m[i][j]){
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }

        TraceBack(1,6,s);
    }

    //构造最优解
    static void TraceBack(int i,int j,int[][] s){
        if (i == j) {
            System.out.print("A"+i);
            return;
        }else {
            System.out.print("(");
            TraceBack(i,s[i][j],s);
            TraceBack(s[i][j]+1,j,s);
            System.out.print(")");
        }




    }
}
