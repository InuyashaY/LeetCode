package yzl.swu.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *  40. 组合总和 II
 *  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 * */

public class CombinationSum2 {
    //回溯法
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subResult = new ArrayList();
        Arrays.sort(candidates);
        generate(result,subResult,candidates,0,target);
        return result;
    }

    public void generate(List<List<Integer>> result, List<Integer> subResult, int[] nums,int i, int target){

        List<Integer> item = new ArrayList(subResult);
        if(target == 0){
            if(!result.contains(item)) result.add(item);
            return;
        }
        if(target < 0 || i >= nums.length) return;
        item.add(nums[i]);
        generate(result,item,nums,i+1,target-nums[i]);
        item.remove(item.size()-1);
        generate(result,item,nums,i+1,target);


    }
}
