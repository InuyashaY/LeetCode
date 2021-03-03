package yzl.swu.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        backTrack(0,nums,subList,result);
        return result;
    }

    void backTrack(int i, int[] nums,List<Integer> subList, List<List<Integer>> result){
        if (i>=nums.length) return;
        subList = new ArrayList<>(subList);
        subList.add(nums[i]);
        result.add(subList);
        //选择放入当前数字
        backTrack(i+1,nums,subList,result);
        //选择不放入当前数字
        subList = new ArrayList<>(subList);
        subList.remove(subList.size()-1);
        backTrack(i+1,nums,subList,result);
    }
}
