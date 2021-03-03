package yzl.swu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 15.三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 *
 *
 * **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = threeSum(test);
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList();
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        int start = 0;
        int mid = 1;
        int end = nums.length-1;
        while(start<end-1){
            if(nums[end]<0) break;
            int total = nums[start]+nums[mid]+nums[end];
            if(total>0){
                end--;
                mid = start+1;
                continue;
            }
            if(total == 0){
                List<Integer> temp = new ArrayList();
                temp.add(nums[start]);
                temp.add(nums[mid]);
                temp.add(nums[end]);
                result.add(temp);
            }
            mid++;
            if(mid>=end){
                start++;
                mid = start+1;
            }

            
        }
        // for(int i=1;i<nums.length-1;i++){
        //     int left = 0;
        //     int right = nums.length-1;
        //     while(true){
        //         int temp = nums[left]+nums[i]+nums[right];
        //         if(temp>0){
        //             if(--right <= i) break;
        //         }else if(temp < 0){
        //             if(++left >= i) break;
        //         }else{
        //             ArrayList<Integer> list = new ArrayList();
        //             list.add(nums[left]);
        //             list.add(nums[i]);
        //             list.add(nums[right]);
        //             result.add(list);
        //         }
        //     }
        // }
        return new ArrayList(result);
    }
}
