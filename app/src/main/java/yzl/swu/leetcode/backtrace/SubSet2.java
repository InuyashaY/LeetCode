package yzl.swu.leetcode.backtrace;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Leetcode 90
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * */
public class SubSet2 {
    public static void main(String[] args) {
        int[] testData = {1,2,2};
        subsetsWithDup(testData);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        generate(result,nums,0,subset);
        return new ArrayList(result);
    }

    public static void generate(Set<List<Integer>> result,int[] nums, int i, List<Integer> s){
        List<Integer> subset = new ArrayList(s);
        if (result.contains(subset)) return;
        if(i >= nums.length){
            result.add(subset);
            return;
        }
        subset.add(nums[i]);
        generate(result,nums,i+1,subset);
        subset.remove(subset.size()-1);
        generate(result,nums,i+1,subset);
    }
}
