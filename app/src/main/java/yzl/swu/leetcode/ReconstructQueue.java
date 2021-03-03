package yzl.swu.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ReconstructQueue {

    public static void main(String[] args) {
//        int[][] test = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
//        reconstructQueue(test);
        String ss = "2611055971756562";
        for (int i=0;i<ss.length();i++){
            System.out.println(""+numDecodings(ss,i));
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        //根据身高 排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });

        int[][] answer = new int[people.length][];
        for (int[] person:people) {
            int goal = person[1];
            for (int i=0;i<people.length;i++){
                if (people[i][0]>person[0]) goal--;
                if (goal == 0){
                    answer[i]=person;
                    break;
                }
            }
        }

        return answer;
    }


    public static int numDecodings(String s,int index) {
        if(s.charAt(0) == '0' || s.length()==0) return 0;
        int[] result = new int[s.length()];
        result[0] = 1;
        if(s.length() == 1) return result[result.length-1];
        result[1]=1;
        if(s.charAt(0)<='2' && s.charAt(1)<='6') result[1]=s.charAt(1)=='0'?1:2;
        if(s.length()==2) return result[result.length-1];
        for(int i=2;i<s.length();i++){
            if(s.charAt(i) == '0' && s.charAt(i-1) == '0') return 0;
            else if(s.charAt(i) == '0' && s.charAt(i-1) != '0') result[i] = result[i-2];
            else if(s.charAt(i) != '0' && s.charAt(i-1) == '0') result[i] = result[i-1];
            else if(Integer.parseInt(s.substring(i-1,i+1)) <= 26)  result[i]=result[i-2]+result[i-1];
            else if(Integer.parseInt(s.substring(i-1,i+1)) > 26) result[i] = result[i-1];
        }

        return result[index];
    }
}
