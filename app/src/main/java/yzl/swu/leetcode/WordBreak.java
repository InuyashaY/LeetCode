package yzl.swu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  单词拆分
 *  给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * */
public class WordBreak {
    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDic = new ArrayList<>(Arrays.asList("a","aa","aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        String s = "leetcode";
        List<String> wordDic = new ArrayList<>(Arrays.asList("leet","code"));
        boolean result = wordBreak2(s,wordDic);
        System.out.println(result);
    }

    //回溯
    public static boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s,0,wordDict);
    }

    public static boolean dfs(String s,int start,List<String> wordDict){
        if(start == s.length()) return true;

        for(String word : wordDict){
            if(isPlace(s,start,word)){
                if(dfs(s,start+word.length(),wordDict)) return true;
            }
        }

        return false;
    }

    public static boolean isPlace(String s,int start,String word){
        if(start+word.length() > s.length()) return false;
        for(int i=0; i<word.length(); i++){
            if(s.charAt(start+i) != word.charAt(i)) return false;
        }
        return true;
    }


    //动态规划
    public static boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if (dp[j] && isPlace2(s,j,i,wordDict)) dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    public static boolean isPlace2(String s,int start,int end,List<String> wordDic){
        if(start >= end) return false;
        for(String word:wordDic){
            if (word.equals(s.substring(start,end))) return true;
        }
        return false;
    }
}
