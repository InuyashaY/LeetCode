package yzl.swu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  只出现一次的数字
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
        }
        for(Integer num : map.keySet()){
            if(map.get(num) == 1) return num;
        }
        return 0;
    }

    //位运算方式
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for(int i:nums){
            result ^= i;
        }
        return result;
    }
}
