package yzl.swu.leetcode.dp;

public class CollectSample {
    static int size = 8,    //方格8*8
            map[][];
    static String  s[][];

    static int collectSample(){
        int[][] m = new int[size +1][size +1];
        //初始化
        for(int i = 1; i<= size; i++){
            m[1][i] += map[1][i];
            m[i][1] += map[i][1];
            s[1][i] = 1 + "," + (i-1);
            s[i][1] = (i-1) + "," + 1;
        }
        s[1][1] = "0,0";
        for(int i = 2; i<= size; i++){
            for(int j = 2; j<= size; j++){
                if(m[i-1][j] > m[i][j-1]){
                    m[i][j] = m[i-1][j] + map[i][j];
                    s[i][j] = (i-1) + "," + j;
                }else{
                    m[i][j] = m[i][j-1] + map[i][j];
                    s[i][j] = i + "," + (j-1);
                }
            }
        }

        return m[size][size];
    }

    //除去采集过的样本
    static void updateSample(int i, int j){
        String xy[] = s[i][j].split(",");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        map[x][y] = 0; //除去曾采集过的样本
        if(x==0 && y==0)
            return ;
        updateSample(x,y);
    }

    public static void main(String[] args) throws Exception {
        map = new int[size +1][size +1];
        s = new String[size +1][size +1];
        //初始化样本价值
        map[2][3] = 13;
        map[2][6] = 6;
        map[3][5] = 7;
        map[4][4] = 14;
        map[5][2] = 21;
        map[5][6] = 4;
        map[6][3] = 15;
        map[7][2] = 14;

        int first = collectSample();
        //执行标记函数，除去采集过的样本
        updateSample(size, size);
        //S重新初始化
        s = new String[size +1][size +1];
        int second = first + collectSample();
        System.out.println("收集样本最大为："+second);

    }
}
