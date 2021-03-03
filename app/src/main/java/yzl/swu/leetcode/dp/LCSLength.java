package yzl.swu.leetcode.dp;
/**
 * 最长公共子序列问题
 *
 * */
public class LCSLength {
    public static void main(String[] args) {
        String x = "hello you are demo";
        String y = "good your demo he";
        System.out.println("原序列："+x);
        System.out.println("子序列："+y);
        System.out.print("最长公共子序列：");
        lcsLengrh(x.length()-1,y.length()-1,x,y);
    }

    //计算最优值
    static void lcsLengrh(int m,int n,String x,String y){
        int[][] c = new int[m+1][m+1];
        int[][] b = new int[m+1][m+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (x.charAt(i) == y.charAt(j)){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;
                }else if (c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }

        LCS(m,n,x,b);
    }

    //构造最优解
    static void LCS(int i,int j,String x,int[][] b){
        if (i==0 || j==0) return;
        if (b[i][j] == 1){
            LCS(i-1,j-1,x,b);
            System.out.print(x.charAt(i));
        }else if (b[i][j] == 2){
            LCS(i-1,j,x,b);
        }else {
            LCS(i,j-1,x,b);
        }
    }
}
