package yzl.swu.leetcode.greedy;

public class Dijkstra {
    public static void main(String[] args) {
        //有向图矩阵
        int[][] c = {{Integer.MAX_VALUE,10,Integer.MAX_VALUE,30,100},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,50,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,10},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,20,Integer.MAX_VALUE,60},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        dijkstra(c.length,0,c);
    }

    static void dijkstra(int n,int v,int[][] c){
        //记录源点到此的距离
        int[] dist = new int[n];
        //记录来到此点的上一步    用于返回路径
        int[] path = new int[n];
        //记录点是否已计算最短路径
        boolean[] s = new boolean[n];
        //初始化点的对应记录
        for (int i=0;i<n;i++){
            dist[i] = c[v][i];
            s[i] = false;
            if (dist[i] == Integer.MAX_VALUE){
                path[i] = 0;
            }else {
                path[i] = v;
            }
        }

        dist[v] = 0;
        s[v] = true;
        //迭代求点集到 i 的最短距离
        for (int i=1; i<n; i++){
            int temp = Integer.MAX_VALUE;
            int from = v;
            //求未加入点集的最近点
            for (int j=0; j<n; j++){
                if (!s[j] && dist[j]<temp){
                    from = j;
                    temp = dist[j];
                }
            }

            //将最近点加入点集 更新dist
            s[from] = true;
            for (int j=0; j<n ; j++){
                if (!s[j] && c[from][j] < Integer.MAX_VALUE){
                    int newDist = dist[from] + c[from][j];
                    if (newDist < dist[j]){
                        dist[j] = newDist;
                        path[j] = from;
                    }
                }
            }
        }

        //递归打印最短路径  1->5
        trackPath(0,4,path);
    }

    static void trackPath(int start, int end, int[] path){
        if (end == start){ System.out.print(++start); return;}
        trackPath(start,path[end],path);
        System.out.print("->"+(++end));
    }

}
