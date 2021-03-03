package yzl.swu.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;
/**
 *  51. N 皇后
 *  n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *  给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * */
public class nQueenSolution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        dfs(queens,n,0);
        return result;
    }

    //递归函数
    public void dfs(int[] queens, int n, int row){
        if(row == n){
            result.add(generateBoard(queens,n));
            return;
        }

        for(int i=0; i<n; i++){
            if(place(queens,row,i)){
                queens[row] = i;
                dfs(queens,n,row+1);
            }
        }
    }

    //约束条件 即剪枝函数
    public boolean place(int[] queens,int r, int c){
        for(int i=0; i< r; i++){
            if(Math.abs(queens[i]-c) == r-i || c==queens[i]) return false;
        }
        return true;
    }


    //生成棋盘
    public List<String> generateBoard(int[] queens, int n){
        List<String> board = new ArrayList();
        for(int i=0; i<n; i++){
            char[] row = new char[n];
            for(int j=0; j<n; j++)
                row[j] = queens[i]==j?'Q':'.';
            board.add(new String(row));
        }
        return board;
    }
}
