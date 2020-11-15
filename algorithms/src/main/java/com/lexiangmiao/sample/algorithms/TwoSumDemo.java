package com.lexiangmiao.sample.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 8, 9};
        int target=10;
        TwoSumDemo o = new TwoSumDemo();

        System.out.println( o.twoSum(nums, target)[0]+" "+o.twoSum(nums, target)[1]);
        System.out.println( o.twoSum2(nums, target)[0]+" "+o.twoSum2(nums, target)[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]).intValue(), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
