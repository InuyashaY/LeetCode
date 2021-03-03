package yzl.swu.leetcode.sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
//        String test = "/a//b////c/d//././/home";
        String test = "/../";

        int[] ttt = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(ttt,3);
//        simplifyPath(test);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder newDic = new StringBuilder();
        for (int i=0;i<path.length();i++){
            if (path.charAt(i) == '/' || i ==path.length()-1){
                if (i==path.length()-1 && path.charAt(i)!='/') newDic.append(path.charAt(i));
                //根目录
                if (stack.size() == 0) stack.push("/");
                    //目录分隔符
                else if (newDic.toString().equals("..")){//上级目录
                    if (!stack.peek().equals("/")) stack.pop();
                }else if (newDic.toString().equals(".")) ;//此目录
                else {
                    if (newDic.length() > 0) stack.push(newDic.toString());
                }
                newDic = new StringBuilder();
            }else {
                newDic.append(path.charAt(i));
            }
        }

        if (stack.size() == 1) return stack.pop();
        while (stack.size() > 0){
            String temp = stack.pop();
            if (temp != "/") stringBuilder.insert(0,"/"+temp);
        }
        return stringBuilder.toString();
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> quenu = new ArrayDeque();
        for(int i=0;i<k;i++) quenu.push(nums[i]);
        Iterator<Integer> iterator =  quenu.iterator();
        while(iterator.hasNext()){
            result[0] = Math.max(result[0],iterator.next());
        }
        for(int i=k;i<nums.length;i++){
            quenu.push(nums[i]);
            if(quenu.pollLast() == result[i-3]){//最大的数被移除
                iterator =  quenu.iterator();
                while(iterator.hasNext()){
                    result[i-2] = Math.max(result[i-2],iterator.next());
                }
            }else{
                result[i-2] = Math.max(result[i-3],quenu.getFirst());
            }
        }
        return result;
    }
}
