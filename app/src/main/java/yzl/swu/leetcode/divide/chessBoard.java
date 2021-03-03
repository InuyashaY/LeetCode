package yzl.swu.leetcode.divide;

//棋盘覆盖问题
public class chessBoard {
    static int id = 0;
    static int boardSize = 8;
    static int[][] BOARD = new int[boardSize][boardSize];
    public static void main(String[] args) {
        chessBoard(0,0,0,3,boardSize);

        for (int i=0;i<boardSize;i++){
            for (int j = 0;j < boardSize;j++){
                System.out.printf("  "+String.format("%02d",BOARD[i][j]));
            }
            System.out.println();
        }
    }

    static void chessBoard(int tr,int tc,int dr,int dc,int size){
        if (size == 1){
            return;
        }
        int s = size/2;
        int t = id++;
        //特殊点在棋盘左上角
        if (dr < tr+s && dc <tc+s){
            chessBoard(tr,tc,dr,dc,s);
        }else {
            BOARD[tr+s-1][tc+s-1] = t; //标记
            chessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }

        //右上
        if(dr<tr+s && dc>=tc+s){
            chessBoard(tr,tc+s,dr,dc,s);
        }else {
            BOARD[tr+s-1][tc+s] = t;
            chessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }

        //左下
        if (dr >= tr+s && dc <tc+s){
            chessBoard(tr+s,tc,dr,dc,s);
        }else {
            BOARD[tr+s][tc+s-1] = t; //标记
            chessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }

        //右下
        if(dr>=tr+s && dc>=tc+s){
            chessBoard(tr+s,tc+s,dr,dc,s);
        }else {
            BOARD[tr+s][tc+s] = t;
            chessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }
}
