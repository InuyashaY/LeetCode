package yzl.swu.leetcode.divide;

import java.util.Arrays;
import java.util.HashMap;
/**
 * 众数问题
 *
 * */
public class Mode {

    static int[] array = {6,1,2,2,2,3,5,6,5,9,115,65,66,1,6,7,8,6,5,2,3,6};
    private static int leftest = 0;
    private static int rightest = array.length-1;
    private static int left, right;
    private static int count=0;
    private static int number;

    public static void main(String[] args) {

        Arrays.sort(array);
        mode(leftest, rightest);
        System.out.println("众数为: "+number+" 重数为: "+count);
    }

    static void mode(int l, int r){

        int midIndex = getMidIndex(l, r);
        split(array, midIndex, l, r);

        if(count < right-left+1){
            count = right-left+1;
            number = array[midIndex];
        }
        if(left-l > count)
            mode(l, left-1);
        if(r-right > count)
            mode(right+1, r);
    }

    static int getMidIndex(int l, int r){
        return (l+r)/2;
    }

    static void split(int[] numbers, int midIndex, int l, int r)
    {
        left = midIndex;
        right = midIndex;

        while (left-1 >=l && numbers[--left] == numbers[midIndex]);
        while (right+1<=r && numbers[++right] == numbers[midIndex]);
        if(numbers[l] != numbers[midIndex])
            left++;
        if(numbers[r] != numbers[midIndex])
            right--;
    }




    //java方式
    static void mode1(int[] array){
        HashMap<Integer,Integer> recordMap = new HashMap<>();
        Integer value;
        //记录出现次数
        for (int i=0; i<array.length; i++){
            value = recordMap.get(array[i]);
            if (value != null){
                recordMap.put(array[i],++value);
            }else {
                recordMap.put(array[i],1);
            }
        }

        //比较出现次数
        int maxKey = 0;
        int maxValue = 0;
        for (Integer key:recordMap.keySet()) {
            if (recordMap.get(key) > maxValue){
                maxKey = key;
                maxValue = recordMap.get(key);
            }
        }


        System.out.printf("众数为："+maxKey+" 重数："+maxValue);
    }


}
