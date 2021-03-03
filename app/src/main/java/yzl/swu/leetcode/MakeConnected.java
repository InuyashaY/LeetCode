package yzl.swu.leetcode;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MakeConnected {
    /**
     * 1319. 连通网络的操作次数
     * medium
     * */
    public static void main(String[] args) {
        String s = "cbabc";
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.contains(c)){
                stack.remove(c);

            }
            stack.push(c);
        }

        String result = "";
        while(stack.size() > 0)
            result = String.valueOf(stack.pop())+result;
        System.out.println(result);
    }


    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(n > m+1) return -1;
        Set<Integer> orgSet = new HashSet();
        for(int i=0; i<m; i++) {
            orgSet.add(connections[i][0]);
            orgSet.add(connections[i][1]);
        }
        return n-orgSet.size();
    }
}
