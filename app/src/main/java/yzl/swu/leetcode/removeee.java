package yzl.swu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 1
 * 2外观数列
 *
 * */
public class removeee {
    public static void main(String[] args) {
        //System.out.printf(countAndSay(5));
        char [][] board = new char[10][];
        isValidSudoku(board);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int index = 0;
        for(int i=0; i<nums.length; i++){
            //System.out.println("index="+index+" num="+i);
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
            String aa = "sdad";


            System.out.println(aa.substring(1,2));
        }
        return index;
    }


    //外观数列
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String lastSay = "1";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++){
            char num=lastSay.charAt(0);int count=1;
            for(int j=1;j<lastSay.length();j++){
                char current = lastSay.charAt(j);
                if(current != num){
                    sb.append(String.format("%d%c",count,num));
                    num = current;
                    count = 1;
                }else {
                    count++;
                }

            }
            sb.append(String.format("%d%c",count,num));
            lastSay = sb.toString();
            sb = new StringBuilder();
        }
        return lastSay;
    }


    public static boolean isValidSudoku(char[][] board) {

        HashSet<Character> set = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();
        int[] ar = new int[5];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList ll = new ArrayList(list);
        set.add('0');
        System.out.printf(""+set.contains('0')+set.size());
        return true;
    }
}
