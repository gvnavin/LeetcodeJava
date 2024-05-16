/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return recur(nums, 0, nums.length - 1, 0, memo);
    }

    public int recur(int[] nums, int beg, int end, int i, Map<Integer, Integer> memo) {
        if (i > end) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int val1 = nums[i] + recur(nums, beg, end, i + 2, memo);
        int val2 = recur(nums, beg, end, i + 1, memo);

        int val = Math.max(val1, val2);
        memo.put(i, val);
        return val;
    }
}
// @lc code=end
